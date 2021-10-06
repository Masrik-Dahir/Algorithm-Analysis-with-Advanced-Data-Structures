import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.text.SimpleDateFormat;
import java.util.Date;

public class Generate {
    public static void main(String[] args) {
        int rand = (int)(Math.random()*(1000000)+2);
        String f = String.valueOf(rand) + "\n";
        for (int i = 0; i < rand; i++){
            f += (int)(Math.random()*(100+1)) + " " + (int)(Math.random()*(3)+1) + "\n";
        }

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_z");
        Date date = new Date(System.currentTimeMillis());
        String name = formatter.format(date)+".txt";

        try {
            File myObj = new File(name);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                FileWriter myWriter = new FileWriter(name);
                myWriter.write(f);
                myWriter.close();
                System.out.println("File written");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
