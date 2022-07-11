
/**
 *
 * @author big
 */


import java.io.*;
        
public class TryReading {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream fstream = new FileInputStream("/Users/big/CodingProjects/javaDevelopment/EMOTIONALSONGS/data/Canzoni.dati.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine = br.readLine();

        //Read File Line By Line
        //while ((strLine = br.readLine()) != null)   {
        // Print the content on the console
        
        System.out.println (strLine);
        //}

    //Close the input stream
    fstream.close();
    } 
}
    

