package cl.uchile.dcc.scrabble.model.tree.bi;

import cl.uchile.dcc.scrabble.model.tree.AbstractNode;
import cl.uchile.dcc.scrabble.model.tree.NodeI;
import cl.uchile.dcc.scrabble.model.types.STypeI;
import org.jetbrains.annotations.NotNull;

/**
 * class that contains general attributes for binary operations type nodes
 */
public abstract class Node2 extends AbstractNode {

    protected NodeI op1;
    protected NodeI op2;

    public Node2(NodeI op1, NodeI op2){
        this.op1 = op1;
        this.op2 = op2;
    }


}
