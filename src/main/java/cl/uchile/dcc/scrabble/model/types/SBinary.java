package cl.uchile.dcc.scrabble.model.types;

import cl.uchile.dcc.scrabble.model.types.logic.LogicTypeI;
import cl.uchile.dcc.scrabble.model.types.numeric.NumTypeI;
import cl.uchile.dcc.scrabble.model.types.numeric.SFloat;
import cl.uchile.dcc.scrabble.model.types.numeric.SInt;

/**
 * class that represents a positive integer with a String of 0's and 1's as value
 */
public class SBinary extends AbstractType implements LogicTypeI, NumTypeI {

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

    @Override
    public SString toSString() {
        return factory.createString(value);
    }

    @Override
    public SFloat toFloat(){
        return factory.createFloat(valueToInt());
    }

    @Override
    public SInt toInt(){
        return factory.createInt(valueToInt());
    }

    @Override
    public SBinary toBinary(){
        return this;
    }


    /**
     * Operations
     */

    //numerical

    /**
     * adds numerically itself with another binary or with an integer returning
     * another binary, if not returns null
     * @param obj : any SType object.
     * @return SBinary
     */
    @Override
    public STypeI plus(STypeI obj) {
        return obj.sumWithBinary(valueToInt(), 1);
    }

    /**
     * subtracts numerically itself with another binary or with an integer returning
     * another binary, if not returns null
     * @param obj : any SType object.
     * @return SBinary
     */
    @Override
    public STypeI minus(STypeI obj) {
        return obj.sumWithBinary(valueToInt(), -1);
    }

    /**
     * divides numerically itself with another binary or with an integer returning
     * another binary, if not returns null
     * @param obj : any SType object.
     * @return SBinary
     */
    @Override
    public STypeI div(STypeI obj) {
        return obj.mulWithBinary(valueToInt(), -1);
    }

    /**
     * multiplies numerically itself with another binary or with an integer returning
     * a binary, if not returns null
     * @param obj : any SType object.
     * @return SBinary
     */
    @Override
    public STypeI mul(STypeI obj) {
        return obj.mulWithBinary(valueToInt(), 1);
    }

    /**
     * double dispatch functions
     * (operation)With(type): defines what to do when (operated) with (type).
     */
    @Override
    public SString sumWithString(String value) {
        return factory.createString(value + this.value);
    }

    @Override
    public NumTypeI sumWithInteger(int value, int mode){
        return factory.createInt(value + (valueToInt() * mode));
    }

    @Override
    public NumTypeI mulWithInteger(int value, int mode){
        return factory.createInt((int) (value * Math.pow(valueToInt(), mode)));
    }

    @Override
    public NumTypeI sumWithFloat(double value, int mode){
        return factory.createFloat(value + (valueToInt() * mode));
    }

    @Override
    public NumTypeI mulWithFloat(double value, int mode){
        return factory.createFloat(value * Math.pow(valueToInt(), mode));
    }

    @Override
    public NumTypeI sumWithBinary(int value, int mode){
        int value2 = valueToInt();
        String result = SInt.intToBinary((value + value2 * mode));
        return factory.createBinary(result);
    }

    @Override
    public NumTypeI mulWithBinary(int value, int mode){
        int value2 = valueToInt();
        String result = SInt.intToBinary((int) (value * Math.pow(value2, mode)));
        return factory.createBinary(result);
    }

    //logical

    /**
     * changes every bit of own value and returns another SBinary
     * @return SBinary
     */
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
        return factory.createBinary(result.toString());
    }

    /**
     * applies and with bool value and every bit creating Factory.createBinary
     * @param obj : SBinary or SBool
     * @return SBinary
     */
    @Override
    public STypeI and(STypeI obj){
        return ((LogicTypeI)obj).andWithBinary(value);
    }

    /**
     * applies or with bool value and every bit creating Factory.createBinary
     * @param obj : SBinary or SBool
     * @return SBinary
     */
    @Override
    public STypeI or(STypeI obj){
        return ((LogicTypeI)obj).orWithBinary(value);
    }


    /**
     * double dispatch functions
     * (operation)With(type): defines what to do when (operated) with (type).
     */
    @Override
    public LogicTypeI andWithBool(boolean value){
        int len = this.value.length();
        StringBuilder result = new StringBuilder();
        if (value) {
            return factory.createBinary(this.value);
        }
        else{
            for (int i = len; i > 0; i--) {
                result.insert(0, '0');
            }
        }
        return factory.createBinary(result.toString());
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
            return factory.createBinary(this.value);
        }
        return factory.createBinary(result.toString());
    }

    /**
     * andWithBinary always returns a SBinary with value length equal to the smaller binary
     */
    @Override
    public SBinary andWithBinary(String Value) {
        // does bit by bit and
        int n = Math.min(Value.length(), value.length());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++){
            if (value.charAt(value.length() -i -1) == '1' && Value.charAt(Value.length()-i -1) == '1') {
                result.insert(0, '1');
            } else {
                result.insert(0, '0');
            }
        }
        // when cant make comparison the rest are zeros
        return factory.createBinary(result.toString());
    }

    /**
     * orWithBinary always returns a SBinary with value length equal to the larger binary
     */
    @Override
    public SBinary orWithBinary(String Value) {
        // does bit by bit or
        String bigS = (Value.length() < value.length() ? value : Value);
        int n = Math.min(Value.length(), value.length());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++){
            if (value.charAt(value.length() -i -1) == '1' || Value.charAt(Value.length()-i -1) == '1') {
                result.insert(0, '1');
            } else {
                result.insert(0, '0');
            }
        }
        // later it fills with the larger binary values
        for (int i = n; i < bigS.length(); i++) {
            if (bigS.charAt(bigS.length() - i - 1) == '1') {
                result.insert(0, '1');
            }
            else {
                result.insert(0, '0');
            }
        }
        return factory.createBinary(result.toString());
    }

}
