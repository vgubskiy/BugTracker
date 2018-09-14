import java.util.ArrayList;

/**
 * Tracker object
 */
public class Tracker {
    /**
     * Array of all users in the tracker
     */
    private ArrayList<User> users = new ArrayList<>();
    /**
     * Array of all projects in the tracker
     */
    private ArrayList<Project> projects = new ArrayList<>();
    /**
     * Array of all tasks int he tracker
     */
    private ArrayList<Task> tasks = new ArrayList<>();
    /**
     * ID generator for project
     */
    private int projectIds = 1;
    /**
     * ID generator for users
     */
    private int userIds = 1;
    /**
     * ID generator for tasks
     */
    private int taskIds = 1;

    /**
     * Get new ID for project object
     * @return int ID
     */
    public int getProjectIds() {
        return projectIds++;
    }
    /**
     * Get new ID for user object
     * @return int ID
     */
    public int getUserIds() {
        return userIds++;
    }
    /**
     * Get new ID for task object
     * @return int ID
     */
    public int getTaskIds() {
        return taskIds++;
    }

    /**
     * Return users list
     * @return users list
     */
    public ArrayList<User> getUsers() {
        return users;
    }
    /**
     * Return project list
     * @return project list
     */
    public ArrayList<Project> getProjects() {
        return projects;
    }
    /**
     * Return tasks list
     * @return tasks list
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
