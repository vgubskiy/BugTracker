import java.util.Scanner;
/**
 * User input in console
 */
public class ConsoleInput {
    /**.
     * Create scanner object
     */
    private Scanner scanner = new Scanner(System.in);
    /**.
     * Get user int input
     * @param question ask user what data to enter
     * @return int data
     */
    public int getUserIntInput(String question) {
        System.out.print(question);
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        int result = scanner.nextInt();
        return result;
    }
    /**.
     * Get user string input
     * @param question ask user what data to enter
     * @return string data
     */
    public String getUserInput(String question) {
        System.out.print(question);
        return scanner.next();
    }
}
