class Person 
{
    String name;
    int age;

    public void displayPersonalDetails() 
	{
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }}
class Student5 extends Person {
    int rollNumber;
    String course;

    public void displayAcademicDetails() 
	{
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Course: " + course);
    }
	public static void main(String[] args) {
        Student5 obj = new Student5();

        obj.name = "Atharva";
        obj.age = 20;
        obj.rollNumber = 248;
        obj.course = "Computer Science";

        System.out.println("--- Student5 Details Information ---");

        obj.displayPersonalDetails();

       obj.displayAcademicDetails();
}}
