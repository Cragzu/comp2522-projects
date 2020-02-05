package ca.bcit.comp2522.lectures.week05;

/**
 * Lecture quiz for Monday Feb 03, 2020.
 *
 * @author Chloe Glave A01166947
 * @author Clint Fernandes A01182058
 * @version 2020
 */
public class feb03Quiz {
    /*find the time on a 24 hour clock with the most segments*/

    public int getNumberOfBars (int number) {
        if (number == 0 || number == 9 || number == 6) {
            return 6;
        } else if (number == 1) {
            return 2;
        } else if (number == 2 || number == 3 || number == 5) {
            return 5;
        } else if (number == 4) {
            return 4;
        } else if (number == 8) {
            return 7;
        } else if (number == 7) {
            return 3;
        }
        return -1;
    }

    public void getTimeWithLargestNumOfBars() {
        int greatestBarsUnitsMinutes = 0;
        int greatestTimeUnitsMinutes;
        int tempUnitsMinutes = 0;
        for (int i = 0; i <= 9; i++) {
            tempUnitsMinutes = getNumberOfBars(i);
            if (tempUnitsMinutes > greatestBarsUnitsMinutes) {
                greatestBarsUnitsMinutes = tempUnitsMinutes;
                greatestTimeUnitsMinutes = i;
            }
        }

        int greatestBarsTensMinutes = 0;
        int greatestTimeTensMinutes;
        int tempTensMinutes = 0;
        for (int i = 0; i <= 5; i++) {
            tempTensMinutes = getNumberOfBars(i);
            if (tempTensMinutes > greatestBarsTensMinutes) {
                greatestBarsTensMinutes = tempUnitsMinutes;
                greatestTimeTensMinutes = i;
            }
        }

        int greatestBarsTensHours = 0;
        int greatestBarsUnitsHours = 0;
        int greatestTimeTensHours = 0;
        int greatestTimeUnitsHours = 0;
        for (int i = 1; i <= 2; i++) {
            if (getNumberOfBars(i) > greatestBarsTensHours) {
                greatestBarsTensHours = getNumberOfBars(i);
                greatestTimeTensHours = i;
            }
            if (i == 1) {
                for (int j = 0; j <= 9; j++) {
                    if (getNumberOfBars(j) > greatestBarsUnitsHours) {
                        greatestBarsUnitsHours = getNumberOfBars(j);
                        greatestTimeUnitsHours = j;
                    }
                }
            } else {
                for (int j = 0; j <= 3; j++) {
                    if (getNumberOfBars(j) > greatestBarsUnitsHours) {
                        greatestBarsUnitsHours = getNumberOfBars(j);
                        greatestTimeUnitsHours = j;
                    }
            }
        }
        System.out.println("Greatest time is " + greatestBarsTensHours + greatestBarsUnitsHours
                + ":" + greatestBarsTensMinutes + greatestBarsUnitsMinutes);
    }

}}
