interface Printable {
    void print();
}
interface Showable {
    void show();
}

class Demo implements Printable, Showable {

    public void print() {
        System.out.println("Printing the document.");
    }

    public void show() {
        System.out.println("Showing the document.");
    }
}

public class MultipleInheritanceDemo8 {
    public static void main(String[] args) {
        Demo obj = new Demo();
        obj.print();
        obj.show();
    }
}
