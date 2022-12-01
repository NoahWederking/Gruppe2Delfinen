import java.io.IOException;

public class Cashier {

    //Attributes
    private final Member member;
    private boolean isRunning;

    //Instances
    Menu cashierMenu = new Menu("====Cashier Menu====", "Please choose: ", new String[]
            {"1. View member state", "2. Change member state", "9. To go back."});

    //Constructors
    public Cashier(Member member) {
        this.member = member;
    }

    //Methods
    public void cashierMenu() throws IOException {
        cashierMenu.printMenu();
        int choice = cashierMenu.readChoice();
        do {
            switch (choice) {
                case 1 -> member.viewMembershipState();
                case 2 -> System.out.println("Change state"); //TODO NTH
                case 9 -> {
                    System.out.println("Quit");
                    isRunning = false;
                }
                default -> System.out.println("Invalid input");
            }
        } while (isRunning);
    }
}
