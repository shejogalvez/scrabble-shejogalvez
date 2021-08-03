package main.model;

import cl.uchile.dcc.scrabble.model.types.TypeFactory;
import cl.uchile.dcc.scrabble.model.tree.Not;
import cl.uchile.dcc.scrabble.model.tree.bi.numeric.Add;
import cl.uchile.dcc.scrabble.model.tree.bi.numeric.Minus;
import cl.uchile.dcc.scrabble.model.tree.bi.numeric.Mult;
import cl.uchile.dcc.scrabble.model.types.numeric.SBinary;
import cl.uchile.dcc.scrabble.model.types.SString;
import cl.uchile.dcc.scrabble.model.types.SBool;
import cl.uchile.dcc.scrabble.model.types.numeric.SFloat;
import cl.uchile.dcc.scrabble.model.types.numeric.SInt;
import cl.uchile.dcc.scrabble.model.tree.variables.VarFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class variableFactoryTest {

    TypeFactory fac = TypeFactory.createFactory();
    VarFactory vfac = VarFactory.createFactory();

    SString texto = fac.createString("hello world");
    SInt entero = fac.createInt(29);
    SFloat flotante = fac.createFloat(4.20);
    SBool booleano = fac.createBool(true);
    SBinary binario = fac.createBinary("100100101");

    @BeforeEach
    void setTest(){
        vfac.setVariable("x", new Add(entero, flotante));
        vfac.setVariable("y", new Not(new Minus(binario, entero)));
    }

    @Test
    void getTest(){
        assertEquals(vfac.getVariable("x").solve(), fac.createFloat(33.2));
        assertEquals(vfac.getVariable("y").solve(), fac.createBinary("011110111"));
        assertEquals(vfac.getVariable("y").solve().toInt(), fac.createInt(247));
    }

    @Test
    void opBetweenVariables(){
        vfac.setVariable("z", new Mult(vfac.getVariable("x"), vfac.getVariable("y")));
        assertEquals(vfac.getVariable("z").solve(), fac.createFloat(247*33.2));
    }

    @Test
    void reDefineTest(){
        assertEquals(vfac.getVariable("x").solve(), fac.createFloat(33.2));
        vfac.setVariable("x", new Add(texto, entero));
        assertEquals(vfac.getVariable("x").solve(), fac.createString("hello world29"));
    }

    @Test
    void notDefinedVariableTest(){
        assertNull(vfac.getVariable("s"));
        assertNull(new Add(entero, texto).solve());
        vfac.setVariable("s", new Add(entero, texto));// the variable can be set with a forbidden expression
    }



}
