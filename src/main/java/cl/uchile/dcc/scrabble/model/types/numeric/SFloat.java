package cl.uchile.dcc.scrabble.model.types.numeric;

import cl.uchile.dcc.scrabble.model.types.AbstractType;
import cl.uchile.dcc.scrabble.model.types.SString;
import cl.uchile.dcc.scrabble.model.types.STypeI;

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

}
