/*
 * FileIO.java
 * This class provides functions to read files
 * Jess Lorantfy
 * January 12th, 2018
 */
package twentyone;

import java.io.*;
import java.net.URL;

/**
 *
 * @author Jessica
 */
public class FileIO {
    /**
     * This function reads a file within the java package folder
     * @param fileName The filename of the file inside the java package
     * @return The full contents of the file as a string
     */
    public String readFile(String fileName) {
        String file = "";
        try {     
            // Get's the absolute file path given a file name
            // Example:
            // If the filename is cards.txt, this would get something like this:
            // C:/Users/Jessica/Documents/TwentyOne/build/classes/twentyone/cards.txt
            URL url = getClass().getResource(fileName);
            
            // This creates the file readers, which read the file from the file system
            FileReader fileReader = new FileReader(url.getPath());
            BufferedReader bufferReader = new BufferedReader(fileReader);
            
            /**
             * Reads each line in the file
             * For each line add it to file variable
             */
            String line = "";
            while ((line = bufferReader.readLine()) != null) {
                file = file + line + "\n";
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println("Couldn't find file");               
        }
        catch(IOException ex) {
            System.out.println("Error reading file");
        }
        
        return file;
    }
}
