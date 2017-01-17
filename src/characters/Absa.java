package characters;

import java.io.File;

import utility.CommandStorage;

public class Absa extends RoACharacter
{
    public Absa(File file)
    {
        super(file, CommandStorage.absaSpecificMoveNames);
    }
}
