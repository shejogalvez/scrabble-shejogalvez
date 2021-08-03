package cl.uchile.dcc.scrabble.model.types.numeric;

import cl.uchile.dcc.scrabble.model.types.STypeI;

public interface NumTypeI extends STypeI {

    // Operations
    STypeI plus(STypeI obj);

    STypeI minus(STypeI obj);

    STypeI div(STypeI obj);

    STypeI mul(STypeI obj);


    NumTypeI sumWithBinary(int Value, int mode);

    NumTypeI mulWithBinary(int Value, int mode);

    NumTypeI sumWithInteger(int Value, int mode);

    NumTypeI mulWithInteger(int Value, int mode);

    NumTypeI sumWithFloat(double Value, int mode);

    NumTypeI mulWithFloat(double Value, int mode);

    // compareTo followup

    int compare(double number);
}
