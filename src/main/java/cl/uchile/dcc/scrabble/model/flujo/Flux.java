package cl.uchile.dcc.scrabble.model.flujo;


import cl.uchile.dcc.scrabble.model.types.SBool;
import cl.uchile.dcc.scrabble.model.types.TypeFactory;

public abstract class Flux implements FluxNode {

    protected static TypeFactory factory = TypeFactory.createFactory();
    protected static SBool tru = factory.createBool(true);
    protected static SBool fals = factory.createBool(false);

}
