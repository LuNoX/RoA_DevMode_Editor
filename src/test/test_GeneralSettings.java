package test;

import model.managers.Project;
import model.utility.RoAFileChooser;

public class test_GeneralSettings
{

    public static void main(String[] args)
    {
        RoAFileChooser ifc = new RoAFileChooser();

        Project prj = new Project(ifc.chooseFile("C:\\Users\\Timo\\Desktop\\roa editor\\active"));
        
        System.out.println(prj.getGeneral().getGameplay().getAsdiStrength());
        System.out.println(prj.getGeneral().getReset().getResetAbsa());
    }

}
