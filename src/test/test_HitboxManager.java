package test;

import characters.RoACharacter;
import moves.Move;
import utility.RoAFileChooser;

public class test_HitboxManager
{

    public static void main(String[] args)
    {
        RoAFileChooser ifc = new RoAFileChooser();

        RoACharacter cm = new RoACharacter(ifc.chooseFile(
                        "C:\\Users\\Timo\\Desktop\\roa editor\\active\\custom_absa.ini"));

        for (Move move : cm.getAllMoves())
        {
            System.out.println(move.getHm().getNumberOfMultihitboxes());
        }
    }

}
