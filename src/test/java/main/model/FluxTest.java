package main.model;

import cl.uchile.dcc.scrabble.model.flujo.*;
import cl.uchile.dcc.scrabble.model.tree.variables.Get;
import cl.uchile.dcc.scrabble.model.tree.bi.comparison.*;
import cl.uchile.dcc.scrabble.model.tree.bi.numeric.*;
import cl.uchile.dcc.scrabble.model.tree.toType.*;
import cl.uchile.dcc.scrabble.model.types.TypeFactory;
import cl.uchile.dcc.scrabble.model.types.numeric.*;
import cl.uchile.dcc.scrabble.model.tree.variables.VarFactory;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FluxTest {


    TypeFactory factory = TypeFactory.createFactory();
    VarFactory var = VarFactory.createFactory();

    int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }

    @Test
    void sumFirstN(){
        int N = 10;
        FluxNode program = new Bundle(new Flux[]{
            new Set("i", factory.createInt(1)),
            new Set("x", factory.createInt(0)),
            new While(
                    new LessThan(new Get("i"),  factory.createInt(N+1)),

                    new Bundle(new Flux[]{
                        new Set("x", new Add(
                                new Get("x"), new Get("i")
                            )
                        ), new Set("i", new Add(
                        new Get("i"), factory.createInt(1)
                            )
                        )
                    })
                )}
            );
        program.act();

        assertEquals(factory.createInt(N*(N+1)/2).getValue(),
                ((SInt) new Get("x").solve()).getValue());
    }

    @RepeatedTest(5)
    void max_common_divisor(){
        Random rnd = new Random();
        int i1 = rnd.nextInt(1000);
        int i2 = rnd.nextInt(1000);
        SInt in1 = factory.createInt(i1);
        SInt in2 = factory.createInt(i2);
        FluxNode program = new Bundle(new Flux[]{
            new Set("a", in1),
            new Set("b", in2),
            new While(
                new MoreThan(new Get("b"), factory.createInt(0)),
                new If(
                    new MoreThan(new Get("a"), new Get("b")),
                    new Set("a", new Minus(
                            new Get("a"),
                            new Get("b")
                    )),
                    new Set("b", new Minus(
                            new Get("b"),
                            new Get("a")
                    ))
                )
            )}
        );
        program.act();
        assertEquals(new Get("a").solve(), factory.createInt(gcd(i1, i2)));
    }

    @Test
    void isFloatAnInteger_true(){
        SFloat in = factory.createFloat(10);
        FluxNode program = new Bundle(new Flux[]{
                new Set("a", in),
                new Set("result", factory.createBool(false)),
                new If(
                        new EqualTo(new Get("a"), new ToInt(new Get("a"))),
                        new Set("result", factory.createBool(true))
                )}
        );
        program.act();
        assertEquals(new Get("result").solve(), factory.createBool(true));
    }

    @Test
    void isFloatAnInteger_false(){
        SFloat in = factory.createFloat(10.5);
        FluxNode program = new Bundle(new Flux[]{
                new Set("a", in),
                new Set("result", factory.createBool(false)),
                new If(
                        new EqualTo(new Get("a"), new ToInt(new Get("a"))),
                        new Set("result", factory.createBool(true))
                )}
        );
        program.act();
        assertEquals(new Get("result").solve(), factory.createBool(false));
    }

}
