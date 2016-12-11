package test;

import characters.RoACharacter;
import utility.*;

public class test_CharacterManager
{
    public static void main(String[] args)
    {
        RoAFileChooser ifc = new RoAFileChooser();

        /*
         * String[] tmp = {"a", "b", "c" , "d"}; Utilities u = new Utilities();
         * tmp = u.removeEntry(tmp, 1); System.out.print(tmp[0] + " " + tmp[1] +
         * " " + tmp[2]);
         */

        RoACharacter cm = new RoACharacter(ifc.chooseFile(
                        "C:\\Users\\Timo\\Desktop\\roa editor\\active\\custom_etalus.ini"));

        for (int i = 0; i < cm.getAllMoves().get(4).getWm().getWindows().size(); i++)
        {
            System.out.println(cm.getAllMoves().get(4).getWm().getWindows().get(i).getSfx());
        }
    }
}
