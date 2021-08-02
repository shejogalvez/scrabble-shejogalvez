package cl.uchile.dcc.scrabble.model.flujo;

/**
 * class that can bundle many fluxNodes, it resolves them in order
 */
public class Bundle extends Flux{

    FluxNode[] args;

    public Bundle(FluxNode[] args){
        this.args = args;
    }

    @Override
    public void act() {
        for (FluxNode arg : args) {
            arg.act();
        }
    }
}
