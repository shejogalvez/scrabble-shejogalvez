package cl.uchile.dcc.scrabble.model.flujo;

import cl.uchile.dcc.scrabble.model.tree.NodeI;
import cl.uchile.dcc.scrabble.model.tree.variables.VarFactory;

/**
 * class that represent a value set to a variable
 */
public class Set extends Flux{

    static final VarFactory varFactory = VarFactory.createFactory();
    String name;
    NodeI value;

    public Set(String name, NodeI value){
        this.name = name;
        this.value = value;
    }

    @Override
    public void act() {
        varFactory.setVariable(name, value);
    }
}
