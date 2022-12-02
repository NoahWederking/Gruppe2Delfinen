import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Trainer {

    //Attributes
    private boolean isRunning;
    private boolean isBack;
    private Member member;
    private Log log;
    Calender calender = new Calender();

    //Instances
    Menu trainerMenu = new Menu("====Trainer Menu====", "Please choose an action: ", new String[]
            {"1. View Competitive Team", "2. Make member competitive", "3. Register swim results",
                    "4. View top 5 swimmers", "9. To go back."});

    Menu swimTeams = new Menu("====Swim Teams====", "Please choose a team: ",
            new String[]{"1. Junior Competitive", "2. Adult Competitive", "3. Adult Swimmers", "4. Senior Swimmers",
                    "5. Junior Swimmers", "9. To go back."});


    Menu competitiveMemberMenu = new Menu("====Competitive Members", "Please select a team",
            new String[] {"1. Junior swimmers" ,"2. Adult swimmers" });


    //Constructors
    public Trainer(Member member) {
        this.member = member;
    }
    public Trainer(){}

    //Methods
    public void trainerMenu() throws IOException {
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


    public void makeMemberCompetitive() throws IOException {
        log.writeLine("\n" + calender.formattedDate + " MAKE A MEMBER COMPETITIVE");
        Scanner scanner = new Scanner(System.in);
        competitiveMemberMenu.printMenu();
        int chooseList = competitiveMemberMenu.readChoice();

        switch (chooseList) {
            case 1 -> competitiveMembers(scanner, member.juniorSwimmers);
            case 2 -> competitiveMembers(scanner, member.adultSwimmers);
            default -> {
                System.out.println("Invalid input.");
                competitiveMemberMenu.readChoice();
            }
        }
        System.out.println("You have now added member to a competitive team.");
    }

    private void competitiveMembers(Scanner scanner, ArrayList<Member> standard) throws IOException {
        for (int i = 0; i < standard.size(); i++) {
            System.out.println(standard.get(i));
            System.out.println("Please select the index of which member to make competitive.");
            int index = scanner.nextInt();

            if(member.getAge() < 18){
                member.juniorCompetitiveSwimmers.add(new Member(member.getName(), member.getAge(),member.getSwimStyle(),
                        member.getBestTime(), member.getLatestPosition()));
            } else if (member.getAge() > 18) {
                member.adultCompetitiveSwimmers.add(new Member(member.getName(), member.getAge(),member.getSwimStyle(),
                        member.getBestTime(), member.getLatestPosition()));
            }

            standard.remove(index);

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
