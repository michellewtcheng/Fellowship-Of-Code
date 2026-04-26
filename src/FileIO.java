/**
* This class is responsible for performing file input and output operations
* @version 1
* @author Michelle Cheng & Adapted from Rolling Project (ITO4131)
*/
import java.util.Scanner;
import java.io.*;
public class FileIO
{
    private String fileName;

    /**
    * Default constructor for the FileIO class
    */
    public FileIO()
    {
        fileName = "Unnamed.txt";
    }

    /**
    * Non-default constructor for the FileIO class
    * @param fileName   The name of the file as a String
    */
    public FileIO(String fileName)
    {
        this.fileName = fileName;
    }

    /**
    * Accessor method for fileName variable
    * @return   The name of the file as a String
    */
    public String getFileName()
    {
        return fileName;
    }

    /**
    * Method to read text file into the program
    * @return   All the text file's data in the form of a single String
    */
    public String readFile()
    {
        StringBuffer fileData = new StringBuffer();
        try
        {
            FileReader reader = new FileReader(this.fileName);
            try
            {
                Scanner fileInput = new Scanner(reader);
                while (fileInput.hasNextLine())
                {
                    fileData.append(fileInput.nextLine() + "\n");
                }
            }
            finally
            {
                try
                {
                    reader.close();
                }
                catch (Exception e)
                {
                    System.out.println("Error in closing Labyrinth file.");
                }
            }
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println(fileName + " not found.");
        }
        catch (Exception e)
        {
            System.out.println("Error in reading from Labyrinth file");
        }
        return fileData.toString();
    }

    /**
    * Mutator method for fileName variable
    * @param newFileName   The name of the file as a String
    */
    public void setFileName(String newFileName)
    {
        if (newFileName != null)
            this.fileName = newFileName;
    }
    
    /**
    * Method to write text to a file.
    * @param inputToWrite   The text to write to the file in a single String
    *                       with \n characters included.
    */
    public void writeFile(String inputToWrite)
    {
        try
        {
            FileWriter writer = new FileWriter(this.fileName);
            try
            {
                writer.append(inputToWrite);
            }
            finally
            {
                try
                {
                    writer.close();
                }
                catch (Exception e)
                {
                    System.out.println("Error in closing output file.");
                }
            }
        }
        catch(IOException ioe)
        {
            System.out.println("An IO error was encountered: " + ioe);
        }
        catch (Exception e)
        {
            System.out.println("Error in writing to the output file.");
        }
    }
}
