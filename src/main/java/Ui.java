/**
 * User interface (menu)
 */
public class Ui {
    /**
     * Menu items
     */
    private final String MENU_HEADER = "TRACKER MENU";
    private final String MENU_1 = "1. Create project";
    private final String MENU_2 = "2. Create user";
    private final String MENU_3 = "3. Create task";
    private final String MENU_4 = "4. Delete project";
    private final String MENU_5 = "5. Delete user";
    private final String MENU_6 = "6. Delete task";
    private final String MENU_7 = "7. View all projects";
    private final String MENU_8 = "8. View all users";
    private final String MENU_9 = "9. View tasks in specify project";
    private final String MENU_10 = "10. View tasks on specify user";
    private final String MENU_11 = "11. Save data";
    private final String MENU_12 = "12. Load data";
    private final String MENU_EXIT = "0. Exit";
    private final String[] MENU = {MENU_HEADER, MENU_1, MENU_2, MENU_3, MENU_4,
                                    MENU_5, MENU_6, MENU_7, MENU_8, MENU_9, MENU_10,
                                        MENU_11, MENU_12, MENU_EXIT};
    /**
     * Print the menu in the console
     */
    public void showMenu() {
        for(String s: MENU) {
            System.out.println(s);
        }
    }
}
