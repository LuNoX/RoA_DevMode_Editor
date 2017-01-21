package test;

import characters.RoACharacter;
import managers.Project;
import moves.Move;
import utility.RoAFileChooser;

public class test_Project
{

    public static void main(String[] args)
    {
        RoAFileChooser ifc = new RoAFileChooser();

        Project prj = new Project(ifc.chooseFile("C:\\Users\\Timo\\Desktop\\roa editor\\active"));

        /*
         * for (int i = 0; i < prj.getCharacters().size(); i++) { if
         * (prj.getCharacters().get(i).getClass().getName() == "characters.Orcane") { for (Move move
         * : prj.getCharacters().get(i).getAllMoves()) { System.out.println(move.getName());
         * System.out.println("Number of Hitboxes: " + move.getHm().getHitboxes().size()); for
         * (Hitbox hitbox : move.getHm().getHitboxes()) { System.out.println("Hitbox id: " +
         * hitbox.getId()); System.out.println("Hitbox parent id: " + hitbox.getParentHitbox());
         * System.out.println("Hitbox base hitpause: " + hitbox.getBaseHitpause());
         * System.out.println("Hitbox window creation frame: " +
         * hitbox.getHitboxWindowCreationFrame()); } System.out.println("______________"); } break;
         * } }
         */

        for (RoACharacter character : prj.getCharacters())
        {
            System.out.println(character.getClass().getName());
            for (Move move : character.getAllMoves())
            {
                if (move.getOther().size() > 0)
                {
                    System.out.println("_______________");
                    System.out.println(move.getName());
                    for (String string : move.getOther())
                    {
                        System.out.println(string);
                    }
                    /*
                     * if (move.isProjectile()) { Projectile tmp = (Projectile) move;
                     * System.out.println(tmp.getProjectileLifetime()); }
                     */
                    // .getHm().getHitboxes().get(0);

                }
            }
            System.out.println("__________________________________________________________");
        }
    }

}
