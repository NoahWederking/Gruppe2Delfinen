import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Chairman {

    //Attributes
    private boolean isRunning;

    //Instances
    Menu memberLists = new Menu("MEMBER LISTS: ", "Please choose: ", new String[]{
            "1. Junior swimmers." + "\n" +
                    "2. Senior swimmers." + "\n" +
                    "3. Adult swimmers." + "\n" +
                    "4. Competitive swimmers over 18." + "\n" +
                    "5. Competitive swimmers under 18."});
    Menu chairmanMenu = new Menu("====Chairman Menu====", "Please choose: ", new String[]
            {"1. Create new member", "2. View member list",
                    "3. Change membership status", "9. To go back"});

    public Chairman() {
    }

    //Methods
    public void chairmanMenu(Member member, MembersList membersList, Log log) throws IOException {
        do {
            chairmanMenu.printMenu();
            int choice = chairmanMenu.readChoice();

            switch (choice) {
                case 1 -> createMember(member, membersList, log);
                case 2 -> printList(membersList);
                case 3 -> makePassiveMember(membersList);
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

    private void printList(MembersList membersList) {
        memberLists.printMenu();
        int chooseList = memberLists.readChoice();

        switch (chooseList) {
            case 1 -> {
                for (Member member : membersList.juniorSwimmers) {
                    System.out.println(member);
                }
            }
            case 2 -> {
                for (Member member : membersList.seniorSwimmers) {
                    System.out.println(member);
                }
            }
            case 3 -> {
                for (Member member : membersList.adultSwimmers) {
                    System.out.println(member);
                }
            }
            case 4 -> {
                for (Member member : membersList.adultCompetitiveSwimmers) {
                    System.out.println(member);
                }
            }
            case 5 -> {
                for (Member member : membersList.juniorCompetitiveSwimmers) {
                    System.out.println(member);
                }
            }
            default -> {
                System.out.println("Invalid input.");
                memberLists.readChoice();
            }
        }
    }

    private void makePassiveMember(MembersList membersList) {
        Scanner scanner = new Scanner(System.in);
        memberLists.printMenu();
        int chooseList = memberLists.readChoice();

        switch (chooseList) {
            case 1 -> passiveMembers(scanner, membersList.juniorSwimmers, membersList);

            case 2 -> passiveMembers(scanner, membersList.seniorSwimmers, membersList);

            case 3 -> passiveMembers(scanner, membersList.adultSwimmers, membersList);

            case 4 -> passiveMembers(scanner, membersList.adultCompetitiveSwimmers, membersList);

            case 5 -> passiveMembers(scanner, membersList.juniorCompetitiveSwimmers, membersList);

            default -> {
                System.out.println("Invalid input.");
                memberLists.readChoice();
            }
        }
        System.out.println("You have now added member to passive list.");
    }

    private void passiveMembers(Scanner scanner, ArrayList<Member> swimmer, MembersList membersList) {
        int id = 0;
        for (Member member : swimmer) {
            System.out.print(id + 1 + "# ");
            System.out.println(member);
            id++;
        }
        System.out.println("Please select the index of which member to make passive.");
        int index = scanner.nextInt();
        membersList.passiveSwimmers.add(swimmer.get(index - 1));
        swimmer.remove(index - 1);
    }

}
