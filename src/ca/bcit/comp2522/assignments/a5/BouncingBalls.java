package ca.bcit.comp2522.assignments.a5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * BouncingBalls, an introduction to threading and JavaFX.
 *
 * @author BCIT
 * @author Chloe Glave
 * @version 2020
 */
public class BouncingBalls extends Application {

    static final ArrayList<Ball> BALLS = new ArrayList<>();

    /**
     * Gets user input for the number of Balls to create.
     *
     * @return the desired number.
     */
    private int getNumberOfBallsFromInput() {
        final Scanner titleScanner = new Scanner(System.in);
        System.out.print("How many balls do you want?: ");

        return titleScanner.nextInt();
    }

    /**
     * Populates the ArrayList with the specified number of Ball objects.
     */
    private void generateListOfBallsFromInput() {
        int numOfBalls = getNumberOfBallsFromInput();
        for (int i = 0; i < numOfBalls; i++) {
            int ballXPosition = new Random().nextInt(500);
            int ballYPosition = new Random().nextInt(500);

            Ball ball = new Ball(ballXPosition, ballYPosition);

            BALLS.add(ball);
        }
    }

    /**
     * Demonstrates threading in JavaFX.
     * @param primaryStage contains the Scene
     */
    public void start(Stage primaryStage) {
        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, 500, 500);

        generateListOfBallsFromInput();

        BALLS.forEach(ball -> {
            canvas.getChildren().add(ball);
            Thread bouncer = new Thread(ball);
            bouncer.setDaemon(true);
            bouncer.start();
        });

        primaryStage.setTitle("Threads and Balls");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Launches the JavaFX application.  We still need a main method in our
     * JavaFX applications.  The main method must do one thing.  Pass
     * the command line arguments (args) to the launch method inherited from
     * the Application class.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
