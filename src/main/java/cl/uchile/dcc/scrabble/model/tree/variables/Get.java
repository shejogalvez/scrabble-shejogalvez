package cl.uchile.dcc.scrabble.model.tree.variables;

import cl.uchile.dcc.scrabble.model.tree.AbstractNode;
import cl.uchile.dcc.scrabble.model.types.STypeI;

/**
 * Pa que no colisionen las cosas(¿)
 */
public class Get extends AbstractNode {

    private final String name;
    private final VarFactory varFactory = VarFactory.createFactory();

    public Get(String name){
        this.name = name;
    }

    @Override
    public STypeI solve() {
        return varFactory.getVariable(name).solve();
    }

}
