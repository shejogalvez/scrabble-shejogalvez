package cl.uchile.dcc.scrabble.model.types.factory;

import cl.uchile.dcc.scrabble.model.types.*;
import cl.uchile.dcc.scrabble.model.types.numeric.*;
import cl.uchile.dcc.scrabble.model.types.logic.*;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * class that contains creation methods for the Scrabble type objects and references to existing objects
 * so that there are no duplicates.
 */
public class TypeFactory {

    private static TypeFactory factory = null;

    Map<String, @NotNull SInt> int_map = new HashMap<>();
    Map<String, @NotNull SString> string_map = new HashMap<>();
    Map<String, @NotNull SBinary> binary_map = new HashMap<>();
    Map<String, @NotNull SBool> bool_map = new HashMap<>();
    Map<String, @NotNull SFloat> float_map = new HashMap<>();

    // dont need more than one factory innit?
    // actually it's pretty important that there only is one
    public static TypeFactory createFactory() {
        if (factory == null) {
            factory = new TypeFactory();
        }
        return factory;
    }

    /**
     * create Type, if hasn't benn created, create new. if it was created, it's returned from respective hashmap
     */
    public SInt createInt(int value) {
        if (int_map.get(Integer.toString(value)) == null) {
            SInt result = new SInt(value);
            int_map.put(Integer.toString(value), result);
            return result;
        } else {
            return int_map.get(Integer.toString(value));
        }
    }

    public SFloat createFloat(double value) {
        if (float_map.get(Double.toString(value)) == null) {
            SFloat result = new SFloat(value);
            float_map.put(Double.toString(value), result);
            return result;
        } else {
            return float_map.get(Double.toString(value));
        }
    }

    public SBinary createBinary(String value) {
        if (binary_map.get(value) == null) {
            SBinary result = new SBinary(value);
            binary_map.put(value, result);
            return result;
        } else {
            return binary_map.get(value);
        }
    }

    public SString createString(String value) {
        if (string_map.get(value) == null) {
            SString result = new SString(value);
            string_map.put(value, result);
            return result;
        } else {
            return string_map.get(value);
        }
    }

    public SBool createBool(boolean value) {
        if (bool_map.get(Boolean.toString(value)) == null) {
            SBool result = new SBool(value);
            bool_map.put(Boolean.toString(value), result);
            return result;
        } else {
            return bool_map.get(Boolean.toString(value));
        }
    }

}
