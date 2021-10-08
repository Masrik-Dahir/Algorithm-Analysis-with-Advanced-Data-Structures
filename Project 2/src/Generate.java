import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

public class Generate {
    public static void main(String[] args) throws IOException {
        int rand = (int)(Math.random()*(99999)+2);
        String f = String.valueOf(rand) + "\n";
        for (int i = 0; i < rand; i++){
            f += (int)(Math.random()*(1000000)+1) + " " + (int)(Math.random()*(3)+1) + "\n";
        }
        File file = new File("Project 2/src/filename.txt");
        FileWriter myWriter = new FileWriter("Project 2/src/filename.txt");
        myWriter.write(f);
        myWriter.close();
    }
}
