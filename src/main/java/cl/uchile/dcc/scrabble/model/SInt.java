package cl.uchile.dcc.scrabble.model;

public class SInt extends AbstractType{

    private int value;

    public SInt(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

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
        return null;
    }
}
