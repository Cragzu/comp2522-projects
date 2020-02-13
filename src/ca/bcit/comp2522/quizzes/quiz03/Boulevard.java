package ca.bcit.comp2522.quizzes.quiz03;

/**
 * @author Chloe Glave A01166947
 * @author Clint Fernandes A01182058
 * @version 2020
 */
public class Boulevard extends Road {
    private boolean medianHasTrees;

    public Boulevard(String name, Direction direction, boolean medianHasTrees) {
        super(name, direction);
        this.medianHasTrees = medianHasTrees;
    }

    @Override
    public String toString() {
        return "Boulevard{"
                + "medianHasTrees=" + medianHasTrees
                + ", direction=" + direction
                + ", name='" + name + '\''
                + '}';
    }
}
