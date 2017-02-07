package controller;

import model.managers.Project;
import model.managers.ProjectManager;
import model.utility.RoAFileChooser;
import ui.MainWindow;

public class Controller
{
    protected ProjectManager projectManager = new ProjectManager();
    protected MainWindow mainWindow = new MainWindow();
    
    public Controller ()
    {
    }
    
    public Controller(ProjectManager projectManager, MainWindow mainWindow)
    {
        this.projectManager = projectManager;
        RoAFileChooser ifc = new RoAFileChooser();

        Project prj = new Project(ifc.chooseFile("C:\\Users\\Timo\\Desktop\\roa editor\\actives\\current active"), "Active Project");
        this.projectManager.addProject(prj);
        this.mainWindow = mainWindow;
        
        this.mainWindow.initalizeTree(this.projectManager);
    }
}
