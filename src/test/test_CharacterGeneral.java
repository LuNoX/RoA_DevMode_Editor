package test;

import characters.RoACharacter;
import managers.Project;
import moves.CustomCommand;
import utility.RoAFileChooser;

public class test_CharacterGeneral
{

    public static void main(String[] args)
    {
        RoAFileChooser ifc = new RoAFileChooser();

        Project prj = new Project(ifc.chooseFile(
                        "C:\\Users\\Timo\\Desktop\\roa editor\\actives\\current active"));

        for (RoACharacter character : prj.getCharacters())
        {
            System.out.println(character.getClass().getName());
            if (character.getGeneral().getCharacterSpecificCommands().size() > 0)
            {
                System.out.println("_______________");
                for (CustomCommand customCommand: character.getGeneral().getCharacterSpecificCommands())
                {
                    System.out.println(customCommand.getName());
                }
            }

            System.out.println("__________________________________________________________");
        }
    }

}
