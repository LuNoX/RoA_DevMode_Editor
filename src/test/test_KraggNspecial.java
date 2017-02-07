package test;

import model.characters.Kragg;
import model.managers.Project;
import model.utility.RoAFileChooser;

public class test_KraggNspecial
{

    public static void main(String[] args)
    {
        RoAFileChooser ifc = new RoAFileChooser();

        Project prj = new Project(ifc.chooseFile("C:\\Users\\Timo\\Desktop\\roa editor\\active"));

        for (int i = 0; i < prj.getCharacters().size(); i++)
        {
            if (prj.getCharacters().get(i).getClass().getName() == "characters.Kragg")
            {
                Kragg kragg = (Kragg) prj.getCharacters().get(i);
                System.out.println(kragg.getNspecial().getHitboxManager().getHitboxes().get(0).getBaseHitpause());
                System.out.println(kragg.getNspecial().getRockHealth());
                System.out.println(kragg.getFspecial().getHitboxManager().getHitboxes().get(1).getId());
                System.out.println(kragg.getFspecial().getMaxGroundSpeed());
                for (String tmp : kragg.getFspecial().getOther())
                {
                    System.out.println(tmp);
                }
                break;
            }
        }
    }

}
