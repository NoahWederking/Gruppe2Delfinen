import java.io.IOException;

public class Cashier {

    //Attributes
    private boolean isRunning;
    private int juniorPrice = 1000;
    private int seniorPrice = 1200;
    private int adultPrice = 1600;
    private int passivePrice = 500;


    //Instances
    Menu memberPrices = new Menu("PRICE LISTS: ", "Please choose: ", new String[]{
            "1. Junior swimmers." + "\n" +
                    "2. Senior swimmers." + "\n" +
                    "3. Adult swimmers."});
    Menu cashierMenu = new Menu("====Cashier Menu====", "Please choose: ", new String[]
            {"1. View member state", "2. View missing payments", "9. To go back."});
    Calender calender = new Calender();
    Log log = new Log();

    public Cashier() throws IOException {
    }

    //Methods
    public void cashierMenu() throws IOException {
        cashierMenu.printMenu();
        int choice = cashierMenu.readChoice();
        do {
            switch (choice) {
                case 1 -> viewMembershipState();
                case 2 -> viewMissingPayments();
                case 9 -> {
                    System.out.println("Quit");
                    isRunning = false;
                }
                default -> System.out.println("Invalid input");
            }
        } while (isRunning);
    }

    public void viewMissingPayments() {
        for (Member member : MembersList.membersInDebt) {
           if (member.getAge() < 18) {
               System.out.println(member.getName() + " DEBT: " + juniorPrice);

           } else if (member.getAge() > 18 && member.getAge() < 60) {
               System.out.println(member.getName() + " DEBT: " + adultPrice);

           } else if (member.getAge() > 60) {
               System.out.println(member.getName() + " DEBT: " + seniorPrice);
           }
        }
    }

    public void viewMembershipState() throws IOException {
        log.writeLine("\n" + calender.formattedDate + " VIEWING MEMBERSHIP STATE");
        memberPrices.printMenu();
        int chooseList = memberPrices.readChoice();

        switch (chooseList) {
            case 1 -> {
                for (Member member : MembersList.juniorSwimmers) {
                    System.out.println(member + " Price: " + juniorPrice);
                    log.writeLine("\n" + calender.formattedDate + member + " Price: " + juniorPrice);
                }
            }
            case 2 -> {
                for (Member member : MembersList.seniorSwimmers) {
                    System.out.println(member + " Price: " + seniorPrice);
                    log.writeLine("\n" + calender.formattedDate + member + " Price: " + seniorPrice);
                }
            }
            case 3 -> {
                for (Member member : MembersList.adultSwimmers) {
                    System.out.println(member + " Price: " + adultPrice);
                    log.writeLine("\n" + calender.formattedDate + member + " Price: " + adultPrice);
                }
            }
            case 4 -> {
                for (Member member : MembersList.passiveSwimmers) {
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
