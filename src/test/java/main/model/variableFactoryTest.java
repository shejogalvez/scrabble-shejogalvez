package main.model;

import cl.uchile.dcc.scrabble.model.types.factory.TypeFactory;
import cl.uchile.dcc.scrabble.model.tree.Not;
import cl.uchile.dcc.scrabble.model.tree.bi.numeric.Add;
import cl.uchile.dcc.scrabble.model.tree.bi.numeric.Minus;
import cl.uchile.dcc.scrabble.model.tree.bi.numeric.Mult;
import cl.uchile.dcc.scrabble.model.types.SBinary;
import cl.uchile.dcc.scrabble.model.types.SString;
import cl.uchile.dcc.scrabble.model.types.logic.SBool;
import cl.uchile.dcc.scrabble.model.types.numeric.SFloat;
import cl.uchile.dcc.scrabble.model.types.numeric.SInt;
import cl.uchile.dcc.scrabble.model.variables.VarFactory;
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
        vfac.setVar("x", new Add(entero, flotante));
        vfac.setVar("y", new Not(new Minus(binario, entero)));
    }

    @Test
    void getTest(){
        assertEquals(vfac.getVar("x"), fac.createFloat(33.2));
        assertEquals(vfac.getVar("y"), fac.createBinary("011110111"));
        assertEquals(vfac.getVar("y").toInt(), fac.createInt(247));
    }

    @Test
    void opBetweenVariables(){
        vfac.setVar("z", new Mult(vfac.getVar("x"), vfac.getVar("y")));
        assertEquals(vfac.getVar("z"), fac.createFloat(247*33.2));
    }

    @Test
    void reDefineTest(){
        assertEquals(vfac.getVar("x").solve(), fac.createFloat(33.2));
        vfac.setVar("x", new Add(texto, entero));
        assertEquals(vfac.getVar("x").solve(), fac.createString("hello world29"));
    }

    @Test
    void notDefinedVariableTest(){
        assertNull(vfac.getVar("s"));
        assertNull(new Add(entero, texto).solve());
        vfac.setVar("s", new Add(entero, texto));// the variable can be set with a forbidden expression
        assertNull(vfac.getVar("s"));// but can't get value from this variable
    }



}
