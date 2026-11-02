interface Animal {
    void eat();
}

interface Vehicle {
    void run();
}

class Demo implements Animal, Vehicle {
    public void eat() {
        System.out.println("Animal eats food.");
    }

    public void run() {
        System.out.println("Vehicle runs on the road.");
    }
}

public class MultipleInheritance {
    public static void main(String[] args) {
        Demo obj = new Demo();
        obj.eat();
        obj.run();
    }
}
