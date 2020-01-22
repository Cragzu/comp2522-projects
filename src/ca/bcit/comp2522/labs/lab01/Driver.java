package ca.bcit.comp2522.labs.lab01;

/**
 * Simulates races between a Tortoise and a Hare.
 * The Tortoise wins the most.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class Driver {
    /**Number of races to simulate.*/
    static final int NUM_RACES = 100;

    /**Length of races to simulate in the first tournament.*/
    static final int RACE_LENGTH_1 = 100;

    /**Length of races to simulate in the second tournament.*/
    static final int RACE_LENGTH_2 = 1000;

    /**
     * Simulates a series of races to determine which racer wins most often.
     *
     * @param numOfRaces the number of races to simulate.
     * @param lengthOfRace the length of each simulated race.
     * @return a string reporting information about the races
     * (the number of wins for each racer, overall winner).
     */
    private static String simulateRaces(int numOfRaces, int lengthOfRace) {
        Race raceInstance = new Race(lengthOfRace);
        int hareWins = 0;
        int tortoiseWins = 0;
        String output = "Starting a tournament with " + numOfRaces
                + " races of length " + lengthOfRace + ".\n";

        for (int lap = 0; lap < numOfRaces; lap++) {
            String roundWinner = raceInstance.simulateRace();
            if (roundWinner.equals("Hare")) {
                hareWins++;
            } else {
                tortoiseWins++;
            }
        }
        output += "Tortoise won " + tortoiseWins + " times, with a final position of "
                + raceInstance.getRacerTortoise().getPosition() + ".\n";
        output += "Hare won " + hareWins + " times, with a final position of "
                + raceInstance.getRacerHare().getPosition() + ".\n";
        output += "The last race took " + raceInstance.getNumOfTicks() + " ticks to complete.\n";

        if (tortoiseWins > hareWins) {
            output += "Tortoise won overall!";
        } else if (tortoiseWins < hareWins) {
            output += "Hare won overall!";
        } else {
            output += "The two won the same number of times, wow!";
        }
        output += "\n";
        return output;
    }

    public static void main(String[] args) {
        System.out.println(simulateRaces(NUM_RACES, RACE_LENGTH_1));
        System.out.println(simulateRaces(NUM_RACES, RACE_LENGTH_2));
    }

}
