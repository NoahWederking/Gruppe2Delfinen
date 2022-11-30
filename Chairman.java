
public class Chairman {

    //Attributes
    private boolean isRunning;
    private final Member member;

    //Instances
    CompetitveMember newCompetitiveSwimmer;
    Menu chairmanMenu = new Menu("====Chairman Menu====", "Please choose: ", new String[]
            {"1. Create new member", "2. Create new competitive member", "3. View member list",
                    "4. Change membership status", "9. To go back"});

    //Constructors
    public Chairman(Member member) {
        this.member = member;
    }

    //Methods
    public void chairmanMenu() {
        do {
            chairmanMenu.printMenu();
            int choice = chairmanMenu.readChoice();

            switch (choice) {
                case 1 -> member.createMember();
                case 2 -> newCompetitiveSwimmer.createMember();
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
