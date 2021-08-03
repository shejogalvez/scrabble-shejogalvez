package cl.uchile.dcc.scrabble.model.types.numeric;

import cl.uchile.dcc.scrabble.model.types.AbstractType;
import cl.uchile.dcc.scrabble.model.types.SString;
import cl.uchile.dcc.scrabble.model.types.STypeI;
import org.jetbrains.annotations.NotNull;

/**
 * class that represents a real number with a double value
 */
public class SFloat extends AbstractType implements NumTypeI {

    private double value;

    public SFloat(double value) {
        this.value = value;
    }

    public double getValue(){
        return value;
    }

    /**
     * transformations
     */
    @Override
    public SString toSString(){
        return factory.createString(Double.toString(value));
    }

    @Override
    public SFloat toFloat() {
        return this;
    }

    /**
     * @return return SInt with the truncated value
     */
    @Override
    public SInt toInt() {
        return factory.createInt((int) value);
    }

    /**
     * plus, minus, mul, div
     * operates with another numerical object to return non null
     * @param obj any SType
     * @return SFloat
     */
    @Override
    public STypeI plus(STypeI obj) {
        return obj.sumWithFloat(value, 1);
    }

    @Override
    public STypeI minus(STypeI obj) {
        return obj.sumWithFloat(value, -1);
    }

    @Override
    public STypeI div(STypeI obj) {
        return obj.mulWithFloat(value, -1);
    }

    @Override
    public STypeI mul(STypeI obj) {
        return obj.mulWithFloat(value, 1);
    }

    @Override
    public SString sumWithString(String value) {
        return factory.createString(value + this.value);
    }


    // double-dispatch
    @Override
    public NumTypeI sumWithInteger(int value, int mode) {
        return  factory.createFloat(value + this.value * mode);
    }

    @Override
    public NumTypeI mulWithInteger(int value, int mode) {
        return factory.createFloat(value * Math.pow(this.value, mode));
    }

    @Override
    public NumTypeI sumWithFloat(double value, int mode) {
        return factory.createFloat(value + this.value * mode);
    }

    @Override
    public NumTypeI mulWithFloat(double value, int mode) {
        return factory.createFloat(value * Math.pow(this.value, mode));
    }

    @Override
    public NumTypeI sumWithBinary(int value, int mode) {
        return factory.createFloat(value + (this.value * mode));
    }

    @Override
    public NumTypeI mulWithBinary(int value, int mode) {
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
