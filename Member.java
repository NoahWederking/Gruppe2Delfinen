import java.util.ArrayList;
import java.util.Scanner;

public class Member {

    // Lavet af Philip, Oliver og Noah

    //Attributes
    private int age;
    private String name;

    //Instances
    ArrayList<Member> competitiveTeamOverEighteen = new ArrayList<>();
    ArrayList<Member> competitiveTeamUnderEighteen = new ArrayList<>();
    ArrayList<Member> juniorSwimmers = new ArrayList<>();
    ArrayList<Member> seniorSwimmers = new ArrayList<>();
    ArrayList<Member> adultSwimmers = new ArrayList<>();
    ArrayList<Member> passiveSwimmers = new ArrayList<>();
    Menu memberLists = new Menu("MEMBER LISTS: ", "Please choose: ", new String[]{
            "1. Junior swimmers." + "\n" +
                    "2. Senior swimmers." + "\n" +
                    "3. Adult swimmers." + "\n" +
                    "4. Competitive swimmers over 18." + "\n" +
                    "5. Competitive swimmers under 18."});

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



    //Constructors
    public Member(String name, int age) {
        setName(name);
        setAge(age);
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
    }

    public void checkAge() {
        if (age < 18) {
            juniorSwimmers.add(new Member(getName(), getAge()));

        } else if (age > 60) {
            seniorSwimmers.add(new Member(getName(), getAge()));

        } else if (age > 18 && age < 60) {
            adultSwimmers.add(new Member(getName(), getAge()));
        }
    }
///slettes!!!!!!!!!!!!!!!!!!!!! TODO
   /* public void checkCompetitive() { //TODO FIX COMPETITIVE BUG
        Scanner scanner = new Scanner(System.in);
        System.out.println("Is member competitive? \n 1. Yes \n 2. No");
        String competitive = scanner.nextLine();

        if (competitive.equals("1")) {

            if (getAge() < 18) {
                competitiveTeamUnderEighteen.add(new Member(getName(), getAge()));

            } else if (getAge() > 18) {
                competitiveTeamOverEighteen.add(new Member(getName(), getAge()));

            }

        } else if (competitive.equals("2")) {


        } else {
            System.out.println("Invalid input");
        } //TODO Loop if invalid
    }*/

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

    public void membershipState() {
        Scanner scanner = new Scanner(System.in);
        memberLists.printMenu();
        int chooseList = memberLists.readChoice();

        switch (chooseList) {
            case 1 -> {
                passiveMembers(scanner, juniorSwimmers);
            }
            case 2 -> {
                passiveMembers(scanner, seniorSwimmers);
            }
            case 3 -> {
                passiveMembers(scanner, adultSwimmers);
            }
            case 4 -> {
                passiveMembers(scanner, competitiveTeamOverEighteen);
            }
            case 5 -> {
                passiveMembers(scanner, competitiveTeamUnderEighteen);
            }
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
            juniorSwimmers.remove(index);
            passiveSwimmers.add(juniorSwimmers.get(index));
        }
    }

    @Override
    public String toString() {
        return "Member: " + "\n" +
                " Name: " + name +
                " Age: " + age;
    }
}
