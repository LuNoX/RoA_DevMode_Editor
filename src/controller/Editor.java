package controller;
import controller.Controller;
import model.managers.ProjectManager;
import ui.MainWindow;
import ui.Resources;

public class Editor
{
    public Editor()
    {
        Resources resources = new Resources();
        ProjectManager projectManager = new ProjectManager();
        MainWindow mainWindow = new MainWindow();
        mainWindow.getFrame().setVisible(true);
        Controller controller = new Controller(projectManager, mainWindow);
    }
}
