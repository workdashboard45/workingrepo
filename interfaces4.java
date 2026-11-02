interface Engine
{
void startEngine();
}
interface Vehicle
{
void drive();

}
class Car implements Engine, Vehicle
{
public void startEngine()
{
System.out.println("Engine Started.");
}
public void drive()
{
System.out.println("Car is Moving.");
}
}
public class VehicleInterfaceDemo
{
public static void main(String args[])
{
Car c = new Car();
c.startEngine();
c.drive();
}
}