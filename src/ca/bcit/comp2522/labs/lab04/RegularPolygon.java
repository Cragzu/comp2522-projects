package ca.bcit.comp2522.labs.lab04;

/**
 * @author Chloe Glave
 * @version 2020
 */
public class RegularPolygon extends Polygon {
    private int lengthOfSides;
    private double apothem;

    @Override
    public void draw() {
        System.out.println("Drawing a polygon");
    }

    @Override
    public double getArea() {
        return 0.5 * apothem * this.getPerimeter();
    }

    @Override
    public double getPerimeter() {
        return lengthOfSides * numOfSides;
    }
}
