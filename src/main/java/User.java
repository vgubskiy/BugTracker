/**
 * User type
 */
public class User {
    /**
     * Users first name
     */
    private String firstName;
    /**
     * User last name
     */
    private String lastName;
    /**
     * User ID
     */
    private int userId;
    /**
     * Public constructor
     */
    public User() {}
    /**
     * Creates user object
     * @param firstName The first name
     * @param lastName The last name
     * @param userId The user ID
     */
    public User(int userId, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
    }

    /**
     * Return user first name
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Return user last name
     * @return The last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Return user ID
     * @return The user ID
     */
    public int getId() {
        return userId;
    }

    /**
     * Set the user first name
     * @param firstName The first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Set the user last name
     * @param lastName The last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Set user ID
     * @param userId The user ID
     */
    public void setId(int userId) {
        this.userId = userId;
    }
}
