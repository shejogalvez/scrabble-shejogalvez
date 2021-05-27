package cl.uchile.dcc.scrabble.model;

public class SBinary extends AbstractType{

    private String value;

    public SBinary(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    // converts binary value to an int
    private int valueToInt(){
        int len = value.length();
        int result = 0;
        for (int i=len; i>0; i--){
            if (value.charAt(i-1) == '1'){
                result += Math.pow(2, len-i);
            }
        }
        return result;
    }


    public SString toSString() {
        return new SString(value);
    }

    @Override
    public SFloat toFloat(){
        return new SFloat(valueToInt());
    }

    @Override
    public SInt toInt(){
        return new SInt(valueToInt());
    }

    @Override
    public SBinary toBinary(){
        return this;
    }


    /**
     * transformations
     */

    @Override
    public STypeI plus(STypeI obj) {
        return obj.mulWithBinary(valueToInt(), 1);
    }

    @Override
    public STypeI minus(STypeI obj) {
        return obj.mulWithBinary(valueToInt(), -1);
    }

    @Override
    public STypeI div(STypeI obj) {
        return obj.mulWithBinary(valueToInt(), -1);
    }

    @Override
    public STypeI mul(STypeI obj) {
        return obj.mulWithBinary(valueToInt(), 1);
    }

    @Override
    public SString sumWithString(String value) {
        return new SString(value + this.value);
    }

}
