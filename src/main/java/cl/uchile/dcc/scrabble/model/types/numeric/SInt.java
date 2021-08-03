package cl.uchile.dcc.scrabble.model.types.numeric;

import cl.uchile.dcc.scrabble.model.types.AbstractType;
import cl.uchile.dcc.scrabble.model.types.SString;
import cl.uchile.dcc.scrabble.model.types.STypeI;
import org.jetbrains.annotations.NotNull;

/**
 * class that represents a integer with an integer value
 */
public class SInt extends AbstractType implements NumTypeI {

    private int value;

    public SInt(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    /**
     * turns an integer into a SBinary value String, "0" if value <= 0
     * @param value number to be transformed
     * @return String of 1's and 0's
     */
    public static String intToBinary(int value){
        StringBuilder result = new StringBuilder();
        int i = value;
        while (i > 0){
            result.insert(0, i % 2);
            i /= 2;
        }
        if (result.toString().equals("")) {
            return "0";
        }
        return result.toString();
    }

    /**
     * transformations
     */
    @Override
    public SString toSString(){
        return factory.createString(Integer.toString(value));
    }

    @Override
    public SFloat toFloat(){
        return factory.createFloat(value);
    }

    @Override
    public SInt toInt(){
        return this;
    }

    @Override
    public SBinary toBinary(){
        return factory.createBinary(intToBinary(value));
    }

    /**
     * Operations
     */
    @Override
    public STypeI plus(STypeI obj) {
        return obj.sumWithInteger(value, 1);
    }

    @Override
    public STypeI minus(STypeI obj) {
        return obj.sumWithInteger(value, -1);
    }

    @Override
    public STypeI div(STypeI obj) {
        return obj.mulWithInteger(value, -1);
    }

    @Override
    public STypeI mul(STypeI obj) {
        return obj.mulWithInteger(value, 1);
    }


    // double-dispatch
    @Override
    public SString sumWithString(String value) {
        return factory.createString(value + this.value);
    }

    @Override
    public NumTypeI sumWithBinary(int value, int mode) {
        return factory.createBinary(intToBinary(value + (this.value * mode)));
    }

    @Override
    public NumTypeI mulWithBinary(int value, int mode) {
        return factory.createBinary(intToBinary((int) (value * Math.pow(this.value, mode))));
    }

    @Override
    public NumTypeI sumWithInteger(int value, int mode) {
        return factory.createInt(value + this.value * mode);
    }

    @Override
    public NumTypeI mulWithInteger(int value, int mode) {
        return factory.createInt((int) (value * Math.pow(this.value, mode)));
    }

    @Override
    public NumTypeI sumWithFloat(double value, int mode) {
        return factory.createFloat(value + this.value * mode);
    }

    @Override
    public NumTypeI mulWithFloat(double value, int mode) {
        return factory.createFloat(value * Math.pow(this.value, mode));
    }

    /*
    compareTo section
     */
    @Override
    public int compareTo(@NotNull Object o) {
        try {
            return ((NumTypeI) o).compare(this.value);
        }
        catch(ClassCastException e){
            return -2;
        }
    }

    @Override
    public int compare(double number) {
        if (value == number) {
            return 0;
        }
        else {
            if (value < number) {
                return 1;
            }
        }
        return -1;
    }

}
