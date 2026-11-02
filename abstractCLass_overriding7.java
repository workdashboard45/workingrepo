abstract class Shape {
    abstract void area();

    void display() {
        System.out.println("This is a shape.");
    }
}
class Circle extends Shape {
    double radius = 5;

    void area() {
        double result = Math.PI * radius * radius;
        System.out.println("Area of Circle: " + result);
    }
}

class Rectangle extends Shape {
    double length = 10;
    double width = 5;

    void area() {
        double result = length * width;
        System.out.println("Area of Rectangle: " + result);
    }
}
public class AbstractDemo7 {
    public static void main(String[] args) {
        Shape s1 = new Circle();
        Shape s2 = new Rectangle();
        s1.display();
        s1.area();
        s2.display();
        s2.area();
    }
} 
