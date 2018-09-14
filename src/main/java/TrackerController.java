import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * TrackerController type
 */
public class TrackerController {
    /**
     * Tracker object field
     */
    private Tracker tracker;
    /**
     * Creates tracker controller object
     * @param tracker tracker object
     */
    public TrackerController(Tracker tracker) {
        this.tracker = tracker;
    }
    /**
     * Get ID for new project
     * @return int ID
     */
    public int getIdForProject() {
        return tracker.getProjectIds();
    }
    /**
     * Get ID for new user
     * @return int ID
     */
    public int getIdForUser() {
        return tracker.getUserIds();
    }
    /**
     * Get ID for new task
     * @return int ID
     */
    public int getIdForTask() {
        return tracker.getTaskIds();
    }
    /**
     * Add new user in the tracker
     * @param user user object
     */
    public void addUser(User user) {
        tracker.getUsers().add(user);
    }

    /**
     * Find and return user in tracker
     * @param id id of the user to find
     * @return user object
     */
    public User getUser(int id) {
        for(User u: tracker.getUsers()) {
            if(id == u.getId()) return u;
        }
        return null;
    }

    /**
     * Return arraylist of all users in tracker
     */
    public ArrayList<User> getAllUsers() {
        return tracker.getUsers();
    }

    /**
     * Remove user from the tracker
     * @param user user object
     * @return int value of the user removal result
     *          0 - success removal
     *          1 - user object received is null
     *          2 - user has active tasks
     */
    public int removeUser(User user) {
        if(user == null) {
            return 1;
        } else if(isUserHasTasks(user)) {
            return 2;
        }
        int ui = user.getId();
        for(User u: tracker.getUsers()) {
            if(ui == u.getId()) {
                tracker.getUsers().remove(u);
                break;
            }
        }
        return 0;
    }

    /**
     * Check if the user has any task
     * @param user user object
     * @return true, if user has any task. False - if user has no tasks.
     */
    private boolean isUserHasTasks(User user) {
        int ui = user.getId();
        for(Task task: tracker.getTasks()) {
            if(task.getUserId() == ui) {
                return true;
            }
        }
        return false;
    }

    /**
     * Add a new project to the tracker
     * @param project project object
     */
    public void addProject(Project project) {
        tracker.getProjects().add(project);
    }

    /**
     * Find and return project in tracker
     * @param id id of the project to find
     * @return project object
     */
    public Project getProject(int id) {
        for(Project p: tracker.getProjects()) {
            if(id == p.getId()) return p;
        }
        return null;
    }

    /**
     * Return arraylist of all projects
     */
    public ArrayList<Project> getAllProjects() {
        return  tracker.getProjects();
    }

    /**
     * Remove project from the tracker
     * @param project project object
     * @return int value of the project removal result
     *          0 - success removal
     *          1 - project object received is null
     *          2 - project has active tasks
     */
    public int removeProject(Project project) {
        if(project == null) {
            return 1;
        } else if(isProjectHasTasks(project)) {
            return 2;
        }
        int pi = project.getId();
        for(Project p: tracker.getProjects()) {
            if(pi == p.getId()) {
                tracker.getProjects().remove(p);
                break;
            }
        }
        return 0;
    }

    /**
     * Check if the project has any task
     * @param project project object
     * @return true, if project has any task. False - if project has no tasks.
     */
    private boolean isProjectHasTasks(Project project) {
        int pi = project.getId();
        for(Task task: tracker.getTasks()) {
            if(task.getProjectId() == pi) {
                return true;
            }
        }
        return false;
    }

    /**
     * Add new task in the tracker
     * @param task task object
     */
    public void addTask(Task task) {
        tracker.getTasks().add(task);
    }

    /**
     * Find and return task in tracker
     * @param id id of the task to find
     * @return task object
     */
    public Task getTask(int id) {
        for(Task t: tracker.getTasks()) {
            if(id == t.getId()) return t;
        }
        return null;
    }

    /**
     * Return array of tasks by projectID
     * @param projectId projectId
     * @return array list of task objects
     */
    public ArrayList<Task> getTasksByProjectId(int projectId) {
        ArrayList<Task> tasksByProjectId = new ArrayList<>();
        for(Task currentTask: tracker.getTasks()) {
            if(projectId == currentTask.getProjectId()) {
                tasksByProjectId.add(currentTask);
            }
        }
        return tasksByProjectId;
    }

    /**
     * Return array of tasks by userID
     * @param userId userId
     * @return array list of task objects
     */
    public ArrayList<Task> getTasksByUserId(int userId) {
        ArrayList<Task> tasksByUserId = new ArrayList<>();
        for(Task currentTask: tracker.getTasks()) {
            if(userId == currentTask.getUserId()) {
                tasksByUserId.add(currentTask);
            }
        }
        return tasksByUserId;
    }

    /**
     * Remove task from the tracker
     * @param task task object
     * @return int value of the task removal result
     *          0 - success removal
     *          1 - task object received is null
     */
    public int removeTask(Task task) {
        if(task == null) {
            return 1;
        }
        int taskId = task.getId();
        for(Task currentTask: tracker.getTasks()) {
            if(taskId == currentTask.getId()) {
                tracker.getTasks().remove(currentTask);
                break;
            }
        }
        return 0;
    }

    /**
     * Save tracker object in the file
     * @param path path to the file
     */
    public void saveData(Path path) throws IOException {
        File saveData = path.toFile();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(saveData, tracker);
    }

    /**
     * Load tracker object from the file specified
     * @param path path to the file
     */
    public void loadData(Path path) throws IOException {
        File loadDataFile = path.toFile();
        ObjectMapper mapper = new ObjectMapper();
        tracker = mapper.readValue(loadDataFile, Tracker.class);
    }

}
