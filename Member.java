public class Member {

    //Attributes
    private int age;
    private String name;
    private String swimStyle;
    private double bestTime;
    private int latestPosition;


    //Constructor
    public Member() {
    }
    public Member(String name, int age) {
        setName(name);
        setAge(age);
    }

    public Member(String name, int age, String swimStyle, double bestTime, int latestPosition) {
        setName(name);
        setAge(age);
        setSwimStyle(swimStyle);
        setBestTime(bestTime);
        setLatestPosition(latestPosition);
    }

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
    public String getSwimStyle() {
        return swimStyle;
    }
    public int getLatestPosition() {
        return latestPosition;
    }

    public double getBestTime() {
        return bestTime;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

