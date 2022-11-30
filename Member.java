import java.util.ArrayList;
import java.util.Scanner;

public class Member {

    //Attributes
    private int age;
    private String name;

    //Constructors
    public Member(String name, int age) {
        setName(name);
        setAge(age);
    }

    public Member() {

    }

    //Instances
  /*  CompetitveMember competitveMember = new CompetitveMember();*/
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

    Menu memberPrices = new Menu("PRICE LISTS: ", "Please choose: ", new String[]{
            "1. Junior swimmers." + "\n" +
                    "2. Senior swimmers." + "\n" +
                    "3. Adult swimmers."});

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
               /* for (Member member : competitveMember.competitiveSwimmersOver18) {
                    System.out.println(member);
                }*/
            }
            case 5 -> {
               /* for (Member member : competitveMember.competitiveSwimmersUnder18) {
                    System.out.println(member);
                }*/
            }
            default -> {
                System.out.println("Invalid input.");
                memberLists.readChoice();
            }
        }
    }

    public void makePassiveMember() {
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
              /*  passiveCompetetiveMember(scanner, competitveMember.competitiveSwimmersOver18);*/
            }
            case 5 -> {
                /*passiveCompetetiveMember(scanner, competitveMember.competitiveSwimmersUnder18);*/
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
            passiveSwimmers.add(juniorSwimmers.get(index));
            juniorSwimmers.remove(index);

        }
    }

    private void passiveCompetetiveMember(Scanner scanner, ArrayList<CompetitveMember> swimmers) {
        for (int i = 0; i < swimmers.size(); i++) {
            System.out.println(swimmers.get(i));
            System.out.println("Please select the index of which member to make passive.");
            int index = scanner.nextInt();
            swimmers.remove(index);
            passiveSwimmers.add(swimmers.get(index));
        }
    }

    public void viewMembershipState() {
        memberPrices.printMenu();
        int chooseList = memberPrices.readChoice();

        switch (chooseList) {
            case 1 -> {
                for (Member member : juniorSwimmers) {
                    System.out.println(member + " Price: 500 DKK.");
                }
            }
            case 2 -> {
                for (Member member : seniorSwimmers) {
                    System.out.println(member + " Price: 1200 DKK.");
                }
            }
            case 3 -> {
                for (Member member : adultSwimmers) {
                    System.out.println(member + " Price: 1600 DKK.");
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
                " Age: " + age;
    }
}
