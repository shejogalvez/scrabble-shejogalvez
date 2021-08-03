package main.model.types;

import cl.uchile.dcc.scrabble.model.types.*;
import cl.uchile.dcc.scrabble.model.types.SBool;
import cl.uchile.dcc.scrabble.model.types.numeric.SBinary;
import cl.uchile.dcc.scrabble.model.types.numeric.SFloat;
import cl.uchile.dcc.scrabble.model.types.numeric.SInt;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class STypeTest {

    /**
     * se confirman las transformaciones de tipos y se convierten a valores correctos
     */

    SString texto = new SString("hello world");
    SInt entero = new SInt(29);
    SFloat flotante = new SFloat(4.20);
    SBool booleano = new SBool(true);
    SBinary binario = new SBinary("100100101");

    /*@Test
    void createTest(){
        SString texto = new SString("hello world");
        SInt entero = new SInt(27);
        SFloat flotante = new SFloat(4.20);
        SBool booleano = new SBool(true);
        SBinary binario = new SBinary("100100101");
    }
     */

    @Test
    void stringTest(){
        assertEquals(texto, texto.toSString());

        assertNull(texto.toBinary());

        assertNull(texto.toInt());

        assertNull(texto.toBool());

        assertNull(texto.toFloat());
    }

    @Test
    void booleanTest(){
        assertEquals(booleano, booleano.toBool());

        SString boolToString = booleano.toSString();
        assertEquals(texto.getClass(), boolToString.getClass());
        assertEquals("true", boolToString.getValue());
    }

    @Test
    void intTest(){
        assertEquals(entero, entero.toInt());

        SString intToString = entero.toSString();
        assertEquals(texto.getClass(), intToString.getClass());
        assertEquals("29", intToString.getValue());

        SBinary intToBinary = entero.toBinary();
        assertEquals(binario.getClass(), intToBinary.getClass());
        assertEquals("11101", intToBinary.getValue());


        SFloat intToFloat = entero.toFloat();
        assertEquals(flotante.getClass(), intToFloat.getClass());
        assertEquals(29.0, intToFloat.getValue());

    }

    @Test
    void floatTest(){
        assertEquals(flotante, flotante.toFloat());

        SString floatToString = flotante.toSString();
        assertEquals(texto.getClass(), floatToString.getClass());
        assertEquals("4.2", floatToString.getValue());
    }

    @Test
    void binaryTest(){
        assertEquals(binario, binario.toBinary());

        SString binaryToString = binario.toSString();
        assertEquals(texto.getClass(), binaryToString.getClass());
        assertEquals("100100101", binaryToString.getValue());

        SInt binaryToInt = binario.toInt();
        assertEquals(entero.getClass(), binaryToInt.getClass());
        assertEquals(293, binaryToInt.getValue());

        SFloat binaryToFloat = binario.toFloat();
        assertEquals(flotante.getClass(), binaryToFloat.getClass());
        assertEquals(293.0, binaryToFloat.getValue());
    }

}
