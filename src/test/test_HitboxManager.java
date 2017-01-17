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
                        "E:\\Schule\\Informatik\\recources\\active\\custom_orcane.ini"));

        for (Move move : cm.getAllMoves())
        {
            System.out.println("Move name: " + move.getName());
            System.out.println("Number of Hitboxes: " + move.getHm().getHitboxes().size());
            for (Hitbox hitbox : move.getHm().getHitboxes())
            {
                System.out.println("Hitbox id: " + hitbox.getId());
                System.out.println("Hitbox parent id: " + hitbox.getParentHitbox());
                System.out.println("Hitbox base hitpause: " + hitbox.getBaseHitpause());
            }
        }
    }

}
