import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Trainer {

    //Attributes
    private boolean isRunning;
    //Fingerpej til member så vi ikke laver en ny instans hver gang :)
    private Member member;

    //Instances
    Calender calender = new Calender();
    Log log = new Log();
    MembersList membersList = new MembersList();
    Menu trainerMenu = new Menu("====Trainer Menu====", "Please choose an action: ", new String[]
            {"1. View Competitive Team", "2. Make member competitive", "3. Change swim results",
                    "4. View top 5 swimmers", "9. To go back."});

    Menu swimDisciplinesMenu = new Menu("====Swim Disciplines====", "Please select a discipline: "
            , new String[]{"1. Crawl", "2. Breast Stroke", "3. Butterfly"});

    Menu competitiveMemberMenu = new Menu("====Competitive Members====", "Please select a team",
            new String[]{"1. Junior swimmers", "2. Adult swimmers"});

    Menu swimTeams = new Menu("====Swim Teams====", "Please choose a team: ",
            new String[]{"1. Junior Competitive", "2. Adult Competitive", "3. Adult Swimmers", "4. Senior Swimmers",
                    "5. Junior Swimmers", "9. To go back."});


    //Constructors
    public Trainer(Member member) throws IOException {
        this.member = member;
    }

    public Trainer() throws IOException {
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

    public void swimDisciplines() {
        swimDisciplinesMenu.printMenu();
        int choice = swimDisciplinesMenu.readChoice();
        switch (choice) {
            case 1 -> member.setSwimStyle("Crawl");
            case 2 -> member.setSwimStyle("Breast Stroke");
            case 3 -> member.setSwimStyle("Butterfly");
            default -> System.out.println("Invalid input");
        }
    }



    public void makeMemberCompetitive() throws IOException {
        log.writeLine("\n" + calender.formattedDate + " MAKE A MEMBER COMPETITIVE");
        Scanner scanner = new Scanner(System.in);
        competitiveMemberMenu.printMenu();
        int chooseList = competitiveMemberMenu.readChoice();

        switch (chooseList) {
            case 1 -> competitiveMembers(scanner, membersList.juniorSwimmers);
            case 2 -> competitiveMembers(scanner, membersList.adultSwimmers);
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

            if (member.getAge() < 18) {
                membersList.juniorCompetitiveSwimmers.add(new Member(member.getName(), member.getAge(), member.getSwimStyle(),
                        member.getBestTime(), member.getLatestPosition()));
            } else if (member.getAge() > 18) {
                membersList.adultCompetitiveSwimmers.add(new Member(member.getName(), member.getAge(), member.getSwimStyle(),
                        member.getBestTime(), member.getLatestPosition()));
            }

            standard.remove(index);
        }
    }
}




