
public class Chairman {
    //Attributes
    private boolean isRunning;

    //Instances
    Member member = new Member();
    Menu chairmanMenu = new Menu("====Chairman Menu====", "Please choose: ", new String[]
            {"1. Create new member", "2. View member list", "3. Change membership status", "9. To go back"});

    public void chairmanMenu() {
        do {
            chairmanMenu.printMenu();
            int choice = chairmanMenu.readChoice();

            switch (choice) {
                case 1 -> member.createMember();
                case 2 -> member.printList();
                case 3 -> member.membershipState();
                case 9 -> isRunning = false;
                default -> {
                    System.out.println("Invalid input.");
                }
            }
        } while (isRunning);
    }
}
