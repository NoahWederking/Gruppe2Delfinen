public class Cashier {

    //Attributes
    private boolean isRunning;

    //Instances
    Menu cashierMenu = new Menu("====Cashier Menu====", "Please choose an action", new String[]
            {"1. View member state", "2. Change member state", "9. Quit"});

    public void cashierMenu() {
        cashierMenu.printMenu();
        int choice = cashierMenu.readChoice();
        do {
            switch (choice) {
                case 1 -> System.out.println("View membership state");
                case 2 -> System.out.println("Change state");
                case 9 -> {System.out.println("Quit"); isRunning = false;}
                default -> System.out.println("Invalid input");
            }
        } while (isRunning);
    }
}
