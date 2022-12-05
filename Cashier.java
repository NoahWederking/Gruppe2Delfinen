import java.io.IOException;

public class Cashier {

    //Attributes
    private boolean isRunning;
    private final int juniorPrice = 1000;
    private final int seniorPrice = 1200;
    private final int adultPrice = 1600;


    //Instances
    Menu memberPrices = new Menu("PRICE LISTS: ", "Please choose: ", new String[]{
            "1. Junior swimmers." + "\n" +
                    "2. Senior swimmers." + "\n" +
                    "3. Adult swimmers."});
    Menu cashierMenu = new Menu("====Cashier Menu====", "Please choose: ", new String[]
            {"1. View member state", "2. View missing payments", "9. To go back."});

    public Cashier() throws IOException {
    }

    //Methods
    public void cashierMenu(MembersList membersList, Calender calender, Log log) throws IOException {
        cashierMenu.printMenu();
        int choice = cashierMenu.readChoice();
        do {
            switch (choice) {
                case 1 -> viewMembershipState(membersList, log, calender);
                case 2 -> viewMissingPayments(membersList);
                case 9 -> {
                    System.out.println("Quit");
                    isRunning = false;
                }
                default -> System.out.println("Invalid input");
            }
        } while (isRunning);
    }

    public void viewMissingPayments(MembersList membersList) {
        for (Member member : membersList.membersInDebt) {
           if (member.getAge() < 18) {
               System.out.println(member.getName() + " DEBT: " + juniorPrice);

           } else if (member.getAge() > 18 && member.getAge() < 60) {
               System.out.println(member.getName() + " DEBT: " + adultPrice);

           } else if (member.getAge() > 60) {
               System.out.println(member.getName() + " DEBT: " + seniorPrice);
           }
        }
    }

    public void viewMembershipState(MembersList membersList, Log log, Calender calender) throws IOException {
        log.writeLine("\n" + calender.formattedDate + " VIEWING MEMBERSHIP STATE");
        memberPrices.printMenu();
        int chooseList = memberPrices.readChoice();

        switch (chooseList) {
            case 1 -> {
                for (Member member : membersList.juniorSwimmers) {
                    System.out.println(member + " Price: " + juniorPrice);
                    log.writeLine("\n" + calender.formattedDate + member + " Price: " + juniorPrice);
                }
            }
            case 2 -> {
                for (Member member : membersList.seniorSwimmers) {
                    System.out.println(member + " Price: " + seniorPrice);
                    log.writeLine("\n" + calender.formattedDate + member + " Price: " + seniorPrice);
                }
            }
            case 3 -> {
                for (Member member : membersList.adultSwimmers) {
                    System.out.println(member + " Price: " + adultPrice);
                    log.writeLine("\n" + calender.formattedDate + member + " Price: " + adultPrice);
                }
            }
            case 4 -> {
                for (Member member : membersList.passiveSwimmers) {
                    int passivePrice = 500;
                    System.out.println(member + " Price: " + passivePrice);
                }
            }
            default -> {
                System.out.println("Invalid input.");
                memberPrices.readChoice();
            }
        }
    }
}
