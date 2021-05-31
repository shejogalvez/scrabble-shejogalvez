package cl.uchile.dcc.scrabble.model;

/**
 * interface that encapsulates all specific methods for logic type objects
 * (SBinary and SBool)
 */

public interface LogicTypeI extends STypeI {

    LogicTypeI andWithBool(boolean Value);

    LogicTypeI orWithBool(boolean Value);

    SBinary andWithBinary(String Value);

    SBinary orWithBinary(String Value);

    LogicTypeI not();

    LogicTypeI and(LogicTypeI obj);

    LogicTypeI or(LogicTypeI obj);
}
