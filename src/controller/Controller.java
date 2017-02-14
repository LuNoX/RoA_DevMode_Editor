package controller;

import java.util.ResourceBundle.Control;

import model.managers.Project;
import model.managers.ProjectManager;
import model.utility.RoAFileChooser;
import ui.MainWindow;

public class Controller
{
    protected ProjectManager projectManager = new ProjectManager();
    protected MainWindow mainWindow = new MainWindow();
    private static Controller instance = null;
    
    public Controller ()
    {
    }
    
    private Controller(ProjectManager projectManager, MainWindow mainWindow)
    {
        this.projectManager = projectManager;
        RoAFileChooser ifc = new RoAFileChooser();

        //Project prj = new Project(ifc.chooseFile("C:\\Users\\Timo\\Desktop\\roa editor\\actives\\current active"), "Active Project");
        Project prj = new Project(ifc.chooseFile("E:\\Schule\\Informatik\\recources\\actives\\current active"), "Active Project");
        this.projectManager.addProject(prj);
        this.mainWindow = mainWindow;
        
        this.mainWindow.initalizeTree(this.projectManager);
        
        Controller.instance = this;
    }
    
    public static Controller getInstance (ProjectManager projectManager, MainWindow mainWindow)
    {
        Controller result = instance;
        if (result == null)
        {
            result = new Controller(projectManager, mainWindow);
        }
        return result;
    }
}
