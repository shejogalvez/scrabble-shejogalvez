package cl.uchile.dcc.scrabble.model;

public class SBinary extends AbstractType implements LogicTypeI{
    /**
     * class that represents a positive integer with a binary number String
     */

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

    //numerical
    @Override
    public STypeI plus(STypeI obj) {
        return obj.sumWithBinary(valueToInt(), 1);
    }

    @Override
    public STypeI minus(STypeI obj) {
        return obj.sumWithBinary(valueToInt(), -1);
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

    @Override
    public STypeI sumWithInteger(int value, int mode){
        return new SInt(value + (valueToInt() * mode));
    }

    @Override
    public STypeI mulWithInteger(int value, int mode){
        return new SInt((int) (value * Math.pow(valueToInt(), mode)));
    }

    @Override
    public STypeI sumWithFloat(double value, int mode){
        return new SFloat(value + (valueToInt() * mode));
    }

    @Override
    public STypeI mulWithFloat(double value, int mode){
        return new SFloat(value * Math.pow(valueToInt(), mode));
    }

    @Override
    public STypeI sumWithBinary(int value, int mode){
        int value2 = valueToInt();
        String result = SInt.intToBinary((value + value2 * mode));
        return new SBinary(result);
    }

    @Override
    public STypeI mulWithBinary(int value, int mode){
        int value2 = valueToInt();
        String result = SInt.intToBinary((int) (value * Math.pow(value2, mode)));
        return new SBinary(result);
    }

    //logical
    @Override
    public LogicTypeI not(){
        int len = value.length();
        StringBuilder result = new StringBuilder();
        for (int i = len; i > 0; i--) {
            if (value.charAt(i - 1) == '1') {
                result.insert(0, '0');
            } else {
                result.insert(0, '1');
            }
        }
        return new SBinary(result.toString());
    }

    @Override
    public LogicTypeI and(LogicTypeI obj){
        return obj.andWithBinary(value);
    }

    @Override
    public LogicTypeI or(LogicTypeI obj){
        return obj.orWithBinary(value);
    }

    @Override
    public LogicTypeI andWithBool(boolean value){
        int len = this.value.length();
        StringBuilder result = new StringBuilder();
        if (value) {
            return new SBinary(this.value);
        }
        else{
            for (int i = len; i > 0; i--) {
                result.insert(0, '0');
            }
        }
        return new SBinary(result.toString());
    }

    @Override
    public LogicTypeI orWithBool(boolean value){
        int len = this.value.length();
        StringBuilder result = new StringBuilder();
        if (value) {
            for (int i = len; i > 0; i--) {
                result.insert(0, '1');
            }
        }
        else{
            return new SBinary(this.value);
        }
        return new SBinary(result.toString());
    }

    @Override
    public SBinary andWithBinary(String Value) {
        return null;
    }

    @Override
    public SBinary orWithBinary(String Value) {
        return null;
    }

}
