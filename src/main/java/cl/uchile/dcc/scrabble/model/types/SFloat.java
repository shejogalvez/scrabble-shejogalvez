package cl.uchile.dcc.scrabble.model.types;

/**
 * class that represents a real number with a double value
 */
public class SFloat extends AbstractType {

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
        return new SString(Double.toString(value));
    }

    @Override
    public SFloat toFloat() {
        return this;
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
        return new SString(value + this.value);
    }

    @Override
    public STypeI sumWithInteger(int value, int mode) {
        return  new SFloat(value + this.value * mode);
    }

    @Override
    public STypeI mulWithInteger(int value, int mode) {
        return new SFloat(value * Math.pow(this.value, mode));
    }

    @Override
    public STypeI sumWithFloat(double value, int mode) {
        return new SFloat(value + this.value * mode);
    }

    @Override
    public STypeI mulWithFloat(double value, int mode) {
        return new SFloat(value * Math.pow(this.value, mode));
    }

    @Override
    public STypeI sumWithBinary(int value, int mode) {
        return new SFloat(value + (this.value * mode));
    }

    @Override
    public STypeI mulWithBinary(int value, int mode) {
        return new SFloat(value * Math.pow(this.value, mode));
    }

}
