import java.io.IOException;

public class Member {

    //Attributes
    private int age;
    private String name;
    private String swimStyle;
    private double bestTime;
    private int latestPosition;
    private Log log;

    //Constructors
    /*public Member(Trainer trainer) throws IOException {
        this.trainer = trainer;
    }*/
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
    /*Calender calender = new Calender();
    Trainer trainer = new Trainer();*/

   /* Menu memberLists = new Menu("MEMBER LISTS: ", "Please choose: ", new String[]{
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
            "1, Competitive members over 18." + "\n" + "2. Competitive members under 18"});*/

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
    /*public void createMember() throws IOException {
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
        checkAge();
    }

    public void createCompetitiveMember() throws IOException {
        log.writeLine("\n" + calender.formattedDate + " CREATING COMPETITIVE MEMBER");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select a member to make competitive: ");
        scanner.nextLine();

        name = getName();
        age = getAge();

        System.out.println("Please enter swim style");
        trainer.swimDisciplinesMenu.printMenu();
        trainer.swimDisciplinesMenu.readChoice();

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
            MembersList.juniorSwimmers.add(new Member(getName(), getAge()));

        } else if (age > 60) {
            MembersList.seniorSwimmers.add(new Member(getName(), getAge()));

        } else if (age > 18 && age < 60) {
            MembersList.adultSwimmers.add(new Member(getName(), getAge()));
        }
    }

    public void printList() throws IOException {
        log.writeLine("\n" + calender.formattedDate + " VIEWING MEMBER LIST");
        memberLists.printMenu();
        int chooseList = memberLists.readChoice();

        switch (chooseList) {
            case 1 -> {
                for (Member member : MembersList.juniorSwimmers) {
                    System.out.println(member);
                }
                log.writeLine("\n" + calender.formattedDate + " VIEWING JUNIOR SWIMMERS");
            }
            case 2 -> {
                for (Member member : MembersList.seniorSwimmers) {
                    System.out.println(member);
                }
                log.writeLine("\n" + calender.formattedDate + " VIEWING SENIOR SWIMMERS");
            }
            case 3 -> {
                for (Member member : MembersList.adultSwimmers) {
                    System.out.println(member);
                }
                log.writeLine("\n" + calender.formattedDate + " VIEWING ADULT SWIMMERS");
            }
            case 4 -> {
                for (Member member : MembersList.adultCompetitiveSwimmers) {
                    System.out.println(member);
                }
                log.writeLine("\n" + calender.formattedDate + " VIEWING ADULT COMPETITIVE SWIMMERS");
            }
            case 5 -> {
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

    public void makePassiveMember() throws IOException {
        log.writeLine("\n" + calender.formattedDate + " MAKING A MEMBER PASSIVE");
        Scanner scanner = new Scanner(System.in);
        memberLists.printMenu();
        int chooseList = memberLists.readChoice();

        switch (chooseList) {
            case 1 -> passiveMembers(scanner, MembersList.juniorSwimmers);

            case 2 -> passiveMembers(scanner, MembersList.seniorSwimmers);

            case 3 -> passiveMembers(scanner, MembersList.adultSwimmers);

            case 4 -> passiveMembers(scanner, MembersList.adultCompetitiveSwimmers);

            case 5 -> passiveMembers(scanner, MembersList.juniorCompetitiveSwimmers);

            default -> {
                System.out.println("Invalid input.");
                memberLists.readChoice();
            }
        }
        System.out.println("You have now added member to passive list.");
    }

    private void passiveMembers(Scanner scanner, ArrayList<Member> swimmer) {
        int id = 0;
        for (Member member : swimmer) {
            System.out.print(id + 1 + "# ");
            System.out.println(member);
            id++;
        }
            System.out.println("Please select the index of which member to make passive.");
            int index = scanner.nextInt();
        MembersList.passiveSwimmers.add(swimmer.get(index - 1));
            swimmer.remove(index - 1);


    }

    public void viewMembershipState() throws IOException {
        log.writeLine("\n" + calender.formattedDate + " VIEWING MEMBERSHIP STATE");
        memberPrices.printMenu();
        int chooseList = memberPrices.readChoice();

        switch (chooseList) {
            case 1 -> {
                for (Member member : MembersList.juniorSwimmers) {
                    int juniorPrice = 1000;
                    System.out.println(member + " Price: " + juniorPrice);
                    log.writeLine("\n" + calender.formattedDate + member + " Price: " + juniorPrice);
                }
            }
            case 2 -> {
                for (Member member : MembersList.seniorSwimmers) {
                    int seniorPrice = 1200;
                    System.out.println(member + " Price: " + seniorPrice);
                    log.writeLine("\n" + calender.formattedDate + member + " Price: " + seniorPrice);
                }
            }
            case 3 -> {
                for (Member member : MembersList.adultSwimmers) {
                    int adultPrice = 1600;
                    System.out.println(member + " Price: " + adultPrice);
                    log.writeLine("\n" + calender.formattedDate + member + " Price: " + adultPrice);
                }
            }
            case 4 -> {
                for (Member member : MembersList.passiveSwimmers) {
                    int passivePrice = 500;
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

    public void showTopFive() {
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

    public void chooseTopFive(ArrayList<Member> swimmer) {
        int id = 0;
        for (Member member : swimmer) {
            System.out.print(id + 1 + "# ");
            System.out.println(member.getBestTime());
            id++;
        }
    }
*/
    @Override
    public String toString() {
        return " Member: " + "Name: " + name + " Age: " + age;
    }
}
