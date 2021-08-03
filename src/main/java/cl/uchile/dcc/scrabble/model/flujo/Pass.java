package cl.uchile.dcc.scrabble.model.flujo;

/**
 * class that represents the no action Node, or 'pass' in some languages.
 * As a null type class it's represented by a singleton.
 */
public class Pass extends Flux{

    private static Pass myself = null;

    private Pass(){
        super();
    }

    public static Pass createPass(){
        if(myself == null){
            myself = new Pass();
        }
        return myself;
    }

    @Override
    public void act() {

    }
}
