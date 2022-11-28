public class Member {


    //Attributes
    private String juniorSwimmer;
    private String seniorSwimmer;
    private boolean isCompetitive;
    private String adultSwimmers; // between 18-60 years.


    //Setters

    public void setJuniorSwimmer(String juniorSwimmer){
        this.juniorSwimmer = juniorSwimmer;
    }

    public void setSeniorSwimmer(String seniorSwimmer){
        this.seniorSwimmer = seniorSwimmer;
    }

    public void isCompetitive(boolean isCompetitive){
        this.isCompetitive = isCompetitive;
    }

    public void setAdultSwimmers(String adultSwimmers){
        this.adultSwimmers = adultSwimmers;
    }


    //Getters
    public String getJuniorSwimmer(){
        return juniorSwimmer;
    }

    public String getSeniorSwimmer(){
        return seniorSwimmer;
    }

    public String getAdultSwimmers(){
        return adultSwimmers;
    }

    public boolean isCompetitive() {
        return isCompetitive;
    }

}
