import java.io.IOException;
import java.util.ArrayList;

public class MembersList {

    public void initialize() throws IOException {
        juniorMembers();
        adultMembers();
        seniorMembers();
        passiveMembers();
        competitiveJuniorMembers();
        competitiveAdultMembers();
        allMembersInDebt();
    }

    public ArrayList<Member> juniorSwimmers = new ArrayList<>();
    public ArrayList<Member> seniorSwimmers = new ArrayList<>();
    public ArrayList<Member> adultSwimmers = new ArrayList<>();
    public ArrayList<Member> passiveSwimmers = new ArrayList<>();
    public ArrayList<Member> juniorCompetitiveSwimmers = new ArrayList<>();
    public ArrayList<Member> adultCompetitiveSwimmers = new ArrayList<>();
    public ArrayList<Member> membersInDebt = new ArrayList<>();

    public void juniorMembers() throws IOException {
        juniorSwimmers.add(new Member("Hans", 12));
        juniorSwimmers.add(new Member("Lisa", 14));
        juniorSwimmers.add(new Member("Emil", 15));
        juniorSwimmers.add(new Member("Emma", 10));
        juniorSwimmers.add(new Member("Victor", 16));
    }

    public void seniorMembers() throws IOException {
        seniorSwimmers.add(new Member("Ole", 66));
        seniorSwimmers.add(new Member("Morten", 75));
        seniorSwimmers.add(new Member("Stanley", 60));
        seniorSwimmers.add(new Member("Yvonne", 63));
        seniorSwimmers.add(new Member("Ruth", 77));
    }

    public void adultMembers() throws IOException {
        adultSwimmers.add(new Member("Anders", 25));
        adultSwimmers.add(new Member("Kristine", 30));
        adultSwimmers.add(new Member("Johanne", 32));
        adultSwimmers.add(new Member("Mikkel", 42));
        adultSwimmers.add(new Member("Thomas", 55));
    }

    public void passiveMembers() throws IOException {
        passiveSwimmers.add(new Member("Kristian", 25));
        passiveSwimmers.add(new Member("Nicklas", 20));
        passiveSwimmers.add(new Member("Nicolas", 32));
        passiveSwimmers.add(new Member("Frederik", 36));
        passiveSwimmers.add(new Member("Signe", 41));
    }

    public void competitiveJuniorMembers() throws IOException {
        juniorCompetitiveSwimmers.add(new Member("Johan", 15, "Breast Stroke", 12.0, 3));
        juniorCompetitiveSwimmers.add(new Member("Jonas", 17, "Crawl", 11.4, 4));
        juniorCompetitiveSwimmers.add(new Member("Emil", 18, "Breast Stroke", 10.6, 2));
        juniorCompetitiveSwimmers.add(new Member("Trine", 16, "Butterfly", 10.4, 1));
        juniorCompetitiveSwimmers.add(new Member("Anna", 16, "Crawl", 10.3, 1));
    }

    public void competitiveAdultMembers() {
        adultCompetitiveSwimmers.add(new Member("Rasmus", 25, "Crawl", 9.9, 1));
        adultCompetitiveSwimmers.add(new Member("Christopher", 21, "Breast Stroke", 10.4, 2));
        adultCompetitiveSwimmers.add(new Member("Jake", 23, "Butterfly", 11.5, 5));
        adultCompetitiveSwimmers.add(new Member("Isabella", 28, "Butterfly", 9.8, 1));
        adultCompetitiveSwimmers.add(new Member("Merle", 30, "Crawl", 10.6, 4));
    }
    public void allMembersInDebt() {
        membersInDebt.add(juniorSwimmers.get(1));
        membersInDebt.add(seniorSwimmers.get(2));
        membersInDebt.add(adultSwimmers.get(3));
        membersInDebt.add(adultCompetitiveSwimmers.get(0));
        membersInDebt.add(juniorCompetitiveSwimmers.get(1));
    }
}

