
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Class that accept user input and operate with tracker data
 */
public class UiController {
    /**
     * Class fields
     */
    private TrackerController trackerController;
    private ConsoleInput input;
    private Ui ui;

    /**
     * UiController constructor
     * @param trackerController tracker controller object
     * @param input user input object
     */
    public UiController(TrackerController trackerController, ConsoleInput input) {
        this.input = input;
        this.trackerController = trackerController;
    }

    /**
     * Method handling user menu option entered
     * @param key menu option
     */
    public void executeUserAction(int key){
        switch (key) {
            /**
             * Exit from application
             */
            case 0: {
                String needToSave = input.getUserInput("Do you want to save data before exit? Y/N: ");
                if(needToSave.toUpperCase().regionMatches(0,"Y",0,1)) {
                    executeUserAction(11);
                }

                System.out.println("EXITING...");
                break;
            }
            /**
             * Create project
             */
            case 1: {
                String projectName = input.getUserInput("Enter the new project name: ");
                int projectId = trackerController.getIdForProject();
                trackerController.addProject(new Project(projectId, projectName));
                System.out.println("Project " + projectName + " created!");
                break;
            }
            /**
             * Create user
             */
            case 2: {
                String userFirstName = input.getUserInput("Enter the new user first name: ");
                String userLastName = input.getUserInput("Enter the new user last name: ");
                int userId = trackerController.getIdForUser();
                trackerController.addUser(new User(userId, userFirstName, userLastName));
                System.out.println("User " + userFirstName + " " + userLastName +
                        " with ID " + userId + " created!");
                break;
            }
            /**
             * Create task
             */
            case 3: {
                int projectId = input.getUserIntInput("Enter projectId of the new task: ");
                if(trackerController.getProject(projectId) == null) {
                    System.out.println("There is no project with ID " + projectId);
                    break;
                }
                String taskName = input.getUserInput("Enter the new task name: ");
                int userId = input.getUserIntInput("Enter userId of the new task: ");
                if(trackerController.getUser(userId) == null) {
                    System.out.println("There is no user with ID " + userId);
                    break;
                }
                int taskId = trackerController.getIdForTask();
                Project taskProject = trackerController.getProject(projectId);
                User taskUser = trackerController.getUser(userId);
                trackerController.addTask(new Task(taskId, taskName, taskProject, taskUser));
                System.out.println("Task " + taskName + " created!");
                break;
            }
            /**
             * Delete project by projectID
             */
            case 4: {
                int projectId = input.getUserIntInput("Enter the project ID to delete: ");
                Project project = trackerController.getProject(projectId);
                switch(trackerController.removeProject(project)) {
                    case 0: {
                        System.out.println("Project " + project.getName() + " deleted!");
                        break;
                    }
                    case 1: {
                        System.out.println("There is no project with ID " + projectId);
                        break;
                    }
                    case 2: {
                        System.out.println("Project has active tasks and can not be deleted!");
                    }
                }
                break;
            }
            /**
             * Delete user by userID
             */
            case 5: {
                int userId = input.getUserIntInput("Enter the user ID to delete: ");
                User user = trackerController.getUser(userId);
                switch(trackerController.removeUser(user)) {
                    case 0: {
                        System.out.println("User " + user.getFirstName() + " " + user.getLastName() + " deleted!");
                        break;
                    }
                    case 1: {
                        System.out.println("There is no user with ID " + userId);
                        break;
                    }
                    case 2: {
                        System.out.println("User has active tasks and can not be deleted!");
                    }
                }
                break;
            }
            /**
             * Delete task by taskID
             */
            case 6: {
                int taskId = input.getUserIntInput("Enter the task ID to delete: ");
                Task task = trackerController.getTask(taskId);
                switch (trackerController.removeTask(task)) {
                    case 0: {
                        System.out.println("Task " + task.getName() + " deleted.");
                        break;
                    }
                    case 1: {
                        System.out.println("There is no task with ID " + taskId);
                        break;
                    }
                }
                break;
            }
            /**
             * Show all projects in the tracker
             */
            case 7: {
                System.out.println("Projects in the tracker:");
                ArrayList<Project> projects = trackerController.getAllProjects();
                if(projects.size() == 0) {
                    System.out.println("There are no projects in the tracker.");
                } else {
                    for (Project p : projects) System.out.println("ID: " + p.getId() + ", name: " + p.getName());
                }
                break;
            }
            /**
             * Show all users in the tracker
             */
            case 8: {
                System.out.println("Users in the tracker:");
                ArrayList<User> users = trackerController.getAllUsers();
                if(users.size() == 0) {
                    System.out.println("There are no users int the tracker.");
                } else {
                    for (User u : users)
                        System.out.println("ID: " + u.getId() + ",  name: " + u.getFirstName() +
                                " " + u.getLastName());
                }
                break;
            }
            /**
             * Show all tasks in specify project
             */
            case 9: {
                int projectId = input.getUserIntInput("Enter projectID: ");
                if(trackerController.getProject(projectId) == null) {
                    System.out.println("There is no project with this ID.");
                    break;
                }
                ArrayList<Task> tasks = trackerController.getTasksByProjectId(projectId);
                System.out.println("Tasks in project: ");
                if(tasks.size() == 0) {
                    System.out.println("There are no tasks in this project.");
                } else {
                    for (Task t : tasks) {
                        System.out.println("ID: " + t.getId() + " name: " + t.getName());
                    }
                }
                break;
            }
            /**
             * Show all tasks on specify user
             */
            case 10: {
                int userId = input.getUserIntInput("Enter userID: ");
                if(trackerController.getUser(userId) == null) {
                    System.out.println("There is no user with ID: " + userId);
                    break;
                }
                ArrayList<Task> tasks = trackerController.getTasksByUserId(userId);
                System.out.println("Tasks on user: ");
                if(tasks.size() == 0) {
                    System.out.println("There are no tasks on this user.");
                } else {
                    for (Task t : tasks) {
                        System.out.println("ID: " + t.getId() + " name: " + t.getName());
                    }
                }
                break;
            }
            /**
             * Save tracker data
             */
            case 11: {
                String inputPath = input.getUserInput("Enter the path to the file: ");
                try {
                    Path path = Paths.get(inputPath);
                    trackerController.saveData(path);
                    System.out.println("Data saved successfully!");
                } catch (InvalidPathException e) {
                    System.out.print("ERROR! ");
                    System.out.println(e.getMessage());
                    executeUserAction(11);
                } catch (IOException e) {
                    System.out.print("ERROR! ");
                    System.out.println(e.getMessage());
                    executeUserAction(11);
                }
                break;
            }
            /**
             * Load tracker data
             */
            case 12: {
                String inputPath = input.getUserInput("Enter the path to the file: ");
                try {
                    Path path = Paths.get(inputPath);
                    trackerController.loadData(path);
                    System.out.println("Data loaded successfully!");
                } catch (InvalidPathException e) {
                    System.out.print("ERROR! ");
                    System.out.println(e.getMessage());
                } catch (IOException e) {
                    System.out.print("ERROR! ");
                    System.out.println(e.getMessage());
                }
                break;
            }
            default:
                System.out.println("Please enter properly menu item.");
        }
    }

}
