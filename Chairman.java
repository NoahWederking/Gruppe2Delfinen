
public class Chairman {
    //Attributes
    private boolean isRunning;

    //Instances
    Member member = new Member();
    Menu chairmanMenu = new Menu("====Chairman Menu====", "Please choose: ", new String[]
            {"1. Create new member", "2. Create new competitive member", "3. View member list",
                    "4. Change membership status", "9. To go back"});

    public void chairmanMenu() {
        do {
            chairmanMenu.printMenu();
            int choice = chairmanMenu.readChoice();

            switch (choice) {
                case 1 -> member.createMember();
                case 2 -> System.out.println();
                case 3 -> member.printList();
                case 4 -> member.makePassiveMember();
                case 9 -> isRunning = false;
                default -> {
                    System.out.println("Invalid input.");
                }
            }
        } while (isRunning);
    }
}
