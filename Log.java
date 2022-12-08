import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;

public class Log {
    FileWriter myWriter = new FileWriter("members.txt", true);

    public Log() throws IOException {
    }

    public void writeLine(String line) throws IOException {
        myWriter.write(line);
    }

    public void closeFile() throws IOException {
        myWriter.close();
    }
    static void writeToFile(ArrayList<Member> members) throws FileNotFoundException, IOException {
        String path = "members.txt";
        FileOutputStream fos = new FileOutputStream(path, true);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(members);
        oos.close();
        System.out.println("New Record has been written!");
    }

    public static ArrayList<Member> getMembers() {
        try{
            FileInputStream fis = new FileInputStream("members.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Member> members = (ArrayList<Member>) ois.readObject();
            ois.close();
            return members;
        } catch( ClassNotFoundException | IOException ex){
            System.out.println(ex.getMessage());
            return null;
        }
        //MVP
    }
}
