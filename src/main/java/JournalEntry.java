import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JournalEntry {

    private LocalDateTime time;
    private String text;

    public JournalEntry(String text) {
        time = LocalDateTime.now();
        this.text = text;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getText() {
        return text;
    }
}
