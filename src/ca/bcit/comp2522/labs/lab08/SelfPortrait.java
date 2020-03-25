package ca.bcit.comp2522.labs.lab08;

import javafx.application.Application;
import javafx.scene.shape.*;
import javafx.scene.transform.Shear;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

/**
 * A beautiful self-portrait created to learn the basics of JavaFX.
 *
 * @author Chloe Glave
 * @version 2020
 */
public class SelfPortrait extends Application {

    /**
     * Creates and displays a picture of Chloe.
     *
     * @param primaryStage contains the scene
     */
    public void start(Stage primaryStage) {
        //<editor-fold desc="backHair">
        Rectangle backHairLeft = new Rectangle(200, 200, 200, 200);
        backHairLeft.setFill(Color.GOLD);
        backHairLeft.setRotate(15);

        Rectangle backHairRight = new Rectangle(200, 200, 200, 200);
        backHairRight.setFill(Color.GOLD);
        backHairRight.setRotate(-15);
        backHairRight.setTranslateX(-100);

        Circle backHairTop = new Circle(250, 225, 175);
        backHairTop.setFill(Color.GOLD);

        Shear spikyShear = new Shear();
        spikyShear.setPivotX(50);
        spikyShear.setX(0.5);

        Rectangle backHairSpiky = new Rectangle(175, 30, 100, 100);
        backHairSpiky.setFill(Color.GOLD);
        backHairSpiky.getTransforms().addAll(spikyShear);
        backHairSpiky.setRotate(25);

        Group backHair = new Group(backHairLeft, backHairRight, backHairTop, backHairSpiky);
        //</editor-fold>

        //<editor-fold desc="headBase">
        Ellipse head = new Ellipse(250, 250, 140, 150);
        head.setFill(Color.WHEAT);

        Ellipse frontHairLeft = new Ellipse(175, 160, 60, 110);
        frontHairLeft.setFill(Color.GOLD);
        frontHairLeft.setRotate(50);

        Ellipse frontHairRight = new Ellipse(325, 160, 60, 110);
        frontHairRight.setFill(Color.GOLD);
        frontHairRight.setRotate(-50);

        Group headBase = new Group(head, frontHairLeft, frontHairRight);
        //</editor-fold>

        //<editor-fold desc="eyes">
        Shear leftLashShear = new Shear();
        leftLashShear.setPivotX(50);
        leftLashShear.setX(0.5);

        Rectangle leftLash = new Rectangle(145, 195, 10, 10);
        leftLash.setFill(Color.SADDLEBROWN);
        leftLash.getTransforms().addAll(leftLashShear);

        leftLash.setRotate(25);

        Ellipse leftPupil = new Ellipse(250, 250, 10, 20);
        leftPupil.setFill(Color.LIGHTBLUE);

        Group leftEye = new Group(leftLash, leftPupil);
        leftEye.setTranslateX(-50);

        Shear rightLashShear = new Shear();
        rightLashShear.setPivotX(50);
        rightLashShear.setX(-0.5);

        Rectangle rightLash = new Rectangle(345, 195, 10, 10);
        rightLash.setFill(Color.SADDLEBROWN);
        rightLash.getTransforms().addAll(rightLashShear);

        rightLash.setRotate(-25);

        Ellipse rightPupil = new Ellipse(250, 250, 10, 20);
        rightPupil.setFill(Color.LIGHTBLUE);

        Group rightEye = new Group(rightLash, rightPupil);
        rightEye.setTranslateX(50);

        Group eyes = new Group(leftEye, rightEye);
        //</editor-fold>

        //<editor-fold desc="nose">
        Shear noseShear = new Shear();
        noseShear.setPivotX(40);
        noseShear.setX(0.5);

        Rectangle nose = new Rectangle(140, 225, 20, 20);
        nose.setFill(Color.BURLYWOOD);
        nose.getTransforms().addAll(noseShear);

        nose.setRotate(25);
        //</editor-fold>




        Group face = new Group(eyes, nose);


//        Ellipse middle = new Ellipse(80, 130, 50, 40);
//        middle.setFill(Color.WHITE);
//
//        Circle head = new Circle(80, 70, 30);
//        head.setFill(Color.WHITE);
//
//        Circle rightEye = new Circle(70, 60, 5);
//        Circle leftEye = new Circle(90, 60, 5);
//        Line mouth = new Line(70, 80, 90, 80);
//
//        Circle topButton = new Circle(80, 120, 6);
//        topButton.setFill(Color.RED);
//
//        Circle bottomButton = new Circle(80, 140, 6);
//        bottomButton.setFill(Color.RED);
//
//        Line leftArm = new Line(110, 130, 160, 130);
//        leftArm.setStrokeWidth(3);
//
//        Line rightArm = new Line(50, 130, 0, 100);
//        rightArm.setStrokeWidth(3);
//
//        Rectangle stovepipe = new Rectangle(60, 0, 40, 50);
//        Rectangle brim = new Rectangle(50, 45, 60, 5);
//        Group hat = new Group(stovepipe, brim);
//        hat.setTranslateX(10);
//        hat.setRotate(15);
//
//        Group snowman = new Group(base, middle, head, leftEye, rightEye, mouth,
//                topButton, bottomButton, leftArm, rightArm, hat);
//        snowman.setTranslateX(170);
//        snowman.setTranslateY(50);
//
//        Circle sun = new Circle(50, 50, 30);
//        sun.setFill(Color.GOLD);
//
//        Rectangle ground = new Rectangle(0, 250, 500, 100);
//        ground.setFill(Color.STEELBLUE);
//
        Group root = new Group(backHair, headBase, face);
        Scene scene = new Scene(root, 500, 500, Color.LAVENDER);

        primaryStage.setTitle("Chloe's Self-Portrait");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Launches the JavaFX application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}


