package cl.uchile.dcc.scrabble.model.tree;


import cl.uchile.dcc.scrabble.model.types.STypeI;


public class Not extends AbstractNode {

    protected NodeI op1;

    public Not(NodeI op1){
        this.op1 = op1;
    }

    public STypeI solve(){
        return op1.solve().not();
    }

}
