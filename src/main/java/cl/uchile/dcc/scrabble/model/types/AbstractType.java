package cl.uchile.dcc.scrabble.model.types;

import cl.uchile.dcc.scrabble.model.types.factory.TypeFactory;
import cl.uchile.dcc.scrabble.model.types.logic.SBool;
import cl.uchile.dcc.scrabble.model.types.numeric.NumTypeI;
import cl.uchile.dcc.scrabble.model.types.numeric.SFloat;
import cl.uchile.dcc.scrabble.model.types.numeric.SInt;

/**
 * Abstract class that contains recurrent outputs of SType functions to avoid to copy code
 */
public abstract class AbstractType implements STypeI{

    // object to have access to Factory class create methods
    protected final TypeFactory factory = TypeFactory.createFactory();

    /**
     * to(Type) : tries to transform itself (make another object) to the desired Type
     * @return object transformed to (Type) or null if can't be transformed to that Type
     *
     * self.to(sameType)() returns self
     */

    public abstract SString toSString();

    public SBool toBool() {
        return null;
    }


    public SFloat toFloat() {
        return null;
    }


    public SInt toInt() {
        return null;
    }


    public SBinary toBinary() {
        return null;
    }

    @Override
    public STypeI plus(STypeI obj) {
        return null;
    }

    @Override
    public STypeI minus(STypeI obj) {
        return null;
    }

    @Override
    public STypeI div(STypeI obj) {
        return null;
    }

    @Override
    public STypeI mul(STypeI obj) {
        return null;
    }

    @Override
    public STypeI and(STypeI obj){
        return null;
    }

    @Override
    public STypeI or(STypeI obj){
        return null;
    }

    @Override
    public STypeI not(){
        return null;
    }

    @Override
    public STypeI solve(){
        return this;
    }

    public NumTypeI sumWithBinary(int Value, int mode){
        return null;
    }

    public NumTypeI mulWithBinary(int Value, int mode){
        return null;
    }

    public NumTypeI sumWithInteger(int Value, int mode){
        return null;
    }

    public NumTypeI mulWithInteger(int Value, int mode){
        return null;
    }

    public NumTypeI sumWithFloat(double Value, int mode){
        return null;
    }

    public NumTypeI mulWithFloat(double Value, int mode){
        return null;
    }


}
