package cl.uchile.dcc.scrabble.model.flujo;

/**
 * fluxNodes are actions or steps done by a program, these steps when they act, they resolve
 * in contrast to NodeI these nodes return nothing.
 */
public interface FluxNode {

    void act();

}
