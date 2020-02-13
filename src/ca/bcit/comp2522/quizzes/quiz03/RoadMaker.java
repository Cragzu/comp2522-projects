package ca.bcit.comp2522.quizzes.quiz03;

import java.util.ArrayList;

/**
 * @author Chloe Glave A01166947
 * @author Clint Fernandes A01182058
 * @version 2020
 */
public class RoadMaker {
    public static void main(String[] args) {
        Road mainStreet = new Road("Main Street", Direction.NORTH);
        Boulevard niagara = new Boulevard("Niagara Boulevard", Direction.SOUTH,
                true);
        Highway transCanada = new Highway("Trans Canada", Direction.EAST, true);

        ArrayList<Road> roads = new ArrayList<>();
        roads.add(mainStreet);
        roads.add(niagara);
        roads.add(transCanada);

        for (Road i : roads) {
            System.out.println(i);
        }
    }
}
