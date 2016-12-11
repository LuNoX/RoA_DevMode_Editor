package test;

import characters.RoACharacter;
import utility.RoAFileChooser;

public class test_CharacterGeneral
{

    public static void main(String[] args)
    {
        RoAFileChooser ifc = new RoAFileChooser();

        RoACharacter cm = new RoACharacter(ifc.chooseFile(
                        "C:\\Users\\Timo\\Desktop\\roa editor\\active\\custom_etalus.ini"));

        System.out.println(cm.getGeneral().getAirDodgeActiveTime());
    }

}
