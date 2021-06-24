package cl.uchile.dcc.scrabble.model.types;


import cl.uchile.dcc.scrabble.model.tree.NodeI;

public interface STypeI extends NodeI {

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

    // Operations
    STypeI plus(STypeI obj);

    STypeI minus(STypeI obj);

    STypeI div(STypeI obj);

    STypeI mul(STypeI obj);

    STypeI and(STypeI obj);

    STypeI or(STypeI obj);

    STypeI not();

    /*
     * used for double-dispatch only

     * double dispatch functions
     * (operation)With(type): defines what to do when (operated) with (type).
     */

    SString sumWithString(String value);

    STypeI sumWithBinary(int Value, int mode);

    STypeI mulWithBinary(int Value, int mode);

    STypeI sumWithInteger(int Value, int mode);

    STypeI mulWithInteger(int Value, int mode);

    STypeI sumWithFloat(double Value, int mode);

    STypeI mulWithFloat(double Value, int mode);

    // tree

    STypeI solve();
}