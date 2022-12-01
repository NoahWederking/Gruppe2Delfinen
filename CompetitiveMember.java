import java.util.ArrayList;
import java.util.Scanner;

public class CompetitiveMember {

    //Attributes-----------
    private String name;
    private int age;
    private String swimStyle;
    private double bestTime;
    private int latestPosition;

    //Instances
    ArrayList<CompetitiveMember> passiveCompetitiveMember = new ArrayList<>();
    ArrayList<CompetitiveMember> competitiveSwimmersUnder18 = new ArrayList<>();
    ArrayList<CompetitiveMember> competitiveSwimmersOver18 = new ArrayList<>();
    ArrayList<CompetitiveMember> crawl = new ArrayList<>();
    ArrayList<CompetitiveMember> breaststrokeSwimmers = new ArrayList<>();

    //Constructors
    public CompetitiveMember(String swimStyle, double bestTime, int latestPosition) {
        setSwimStyle(swimStyle);
        setBestTime(bestTime);
        setLatestPosition(latestPosition);
    }

    public CompetitiveMember() {

    }
    public CompetitiveMember(String name, int age){
        setName(name);
        setAge(age);
    }
    //SETTERS---------
    public void setSwimStyle(String swimStyle) {
        this.swimStyle = swimStyle;
    }

    public void setBestTime(double bestTime) {
        this.bestTime = bestTime;
    }

    public void setLatestPosition(int latestPosition) {
        this.latestPosition = latestPosition;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }

    //GETTERS----------
    public String getSwimStyle() {
        return swimStyle;
    }

    public double getBestTime() {
        return bestTime;
    }

    public int getLatestPosition() {
        return latestPosition;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

    //Methods
    public void printCompMem() {
        System.out.println(getSwimStyle());
        System.out.println(getBestTime());
        System.out.println(getLatestPosition());
    }

    void passiveCompetitiveMember(Scanner scanner, ArrayList<CompetitiveMember> competitiveMembers) {
        for (int i = 0; i < competitiveMembers.size(); i++) {
            System.out.println(competitiveMembers.get(i));
            System.out.println("Please select the index of which member to make passive.");
            int index = scanner.nextInt();
            passiveCompetitiveMember.add(competitiveMembers.get(index));
            competitiveMembers.remove(index);
        }
    }

    public void competitiveCreatMember() {

    }

    @Override
    public String toString() {
        return "CompetitiveMember{" +
                "swimStyle='" + swimStyle + '\'' +
                ", bestTime=" + bestTime +
                ", latestPosition=" + latestPosition +
                '}';
    }
}
