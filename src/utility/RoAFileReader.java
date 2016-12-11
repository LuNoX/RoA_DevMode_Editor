package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RoAFileReader
{
    protected String activeLine = null;
    protected BufferedReader reader;

    /**
     * Erstellt einen neuen Leser anhand einer Datei
     * 
     * @param file
     *            die Datei anhand dessen der Leser erstellt werden soll
     */
    public RoAFileReader(File file)
    {
        try
        {
            reader = new BufferedReader(new FileReader(file));
            // this.nextLine();
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    /**
     * Liest die nächste Zeile der Datei und speichert sie
     */
    public void nextLine()
    {
        try
        {
            this.activeLine = reader.readLine();
        }
        catch (IOException e)
        {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    public void close()
    {
        try
        {
            this.reader.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    public String getActiveLine()
    {
        return this.activeLine;
    }

}
