import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Trainer {

    //Attributes
    private boolean isRunning;

    //Instances
    Menu competitiveMemberList = new Menu("COMPETITIVE MEMBER LISTS:", "Please choose: ", new String[]{
            "1, Competitive members over 18." + "\n" + "2. Competitive members under 18"});
    Menu memberLists = new Menu("MEMBER LISTS: ", "Please choose: ", new String[]{
            "1. Junior swimmers." + "\n" +
                    "2. Senior swimmers." + "\n" +
                    "3. Adult swimmers." + "\n" +
                    "4. Competitive swimmers over 18." + "\n" +
                    "5. Competitive swimmers under 18."});
    Menu trainerMenu = new Menu("====Trainer Menu====", "Please choose an action: ", new String[]
            {"1. View Competitive Team", "2. Make member competitive", "3. Change swim results",
                    "4. View top 5 swimmers", "9. To go back."});

    Menu swimDisciplinesMenu = new Menu("====Swim Disciplines====", "Please select a discipline: "
            , new String[]{"1. Crawl", "2. Breast Stroke", "3. Butterfly"});

    Menu competitiveMemberMenu = new Menu("====Competitive Members====", "Please select a team",
            new String[]{"1. Junior swimmers", "2. Adult swimmers"});


    //Constructors
    public Trainer() throws IOException {
    }

    //Methods
    public void trainerMenu(Member member, MembersList membersList, Calender calender, Log log) throws IOException {
        trainerMenu.printMenu();
        int choice = trainerMenu.readChoice();
        do {
            switch (choice) {
                case 1 -> printList(membersList, calender, log);
                case 2 -> createCompetitiveMember(member, membersList, calender, log);
                case 3 -> changeSwimResults(membersList);
                case 4 -> showTopFive(membersList, calender, log);
                case 5 -> printMembers(membersList.adultCompetitiveSwimmers);
                case 9 -> isRunning = false;
                default -> System.out.println("Invalid input");
            }
        } while (isRunning);
    }
    public void showTopFive(MembersList membersList, Calender calender, Log log) throws IOException {
        log.writeLine("VIEWING TOP 5 LIST");
        Scanner scanner = new Scanner(System.in);
        competitiveMemberList.printMenu();
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
        competitiveMemberList.printMenu();
        int answer = competitiveMemberList.readChoice();

        switch (answer) {
            case 1 -> {
                int i = 0;
                for (Member member : membersList.adultCompetitiveSwimmers) {
                    System.out.print(i + 1 +"# ");
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
    public void createCompetitiveMember(Member member, MembersList membersList, Calender calender, Log log) throws IOException {
        log.writeLine("\n" + calender.formattedDate + " CREATING COMPETITIVE MEMBER");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select a team");
        makeMemberCompetitive(member, membersList, calender, log);

//        System.out.println("Please select a member to make competitive: ");
//        scanner.nextLine();
//
//        name = getName();
//        age = getAge();
//
//        System.out.println("Please enter swim style");
//        swimDisciplines();
//
//        System.out.println("Please enter the members best time: ");
//        bestTime = scanner.nextDouble();
//        setBestTime(bestTime);
//
//        System.out.println("Please enter the members latest position: ");
//        latestPosition = scanner.nextInt();
//        setLatestPosition(latestPosition);


    }
    public void printList() throws IOException {
        log.writeLine("\n" + calender.formattedDate + " VIEWING MEMBER LIST");
        competitiveMemberList.printMenu();
        int chooseList = competitiveMemberList.readChoice();

        switch (chooseList) {

            case 1 -> {
                for (Member member : MembersList.adultCompetitiveSwimmers) {
                    System.out.println(member);
                }
                log.writeLine("\n" + calender.formattedDate + " VIEWING ADULT COMPETITIVE SWIMMERS");
            }
            case 2 -> {
                for (Member member : MembersList.juniorCompetitiveSwimmers) {
                    System.out.println(member);
                }
                log.writeLine("\n" + calender.formattedDate + " VIEWING JUNIOR COMPETITIVE SWIMMERS");
            }
            default -> {
                System.out.println("Invalid input.");
                memberLists.readChoice();
            }
        }
    }

    public void swimDisciplines(Member member) {
        swimDisciplinesMenu.printMenu();
        int choice = swimDisciplinesMenu.readChoice();
        switch (choice) {
            case 1 -> member.setSwimStyle("Crawl");
            case 2 -> member.setSwimStyle("Breast Stroke");
            case 3 -> member.setSwimStyle("Butterfly");
            default -> System.out.println("Invalid input");
        }
    }

    public void makeMemberCompetitive(Member member, MembersList membersList, Calender calender, Log log) throws IOException {
        log.writeLine("\n" + calender.formattedDate + " MAKE A MEMBER COMPETITIVE");
        Scanner scanner = new Scanner(System.in);
        competitiveMemberMenu.printMenu();
        int chooseList = competitiveMemberMenu.readChoice();

        switch (chooseList) {
            case 1 -> competitiveMembers(scanner, membersList.juniorSwimmers, member, membersList);
            case 2 -> competitiveMembers(scanner, membersList.adultSwimmers, member, membersList);
            default -> System.out.println("Invalid input.");

        }
        System.out.println("You have now added member to a competitive team.");
    }

    private void competitiveMembers(Scanner scanner, ArrayList<Member> members, Member member, MembersList membersList) {
            printMembers(members);
            System.out.println("Please select the index of which member to make competitive.");
            int index = scanner.nextInt();
            if (member.getAge() < 18) {
                members.get(index).setBestTime(member.getBestTime());
                members.get(index).setLatestPosition(member.getLatestPosition());
                membersList.juniorCompetitiveSwimmers.add(new Member(member.getName(), member.getAge(),
                        member.getSwimStyle(), member.getBestTime(), member.getLatestPosition()));
            } else if (member.getAge() > 18) {
                membersList.adultCompetitiveSwimmers.add(new Member(member.getName(), member.getAge(),
                        member.getSwimStyle(), member.getBestTime(), member.getLatestPosition()));
            }

            standard.remove(index);
        }
    }
    @Override
    public String toString() {
        return " Member: " + "Name: " + name + " Age: " + age + " Best time: " + bestTime + " Swim style: " + swimStyle +
                " Latest position: " + latestPosition;
    }
}




