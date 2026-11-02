import java.io.*;
public class FileCopy {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("source.txt");
            FileOutputStream fos = new FileOutputStream("byte_copy.txt");
            int data;

            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            fis.close();
            fos.close();
            System.out.println("File copied successfully using Byte Streams.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            FileReader fr = new FileReader("source.txt");
            FileWriter fw = new FileWriter("character_copy.txt");
            int ch;

            while ((ch = fr.read()) != -1) {
                fw.write(ch);
            }
            fr.close();
            fw.close();
            System.out.println("File copied successfully using Character Streams.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage()); 
        }  }
}
