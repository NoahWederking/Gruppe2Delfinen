import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Trainer {

    //Attributes
    private boolean isRunning;
    private int age;
    private String name;
    private String swimStyle;
    private double bestTime;
    private int latestPosition;

    //Instances
    Calender calender = new Calender();
    Log log = new Log();
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

    //Setters
    public void setSwimStyle(String swimStyle) {
        this.swimStyle = swimStyle;
    }
    public void setBestTime(double bestTime) {
        this.bestTime = bestTime;
    }

    public void setLatestPosition(int latestPosition) {
        this.latestPosition = latestPosition;
    }

    //Getters
    public String getSwimStyle() {
        return swimStyle;
    }
    public int getLatestPosition() {
        return latestPosition;
    }

    public double getBestTime() {
        return bestTime;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //Methods
    public void trainerMenu(Member member) throws IOException {
        trainerMenu.printMenu();
        int choice = trainerMenu.readChoice();
        do {
            switch (choice) {
                case 1 -> printList();
                case 2 -> createCompetitiveMember();
                case 3 -> changeSwimResults();
                case 4 -> showTopFive();
                case 5 -> printMembers(MembersList.adultCompetitiveSwimmers);
                case 9 -> isRunning = false;
                default -> System.out.println("Invalid input");
            }
        } while (isRunning);
    }
    public void showTopFive() throws IOException {
        log.writeLine("VIEWING TOP 5 LIST");
        Scanner scanner = new Scanner(System.in);
        competitiveMemberList.printMenu();
        System.out.println("Please choose either adult or junior (1 , 2)");
        int answer = scanner.nextInt();
        if (answer == 1) {
            chooseTopFive(MembersList.adultCompetitiveSwimmers);

        } else {
            chooseTopFive(MembersList.juniorCompetitiveSwimmers);
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
    public void changeSwimResults() {
        competitiveMemberList.printMenu();
        int answer = competitiveMemberList.readChoice();

        switch (answer) {
            case 1 -> {
                int i = 0;
                for (Member member : MembersList.adultCompetitiveSwimmers) {
                    System.out.print(i + 1 +"# ");
                    System.out.println(member);
                    i++;
                }
                newBestResult("adult");
            }
            case 2 -> {
                int i = 0;
                for (Member member : MembersList.juniorCompetitiveSwimmers) {
                    System.out.print(i + 1 + "# ");
                    System.out.println(member);
                    i++;
                }
                newBestResult("junior");
            }
        }
    }

    public void newBestResult(String juniorOrAdult) {
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        scanner.nextLine(); //Scanner bug
        System.out.println("Please input the new best time.");
        double newBestTime = scanner.nextDouble();
        if (juniorOrAdult.equals("adult")) {
            MembersList.adultCompetitiveSwimmers.get(index - 1).setBestTime(newBestTime);
            System.out.println("Result has now been updated.");

        } else {
            MembersList.juniorCompetitiveSwimmers.get(index - 1).setBestTime(newBestTime);
            System.out.println("Result has now been updated.");
        }
    }
    public void createCompetitiveMember() throws IOException {
        log.writeLine("\n" + calender.formattedDate + " CREATING COMPETITIVE MEMBER");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select a team");
        makeMemberCompetitive();

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

    public void swimDisciplines() {
        swimDisciplinesMenu.printMenu();
        int choice = swimDisciplinesMenu.readChoice();
        switch (choice) {
            case 1 -> setSwimStyle("Crawl");
            case 2 -> setSwimStyle("Breast Stroke");
            case 3 -> setSwimStyle("Butterfly");
            default -> System.out.println("Invalid input");
        }
    }

    public void makeMemberCompetitive() throws IOException {
        log.writeLine("\n" + calender.formattedDate + " MAKE A MEMBER COMPETITIVE");
        Scanner scanner = new Scanner(System.in);
        competitiveMemberMenu.printMenu();
        int chooseList = competitiveMemberMenu.readChoice();

        switch (chooseList) {
            case 1 -> competitiveMembers(scanner, MembersList.juniorSwimmers);
            case 2 -> competitiveMembers(scanner, MembersList.adultSwimmers);
            default -> {
                System.out.println("Invalid input.");
                competitiveMemberMenu.readChoice();
            }
        }
        System.out.println("You have now added member to a competitive team.");
    }

    private void competitiveMembers(Scanner scanner, ArrayList<Member> members) {
            printMembers(members);
            System.out.println("Please select the index of which member to make competitive.");
            int index = scanner.nextInt();

            if (getAge() < 18) {
                members.get(index).setBestTime(bestTime);
                members.get(index).setLatestPosition(latestPosition);
                MembersList.juniorCompetitiveSwimmers.add(new Member(getName(), getAge(), getSwimStyle(),
                        getBestTime(), getLatestPosition()));
            } else if (getAge() > 18) {
                MembersList.adultCompetitiveSwimmers.add(new Member(getName(), getAge(), getSwimStyle(),
                        getBestTime(), getLatestPosition()));
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




