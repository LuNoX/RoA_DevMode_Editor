package controller;
import controller.Controller;
import model.managers.ProjectManager;
import ui.MainWindow;

public class Editor
{
    public Editor()
    {
        ProjectManager projectManager = new ProjectManager();
        MainWindow mainWindow = new MainWindow();
        mainWindow.getFrame().setVisible(true);
        Controller controller = new Controller(projectManager, mainWindow);
    }
}
