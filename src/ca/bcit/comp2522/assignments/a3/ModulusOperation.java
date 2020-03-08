package ca.bcit.comp2522.assignments.a3;

/**
 * Modulus operation.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class ModulusOperation extends AbstractOperation {
    /**The char code for the modulus operation.*/
    static final char MODULUS_CODE = '%';

    /**
     * Constructor - passes modulus code to superclass.
     */
    public ModulusOperation() {
        super(MODULUS_CODE);
    }

    @Override
    public int perform(final int operandA, final int operandB) {
        return operandA % operandB;
    }

    /**
     * Generates a string representation of the object.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "ModulusOperation{}";
    }
}
