package cl.uchile.dcc.scrabble.model.flujo;

import cl.uchile.dcc.scrabble.model.tree.NodeI;

/**
 * your everyday if conditional.
 * if cond is true, do ifTrue, else do ifFalse
 */

public class If extends Flux{

    NodeI cond;
    FluxNode ifTrue;
    FluxNode ifFalse;

    public If(NodeI cond, FluxNode ifTrue, FluxNode ifFalse){
        this.cond = cond;
        this.ifFalse = ifFalse;
        this.ifTrue = ifTrue;
    }

    /**
     * can create an If setting only an ifTrue action
     */
    public If(NodeI cond, FluxNode ifTrue){
        this.cond = cond;
        this.ifFalse = Pass.createPass();
        this.ifTrue = ifTrue;
    }

    @Override
    public void act(){

        if (cond.solve().equals(tru)) {
            ifTrue.act();
        } else {
            ifFalse.act();
        }
    }
}
