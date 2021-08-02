package cl.uchile.dcc.scrabble.model.tree;

import cl.uchile.dcc.scrabble.model.types.STypeI;

/**
 * Any Set of actions that returns a SType object should be in a AST, hence
 * implement NodeI
 */

public interface NodeI{

    /**
     * solves a AST using recursion(?)
     * @return result of the expression of the Tree
     */
    STypeI solve();


}
