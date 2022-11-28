import java.util.ArrayList;
import java.util.Scanner;

public class Member {

    //Attributes
    private int age;
    private String name;
    private boolean isCompetitive;
    private String[] menuItems = new String[]{
            "1. Junior swimmers. \n" +
                    "2. Senior swimmers. \n" +
                    "3. Adult swimmers. \n" +
                    "4. Competitive swimmers over 18. \n" +
                    "5. Competitive swimmers under 18."};

    //Instances
    ArrayList<Member> competitiveTeamOverEighteen = new ArrayList<>();
    ArrayList<Member> competitiveTeamUnderEighteen = new ArrayList<>();
    ArrayList<Member> juniorSwimmers = new ArrayList<>();
    ArrayList<Member> seniorSwimmers = new ArrayList<>();
    ArrayList<Member> adultSwimmers = new ArrayList<>();

    Menu memberLists = new Menu("MEMBER LISTS: ", "Please choose: ", menuItems);

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void isCompetitive(boolean isCompetitive) {
        this.isCompetitive = isCompetitive;
    }


    //Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isCompetitive() {
        return isCompetitive;
    }

    //Constructors
    public Member(String name, int age, boolean isCompetitive) {
        setName(name);
        setAge(age);
        isCompetitive(isCompetitive);
    }

    public Member() {

    }

    //Methods
    public void createMember() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please insert new member name: ");
        name = scanner.nextLine();
        setName(name);

        System.out.println("Please insert new member age: ");
        age = scanner.nextInt();
        scanner.nextLine();
        setAge(age);

        checkAge();
        checkCompetitive();
    }

    public void checkAge() {
        if (getAge() < 18) {
            juniorSwimmers.add(new Member(getName(), getAge(), isCompetitive()));

        } else if (getAge() > 60) {
            seniorSwimmers.add(new Member(getName(), getAge(), isCompetitive()));

        } else if (getAge() > 18 && getAge() < 60) {
            adultSwimmers.add(new Member(getName(), getAge(), isCompetitive()));
        }
    }

    public void checkCompetitive() { //TODO FIX COMPETITIVE BUG
        Scanner scanner = new Scanner(System.in);
        System.out.println("Is member competitive? \n 1. Yes \n 2. No");
        String competitive = scanner.nextLine();
        if (competitive.equals("1")) {
            isCompetitive(true);
            if (getAge() < 18) {
                competitiveTeamUnderEighteen.add(new Member(getName(), getAge(), isCompetitive()));

            } else if (getAge() > 18) {
                competitiveTeamOverEighteen.add(new Member(getName(), getAge(), isCompetitive()));

            }

        } else if (competitive.equals("2")) {
            isCompetitive(false);

        } else {
            System.out.println("Invalid input");
        } //TODO Loop if invalid
    }

    public void printList() {
        memberLists.printMenu();
        int chooseList = memberLists.readChoice();

        switch (chooseList) {
            case 1 -> {
                for (Member member : juniorSwimmers) {
                    System.out.println(member);
                }
            }
            case 2 -> {
                for (Member member : seniorSwimmers) {
                    System.out.println(member);
                }
            }
            case 3 -> {
                for (Member member : adultSwimmers) {
                    System.out.println(member);
                }
            }
            case 4 -> {
                for (Member member : competitiveTeamOverEighteen) {
                    System.out.println(member);
                }
            }
            case 5 -> {
                for (Member member : competitiveTeamUnderEighteen) {
                    System.out.println(member);
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
        return "Member: " + "\n" +
                " Name: " + name +
                " Age: " + age +
                " isCompetitive: " + isCompetitive;
    }
}
