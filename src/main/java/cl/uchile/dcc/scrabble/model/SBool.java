package cl.uchile.dcc.scrabble.model;

public class SBool extends AbstractType implements LogicTypeI{

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
    public LogicTypeI not(){
        return new SBool(!value);
    }

    @Override
    public LogicTypeI and(LogicTypeI obj){
        return obj.andWithBool(value);
    }

    @Override
    public LogicTypeI or(LogicTypeI obj){
        return obj.orWithBool(value);
    }

    @Override
    public SString sumWithString(String value) {
        return new SString(value + this.value);
    }

    @Override
    public LogicTypeI andWithBool(boolean value){
        return new SBool(value & this.value);
    }

    @Override
    public LogicTypeI orWithBool(boolean value) {
        return new SBool(value & this.value);
    }

    @Override
    public SBinary andWithBinary(String value){
        int len = value.length();
        StringBuilder result = new StringBuilder();
        if (this.value) {
            return new SBinary(value);
        }
        else{
            for (int i = len; i > 0; i--) {
                result.insert(0, '0');
            }
        }
        return new SBinary(result.toString());
    }

    @Override
    public SBinary orWithBinary(String value){
        int len = value.length();
        StringBuilder result = new StringBuilder();
        if (this.value) {
            for (int i = len; i > 0; i--) {
                result.insert(0, '1');
            }
        }
        else{
            return new SBinary(value);
        }
        return new SBinary(result.toString());
    }
}
