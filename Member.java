import java.io.IOException;
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

    //Constructors
    public Member(Trainer trainer) throws IOException {
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
    Calender calender = new Calender();
    Trainer trainer = new Trainer();
    MembersList membersList = new MembersList();

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
    Menu competitiveMemberList = new Menu("COMPETITIVE MEMBER LISTS:", "Please choose: ", new String[]{
            "1, Competitive members over 18." + "\n" + "2. Competitive members under 18"});

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
    public void createMember() throws IOException {
        log.writeLine("\n" + calender.formattedDate + " CREATING MEMBER");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please insert new member name: ");
        name = scanner.nextLine();
        setName(name);

        System.out.println("Please insert new member age: ");
        age = scanner.nextInt();
        log.writeLine("\n" + calender.formattedDate + " MEMBER INFO: NAME: " + name + " AGE: " + age);
        scanner.nextLine();
        setAge(age);
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
        trainer.swimDisciplinesMenu();

        System.out.println("Please enter the members best time: ");
        bestTime = scanner.nextDouble();

        System.out.println("Please enter the members latest position: ");
        latestPosition = scanner.nextInt();
    }

    public void checkAge() throws IOException {
        if (age < 18) {
            membersList.juniorSwimmers.add(new Member(getName(), getAge()));

        } else if (age > 60) {
            membersList.seniorSwimmers.add(new Member(getName(), getAge()));

        } else if (age > 18 && age < 60) {
            membersList.adultSwimmers.add(new Member(getName(), getAge()));
        }
    }

    public void checkCompetitiveAge() throws IOException {
        if (age < 18) {
            membersList.juniorCompetitiveSwimmers.add(new Member(getName(), getAge()));
        } else if (age > 18) {
            membersList.adultCompetitiveSwimmers.add(new Member(getName(), getAge()));
        }
    }


    public void printList() throws IOException {
        log.writeLine("\n" + calender.formattedDate + " VIEWING MEMBER LIST");
        memberLists.printMenu();
        int chooseList = memberLists.readChoice();

        switch (chooseList) {
            case 1 -> {
                for (Member member : membersList.juniorSwimmers) {
                    System.out.println(member);
                }
                log.writeLine("\n" + calender.formattedDate + " VIEWING JUNIOR SWIMMERS");
            }
            case 2 -> {
                for (Member member : membersList.seniorSwimmers) {
                    System.out.println(member);
                }
                log.writeLine("\n" + calender.formattedDate + " VIEWING SENIOR SWIMMERS");
            }
            case 3 -> {
                for (Member member : membersList.adultSwimmers) {
                    System.out.println(member);
                }
                log.writeLine("\n" + calender.formattedDate + " VIEWING ADULT SWIMMERS");
            }
            case 4 -> {
                for (Member member : membersList.adultCompetitiveSwimmers) {
                    System.out.println(member);
                }
                log.writeLine("\n" + calender.formattedDate + " VIEWING ADULT COMPETITIVE SWIMMERS");
            }
            case 5 -> {
                for (Member member : membersList.juniorCompetitiveSwimmers) {
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
            case 1 -> passiveMembers(scanner, membersList.juniorSwimmers);

            case 2 -> passiveMembers(scanner, membersList.seniorSwimmers);

            case 3 -> passiveMembers(scanner, membersList.adultSwimmers);

            case 4 -> passiveMembers(scanner, membersList.adultCompetitiveSwimmers);

            case 5 -> passiveMembers(scanner, membersList.juniorCompetitiveSwimmers);

            default -> {
                System.out.println("Invalid input.");
                memberLists.readChoice();
            }
        }
        System.out.println("You have now added member to passive list.");
    }

    private void passiveMembers(Scanner scanner, ArrayList<Member> swimmer) {
        int id = 0;
        for (int i = 0; i < swimmer.size(); i++) {
            System.out.print(id + 1 + "# ");
            System.out.println(swimmer.get(i));
            id++;
        }
            System.out.println("Please select the index of which member to make passive.");
            int index = scanner.nextInt();
            membersList.passiveSwimmers.add(swimmer.get(index));
            swimmer.remove(index);


    }

    public void viewMembershipState() throws IOException {
        log.writeLine("\n" + calender.formattedDate + " VIEWING MEMBERSHIP STATE");
        memberPrices.printMenu();
        int chooseList = memberPrices.readChoice();

        switch (chooseList) {
            case 1 -> {
                for (Member member : membersList.juniorSwimmers) {
                    System.out.println(member + " Price: " + juniorPrice);
                    log.writeLine("\n" + calender.formattedDate + member + " Price: " + juniorPrice);
                }
            }
            case 2 -> {
                for (Member member : membersList.seniorSwimmers) {
                    System.out.println(member + " Price: " + seniorPrice);
                    log.writeLine("\n" + calender.formattedDate + member + " Price: " + seniorPrice);
                }
            }
            case 3 -> {
                for (Member member : membersList.adultSwimmers) {
                    System.out.println(member + " Price: " + adultPrice);
                    log.writeLine("\n" + calender.formattedDate + member + " Price: " + adultPrice);
                }
            }
            case 4 -> {
                for (Member member : membersList.passiveSwimmers) {
                    System.out.println(member + " Price: " + passivePrice);
                }
            }
            default -> {
                System.out.println("Invalid input.");
                memberLists.readChoice();
            }
        }
    }

    public void changeSwimResults() {
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
                newBestResult("adult");
            }
            case 2 -> {
                int i = 0;
                for (Member member : membersList.juniorCompetitiveSwimmers) {
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
            membersList.adultCompetitiveSwimmers.get(index - 1).setBestTime(newBestTime);
            System.out.println("Result has now been updated.");

        } else {
            membersList.juniorCompetitiveSwimmers.get(index - 1).setBestTime(newBestTime);
            System.out.println("Result has now been updated.");
        }
    }

    public void showTopFive() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Top 5 list over adult or junior");
        competitiveMemberList.printMenu();

    }

    public void chooseTopFive(String adultOrJunior) {
        for (int i = 0; i <membersList.adultCompetitiveSwimmers.size() ; i++) {
            membersList.adultCompetitiveSwimmers.get(i).getBestTime();
        }
    }

    @Override
    public String toString() {
        return " Member: " + "Name: " + name + " Age: " + age;
    }
}
