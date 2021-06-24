package cl.uchile.dcc.scrabble.model.tree;

import cl.uchile.dcc.scrabble.model.types.STypeI;

public class Mult extends Node2 {

    public Mult(NodeI op1, NodeI op2){
        super(op1, op2);
    }

    @Override
    public STypeI solve() {
        return (op1.solve()).mul(op2.solve());
    }
}
