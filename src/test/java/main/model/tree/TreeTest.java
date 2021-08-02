package main.model.tree;

import cl.uchile.dcc.scrabble.model.tree.bi.And;
import cl.uchile.dcc.scrabble.model.tree.bi.Or;
import cl.uchile.dcc.scrabble.model.types.TypeFactory;
import cl.uchile.dcc.scrabble.model.tree.*;
import cl.uchile.dcc.scrabble.model.tree.bi.numeric.Add;
import cl.uchile.dcc.scrabble.model.tree.bi.numeric.Div;
import cl.uchile.dcc.scrabble.model.tree.bi.numeric.Minus;
import cl.uchile.dcc.scrabble.model.tree.bi.numeric.Mult;
import cl.uchile.dcc.scrabble.model.types.*;
import cl.uchile.dcc.scrabble.model.types.numeric.SBinary;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TreeTest {

    TypeFactory typeFactory = TypeFactory.createFactory();

    @Test
    void solveTest(){
        STypeI result =
            new Add(
                // 28 + 6.9
                new Or(
                        //1000 or 10100
                        typeFactory.createBinary("1000"),
                        new Minus(
                                //25-5
                                typeFactory.createInt(25),
                                typeFactory.createBinary("0101")
                        ).solve().toBinary()
                    ),
                typeFactory.createFloat(6.9)
                ).solve();

        assertEquals(typeFactory.createFloat(34.9), result);
    }

    @Test
    void errorTest(){
        // no can do minus with string
        STypeI result =
                    new Minus(
                            typeFactory.createString("25"),
                            typeFactory.createBinary("0101")
                    ).solve();
        assertNull(result);
    }

    @Test
    void noerrorTest(){
        STypeI result =
                new Minus(
                        typeFactory.createInt(25),
                        typeFactory.createBinary("0101")
                ).solve();
        assertEquals(typeFactory.createInt(20), result);
    }

    @Test
    void logicTreeTest(){
        SBinary a =
        new Or(
                typeFactory.createBinary("10000"),
                typeFactory.createBinary("0100")
        ).solve().toBinary();
        assertEquals(typeFactory.createBinary("10100").getValue(),  a.getValue());

        STypeI b =
            new And(
                a,
                typeFactory.createBinary("1101")
            ).solve();

        assertEquals(typeFactory.createBinary("0100"), b);

        STypeI c = new Not(b).solve();

        assertEquals(typeFactory.createBinary("1011"), c);

    }

    @Test
    void identityTest(){
        STypeI result =
                new Div(
                    new Mult(typeFactory.createFloat(5.5),
                        typeFactory.createInt(10)),
                    typeFactory.createInt(10)
                ).solve();
        assertEquals(typeFactory.createFloat(5.5), result);

        STypeI result2 =
                new Mult(
                        new Div(typeFactory.createFloat(5.5),
                                typeFactory.createInt(10)),
                        typeFactory.createInt(10)
                ).solve();
        assertEquals(typeFactory.createFloat(5.5), result2);
    }
}
