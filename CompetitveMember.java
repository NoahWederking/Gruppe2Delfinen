import java.util.ArrayList;

public class CompetitveMember extends Member{


    //Attributes-----------
    private String swimStyle;
    private double bestTime;
    private int latestPosition;

    ArrayList<CompetitveMember> crawlSwimmers = new ArrayList<>();
    ArrayList<CompetitveMember> breaststrokeSwimmers = new ArrayList<>();

    public CompetitveMember(String swimStyle, double bestTime, int latestPosition){
        super();
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

}
