import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Chairman {

    //Attributes
    private boolean isRunning;

    //Instances
    Menu memberLists = new Menu("MEMBER LISTS: ", "Please choose: ", new String[]{
            "1. Junior swimmers.", "2. Senior swimmers.", "3. Adult swimmers.", "4. Competitive swimmers over 18.",
                    "5. Competitive swimmers under 18." , "6. Passive members"});
    Menu chairmanMenu = new Menu("====Chairman Menu====", "Please choose: ", new String[]
            {"1. Create new member", "2. View member list",
                    "3. Change membership status", "9. To go back"});

    public Chairman() {
    }

    //Methods
    public void chairmanMenu(Member member, MembersList membersList, Log log,Trainer trainer) throws IOException {
        do {
            chairmanMenu.printMenu();
            int choice = chairmanMenu.readChoice();

            switch (choice) {
                case 1 -> createMember(member, membersList, log);
                case 2 -> printList(membersList,trainer);
                case 3 -> makePassiveMember(membersList, trainer);
                case 9 -> isRunning = false;
                default -> System.out.println("Invalid input.");

            }
        } while (isRunning);
    }
    private void createMember(Member member, MembersList membersList, Log log) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert new member name: ");
        member.setName(scanner.nextLine());

        System.out.println("Please insert new member age: ");
        member.setAge(scanner.nextInt());
        //scanner.nextLine(); Scanner bug
        checkAge(member, membersList, log);
    }

    private void checkAge(Member member, MembersList membersList, Log log) throws IOException {
        if (member.getAge() < 18) {
            membersList.juniorSwimmers.add(new Member(member.getName(), member.getAge()));
            log.writeLine("\n" + member.getName()+ " " + member.getAge());

        } else if (member.getAge() > 60) {
            membersList.seniorSwimmers.add(new Member(member.getName(), member.getAge()));
            log.writeLine("\n" + member.getName()+ " " + member.getAge());

        } else if (member.getAge() > 18 && member.getAge() < 60) {
            membersList.adultSwimmers.add(new Member(member.getName(), member.getAge()));
            log.writeLine("\n" + member.getName()+ " " + member.getAge());
        }
    }

    private void printList(MembersList membersList, Trainer trainer) {
        memberLists.printMenu();
        int chooseList = memberLists.readChoice();

        switch (chooseList) {
            case 1 -> trainer.printMembers(membersList.juniorSwimmers,"");

            case 2 -> trainer.printMembers(membersList.seniorSwimmers,"");
            case 3 -> trainer.printMembers(membersList.adultSwimmers,"");

            case 4 -> trainer.printCompetitive(membersList.adultCompetitiveSwimmers,"");
            case 5 -> trainer.printCompetitive(membersList.juniorCompetitiveSwimmers,"");

            case 6 -> trainer.printMembers(membersList.passiveSwimmers,"");
                        default -> {
                System.out.println("Invalid input.");
                memberLists.readChoice();
            }
        }
    }

    private void makePassiveMember(MembersList membersList, Trainer trainer) {
        Scanner scanner = new Scanner(System.in);
        memberLists.printMenu();
        int chooseList = memberLists.readChoice();

        switch (chooseList) {
            case 1 -> passiveMembers(scanner, membersList.juniorSwimmers, membersList,trainer);

            case 2 -> passiveMembers(scanner, membersList.seniorSwimmers, membersList,trainer);

            case 3 -> passiveMembers(scanner, membersList.adultSwimmers, membersList,trainer);

            case 4 -> passiveCompetitiveMembers(scanner, membersList.adultCompetitiveSwimmers, membersList,trainer);

            case 5 -> passiveCompetitiveMembers(scanner, membersList.juniorCompetitiveSwimmers, membersList,trainer);

            default -> {
                System.out.println("Invalid input.");
                memberLists.readChoice();
            }
        }
        System.out.println("You have now added member to passive list.");
    }

    private void passiveMembers(Scanner scanner, ArrayList<Member> swimmer, MembersList membersList, Trainer trainer) {
        trainer.printMembers(swimmer,"");
        System.out.println("Please select the index of which member to make passive.");
        int index = scanner.nextInt();
        membersList.passiveSwimmers.add(swimmer.get(index));
        swimmer.remove(index);
    }
    private void passiveCompetitiveMembers(Scanner scanner, ArrayList<Member> swimmer, MembersList membersList, Trainer trainer) {
        trainer.printCompetitive(swimmer,"");
        System.out.println("Please select the index of which member to make passive.");
        int index = scanner.nextInt();
        membersList.passiveSwimmers.add(swimmer.get(index));
        swimmer.remove(index);
    }

}
