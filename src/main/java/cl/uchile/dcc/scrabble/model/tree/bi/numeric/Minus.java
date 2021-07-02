package cl.uchile.dcc.scrabble.model.tree.bi.numeric;

import cl.uchile.dcc.scrabble.model.tree.bi.Node2;
import cl.uchile.dcc.scrabble.model.types.STypeI;

public class Minus extends Node2 {

    public Minus(STypeI op1, STypeI op2) {
        super(op1, op2);
    }

    @Override
    public STypeI solve() {
        return op1.solve().minus(op2.solve());
    }
}
