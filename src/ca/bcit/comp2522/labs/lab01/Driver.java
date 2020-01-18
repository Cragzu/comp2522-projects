package ca.bcit.comp2522.labs.lab01;

/**
 * Simulates races between a Tortoise and a Hare.
 * The Tortoise wins the most.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class Driver {

    /**
     * Simulates a series of races to determine which racer wins most often.
     *
     * @param numOfRaces the number of races to simulate.
     * @param lengthOfRace the length of each simulated race.
     * @return a string reporting information about the races (the number of wins for each racer, overall winner).
     */
    private static void simulateRaces(int numOfRaces, int lengthOfRace) {
        Race raceInstance = new Race(lengthOfRace);
        int hareWins = 0;
        int tortoiseWins = 0;
        String output = ""; // todo: return output string instead of printing

        for(int lap = 0; lap < numOfRaces; lap++) {
            String roundWinner = raceInstance.simulateRace();
            if(roundWinner.equals("Hare")) {
                hareWins++;
            }
            else {
                tortoiseWins++;
            }
        }
        System.out.println("Tortoise won " + tortoiseWins + " times");
        System.out.println("Hare won " + hareWins + " times");

        if (tortoiseWins > hareWins) {
            System.out.println("Tortoise won overall!");
        }
        else if (tortoiseWins < hareWins) {
            System.out.println("Hare won overall!");
        }
        else {
            System.out.println("The two won the same number of times, wow!");
        }

    }

    public static void main(String[] args) {
        simulateRaces(100, 100);
        simulateRaces(100, 1000);
    }

}
