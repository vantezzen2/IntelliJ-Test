import java.io.*;

public class Main {
    public static void writeTestFile(String name) {
        OutputStream stream;
        try {
            stream = new FileOutputStream(name);
        } catch(FileNotFoundException ex) {
            System.out.print("Fehler beim Oeffnen: ");
            System.out.println(ex);
            return;
        }

        PrintStream ps = new PrintStream(stream);

        String body = "Hallo, Festplatte!";
        //byte[] bodyBytes = body.getBytes();

        ps.println(body);
    }

    public static void readTestFile(String name) {
        InputStream stream;
        try {
            stream = new FileInputStream(name);
        } catch (FileNotFoundException ex) {
            System.out.print("Fehler beim Oeffnen: ");
            System.out.println(ex);
            return;
        }

        InputStreamReader isr = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(isr);

        try {
            String line = reader.readLine();
            System.out.println("File Inhalt: " + line);
            //stream.read(readBuffer);
        } catch (IOException ex) {
            System.out.print("Fehler beim Lesen: ");
            System.out.println(ex);
            return;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        String name = "test.txt";

        writeTestFile(name);
        readTestFile(name);
    }
}
