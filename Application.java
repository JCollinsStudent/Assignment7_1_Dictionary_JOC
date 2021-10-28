import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * The Application class contains a main method which reads key:value pairs from a csv file, sorts it, and prints it.
 *
 * @author Joshua Collins
 * @version 1.0
 * @since 2021-10-28
 */ 
public class Application {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        try {
            Scanner scan = new Scanner(new File("DictionaryWordValuePairs.csv"));
            ArrayList<String> lines = new ArrayList<String>();
            ArrayList<DictionaryObject> moreLines = new ArrayList<DictionaryObject>();
            while (scan.hasNext()) {
                String newLine = scan.nextLine();
                lines.add(newLine.startsWith("\uFEFF") ? newLine.substring(1) : newLine);
            }

            int j = 0;
            for (int i=0; i < (lines.size()); i++) {
                String keyValueText = lines.get(i);
                keyValueText = keyValueText.replace("\"", "");
                String[] keyValueArr = keyValueText.split(",", 2);
                String key = keyValueArr[0];
                String value = keyValueArr[1];

                if (i >= lines.size()/2) {
                    moreLines.add(j, new DictionaryObject(key, value));
                    // j++;
                }
                else {
                    dictionary.addAtIndex(i, new DictionaryObject(key, value));
                }
            }

            dictionary.print();
            dictionary.sortByKey();
            dictionary.print();

            for (DictionaryObject obj : moreLines) {
                dictionary.add(obj.key, obj.value);
            }
            scan.close();

            dictionary.print();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}