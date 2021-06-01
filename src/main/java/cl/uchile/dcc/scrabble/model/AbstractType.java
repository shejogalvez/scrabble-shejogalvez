package cl.uchile.dcc.scrabble.model;

/**
 * Abstract class that contains recurrent outputs of SType functions to avoid to copy code
 */
public abstract class AbstractType implements STypeI{

    /**
     * to(Type) : tries to transform itself (make another object) to the desired Type
     * @return object transformed to (Type) or null if can't be transformed to that Type
     *
     * self.to(sameType)() returns self
     */

    public abstract SString toSString();

    public SBool toBool() {
        return null;
    }


    public SFloat toFloat() {
        return null;
    }


    public SInt toInt() {
        return null;
    }


    public SBinary toBinary() {
        return null;
    }

    @Override
    public STypeI plus(STypeI obj) {
        return null;
    }

    @Override
    public STypeI minus(STypeI obj) {
        return null;
    }

    @Override
    public STypeI div(STypeI obj) {
        return null;
    }

    @Override
    public STypeI mul(STypeI obj) {
        return null;
    }

    @Override
    public STypeI sumWithBinary(int Value, int mode) {
        return null;
    }

    @Override
    public STypeI mulWithBinary(int Value, int mode) {
        return null;
    }

    @Override
    public STypeI sumWithInteger(int Value, int mode) {
        return null;
    }

    @Override
    public STypeI mulWithInteger(int Value, int mode) {
        return null;
    }

    @Override
    public STypeI sumWithFloat(double Value, int mode) {
        return null;
    }

    @Override
    public STypeI mulWithFloat(double Value, int mode) {
        return null;
    }

}
