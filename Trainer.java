import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Trainer {

    //Attributes
    private boolean isRunning;

    //Instances
    Menu memberLists = new Menu("MEMBER LISTS: ", "Please choose: ", new String[]{
            "1. Junior swimmers." + "\n" +
                    "2. Senior swimmers." + "\n" +
                    "3. Adult swimmers." + "\n" +
                    "4. Competitive swimmers over 18." + "\n" +
                    "5. Competitive swimmers under 18."});
    Menu trainerMenu = new Menu("====Trainer Menu====", "Please choose an action: ", new String[]
            {"1. View Competitive Team", "2. Make member competitive", "3. Change swim results",
                    "4. View top 5 swimmers", "9. To go back."});

    Menu swimDisciplinesMenu = new Menu("====Swim Disciplines====", "Please select a swimstyle:  "
            , new String[]{"1. Crawl", "2. Breast Stroke", "3. Butterfly"});

    Menu competitiveMemberMenu = new Menu("====Competitive Members====", "Please select a team",
            new String[]{"1. Junior swimmers", "2. Adult swimmers"});
    Menu juniorAndAdultMenu = new Menu("===Members===", "Please select a non-Competitive team",
            new String[]{"1. Junior swimmers", "2. Adult swimmers"});


    //Constructors
    public Trainer() {}

    //Methods
    public void trainerMenu(Member member, MembersList membersList, Log log) throws IOException {
        trainerMenu.printMenu();
        int choice = trainerMenu.readChoice();
        do {
            switch (choice) {
                case 1 -> printList(membersList);
                case 2 -> createCompetitiveMember(member, membersList, log);
                case 3 -> changeSwimResults(membersList);
                case 4 -> showTopFive(membersList);
                case 5 -> printMembers(membersList.adultCompetitiveSwimmers,"");
                case 9 -> isRunning = false;
                default -> System.out.println("Invalid input");
            }
        } while (isRunning);
    }

    public void showTopFive(MembersList membersList) {
        Scanner scanner = new Scanner(System.in);
        competitiveMemberMenu.printMenu();
        System.out.println("Please choose either adult or junior (1 , 2)");
        int answer = scanner.nextInt();
        if (answer == 1) {
            chooseTopFive(membersList.adultCompetitiveSwimmers);

        } else {
            chooseTopFive(membersList.juniorCompetitiveSwimmers);
        }
    }

    public void chooseTopFive(ArrayList<Member> members) {
        int id = 0;
        Collections.sort(members, new SortSwimmersByTime());
        for (Member member : members) {
            System.out.print(id + 1 + "# ");
            System.out.println(member.getName() + " " + member.getBestTime());
            id++;
        }
    }

    public void changeSwimResults(MembersList membersList) {
        competitiveMemberMenu.printMenu();
        int answer = competitiveMemberMenu.readChoice();

        switch (answer) {
            case 1 -> {
                int i = 0;
                for (Member member : membersList.adultCompetitiveSwimmers) {
                    System.out.print(i + 1 + "# ");
                    System.out.println(member);
                    i++;
                }
                newBestResult("adult", membersList);
            }
            case 2 -> {
                int i = 0;
                for (Member member : membersList.juniorCompetitiveSwimmers) {
                    System.out.print(i + 1 + "# ");
                    System.out.println(member);
                    i++;
                }
                newBestResult("junior", membersList);
            }
        }
    }

    public void newBestResult(String juniorOrAdult, MembersList membersList) {
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        scanner.nextLine(); //Scanner bug
        System.out.println("Please input the new best time.");
        double newBestTime = scanner.nextDouble();
        if (juniorOrAdult.equals("adult")) {
            membersList.adultCompetitiveSwimmers.get(index - 1).setBestTime(newBestTime);
            System.out.println("Result has now been updated.");

        } else {
            membersList.juniorCompetitiveSwimmers.get(index - 1).setBestTime(newBestTime);
            System.out.println("Result has now been updated.");
        }
    }

    //TODO indsæt print arraylist metode fra noahs project
    public void printMembers(ArrayList<Member> genericArrayList, String extra) {
        int i = 0;
        for (Member member : genericArrayList) {
            System.out.print(i + 0 + "# ");
            System.out.printf("Name: " + member.getName() + " Age: " + member.getAge() + " " + extra + "\n");
            i++;
        }
    }

    public void printCompetitive(ArrayList<Member> genericArrayList, String extra) {
        int i = 0;
        for (Member member : genericArrayList) {
            System.out.print(i + 0 + "# ");
            System.out.printf("Name: " + member.getName() + " Age: " + member.getAge() + " SwimStyle: " + member.getSwimStyle()
                    + " Besttime:  " + member.getBestTime() + " Latest Position: " +
                    member.getLatestPosition() +" " + extra + "\n");
            i++;
        }
    }

    public void printList(MembersList membersList) {
        competitiveMemberMenu.printMenu();
        int chooseList = competitiveMemberMenu.readChoice();

        switch (chooseList) {
            case 1 -> printCompetitive(membersList.juniorCompetitiveSwimmers,"");

            case 2 -> printCompetitive(membersList.adultCompetitiveSwimmers,"");

            default -> {
                System.out.println("Invalid input.");
                memberLists.readChoice();
            }
        }
    }
//    public void setCompetitionAndDate(int index, ArrayList <Member> members, Scanner scanner){
//        System.out.println("Please type in the competition: ");
//        String competition = scanner.nextLine();
//        members.get(index).setCompetition(competition);
//
//    }

    public void swimDisciplines(int index, ArrayList<Member> members) {
        swimDisciplinesMenu.printMenu();
        int choice = swimDisciplinesMenu.readChoice();
        switch (choice) {
            case 1 -> members.get(index).setSwimStyle("Crawl");
            case 2 -> members.get(index).setSwimStyle("Breast Stroke");
            case 3 -> members.get(index).setSwimStyle("Butterfly");
            default -> System.out.println("Invalid input");
        }
    }

    public void createCompetitiveMember(Member member, MembersList membersList, Log log) throws IOException {
        Scanner scanner = new Scanner(System.in);
        competitiveMemberMenu.printMenu();
        int chooseList = juniorAndAdultMenu.readChoice();
        switch (chooseList) {
            case 1 -> competitiveMembers(scanner, membersList.juniorSwimmers, member, membersList, log);
            case 2 -> competitiveMembers(scanner, membersList.adultSwimmers, member, membersList, log);
            default -> System.out.println("Invalid input.");

        }
        scanner.nextLine();

        System.out.println("You have now added member to a competitive team.");
    }

    public void getInformationAboutCompetitiveSwimmer(Scanner scanner, ArrayList<Member> members, int index){
        swimDisciplines(index, members);
        System.out.println("Please enter the members best time: ");
        members.get(index).setBestTime(scanner.nextDouble());
        System.out.println("Please enter the members latest position: ");
        members.get(index).setLatestPosition(scanner.nextInt());

    }

    private void competitiveMembers(Scanner scanner, ArrayList<Member> members, Member member, MembersList membersList, Log log) throws IOException {
        printMembers(members,"");
        System.out.println("Please select the index of which member to make competitive.");
        int index = scanner.nextInt();
        getInformationAboutCompetitiveSwimmer(scanner, members, index);
        if (members.get(index).getAge() < 18) {
            membersList.juniorCompetitiveSwimmers.add(new Member(members.get(index).getName(), members.get(index).getAge(),
                    members.get(index).getSwimStyle(), members.get(index).getBestTime(),
                    members.get(index).getLatestPosition()));
        } else if (members.get(index).getAge() > 18) {
            membersList.adultCompetitiveSwimmers.add(new Member(members.get(index).getName(),
                    members.get(index).getAge(),
                    members.get(index).getSwimStyle(), members.get(index).getBestTime(),
                    members.get(index).getLatestPosition()));
        }
        log.writeLine("\n" + member.getName()+ " " + member.getAge()+ " " + member.getSwimStyle()+ " " +
                member.getBestTime() + " " + member.getLatestPosition());
        members.remove(index);

    }
}




