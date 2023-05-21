import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class JournalManager {

    File file = new File("Diary.txt");

    public void writeEntry(JournalEntry entry) {
        String note = entry.getTime().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) + " - " + entry.getText() + "\n";
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true));
            bufferedWriter.write(note);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> readEntries() {
        int count = 0;
        String checkEmpty;
        List<String> entriesList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((checkEmpty = bufferedReader.readLine()) != null) {
                entriesList.add(checkEmpty);
                count++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (count == 0) {
            entriesList.add("No personal");
        }
        return entriesList;
    }

    public boolean deleteEntries(LocalDateTime timestamp) {
        boolean isDeleted = false;
        String checkEmpty;
        List<String> entriesList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((checkEmpty = bufferedReader.readLine()) != null) {
                entriesList.add(checkEmpty);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (String entry : entriesList) {
                if (entry.startsWith(timestamp.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")))) {
                    isDeleted = true;
                } else {
                    bufferedWriter.write(entry + "\n");
                    bufferedWriter.flush();
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return isDeleted;
    }

    public void clearEntries() {
        try {
            FileWriter fileWriter = new FileWriter(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
