import java.util.ArrayList;
import java.util.Scanner;

public class CompetitveMember extends Member {


    //Attributes-----------
    private String swimStyle;
    private double bestTime;
    private int latestPosition;
    private String name;
    private int age;

    ArrayList<CompetitveMember> competitiveSwimmersUnder18 = new ArrayList<>();
    ArrayList<CompetitveMember> competitiveSwimmersOver18 = new ArrayList<>();
    ArrayList<CompetitveMember> crawl = new ArrayList<>();
    ArrayList<CompetitveMember> breaststrokeSwimmers = new ArrayList<>();
    Member member = new Member();

    public CompetitveMember(String name, int age, String swimStyle, double bestTime, int latestPosition){
        super(name,age);
        setSwimStyle(swimStyle);
        setBestTime(bestTime);
        setLatestPosition(latestPosition);
    }
    public CompetitveMember() {

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

    @Override
    public void createMember() {
        super.createMember();
    }

    public void printCompMem(){
        System.out.println(getName());
        System.out.println(getAge());
        System.out.println(getSwimStyle());
        System.out.println(getBestTime());
        System.out.println(getLatestPosition());
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
