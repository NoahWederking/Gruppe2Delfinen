import java.util.ArrayList;
import java.util.Scanner;

public class CompetitveMember extends Member implements CreateMember{


    //Attributes-----------
    private String swimStyle;
    private double bestTime;
    private int latestPosition;
    //Instances

    ArrayList<CompetitveMember> competitiveSwimmersUnder18 = new ArrayList<>();
    ArrayList<CompetitveMember> competitiveSwimmersOver18 = new ArrayList<>();
    ArrayList<CompetitveMember> crawl = new ArrayList<>();
    ArrayList<CompetitveMember> breaststrokeSwimmers = new ArrayList<>();

    public CompetitveMember(String name, int age, String swimStyle, double bestTime, int latestPosition){
        super(name,age);
        setSwimStyle(swimStyle);
        setBestTime(bestTime);
        setLatestPosition(latestPosition);
    }




    //SETTERS---------
    public void setSwimStyle(String swimStyle){
        this.swimStyle = swimStyle;
    }
    public void setBestTime(double bestTime){
        this.bestTime = bestTime;
    }
    public void setLatestPosition(int latestPosition){
        this.latestPosition = latestPosition;
    }

    //GETTERS----------
    public String getSwimStyle(){
        return swimStyle;
    }
    public double getBestTime(){
        return bestTime;
    }
    public int getLatestPosition(){
        return latestPosition;
    }







    public void checkAge(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please insert new member name: ");
        String name = scanner.nextLine();
        setName(name);

        System.out.println("Please insert new member age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        setAge(age);

        System.out.println("Please select swimstyle");
        checkAge();
    }

    @Override
    public String toString() {
        return "CompetitveMember{" +
                "swimStyle='" + swimStyle + '\'' +
                ", bestTime=" + bestTime +
                ", latestPosition=" + latestPosition +
                '}';
    }
}
