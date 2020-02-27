package ca.bcit.comp2522.assignments.a3;

/**
 * Interface of operations.
 *
 * @author Chloe Glave
 * @version 2020
 */
interface Operation {
    char getSymbol();
    int perform(int operandA, int operandB);
}
