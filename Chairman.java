import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Chairman {

    //Attributes
    private boolean isRunning;
    private String name;
    private int age;

    //Instances
    Menu memberLists = new Menu("MEMBER LISTS: ", "Please choose: ", new String[]{
            "1. Junior swimmers." + "\n" +
                    "2. Senior swimmers." + "\n" +
                    "3. Adult swimmers." + "\n" +
                    "4. Competitive swimmers over 18." + "\n" +
                    "5. Competitive swimmers under 18."});
    Menu chairmanMenu = new Menu("====Chairman Menu====", "Please choose: ", new String[]
            {"1. Create new member", "2. View member list",
                    "3. Change membership status", "9. To go back"});
    Log log = new Log();
    Calender calender = new Calender();

    public Chairman() throws IOException {
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //Methods
    public void chairmanMenu(Member member) throws IOException {
        do {
            chairmanMenu.printMenu();
            int choice = chairmanMenu.readChoice();

            switch (choice) {
                case 1 -> createMember(member);
                case 2 -> printList();
                case 3 -> makePassiveMember();
                case 9 -> isRunning = false;
                default -> System.out.println("Invalid input.");

            }
        } while (isRunning);
    }
    private void createMember(Member member) throws IOException {
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
        checkAge(member);
    }

    private void checkAge(Member member) {
        if (age < 18) {
            MembersList.juniorSwimmers.add(new Member(member.getName(), member.getAge()));

        } else if (age > 60) {
            MembersList.seniorSwimmers.add(new Member(member.getName(), member.getAge()));

        } else if (age > 18 && age < 60) {
            MembersList.adultSwimmers.add(new Member(member.getName(), member.getAge()));
        }
    }

    private void printList() throws IOException {
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

    private void makePassiveMember() throws IOException {
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
    @Override
    public String toString() {
        return " Member: " + "Name: " + name + " Age: " + age;
    }
}
