package cl.uchile.dcc.scrabble.model.tree.bi;

import cl.uchile.dcc.scrabble.model.tree.NodeI;
import cl.uchile.dcc.scrabble.model.types.STypeI;

public class Or extends Node2 {

    public Or(NodeI op1, NodeI op2) {
        super(op1, op2);
    }

    @Override
    public STypeI solve() {
        return (op1.solve()).or(op2.solve());
    }
}
