package main.model.tree;

import cl.uchile.dcc.scrabble.model.tree.*;
import cl.uchile.dcc.scrabble.model.types.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TreeTest {

    @Test
    void solveTest(){
        STypeI result =
            new Add(
                // 28 + 6.9
                new Or(
                        //1000 or 10100
                        new SBinary("1000"),
                        new Minus(
                                //25-5
                                new SInt(25),
                                new SBinary("0101")
                        ).solve().toBinary()
                    ),
                new SFloat(6.9)
                ).solve();

        assertEquals(new SFloat(34.9), result);
    }

    @Test
    void errorTest(){
        // no can do minus with string
        STypeI result =
                    new Minus(
                            new SString("25"),
                            new SBinary("0101")
                    ).solve();
        assertNull(result);
    }

    @Test
    void noerrorTest(){
        STypeI result =
                new Minus(
                        new SInt(25),
                        new SBinary("0101")
                ).solve();
        assertEquals(new SInt(20), result);
    }

    @Test
    void logicTreeTest(){
        SBinary a =
        new Or(
                new SBinary("10000"),
                new SBinary("0100")
        ).solve().toBinary();
        assertEquals(new SBinary("10100").getValue(),  a.getValue());

        STypeI b =
            new And(
                a,
                new SBinary("1101")
            ).solve();

        assertEquals(new SBinary("0100"), b);

        STypeI c = new Not(b).solve();

        assertEquals(new SBinary("1011"), c);

    }

    @Test
    void identityTest(){
        STypeI result =
                new Div(
                    new Mult(new SFloat(5.5),
                        new SInt(10)),
                    new SInt(10)
                ).solve();
        assertEquals(new SFloat(5.5), result);

        STypeI result2 =
                new Mult(
                        new Div(new SFloat(5.5),
                                new SInt(10)),
                        new SInt(10)
                ).solve();
        assertEquals(new SFloat(5.5), result2);
    }
}
