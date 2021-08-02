package cl.uchile.dcc.scrabble.model.flujo;

import cl.uchile.dcc.scrabble.model.tree.NodeI;

/**
 * your everyday while cycle.
 * while cond is true, do whileTrue
 */

public class While extends Flux{

    NodeI cond;
    FluxNode whileTrue;

    public While(NodeI cond, FluxNode whileTrue){
        this.cond = cond;
        this.whileTrue = whileTrue;
    }


    @Override
    public void act() {
        while(cond.solve().equals(tru)){
            whileTrue.act();
        }
    }
}
