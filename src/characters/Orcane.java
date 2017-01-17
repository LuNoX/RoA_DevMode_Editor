package characters;

import java.io.File;

import utility.CommandStorage;

public class Orcane extends RoACharacter
{
    public Orcane(File file)
    {
        super(file, CommandStorage.orcaneSpecificMoveNames);
    }
}
