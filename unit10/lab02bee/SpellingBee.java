import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;

public class SpellingBee {

    private char[] letters;
    private char mustUse;

    // TODO construct me!

    public boolean checkWord(String word) {
        // TODO implement me!
        return true;
    }

    /**
     * Loads the contents of file "filename" as a String.
     * 
     * @param filename the file to load
     * @return the contents of file "filename"
     */
    public static String loadFile(String filename) {
        String contents = "";
        Path path = Paths.get(filename);
        try {
            path = Path.of(ClassLoader.getSystemResource(filename).toURI());
            contents = Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return contents;
    }

    public static void main(String[] args) {
        String[] words = loadFile("words_dropped.txt").split("\n");
        System.out.println("Loaded " + words.length + " words");
        // TODO solve me!
        // SpellingBee bee = new SpellingBee("ranglty".toCharArray(), 'y');

        // TODO sort words!

        // TODO what position in the sorted list is the word "search" ?
        Arrays.sort(words);
        // linear search
        int n = 0;
        for (String word : words) {
            n++;
            if (word.equals("potato")) {
                System.out.println("Linear: found potato in "+n+" guesses.");
            }
        }
        String findMe = "potato";

        
        int begin = 0;
        int end = words.length - 1;
        int guess = (begin + end) / 2;
        int check = words[guess].compareTo(findMe);
        n = 1;
        // System.out.println("word is " + words[guess]);
        // System.out.println("check is " + check);

        while (check != 0) {
            
            if (check < 0) {
                // word[guess] is before findMe, so move begin to guess.
                begin = guess;
            } else if (check > 0) {
                // findMe is before word[guess], so move end to guess.
                end = guess;
            }
            guess = (begin + end) / 2;
            check = words[guess].compareTo(findMe);
            n++;
            // System.out.println("word is " + words[guess]);
            // System.out.println("check is " + check);
        }
        System.out.println("Binary: found potato in "+n+" guesses.");


    }
}
