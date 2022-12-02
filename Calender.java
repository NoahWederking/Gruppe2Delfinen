import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Calender {
    LocalDateTime time = LocalDateTime.now();
    DateTimeFormatter myFormattedDate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String formattedDate = time.format(myFormattedDate);
}
