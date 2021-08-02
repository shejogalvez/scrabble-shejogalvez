package main.model.tree;

import cl.uchile.dcc.scrabble.model.tree.NodeI;
import cl.uchile.dcc.scrabble.model.tree.Not;
import cl.uchile.dcc.scrabble.model.tree.bi.And;
import cl.uchile.dcc.scrabble.model.tree.bi.Or;
import cl.uchile.dcc.scrabble.model.tree.bi.numeric.Add;
import cl.uchile.dcc.scrabble.model.tree.bi.numeric.Div;
import cl.uchile.dcc.scrabble.model.tree.bi.numeric.Minus;
import cl.uchile.dcc.scrabble.model.tree.bi.numeric.Mult;
import cl.uchile.dcc.scrabble.model.tree.toType.*;
import cl.uchile.dcc.scrabble.model.types.STypeI;
import cl.uchile.dcc.scrabble.model.types.TypeFactory;
import cl.uchile.dcc.scrabble.model.types.numeric.SBinary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TransformTreeTest {

    TypeFactory typeFactory = TypeFactory.createFactory();


    @Test
    void errorTest(){
        // no can do ToBool, literally the most useless method in the seven seas
        STypeI result =
                new ToBool(
                    new Minus(
                        typeFactory.createInt(25),
                        typeFactory.createBinary("0101")
                    )
                ).solve();
        assertNull(result);
    }


    @Test
    void logicTreeTest(){
        NodeI a =
                new ToBinary(
                    new Or(
                        typeFactory.createBinary("10000"),
                        typeFactory.createBinary("0100")
                    )
                );
        assertEquals(typeFactory.createBinary("10100").getValue(),  ((SBinary)a.solve()).getValue());

        NodeI b =
                new And(
                        a,
                        typeFactory.createBinary("1101")
                );

        assertEquals(typeFactory.createBinary("0100"), b.solve());

        STypeI c = new ToFloat(b).solve();

        assertEquals(typeFactory.createFloat(4), c);

    }

    @Test
    void identityTest(){
        NodeI step =
                new Div(
                        new Mult(typeFactory.createFloat(5.5),
                                typeFactory.createInt(10)),
                        typeFactory.createInt(10)
                ).solve();
        STypeI result = new ToString(step).solve();
        assertEquals(typeFactory.createString("5.5"), result);

        NodeI step2 =
                new Mult(
                        new Div(typeFactory.createFloat(5.5),
                                typeFactory.createInt(10)),
                        typeFactory.createInt(10)
                ).solve();
        STypeI result2 = new ToString(step2).solve();
        assertEquals(typeFactory.createString("5.5"), result2);
    }
}
