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

    public List<Project> getProjects()
    {
        return projects;
    }

    public static RoAFileChooser getRoaFileChooser()
    {
        return roaFileChooser;
    }
    
    public void addProject(Project project)
    {
        this.projects.add(project);
    }
    
    public void exportProjects()
    {
        for (Project project : this.projects)
        {
            project.exportProject();
        }
    }
}
