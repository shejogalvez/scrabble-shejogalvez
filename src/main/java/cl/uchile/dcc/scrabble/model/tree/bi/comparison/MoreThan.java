package cl.uchile.dcc.scrabble.model.tree.bi.comparison;

import cl.uchile.dcc.scrabble.model.tree.NodeI;
import cl.uchile.dcc.scrabble.model.types.STypeI;

public class MoreThan extends Compare {

    public MoreThan(NodeI op1, NodeI op2) {
        super(op1, op2);
    }

    @Override
    public STypeI solve(){
        if (op1.solve().compareTo(op2.solve()) > 0){
            return tru;
        }
        else{
            return fals;
        }
    }

}
