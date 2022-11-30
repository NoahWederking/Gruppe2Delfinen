public class Trainer {

    //Attributes
    boolean isRunning;
    boolean isBack;
    private final Member member;

    //Instances
    Menu trainerMenu = new Menu("====Trainer Menu====", "Please choose an action", new String[]
            {"1. View Competitive Team", "2. Register swim results", "3. View Top five swimmers"});

    Menu swimTeams = new Menu("====Swim Teams====", "Please choose a team",
            new String[]{"1. Junior Competitive", "2. Adult Competitive", "3. Adult Swimmers", "4. Senior Swimmers",
                    "5. Junior Swimmers", "9. Quit"});

    //Constructors
    public Trainer(Member member) {
        this.member = member;
    }

    //Methods
    public void trainerMenu() {
        trainerMenu.printMenu();
        int choice = trainerMenu.readChoice();
        do {
            switch (choice) {
                case 1 -> member.printList();
                case 2 -> System.out.println("Register swim results");
                case 3 -> System.out.println("Top 5");
                case 9 -> {System.out.println("Quit"); isRunning = false;}
                default -> System.out.println("Invalid input");
            }
        }while (isRunning);
    }

   /* public void viewSwimTeams(){
        swimTeams.printMenu();
        int choice = swimTeams.readChoice();
        do{
            switch (choice){
                case 1 -> System.out.println("Print ARRAY FOR JUNOIR TEAM");
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
