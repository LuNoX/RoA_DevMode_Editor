package managers;

import java.util.ArrayList;
import java.util.List;

public class ProjectManager
{
    protected List<Project> projects = null;

    public ProjectManager(List<Project> projects)
    {
        this.projects = projects;
    }

    public ProjectManager()
    {
        projects = new ArrayList<Project>();
    }
}
