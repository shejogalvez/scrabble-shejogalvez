package cl.uchile.dcc.scrabble.model.tree.toType;

import cl.uchile.dcc.scrabble.model.tree.AbstractNode;
import cl.uchile.dcc.scrabble.model.tree.NodeI;
import cl.uchile.dcc.scrabble.model.types.STypeI;

public class ToString extends AbstractNode {

    private final NodeI expression;

    public ToString(NodeI expression){
        this.expression = expression;
    }

    @Override
    public STypeI solve() {
        return expression.solve().toSString();
    }
}
