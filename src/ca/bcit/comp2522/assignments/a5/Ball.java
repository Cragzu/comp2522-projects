package ca.bcit.comp2522.assignments.a5;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

/**
 *  Ball is a Runnable.  A Ball bounces.
 *
 * @author BCIT
 * @version 2020
 */
public class Ball extends Circle implements Runnable {

    private static final Random generator = new Random();

    static final int MAX_X = 500; // horizontal edge of enclosing Panel
    static final int MAX_Y = 500; // vertical edge of enclosing Panel

    private int dx; // change in horizontal position of ball
    private int dy; // change in vertical position of ball


    /**
     * Constructs an object of type Ball.
     * @param xPosition an int
     * @param yPosition an int
     */
    public Ball(int xPosition, int yPosition, Color color) {
        super(10, color);
        this.setCenterX(xPosition);
        this.setCenterY(yPosition);
        dx = generator.nextInt(5); // change in x (0 - 4 pixels)
        dy = generator.nextInt(5); // change in y (0 - 4 pixels)
    }

    /**
     * Bounces the Ball off the edges of the window.
     */
    public void checkCollisionWithWalls() {
        // if bounce off top or bottom of Panel
        if (this.getCenterY() <= 0 || this.getCenterY() >= MAX_Y)
            dy *= -1; // reverses velocity in y direction

        // if bounce off left or right of Panel
        if (this.getCenterX() <= 0 || this.getCenterX() >= MAX_X)
            dx *= -1; // reverses velocity in x direction

        this.setCenterX(this.getCenterX() + dx); // determines new x-position
        this.setCenterY(this.getCenterY() + dy); // determines new y-position
    }

    /**
     * Bounces the Ball off other balls.
     */
    public void checkCollisionWithOthers() {
        BouncingBalls.BALLS.forEach(listBall -> {
            if (!this.equals(listBall) // prevent collision with itself
                 && this.intersects(listBall.getBoundsInLocal())) {

                dy *= -1; // reverses velocity in y direction
                dx *= -1; // reverses velocity in x direction
            }
        });
    }

    /**
     * Bounces the Ball perpetually.
     */
    public void run() {
        while (true) {
            try {
                Thread.sleep(20); // sleep for 20 milliseconds
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }

            /* Long-running operations must not be run on the JavaFX application
               thread, since this prevents JavaFX from updating the UI, resulting
               in a frozen UI.

               Furthermore any change to a Node that is part of a "live" scene
               graph must happen on the JavaFX application thread.

               Platform.runLater can be used to execute those updates on the
               JavaFX application thread.
             */
            Platform.runLater( () -> {
                checkCollisionWithWalls();
                checkCollisionWithOthers();
            });
        }
    }
}