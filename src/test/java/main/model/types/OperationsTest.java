package main.model.types;

import cl.uchile.dcc.scrabble.model.types.*;
import cl.uchile.dcc.scrabble.model.types.SBool;
import cl.uchile.dcc.scrabble.model.types.numeric.SBinary;
import cl.uchile.dcc.scrabble.model.types.numeric.SFloat;
import cl.uchile.dcc.scrabble.model.types.numeric.SInt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OperationsTest {
    SString texto = new SString("hello world");
    SInt entero = new SInt(29);
    SFloat flotante = new SFloat(4.20);
    SBool booleano = new SBool(true);
    SBinary binario = new SBinary("100100101");

    @Test
    void StringTest(){
        assertEquals(texto.getClass(), texto.plus(texto).getClass());
        assertEquals("hello worldhello world", ((SString)texto.plus(texto)).getValue());

        assertEquals(texto.getClass(), texto.plus(entero).getClass());
        assertEquals("hello world29", ((SString)texto.plus(entero)).getValue());

        assertEquals(texto.getClass(), texto.plus(flotante).getClass());
        assertEquals("hello world4.2", ((SString)texto.plus(flotante)).getValue());

        assertEquals(texto.getClass(), texto.plus(booleano).getClass());
        assertEquals("hello worldtrue", ((SString)texto.plus(booleano)).getValue());

        assertEquals(texto.getClass(), texto.plus(binario).getClass());
        assertEquals("hello world100100101", ((SString)texto.plus(binario)).getValue());
    }

    @Test
    void intTest() {
        //suma
        assertNull(entero.plus(texto));

        assertEquals(entero.getClass(), entero.plus(entero).getClass());
        assertEquals(58, ((SInt) entero.plus(entero)).getValue());

        assertEquals(flotante.getClass(), entero.plus(flotante).getClass());
        assertEquals(29 + 4.2, ((SFloat) entero.plus(flotante)).getValue());

        assertNull(entero.plus(booleano));

        assertEquals(entero.getClass(), entero.plus(binario).getClass());
        assertEquals(293 + 29, ((SInt) entero.plus(binario)).getValue());

        //resta
        assertEquals(entero.getClass(), entero.minus(entero).getClass());
        assertEquals(0, ((SInt) entero.minus(entero)).getValue());

        assertEquals(flotante.getClass(), entero.minus(flotante).getClass());
        assertEquals(29 - 4.2, ((SFloat) entero.minus(flotante)).getValue());

        assertEquals(entero.getClass(), entero.minus(binario).getClass());
        assertEquals(-293 + 29, ((SInt) entero.minus(binario)).getValue());

        //multiplicacion
        assertEquals(entero.getClass(), entero.mul(entero).getClass());
        assertEquals(29*29, ((SInt) entero.mul(entero)).getValue());

        assertEquals(flotante.getClass(), entero.mul(flotante).getClass());
        assertEquals(29 * 4.2, ((SFloat) entero.mul(flotante)).getValue());

        assertEquals(entero.getClass(), entero.mul(binario).getClass());
        assertEquals(293 * 29, ((SInt) entero.mul(binario)).getValue());

        //division
        assertEquals(entero.getClass(), entero.div(entero).getClass());
        assertEquals(1, ((SInt)entero.div(entero)).getValue());

        assertEquals(flotante.getClass(), entero.div(flotante).getClass());
        assertEquals(29/4.2, ((SFloat)entero.div(flotante)).getValue());

        assertEquals(entero.getClass(), entero.div(binario).getClass());
        assertEquals(29/293, ((SInt)entero.div(binario)).getValue());
    }

    @Test
    void testBinaryNum(){
        //suma
        assertNull(binario.plus(texto));

        assertEquals(binario.getClass(), binario.plus(entero).getClass());
        assertEquals(SInt.intToBinary(29+293), ((SBinary) binario.plus(entero)).getValue());

        assertEquals(flotante.getClass(), binario.plus(flotante).getClass());
        assertEquals(4.2+293, ((SFloat)binario.plus(flotante)).getValue());

        assertNull(binario.plus(booleano));

        assertEquals(binario.getClass(), binario.plus(binario).getClass());
        assertEquals(SInt.intToBinary(293+293), ((SBinary) binario.plus(binario)).getValue());

        //resta
        assertEquals(binario.getClass(), binario.minus(entero).getClass());
        assertEquals(SInt.intToBinary(293-29), ((SBinary) binario.minus(entero)).getValue());

        assertEquals(binario.getClass(), binario.minus(binario).getClass());
        assertEquals("0", ((SBinary) binario.minus(binario)).getValue());

        assertEquals(flotante.getClass(), binario.minus(flotante).getClass());
        assertEquals(293-4.2, ((SFloat)binario.minus(flotante)).getValue());

        SInt bigInt = new SInt(2000);
        assertEquals("0", ((SBinary) binario.minus(bigInt)).getValue());

        //multiplicacion
        assertEquals(binario.getClass(), binario.mul(entero).getClass());
        assertEquals(SInt.intToBinary(29*293), ((SBinary) binario.mul(entero)).getValue());

        assertEquals(binario.getClass(), binario.mul(binario).getClass());
        assertEquals(SInt.intToBinary(293*293), ((SBinary) binario.mul(binario)).getValue());

        assertEquals(flotante.getClass(), binario.mul(flotante).getClass());
        assertEquals(4.2*293, ((SFloat)binario.mul(flotante)).getValue());

        //division
        assertEquals(binario.getClass(), binario.div(entero).getClass());
        assertEquals(SInt.intToBinary(293/29), ((SBinary)binario.div(entero)).getValue());

        assertEquals(binario.getClass(), binario.div(binario).getClass());
        assertEquals("1", ((SBinary)binario.div(binario)).getValue());

        assertEquals(flotante.getClass(), binario.div(flotante).getClass());
        assertEquals(293/4.2, ((SFloat)binario.div(flotante)).getValue());
    }


    @Test
    void floatTest(){
        //suma
        assertNull(flotante.plus(texto));

        assertEquals(flotante.getClass(), flotante.plus(entero).getClass());
        assertEquals(4.2+29, ((SFloat ) flotante.plus(entero)).getValue());

        assertEquals(flotante.getClass(), flotante.plus(flotante).getClass());
        assertEquals(4.2 + 4.2, ((SFloat) flotante.plus(flotante)).getValue());

        assertNull(flotante.plus(booleano));

        assertEquals(flotante.getClass(), flotante.plus(binario).getClass());
        assertEquals(293 + 4.2, ((SFloat) flotante.plus(binario)).getValue());

        //resta
        assertEquals(flotante.getClass(), flotante.minus(entero).getClass());
        assertEquals(4.2-29, ((SFloat) flotante.minus(entero)).getValue());

        assertEquals(flotante.getClass(), flotante.minus(flotante).getClass());
        assertEquals(0, ((SFloat) flotante.minus(flotante)).getValue());

        assertEquals(flotante.getClass(), flotante.minus(binario).getClass());
        assertEquals(-293 + 4.2, ((SFloat) flotante.minus(binario)).getValue());

        //multiplicacion
        assertEquals(flotante.getClass(), flotante.mul(entero).getClass());
        assertEquals(4.2*29, ((SFloat) flotante.mul(entero)).getValue());

        assertEquals(flotante.getClass(), flotante.mul(flotante).getClass());
        assertEquals(4.2 * 4.2, ((SFloat) flotante.mul(flotante)).getValue());

        assertEquals(flotante.getClass(), flotante.mul(binario).getClass());
        assertEquals(293 * 4.2, ((SFloat) flotante.mul(binario)).getValue());

        //division
        assertEquals(flotante.getClass(), flotante.div(entero).getClass());
        assertEquals(4.2/29, ((SFloat)flotante.div(entero)).getValue());

        assertEquals(flotante.getClass(), flotante.div(flotante).getClass());
        assertEquals(1, ((SFloat)flotante.div(flotante)).getValue());

        assertEquals(flotante.getClass(), flotante.div(binario).getClass());
        assertEquals(4.2/293, ((SFloat)flotante.div(binario)).getValue());
    }

    @Test
    void testLogic() {
        assertEquals("100100101", ((SBinary)binario.and(booleano)).getValue());

        assertEquals("111111111", ((SBinary)binario.or(booleano)).getValue());

        assertEquals("011011010", ((SBinary)binario.not()).getValue());

        assertEquals("100100101", ((SBinary)booleano.and(binario)).getValue());

        assertEquals("111111111", ((SBinary)booleano.or(binario)).getValue());

        SBool not = new SBool(false);
        assertEquals("000000000", ((SBinary)not.and(binario)).getValue());

        assertFalse(((SBool) booleano.not()).getValue());

        SBool not_booleano = new SBool(false);

        assertEquals(true, ((SBool) booleano.and(booleano)).getValue());

        assertEquals(true, ((SBool) booleano.or(booleano)).getValue());

        assertEquals(false, ((SBool) booleano.and(not_booleano)).getValue());

        assertEquals(true, ((SBool) booleano.or(not_booleano)).getValue());

        assertEquals("000000000", ((SBinary)not_booleano.and(binario)).getValue());
    }

    @Test
    void nullTestBonus(){
        assertNull(booleano.plus(entero));

        assertNull(booleano.minus(entero));

        assertNull(booleano.mul(entero));

        assertNull(booleano.div(entero));

        assertNull(texto.mul(entero));

        assertNull(texto.mul(flotante));

        assertNull(texto.mul(binario));
    }

    @Test
    void moreNullTest(){

        assertNull(entero.or(flotante));

        assertNull(flotante.and(binario));

        assertNull(texto.not());

        assertNull(binario.mul(texto));

        assertNull(entero.mul(booleano));

        assertNull(flotante.mul(texto));
    }
}
