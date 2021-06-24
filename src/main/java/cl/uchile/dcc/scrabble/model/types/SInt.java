package cl.uchile.dcc.scrabble.model.types;

/**
 * class that represents a integer with an integer value
 */
public class SInt extends AbstractType{

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
        return new SString(Integer.toString(value));
    }

    @Override
    public SFloat toFloat(){
        return new SFloat(value);
    }

    @Override
    public SInt toInt(){
        return this;
    }

    @Override
    public SBinary toBinary(){
        return new SBinary(intToBinary(value));
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

    @Override
    public SString sumWithString(String value) {
        return new SString(value + this.value);
    }

    @Override
    public STypeI sumWithBinary(int value, int mode) {
        return new SBinary(intToBinary(value + (this.value * mode)));
    }

    @Override
    public STypeI mulWithBinary(int value, int mode) {
        return new SBinary(intToBinary((int) (value * Math.pow(this.value, mode))));
    }

    @Override
    public STypeI sumWithInteger(int value, int mode) {
        return new SInt(value + this.value * mode);
    }

    @Override
    public STypeI mulWithInteger(int value, int mode) {
        return new SInt((int) (value * Math.pow(this.value, mode)));
    }

    @Override
    public STypeI sumWithFloat(double value, int mode) {
        return new SFloat(value + this.value * mode);
    }

    @Override
    public STypeI mulWithFloat(double value, int mode) {
        return new SFloat(value * Math.pow(this.value, mode));
    }


}
