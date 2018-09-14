public class Main {
    /**
     * Initialization application objects and make loop for interact with user
     */
    public void init() {
        /**
         * Create tracker object
         */
        Tracker tracker = new Tracker();
        /**
         * Create tracker controller object
         */
        TrackerController trackerController = new TrackerController(tracker);
        /**
         * Create console input object
         */
        ConsoleInput input = new ConsoleInput();
        /**
         * Create menu object
         */
        Ui menu = new Ui();
        /**
         * Create Ui controller
         */
        UiController uiController = new UiController(trackerController, input);
        boolean loop = true;
        /**
         * Ask user to load data from file before application starts
         */
        String needToLoad = input.getUserInput("Do you want to load data? Y/N: ");
        if(needToLoad.toUpperCase().regionMatches(0,"Y",0,1)) {
            uiController.executeUserAction(12);
        }
        /**
         * Create loop
         */
        while (loop) {
            System.out.println("");
            menu.showMenu();
            System.out.println("");
            int key = input.getUserIntInput("Please, choose menu item: ");
            System.out.println("");
            uiController.executeUserAction(key);
            if (key == 0) {
                loop = false;
            }
        }
    }

    public static void main(String[] args) {
        /**
         * Create main object
         */
        Main start = new Main();
        /**
         * Start application
         */
        start.init();

    }
}
