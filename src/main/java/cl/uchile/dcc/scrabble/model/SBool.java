package cl.uchile.dcc.scrabble.model;

public class SBool extends AbstractType{

    private boolean value;

    public SBool(boolean value){
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public SString toSString(){
        return new SString(Boolean.toString(value));
    }

    @Override
    public SBool toBool(){
        return this;
    }
}
