package cl.uchile.dcc.scrabble.model;

import java.util.concurrent.Callable;

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

    /**
     * transformations
     */

    @Override
    public STypeI and(STypeI obj){
        return andWithBool(value);
    }

    @Override
    public STypeI or(STypeI obj){
        return orWithBool(value);
    }

    @Override
    public SString sumWithString(String value) {
        return new SString(value + this.value);
    }

    @Override
    public STypeI andWithBool(boolean value){
        return new SBool(value & this.value);
    }
}
