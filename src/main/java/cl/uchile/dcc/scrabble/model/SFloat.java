package cl.uchile.dcc.scrabble.model;

public class SFloat extends AbstractType {

    private double value;

    public SFloat(double value) {
        this.value = value;
    }

    public double getValue(){
        return value;
    }

    @Override
    public SString toSString(){
        return new SString(Double.toString(value));
    }

    @Override
    public SFloat toFloat() {
        return this;
    }
}
