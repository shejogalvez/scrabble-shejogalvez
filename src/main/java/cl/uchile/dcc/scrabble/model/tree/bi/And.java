package cl.uchile.dcc.scrabble.model.tree.bi;


import cl.uchile.dcc.scrabble.model.tree.NodeI;
import cl.uchile.dcc.scrabble.model.types.SBool;
import cl.uchile.dcc.scrabble.model.types.SString;
import cl.uchile.dcc.scrabble.model.types.STypeI;
import cl.uchile.dcc.scrabble.model.types.numeric.SBinary;
import cl.uchile.dcc.scrabble.model.types.numeric.SFloat;
import cl.uchile.dcc.scrabble.model.types.numeric.SInt;

public class And extends Node2 {

    public And(NodeI op1, NodeI op2) {
        super(op1, op2);
    }

    @Override
    public STypeI solve() {
        return (op1.solve()).and(op2.solve());
    }


}
