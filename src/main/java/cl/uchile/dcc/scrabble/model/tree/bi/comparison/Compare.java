package cl.uchile.dcc.scrabble.model.tree.bi.comparison;

import cl.uchile.dcc.scrabble.model.tree.NodeI;
import cl.uchile.dcc.scrabble.model.tree.bi.Node2;
import cl.uchile.dcc.scrabble.model.types.SBool;
import cl.uchile.dcc.scrabble.model.types.TypeFactory;

public abstract class Compare extends Node2 {

    private static final TypeFactory factory = TypeFactory.createFactory();
    protected static SBool tru = factory.createBool(true);
    protected static SBool fals = factory.createBool(false);

    Compare(NodeI op1, NodeI op2) {
        super(op1, op2);
    }

}
