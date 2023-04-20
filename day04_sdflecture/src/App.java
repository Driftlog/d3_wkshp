import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Make sure if you have the external txt file before running
public class App {
    public static void main(String[] args) throws Exception {

        String dirPath = args[0];
        String fileName = args[1];
        String dirPathFileName = dirPath + File.separator + fileName;

        File newDir = new File(dirPath);
        if (newDir.exists()) {
             System.out.println(newDir + " directory already exists");
            } else {
                newDir.mkdir();
            }

        File newFile = new File(dirPathFileName);
        if (!newFile.exists()) {
            System.out.println(dirPathFileName + "does not exist");
            System.exit(0);
            /* exit(0) : Generally used to indicate successful termination.
            exit(1) or exit(-1) or any other non-zero value – Generally indicates unsuccessful termination. */
        } 

        // FileReader and BufferedReader 
        FileReader fr = new FileReader(new File(dirPathFileName));
        BufferedReader br = new BufferedReader(fr);
        String lineInput = "";

        //StringBuilder allows for appending, instead of constant concatenating
        StringBuilder sbFileContent = new StringBuilder();
        while ((lineInput = br.readLine()) != null) {
            //convert string to all uppercase then appends to SB
            sbFileContent.append(lineInput.toUpperCase());
        }

        br.close();
        fr.close();

        //print the StringBuilder object
        System.out.println(sbFileContent);
        // Or sbFileContent.toString().toUpperCase

        String fileContent = sbFileContent.toString();
        fileContent = fileContent.replace(",", " ");
        fileContent = fileContent.replace(".", " ");
        fileContent = fileContent.replace("{", " ");
        fileContent = fileContent.replace("}", " ");
        fileContent = fileContent.replace("'", " ");
        fileContent = fileContent.replace("?", " ");
        fileContent = fileContent.replace("!", " ");
        fileContent = fileContent.replace("(", " ");
        fileContent = fileContent.replace(")", " ");

        String [] fileContentArray = fileContent.split(" ");

        //storing unique words
        Map<String, Integer> words = new HashMap<>();

        for (String word: fileContentArray) {

            Integer wordExists = words.get(word);

            if (wordExists == null) {
                words.put(word, 1);
            } else {
                words.put(word, wordExists+1);
        }
    }

    System.out.println(words);
}
}