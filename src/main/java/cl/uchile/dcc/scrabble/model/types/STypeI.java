package cl.uchile.dcc.scrabble.model.types;


import cl.uchile.dcc.scrabble.model.tree.NodeI;
import cl.uchile.dcc.scrabble.model.types.numeric.NumTypeI;
import cl.uchile.dcc.scrabble.model.types.numeric.SBinary;
import cl.uchile.dcc.scrabble.model.types.numeric.SFloat;
import cl.uchile.dcc.scrabble.model.types.numeric.SInt;
import org.jetbrains.annotations.NotNull;

public interface STypeI extends NodeI, Comparable{

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

    NumTypeI sumWithBinary(int Value, int mode);

    NumTypeI mulWithBinary(int Value, int mode);

    NumTypeI sumWithInteger(int Value, int mode);

    NumTypeI mulWithInteger(int Value, int mode);

    NumTypeI sumWithFloat(double Value, int mode);

    STypeI mulWithFloat(double Value, int mode);

    SString sumWithString(String value);

    // tree

    /**
     * @return self
     */
    STypeI solve();

    // compare
    int compareTo(@NotNull Object o);
}
