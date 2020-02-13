package ca.bcit.comp2522.quizzes.quiz03;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Boulevard)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Boulevard boulevard = (Boulevard) o;
        return medianHasTrees == boulevard.medianHasTrees;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), medianHasTrees);
    }
}
