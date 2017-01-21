package test;

import characters.RoACharacter;
import managers.Hitbox;
import moves.Move;
import utility.RoAFileChooser;

public class test_HitboxManager
{

    public static void main(String[] args)
    {
        RoAFileChooser ifc = new RoAFileChooser();

        RoACharacter cm = new RoACharacter(ifc.chooseFile(
                        "C:\\Users\\Timo\\Desktop\\roa editor\\active\\custom_orcane.ini"));

        for (Move move : cm.getAllMoves())
        {
            System.out.println(move.getName());
            System.out.println("Number of Hitboxes: " + move.getHitboxManager().getHitboxes().size());
            for (Hitbox hitbox : move.getHitboxManager().getHitboxes())
            {
                System.out.println("Hitbox id: " + hitbox.getId());
                System.out.println("Hitbox parent id: " + hitbox.getParentHitbox());
                System.out.println("Hitbox base hitpause: " + hitbox.getBaseHitpause());
                System.out.println("Hitbox window creation frame: " + hitbox.getHitboxWindowCreationFrame());
            }
            System.out.println("______________");
        }
    }

}
