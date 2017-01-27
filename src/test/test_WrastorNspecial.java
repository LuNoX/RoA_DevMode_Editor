package test;

import characters.Wrastor;
import managers.Hitbox;
import managers.Project;
import utility.RoAFileChooser;

public class test_WrastorNspecial
{

    public static void main(String[] args)
    {
        RoAFileChooser ifc = new RoAFileChooser();

        Project prj = new Project(ifc.chooseFile("C:\\Users\\Timo\\Desktop\\roa editor\\actives\\current active"));

        for (int i = 0; i < prj.getCharacters().size(); i++)
        {
            if (prj.getCharacters().get(i).getClass().getName() == "characters.Wrastor")
            {
                Wrastor wrastor = (Wrastor) prj.getCharacters().get(i);
                System.out.println(wrastor.getNspecial().getTimeBetweenMultihitLoops());
                for (Hitbox hitbox : wrastor.getNspecial().getHitboxManager().getHitboxes())
                {
                    System.out.println(hitbox.getBaseKnockback());
                }
                for (String tmp : wrastor.getNspecial().getOther())
                {
                    System.out.println(tmp);
                }
                break;
            }
        }
    }

}
