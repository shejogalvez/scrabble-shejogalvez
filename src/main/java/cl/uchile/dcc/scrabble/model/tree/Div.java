package cl.uchile.dcc.scrabble.model.tree;

import cl.uchile.dcc.scrabble.model.types.STypeI;

public class Div extends Node2 {

    public Div(NodeI op1, NodeI op2) {
        super(op1, op2);
    }

    @Override
    public STypeI solve() {
        return (op1.solve()).div(op2.solve());
    }
}
