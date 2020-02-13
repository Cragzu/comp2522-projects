package ca.bcit.comp2522.quizzes.quiz03;

import java.util.Objects;

/**
 * @author Chloe Glave A01166947
 * @author Clint Fernandes A01182058
 * @version 2020
 */
public class Road {
    protected final Direction direction;
    protected String name;

    /*Constructor.*/
    public Road(final String name, final Direction direction) {
        this.name = name;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Road{"
                + "direction=" + direction
                + ", name='" + name + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Road road = (Road) o;
        return direction == road.direction
                && name.equals(road.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, name);
    }
}
