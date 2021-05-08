package cl.uchile.dcc.scrabble.model;

public class SBinary extends AbstractType{

    private String value;

    public SBinary(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }


    public SString toSString() {
        return new SString(value);
    }

    @Override
    public SFloat toFloat(){
        int len = value.length();
        double result = 0.0;
        for (int i=len; i>0; i--){
            if (value.charAt(i-1) == '1'){
                result += Math.pow(2, len-i);
            }
        }
        return new SFloat(result);
    }

    @Override
    public SInt toInt(){
        int len = value.length();
        int result = 0;
        for (int i=len; i>0; i--){
            if (value.charAt(i-1) == '1'){
                result += Math.pow(2, len-i);
            }
        }
        return new SInt(result);
    }

    @Override
    public SBinary toBinary(){
        return this;
    }

}
