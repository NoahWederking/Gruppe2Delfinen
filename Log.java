import java.io.FileWriter;
import java.io.IOException;

public class Log {
    FileWriter myWriter = new FileWriter("log.txt", true);

    public Log() throws IOException {
    }

    public void writeLine(String line) throws IOException {
        myWriter.write(line);
    }

    public void closeFile() throws IOException {
        myWriter.close();
    }
}
