/**
 * Task type
 */
public class Task {
    /**
     * Task name
     */
    private String taskName;
    /**
     * Task description
     */
    private String desc;
    /**
     * Task status
     */
    private String status;
    /**
     * Task priority
     */
    private String priority;
    /**
     * Task ID
     */
    private int taskId;
    /**
     * ID of the project in wich this task created
     */
    private int projectId;
    /**
     * ID of the user who will be working on this task
     */
    private int userId;
    /**
     * Public constructor
     */
    public Task() {}
    /**
     * Creates task object with minimum necessary fields
     * @param taskId task ID
     * @param taskName task name
     * @param project project in wich this task created
     * @param user user who will be working on this task
     */
    public Task(int taskId, String taskName, Project project, User user) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.projectId = project.getId();
        this.userId = user.getId();
    }
    /**
     * Creates task object with all fields
     * @param taskId task ID
     * @param taskName task name
     * @param desc  description of the task
     * @param status task status
     * @param priority task priority
     * @param projectId ID of the project in wich this task created
     * @param userId ID of the user who will be working on this task
     */
    public Task(int taskId, String taskName, String desc, String status, String priority, int projectId, int userId) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.desc = desc;
        this.status = status;
        this.priority = priority;
        this.projectId = projectId;
        this.userId = userId;
    }

    /**
     * Return the the task name
     * @return task name
     */
    public String getName() {
        return taskName;
    }

    /**
     * Return the the task description
     * @return task description
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Return the task status
     * @return task status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Return the task priority
     * @return task priority
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Return the task ID
     * @return task ID
     */
    public int getId() {
        return taskId;
    }

    /**
     * Return the project ID in wich this task created
     * @return project ID
     */
    public int getProjectId() {
        return projectId;
    }

    /**
     * Return the user ID who will be working on this task
     * @return user ID
     */
    public int getUserId() {
        return userId;
    }

    /**
     * set task ID
     * @param taskId task ID
     */
    public void setId(int taskId) {
        this.taskId = taskId;
    }

    /**
     * Set the task name
     * @param taskName task name
     */
    public void setName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * Set the task description
     * @param desc task description
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Set the task status
     * @param status task status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Set the task priority
     * @param priority task priority
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * Set the project ID in wich this task created
     * @param projectId project ID
     */
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    /**
     * Set the user ID who will be working on this task
     * @param userId user ID
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
