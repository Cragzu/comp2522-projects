package ca.bcit.comp2522.labs.lab04;

/**
 * @author Chloe Glave
 * @version 2020
 */
public class Rectangle extends Shape2D {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        super();
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return (width * 2) + (height * 2);
    }
}
