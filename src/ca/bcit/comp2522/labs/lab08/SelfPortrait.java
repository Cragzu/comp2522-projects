package ca.bcit.comp2522.labs.lab08;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        //<editor-fold desc="body">
        Rectangle shirt = new Rectangle(190, 300, 120, 200);
        shirt.setFill(Color.MEDIUMPURPLE);

        Ellipse neck = new Ellipse(250, 390, 25, 20);
        neck.setFill(Color.WHEAT);

        Group body = new Group(shirt, neck);
        //</editor-fold>

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
        head.setStroke(Color.BURLYWOOD);

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

        //<editor-fold desc="mouth">
        Ellipse mouthBase = new Ellipse(240, 350, 20, 30);
        mouthBase.setFill(Color.PALEVIOLETRED);

        Ellipse tongue = new Ellipse(240, 370, 13, 10);
        tongue.setFill(Color.MEDIUMVIOLETRED);

        Ellipse topMouthCover = new Ellipse(240, 300, 40, 40);
        topMouthCover.setFill(Color.WHEAT);

        Group mouth = new Group(mouthBase, tongue, topMouthCover);

        mouth.setRotate(15);
        mouth.setTranslateY(-10);
        //</editor-fold>

        Group face = new Group(mouth, nose, eyes);



        //<editor-fold desc="image">
        Image bcit = new Image("bcit.png");

        ImageView imageView = new ImageView(bcit);

        final int viewX = 0;
        final int viewY = 0;
        final int viewWidth = 2000;
        final int viewHeight = 2000;

        imageView.setFitHeight(200);
        imageView.setFitWidth(200);

        imageView.setViewport(new Rectangle2D(viewX, viewY, viewWidth, viewHeight));
        //</editor-fold>

        Group root = new Group(imageView, backHair, body, headBase, face);
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


