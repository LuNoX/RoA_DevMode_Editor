package model.managers;

import java.util.ArrayList;
import java.util.List;

import model.utility.RoAFileChooser;

public class ProjectManager
{
    protected List<Project> projects = null;
    public static RoAFileChooser roaFileChooser = new RoAFileChooser(); //TODO remove this if it turns out to be ineffective or unnecessary

    public ProjectManager(List<Project> projects)
    {
        this.projects = projects;
    }

    public ProjectManager()
    {
        projects = new ArrayList<Project>();
    }
}
