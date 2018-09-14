/**
 * Project type
 */
public class Project {
    /**
     * Project name
     */
    private String name;
    /**
     * Project id
     */
    private int projectId;
    /**
     * Public constructor
     */
    public Project() {}

    /**
     * Creates a new Project object
     * @param projectId project ID
     * @param name The project name
     */
    public Project(int projectId, String name) {
        this.name = name;
        this.projectId = projectId;
    }

    /**
     * Return a project name
     * @return The project name
     */
    public String getName() {
        return name;
    }

    /**
     * Return a project ID
     * @return The project ID
     */
    public int getId() {
        return projectId;
    }

    /**
     * Set a project name
     * @param name The project name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set a project ID
     * @param projectId project ID
     */
    public void setId(int projectId) {
        this.projectId = projectId;
    }
}
