package cl.uchile.dcc.scrabble.model;

public class SString extends AbstractType{

    private String value;
    public SString(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    /**
     * transformations
     */
    @Override
    public SString toSString(){
        return this;
    }

    /**
     * Operations
     */
    @Override
    public STypeI plus(STypeI obj){
        return obj.sumWithString(value);
    }

    @Override
    public SString sumWithString(String value) {
        return new SString(value + this.value);
    }
}
