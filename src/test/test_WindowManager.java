package test;

import characters.RoACharacter;
import utility.RoAFileChooser;

public class test_WindowManager
{

    public static void main(String[] args)
    {
        RoAFileChooser ifc = new RoAFileChooser();

        RoACharacter cm = new RoACharacter(ifc.chooseFile(
                        "C:\\Users\\Timo\\Desktop\\roa editor\\active\\custom_etalus.ini"));

        for (int i = 0; i < cm.getAllMoves().get(4).getWindowManager().getWindows().size(); i++)
        {
            System.out.println(cm.getAllMoves().get(4).getWindowManager().getWindows().get(i).getLength());
        }

    }

}
