package ca.bcit.comp2522.quizzes.quiz03;

/**
 * @author Chloe Glave A01166947
 * @author Clint Fernandes A01182058
 * @version 2020
 */
public class Highway extends Road {
    private boolean hasHOVLane;

    public Highway(String name, Direction direction, boolean hasHOVLane) {
        super(name, direction);
        this.hasHOVLane = hasHOVLane;
    }

    @Override
    public String toString() {
        return "Highway{"
                + "hasHOVLane=" + hasHOVLane
                + ", direction=" + direction
                + ", name='" + name + '\''
                + '}';
    }
}
