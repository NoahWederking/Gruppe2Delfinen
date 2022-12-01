import java.io.IOException;

public class Chairman {

    //Attributes
    private boolean isRunning;
    private final Member member;

    //Instances
    CompetitiveMember newCompetitiveSwimmer = new CompetitiveMember();
    Menu chairmanMenu = new Menu("====Chairman Menu====", "Please choose: ", new String[]
            {"1. Create new member", "2. View member list",
                    "3. Change membership status", "9. To go back"});

    //Constructors
    public Chairman(Member member) throws IOException {
        this.member = member;
    }

    //Methods
    public void chairmanMenu() throws IOException {
        do {
            chairmanMenu.printMenu();
            int choice = chairmanMenu.readChoice();

            switch (choice) {
                case 1 -> member.createMember();
                case 2 -> member.printList();
                case 3 -> member.makePassiveMember();
                case 9 -> isRunning = false;
                default -> System.out.println("Invalid input.");

            }
        } while (isRunning);
    }
}
