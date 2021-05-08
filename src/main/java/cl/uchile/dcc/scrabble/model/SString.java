package cl.uchile.dcc.scrabble.model;

public class SString extends AbstractType{

    private String value;
    public SString(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    @Override
    public SString toSString(){
        return this;
    }
}
