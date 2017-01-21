package settings;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import utility.RoAFileReader;

public class GeneralSettings
{
    protected File settingsFile = null;
    protected List<String> content = new ArrayList<String>();
    
    protected Gameplay gameplay = new Gameplay();
    protected Reset reset = new Reset();
    
    public GeneralSettings()
    {
    }
    // TODO fill this constructor
    public GeneralSettings(File file)
    {
        this.settingsFile = file;
        this.initializeEverything();
    }
    
    public void initializeEverything()
    {
        this.initializeContent();
        this.initializeGameplayAndReset();
    }
    
    public void initializeContent()
    {
        RoAFileReader ifr = new RoAFileReader(this.settingsFile);
        ifr.nextLine();

        // save the file as an ArrayList of Strings
        while (ifr.getActiveLine() != null)
        {
            if (!ifr.getActiveLine().equals(""))
            {
                this.content.add(ifr.getActiveLine());
                ifr.nextLine();
            }
        }
        ifr.close();
    }
    
    public void initializeGameplayAndReset()
    {
        String line = null;
        int startIndex = this.content.size() + 1;

        for (int i = this.content.size() - 1; i >= 0; i--)
        {
            line = this.content.get(i);
            if (line.contains("[") && line.contains("]"))
            {
                int endIndex = startIndex - 1;
                startIndex = i + 1;

                String name = line.substring(line.indexOf("[") + 1, line.indexOf("]"));
                if (name.equals("GAMEPLAY"))
                {
                    Gameplay gameplay = new Gameplay(new ArrayList<>(this.content.subList(startIndex,
                                    endIndex)));
                    this.gameplay = gameplay;
                }
                else if (name.equals("GENERAL"))
                {
                    Reset reset = new Reset(new ArrayList<>(this.content.subList(startIndex,
                                    endIndex)));
                    this.reset = reset;
                }
            }
        }
    }
    public File getSettingsFile()
    {
        return settingsFile;
    }
    public List<String> getContent()
    {
        return content;
    }
    public Gameplay getGameplay()
    {
        return gameplay;
    }
    public Reset getReset()
    {
        return reset;
    }
}
