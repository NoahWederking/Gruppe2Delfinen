import java.util.ArrayList;
import java.util.Scanner;

public class Member {

    //Attributes
    private int age;
    private String name;
    private String juniorSwimmer;
    private String seniorSwimmer;
    private boolean isCompetitive;
    private String adultSwimmer; // between 18-60 years.

    //Create member attributes
    private String memberName;
    private int memberAge;
    private String memberCompetitive;

    //Instances
    ArrayList<Member> competitiveTeamOverEighteen = new ArrayList<>();
    ArrayList<Member> competitiveTeamUnderEighteen = new ArrayList<>();
    ArrayList<Member> juniorSwimmers = new ArrayList<>();
    ArrayList<Member> seniorSwimmers = new ArrayList<>();
    ArrayList<Member> adultSwimmers = new ArrayList<>();

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setJuniorSwimmer(String juniorSwimmer) {
        this.juniorSwimmer = juniorSwimmer;
    }

    public void setSeniorSwimmer(String seniorSwimmer) {
        this.seniorSwimmer = seniorSwimmer;
    }

    public void isCompetitive(boolean isCompetitive) {
        this.isCompetitive = isCompetitive;
    }

    public void setAdultSwimmer(String adultSwimmer) {
        this.adultSwimmer = adultSwimmer;
    }


    //Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getJuniorSwimmer() {
        return juniorSwimmer;
    }

    public String getSeniorSwimmer() {
        return seniorSwimmer;
    }

    public String getAdultSwimmer() {
        return adultSwimmer;
    }

    public boolean isCompetitive() {
        return isCompetitive;
    }

    //Constructor
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
        memberName = scanner.nextLine();
        setName(memberName);

        System.out.println("Please insert new member age: ");
        memberAge = scanner.nextInt();
        scanner.nextLine();
        setAge(memberAge);
        checkAge();

        checkCompetitive();
    }

    public void checkAge() {
        if (getAge() < 18) {
            setJuniorSwimmer(memberName);

        } else if (getAge() > 60) {
            setSeniorSwimmer(memberName);

        } else if (getAge() > 18 && getAge() < 60) {
            setAdultSwimmer(memberName);
        }
    }

    public void checkCompetitive() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Is member competitive? \n 1. Yes \n 2. No");
        memberCompetitive = scanner.nextLine();
        if (memberCompetitive.equals("1")) {
            isCompetitive(true);
            if (getAge() < 18) {
                competitiveTeamUnderEighteen.add(new Member(getName(), getAge(), isCompetitive()));
            }

        } else if (memberCompetitive.equals("2")) {
            isCompetitive(false);
            if (getAge() > 18) {
                competitiveTeamOverEighteen.add(new Member(getName(), getAge(), isCompetitive()));
            }

        } else {
            System.out.println("Invalid input");
        } //TODO Loop hvis input er invalid
    }

    public void printList() {
        System.out.println(competitiveTeamOverEighteen);
        System.out.println(competitiveTeamUnderEighteen);
    }

    @Override
    public String toString() {
        return "Member: " +
                "Name: " + name +
                "Age: " + age  +
                "isCompetitive: " + isCompetitive;
    }
}
