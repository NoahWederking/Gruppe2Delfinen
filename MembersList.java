import java.util.ArrayList;

public class MembersList {

    public static void initialize() {
        MembersList.juniorMembers();
        MembersList.adultMembers();
        MembersList.seniorMembers();
        MembersList.passiveMembers();
        MembersList.competitiveJuniorMembers();
        MembersList.competitiveAdultMembers();
        MembersList.allMembersInDebt();
    }

    public static ArrayList<Member> juniorSwimmers = new ArrayList<>();
    public static ArrayList<Member> seniorSwimmers = new ArrayList<>();
    public static ArrayList<Member> adultSwimmers = new ArrayList<>();
    public static ArrayList<Member> passiveSwimmers = new ArrayList<>();
    public static ArrayList<Member> juniorCompetitiveSwimmers = new ArrayList<>();
    public static ArrayList<Member> adultCompetitiveSwimmers = new ArrayList<>();
    public static ArrayList<Member> membersInDebt = new ArrayList<>();

    public static void juniorMembers() {
        MembersList.juniorSwimmers.add(new Member("Hans", 12));
        MembersList.juniorSwimmers.add(new Member("Lisa", 14));
        MembersList.juniorSwimmers.add(new Member("Emil", 15));
        MembersList.juniorSwimmers.add(new Member("Emma", 10));
        MembersList.juniorSwimmers.add(new Member("Victor", 16));
    }

    public static void seniorMembers() {
        MembersList.seniorSwimmers.add(new Member("Ole", 66));
        MembersList.seniorSwimmers.add(new Member("Morten", 75));
        MembersList.seniorSwimmers.add(new Member("Stanley", 60));
        MembersList.seniorSwimmers.add(new Member("Yvonne", 63));
        MembersList.seniorSwimmers.add(new Member("Ruth", 77));
    }

    public static void adultMembers() {
        MembersList.adultSwimmers.add(new Member("Anders", 25));
        MembersList.adultSwimmers.add(new Member("Kristine", 30));
        MembersList.adultSwimmers.add(new Member("Johanne", 32));
        MembersList.adultSwimmers.add(new Member("Mikkel", 42));
        MembersList.adultSwimmers.add(new Member("Thomas", 55));
    }

    public static void passiveMembers() {
        MembersList.passiveSwimmers.add(new Member("Kristian", 25));
        MembersList.passiveSwimmers.add(new Member("Nicklas", 20));
        MembersList.passiveSwimmers.add(new Member("Nicolas", 32));
        MembersList.passiveSwimmers.add(new Member("Frederik", 36));
        MembersList.passiveSwimmers.add(new Member("Signe", 41));
    }

    public static void competitiveJuniorMembers() {
        MembersList.juniorCompetitiveSwimmers.add(new Member("Johan", 15, "Breast Stroke", 12.0, 3));
        MembersList.juniorCompetitiveSwimmers.add(new Member("Jonas", 17, "Crawl", 11.4, 4));
        MembersList.juniorCompetitiveSwimmers.add(new Member("Emil", 18, "Breast Stroke", 10.6, 2));
        MembersList.juniorCompetitiveSwimmers.add(new Member("Trine", 16, "Butterfly", 10.4, 1));
        MembersList.juniorCompetitiveSwimmers.add(new Member("Anna", 16, "Crawl", 10.3, 1));
    }

    public static void competitiveAdultMembers() {
        MembersList.adultCompetitiveSwimmers.add(new Member("Rasmus", 25, "Crawl", 9.9, 1));
        MembersList.adultCompetitiveSwimmers.add(new Member("Christopher", 21, "Breast Stroke", 10.4, 2));
        MembersList.adultCompetitiveSwimmers.add(new Member("Jake", 23, "Butterfly", 11.5, 5));
        MembersList.adultCompetitiveSwimmers.add(new Member("Isabella", 28, "Butterfly", 9.8, 1));
        MembersList.adultCompetitiveSwimmers.add(new Member("Merle", 30, "Crawl", 10.6, 4));
    }
    public static void allMembersInDebt() {
        MembersList.membersInDebt.add(MembersList.juniorSwimmers.get(1));
        MembersList.membersInDebt.add(MembersList.seniorSwimmers.get(2));
        MembersList.membersInDebt.add(MembersList.adultSwimmers.get(3));
        MembersList.membersInDebt.add(MembersList.adultCompetitiveSwimmers.get(0));
        MembersList.membersInDebt.add(MembersList.juniorCompetitiveSwimmers.get(1));
    }
}

