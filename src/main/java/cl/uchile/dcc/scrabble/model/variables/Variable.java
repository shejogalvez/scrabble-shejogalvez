package cl.uchile.dcc.scrabble.model.variables;

import cl.uchile.dcc.scrabble.model.tree.NodeI;
import cl.uchile.dcc.scrabble.model.types.STypeI;

/**
 * class that represents a Variable, an special object that can mutate it's type and value
 */
public class Variable implements NodeI{

    private STypeI value;

    public Variable(STypeI val){
        value = val;
    }

    public void setValue(STypeI val){
        value = val;
    }

    /**
     * @return value contained in the variable
     */
    @Override
    public STypeI solve() {
        return value;
    }

}
