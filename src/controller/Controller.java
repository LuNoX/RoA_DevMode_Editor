package controller;

import model.managers.ProjectManager;

public class Controller
{
    public static ProjectManager projectManager = null;
    
    public Controller ()
    {
        Controller.projectManager = new ProjectManager();
    }
    
    public Controller(ProjectManager projectManager)
    {
        Controller.projectManager = projectManager;
    }
}
