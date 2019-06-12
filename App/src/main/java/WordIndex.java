import java.io.*;
import java.util.*;

public class WordIndex {

    public static void main(String[] args) {

        WordIndex wi = new WordIndex();
        wi.loadFile("/home/maminspapin/1.txt");
        System.out.println(wi.getIndexes4Word("dog"));
    }



    private Trie wordsStore = new Trie();

    /*
    Проверить, существует ли файл
    */
    private static boolean isFileAvailable(String fileName) {

        File userFile = new File(fileName);
        return userFile.exists();
    }

    /*
    Загрузить файл и построить индекс
    */
    public void loadFile(String filename) {

        StringBuilder words = new StringBuilder();
        StringBuilder word = new StringBuilder();
        int index = 1;
        int wordIndex = 1;

        if(isFileAvailable(filename)) {
            File userFile = new File(filename);

            try (InputStreamReader isr = new InputStreamReader(new FileInputStream(userFile),"UTF-8")) {
                int ch;
                while ((ch = isr.read()) != -1) {
                    words.append((char)ch);
                }
            } catch (IOException e) {
                System.out.println("Error while reading file");
            }

        } else {
            System.out.println("File is not exist");
            return;
        }

        char[] chs = words.toString().toCharArray();

        for (int i = 0; i < words.length(); i++) {

            if (!Character.isWhitespace(chs[i])) {
                word.append(chs[i]);
            } else {
                wordsStore.insert(word.toString(), wordIndex);
                word = new StringBuilder();
                wordIndex = index + 1;
            }

            index++;
        }
    }

    /*
    Список позиций слова в файле
    */
    public Set<Integer> getIndexes4Word(String searchWord) {
        Set<Integer> result = wordsStore.search(searchWord);
        return result;
    }


}