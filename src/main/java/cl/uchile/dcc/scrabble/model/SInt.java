package cl.uchile.dcc.scrabble.model;

public class SInt extends AbstractType{

    private int value;

    public SInt(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
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

    /**
     * transformations
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
        return null;
    }

    @Override
    public STypeI mulWithBinary(int value, int mode) {
        return null;
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
