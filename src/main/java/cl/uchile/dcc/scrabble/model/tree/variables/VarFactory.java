package cl.uchile.dcc.scrabble.model.tree.variables;

import cl.uchile.dcc.scrabble.model.tree.NodeI;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * class where variables are defined, stored, and retrieved.
 */
public class VarFactory {

    private static VarFactory factory = null;

    Map<String, @NotNull Variable> variables_map = new HashMap<>();

    public static VarFactory createFactory(){
        if (factory == null){
            factory = new VarFactory();
        }
        return factory;
    }

    /**
     * creates a variable with given name and value given by the inputted expression, stores the variable in
     * variables_map
     */
    public void setVariable(String name, NodeI expression){
        if (variables_map.get(name) == null){
            variables_map.put(name, new Variable(expression.solve()));
        }
        else{
            variables_map.get(name).setValue(expression.solve());
        }
    }

    /**
     * looks for a variable named "name" in variables_map, if exist returns it's value.
     * if it doesn't exist, returns null
     */
    public Variable getVariable(String name){
        return variables_map.get(name);
    }

}
