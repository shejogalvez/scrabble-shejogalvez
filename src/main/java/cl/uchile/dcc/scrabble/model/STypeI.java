package cl.uchile.dcc.scrabble.model;


public interface STypeI {

    /**
     * to(Type) : tries to transform itself (make another object) to the desired Type
     * @return object transformed to (Type) or null if can't be transformed to that Type
     *
     * self.to(sameType)() returns self
     */
    SString toSString();

    SBool toBool();

    SFloat toFloat();

    SInt toInt();

    SBinary toBinary();

    /**
     * functions expected to be used as operations
     */

    STypeI plus(STypeI obj);

    STypeI minus(STypeI obj);

    STypeI div(STypeI obj);

    STypeI mul(STypeI obj);

    /**
     * used for double-dispatch only
     */

    SString sumWithString(String value);

    STypeI sumWithBinary(int Value, int mode);

    STypeI mulWithBinary(int Value, int mode);

    STypeI sumWithInteger(int Value, int mode);

    STypeI mulWithInteger(int Value, int mode);

    STypeI sumWithFloat(double Value, int mode);

    STypeI mulWithFloat(double Value, int mode);
}
