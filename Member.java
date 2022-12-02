import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Member {

    //Attributes
    private int age;
    private String name;
    private String swimStyle;
    private double bestTime;
    private int latestPosition;
    private final int juniorPrice = 1000;
    private final int adultPrice = 1600;
    private final int seniorPrice = 1200;
    private final int passivePrice = 500;
    private Log log;
    private Trainer trainer;


    //Constructors
    public Member(Trainer trainer){
        this.trainer = trainer;
    }
    public Member(Log log) throws IOException {
        this.log = log;
    }
    public Member(String name, int age) throws IOException {
        setName(name);
        setAge(age);
    }
    public Member(String name, int age, String swimStyle, double bestTime, int latestPosition) throws IOException {
        setName(name);
        setAge(age);
        setSwimStyle(swimStyle);
        setBestTime(bestTime);
        setLatestPosition(latestPosition);
    }

    //Instances
    ArrayList<Member> juniorSwimmers = new ArrayList<>();
    ArrayList<Member> seniorSwimmers = new ArrayList<>();
    ArrayList<Member> adultSwimmers = new ArrayList<>();
    ArrayList<Member> passiveSwimmers = new ArrayList<>();
    ArrayList<Member> juniorCompetitiveSwimmers = new ArrayList<>();
    ArrayList<Member> adultCompetitiveSwimmers = new ArrayList<>();
    Calender calender = new Calender();

    Menu memberLists = new Menu("MEMBER LISTS: ", "Please choose: ", new String[]{
            "1. Junior swimmers." + "\n" +
                    "2. Senior swimmers." + "\n" +
                    "3. Adult swimmers." + "\n" +
                    "4. Competitive swimmers over 18." + "\n" +
                    "5. Competitive swimmers under 18."});
    Menu memberPrices = new Menu("PRICE LISTS: ", "Please choose: ", new String[]{
            "1. Junior swimmers." + "\n" +
                    "2. Senior swimmers." + "\n" +
                    "3. Adult swimmers."});
    Menu swimDisciplinesMenu = new Menu("====Swim Disciplines====", "Please select a discipline: "
            , new String[]{"1. Crawl", "2. Breast Stroke", "3. Butterfly"});

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
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
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public String getSwimStyle() {
        return swimStyle;
    }

    public double getBestTime() {
        return bestTime;
    }

    public int getLatestPosition() {
        return latestPosition;
    }


    //Methods
    public void  swimDisciplinesMenu(){
        swimDisciplinesMenu.printMenu();
        int choice = swimDisciplinesMenu.readChoice();
        switch (choice){
            case 1 -> setSwimStyle("Crawl");
            case 2 -> setSwimStyle("Breast Stroke");
            case 3 -> setSwimStyle("Butterfly");
            default -> System.out.println("Invalid input");
        }
    }

    public void createMember() throws IOException {
        Scanner scanner = new Scanner(System.in);
        log.writeLine("\n" + calender.formattedDate + " CREATING MEMBER");

        System.out.println("Please insert new member name: ");
        name = scanner.nextLine();
        setName(name);

        System.out.println("Please insert new member age: ");
        age = scanner.nextInt();
        log.writeLine("\n" + calender.formattedDate + " MEMBER INFO: NAME: " + name + " AGE: " + age);
        scanner.nextLine();
        setAge(age);
        checkAge();
    }

    public void createCompetitiveMember() throws IOException {
        log.writeLine("\n" + calender.formattedDate + " CREATING COMPETITIVE MEMBER");
        Scanner scanner = new Scanner(System.in);
        printList();
        System.out.println("Please select a member to make competitive: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        name = getName();
        age = getAge();

        System.out.println("Please enter swim style");
        swimDisciplinesMenu.printMenu();
        swimDisciplinesMenu.readChoice();


        System.out.println("Please enter the members best time: ");
        bestTime = scanner.nextDouble();
        setBestTime(bestTime);

        System.out.println("Please enter the members latest position: ");
        latestPosition = scanner.nextInt();
        setLatestPosition(latestPosition);
        trainer.makeMemberCompetitive();

    }

    public void checkAge() throws IOException {
        if (age < 18) {
            juniorSwimmers.add(new Member(getName(), getAge()));

        } else if (age > 60) {
            seniorSwimmers.add(new Member(getName(), getAge()));

        } else if (age > 18 && age < 60) {
            adultSwimmers.add(new Member(getName(), getAge()));
        }
    }
    public void checkCompetitiveAge() throws IOException {
        if (age <18){
            juniorCompetitiveSwimmers.add(new Member(getName(), getAge()));
        } else if (age > 18) {
            adultCompetitiveSwimmers.add(new Member(getName(), getAge()));
        }
    }


    public void printList() throws IOException {
        log.writeLine("\n" + calender.formattedDate + " VIEWING MEMBER LIST");
        memberLists.printMenu();
        int chooseList = memberLists.readChoice();

        switch (chooseList) {
            case 1 -> {
                for (Member member : juniorSwimmers) {
                    System.out.println(member);
                }
                log.writeLine("\n" + calender.formattedDate + " VIEWING JUNIOR SWIMMERS");
            }
            case 2 -> {
                for (Member member : seniorSwimmers) {
                    System.out.println(member);
                }
                log.writeLine("\n" + calender.formattedDate + " VIEWING SENIOR SWIMMERS");
            }
            case 3 -> {
                for (Member member : adultSwimmers) {
                    System.out.println(member);
                }
                log.writeLine("\n" + calender.formattedDate + " VIEWING ADULT SWIMMERS");
            }
            case 4 -> {
                for (Member member : adultCompetitiveSwimmers) {
                    System.out.println(member);
                }
                log.writeLine("\n" + calender.formattedDate + " VIEWING ADULT COMPETITIVE SWIMMERS");
            }
            case 5 -> {
                for (Member member : juniorCompetitiveSwimmers) {
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

    public void makePassiveMember() throws IOException {
        log.writeLine("\n" + calender.formattedDate + " MAKING A MEMBER PASSIVE");
        Scanner scanner = new Scanner(System.in);
        memberLists.printMenu();
        int chooseList = memberLists.readChoice();

        switch (chooseList) {
            case 1 -> passiveMembers(scanner, juniorSwimmers);

            case 2 -> passiveMembers(scanner, seniorSwimmers);

            case 3 -> passiveMembers(scanner, adultSwimmers);

            case 4 -> passiveMembers(scanner, adultCompetitiveSwimmers);

            case 5 -> passiveMembers(scanner, juniorCompetitiveSwimmers);

            default -> {
                System.out.println("Invalid input.");
                memberLists.readChoice();
            }
        }
        System.out.println("You have now added member to passive list.");
    }

    private void passiveMembers(Scanner scanner, ArrayList<Member> juniorSwimmers) {
        for (int i = 0; i < juniorSwimmers.size(); i++) {
            System.out.println(juniorSwimmers.get(i));
            System.out.println("Please select the index of which member to make passive.");
            int index = scanner.nextInt();
            passiveSwimmers.add(juniorSwimmers.get(index));
            juniorSwimmers.remove(index);

        }
    }

    public void viewMembershipState() throws IOException {
        log.writeLine("\n" + calender.formattedDate + " VIEWING MEMBERSHIP STATE");
        memberPrices.printMenu();
        int chooseList = memberPrices.readChoice();

        switch (chooseList) {
            case 1 -> {
                for (Member member : juniorSwimmers) {
                    System.out.println(member + " Price: " + juniorPrice);
                    log.writeLine("\n" + calender.formattedDate + member + " Price: " + juniorPrice);
                }
            }
            case 2 -> {
                for (Member member : seniorSwimmers) {
                    System.out.println(member + " Price: " + seniorPrice);
                    log.writeLine("\n" + calender.formattedDate + member + " Price: " + seniorPrice);
                }
            }
            case 3 -> {
                for (Member member : adultSwimmers) {
                    System.out.println(member + " Price: " + adultPrice);
                    log.writeLine("\n" + calender.formattedDate + member + " Price: " + adultPrice);
                }
            }
            default -> {
                System.out.println("Invalid input.");
                memberLists.readChoice();
            }
        }
    }

    @Override
    public String toString() {
        return " Member: " + "Name: " + name + " Age: " + age;
    }
}
