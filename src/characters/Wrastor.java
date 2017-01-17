package characters;

import java.io.File;

import utility.CommandStorage;

public class Wrastor extends RoACharacter
{    
    public Wrastor(File file)
    {
        super(file, CommandStorage.wrastorSpecificMoveNames);
    }
}
