import java.io.IOException;

public class Trainer {

    //Attributes
    private boolean isRunning;
    //Fingerpej til member så vi ikke laver en ny instans hver gang :)
    private Member member;

    //Instances
    Menu trainerMenu = new Menu("====Trainer Menu====", "Please choose an action: ", new String[]
            {"1. View Competitive Team", "2. Make member competitive", "3. Change swim results",
                    "4. View top 5 swimmers", "9. To go back."});
    Menu swimDisciplinesMenu = new Menu("====Swim Disciplines====", "Please select a discipline: "
            , new String[]{"1. Crawl", "2. Breast Stroke", "3. Butterfly"});


    //Constructors
    public Trainer(Member member) {
        this.member = member;
    }

    public Trainer() {
    }

    //Methods
    public void trainerMenu() throws IOException {
        trainerMenu.printMenu();
        int choice = trainerMenu.readChoice();
        do {
            switch (choice) {
                case 1 -> member.printList();
                case 2 -> member.createCompetitiveMember();
                case 3 -> member.changeSwimResults();
                case 4 -> member.showTopFive();
                case 9 -> isRunning = false;
                default -> System.out.println("Invalid input");
            }
        } while (isRunning);
    }

    public void swimDisciplinesMenu() {
        swimDisciplinesMenu.printMenu();
        int choice = swimDisciplinesMenu.readChoice();
        switch (choice) {
            case 1 -> member.setSwimStyle("Crawl");
            case 2 -> member.setSwimStyle("Breast Stroke");
            case 3 -> member.setSwimStyle("Butterfly");
            default -> System.out.println("Invalid input");
        }
    }
}