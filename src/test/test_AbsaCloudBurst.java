package test;

import characters.Absa;
import managers.Project;
import utility.RoAFileChooser;

public class test_AbsaCloudBurst
{

    public static void main(String[] args)
    {
        RoAFileChooser ifc = new RoAFileChooser();

        Project prj = new Project(ifc.chooseFile("C:\\Users\\Timo\\Desktop\\roa editor\\active"));

        for (int i = 0; i < prj.getCharacters().size(); i++)
        {
            if (prj.getCharacters().get(i).getClass().getName() == "characters.Absa")
            {
                Absa absa = (Absa) prj.getCharacters().get(i);
                System.out.println(absa.getCloudBurst().getHitboxManager().getHitboxes().get(0).getId());
                System.out.println(absa.getCloudBurst().getHitboxManager().getHitboxes().get(1).getId());
                System.out.println(absa.getCloudBurst().getHitboxManager().getNumberOfUniqueHitboxes());
                for (String tmp : absa.getCloudBurst().getOther())
                {
                    System.out.println(tmp);
                }
                break;
            }
        }
    }

}
