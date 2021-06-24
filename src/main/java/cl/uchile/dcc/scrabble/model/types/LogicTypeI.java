package cl.uchile.dcc.scrabble.model.types;

/**
 * interface that encapsulates all specific methods for logic type objects
 * (SBinary and SBool)
 */

public interface LogicTypeI extends STypeI {

    /**
     * Operations
     */

    STypeI not();

    STypeI and(STypeI obj);

    STypeI or(STypeI obj);


    /**
     * used for double-dispatch only

     * double dispatch functions
     * (operation)With(type): defines what to do when (operated) with (type).
     */

    LogicTypeI andWithBool(boolean Value);

    LogicTypeI orWithBool(boolean Value);

    SBinary andWithBinary(String Value);

    SBinary orWithBinary(String Value);
}
