package cl.uchile.dcc.scrabble.model.tree;

import cl.uchile.dcc.scrabble.model.types.STypeI;

public interface NodeI {

    /**
     * solves a AST using recursion(?)
     * @return result of the expression of the Tree
     */
    STypeI solve();

}
