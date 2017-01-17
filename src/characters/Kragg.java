package characters;

import java.io.File;

import utility.CommandStorage;

public class Kragg extends RoACharacter
{
    public Kragg(File file)
    {
        super(file, CommandStorage.kraggSpecificMoveNames);
    }
}
