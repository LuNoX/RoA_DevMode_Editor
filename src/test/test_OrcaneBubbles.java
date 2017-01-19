package test;

import characters.Orcane;
import managers.Project;
import utility.RoAFileChooser;

public class test_OrcaneBubbles
{

    public static void main(String[] args)
    {
        RoAFileChooser ifc = new RoAFileChooser();

        Project prj = new Project(ifc.chooseFile("C:\\Users\\Timo\\Desktop\\roa editor\\active"));

        for (int i = 0; i < prj.getCharacters().size(); i++)
        {
            if (prj.getCharacters().get(i).getClass().getName() == "characters.Orcane")
            {
                Orcane orcane = (Orcane) prj.getCharacters().get(i);
                System.out.println(orcane.getBubbles().getDamage());
                System.out.println(orcane.getBubbles().getHitstop());
                break;
            }
        }
    }

}
