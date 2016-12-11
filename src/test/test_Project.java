package test;

import managers.Project;
import utility.RoAFileChooser;

public class test_Project
{

    public static void main(String[] args)
    {
        RoAFileChooser ifc = new RoAFileChooser();

        Project prj = new Project(ifc.chooseFile("C:\\Users\\Timo\\Desktop\\roa editor\\active"));

        for (int i = 0; i < prj.getCharacters().size(); i++)
        {
            if (prj.getCharacters().get(i).getClass().getName() == "characters.Etalus")
            {
                for (int j = 0; j < prj.getCharacters().get(i).getAllMoves().get(4).getWm()
                                .getWindows().size(); j++)
                {
                    System.out.println(prj.getCharacters().get(i).getAllMoves().get(4).getWm()
                                    .getWindows().get(j).getLength());
                }
                break;
            }
        }
    }

}
