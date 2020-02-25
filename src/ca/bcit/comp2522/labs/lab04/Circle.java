package ca.bcit.comp2522.labs.lab04;

/**
 * @author Chloe Glave
 * @version 2020
 */
public class Circle extends Shape2D {
    public static final double PI = 3.141592535;

    private double radius;

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }

    @Override
    public double getArea() {
        return PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * PI * radius;
    }
}
