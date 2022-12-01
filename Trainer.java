public class Trainer {

    //Attributes
    private boolean isRunning;
    private boolean isBack;
    private Member member;

    //Instances
    Menu trainerMenu = new Menu("====Trainer Menu====", "Please choose an action: ", new String[]
            {"1. View Competitive Team", "2. Make member competitive", "3. Register swim results",
                    "4. View top 5 swimmers", "9. To go back."});

    Menu swimTeams = new Menu("====Swim Teams====", "Please choose a team: ",
            new String[]{"1. Junior Competitive", "2. Adult Competitive", "3. Adult Swimmers", "4. Senior Swimmers",
                    "5. Junior Swimmers", "9. To go back."});

    Menu swimDisciplinesMenu = new Menu("====Swim Disciplines====", "Please select a discipline: "
    , new String[]{"1. Crawl", "2. Breast Stroke", "3. Butterfly"});


    //Constructors
    public Trainer(Member member) {
        this.member = member;
    }
    public Trainer(){}

    //Methods
    public void trainerMenu() {
        trainerMenu.printMenu();
        int choice = trainerMenu.readChoice();
        do {
            switch (choice) {
                case 1 -> member.printList();
                case 2 -> member.createCompetitiveMember();
                case 3 -> System.out.println("Register swim results");
                case 4 -> System.out.println("Top 5");
                case 9 -> {
                    System.out.println("Quit");
                    isRunning = false;
                }
                default -> System.out.println("Invalid input");
            }
        } while (isRunning);
    }
    public void  swimDisciplinesMenu(){
        swimDisciplinesMenu.printMenu();
        int choice = swimDisciplinesMenu.readChoice();
        switch (choice){
            case 1 -> member.setSwimStyle("Crawl");
            case 2 -> member.setSwimStyle("Breast Stroke");
            case 3 -> member.setSwimStyle("Butterfly");
            default -> System.out.println("Invalid input");
        }
    }


   /* public void viewSwimTeams(){
        swimTeams.printMenu();
        int choice = swimTeams.readChoice();
        do{
            switch (choice){
                case 1 -> System.out.println("Print ARRAY FOR JUNIOR TEAM");
                case 2 -> System.out.println("Print ARRAY FOR adult TEAM");
                case 3 -> System.out.println("Print ARRAY for adultSwimmers");
                case 4 -> System.out.println("Print array for senior swimmer");
                case 5 -> System.out.println("print array Junior swimmers");
                case 9 -> System.out.println("Quit");
                default -> System.out.println("invalid input");
            }
        } while(isBack);
    }*/

}
