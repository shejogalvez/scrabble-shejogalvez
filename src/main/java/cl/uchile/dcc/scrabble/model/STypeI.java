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


}
