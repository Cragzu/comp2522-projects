package ca.bcit.comp2522.quizzes.quiz02;

import ca.bcit.comp2522.assignments.a2.Guppy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author Chloe Glave A01166947
 * @author Clint Fernandes A01182058
 * @version 2020
 */
public class Statistics {

    static int getMedian(ArrayList<Integer> allInts) throws NegativeIntegerException {
        Iterator<Integer> it = allInts.iterator();

        while (it.hasNext()) {
            int i = it.next();
            if (i < 0) {
                throw new NegativeIntegerException();
            }
            allInts.add(i);
        }

        Collections.sort(allInts);

        int middleOfList = Math.floorDiv(allInts.size(), 2);

        return allInts.get(middleOfList);
    }

    public static void main(String[] args) {
        int numOfCommandLineArgs = args.length;
        ArrayList<Integer> ints = new ArrayList<>();
        for (int i = 0; i < numOfCommandLineArgs; i++) {
            ints.add(Integer.parseInt(args[i]));
        }

        try {
            getMedian(ints);
        } catch (NegativeIntegerException nie) {
            System.out.println("ints cannot be less than 0");
        }
    }
}


