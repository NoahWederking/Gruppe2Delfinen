import java.io.IOException;

public class Cashier {

    //Attributes
    private boolean isRunning;

    //Instances
    Menu memberPrices = new Menu("PRICE LISTS: ", "Please choose: ", new String[]{
            "1. Junior swimmers." + "\n" +
                    "2. Senior swimmers." + "\n" +
                    "3. Adult swimmers."});
    Menu cashierMenu = new Menu("====Cashier Menu====", "Please choose: ", new String[]
            {"1. View member state", "9. To go back."});
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
                case 9 -> {
                    System.out.println("Quit");
                    isRunning = false;
                }
                default -> System.out.println("Invalid input");
            }
        } while (isRunning);
    }
    public void viewMembershipState() throws IOException {
        log.writeLine("\n" + calender.formattedDate + " VIEWING MEMBERSHIP STATE");
        memberPrices.printMenu();
        int chooseList = memberPrices.readChoice();

        switch (chooseList) {
            case 1 -> {
                for (Member member : MembersList.juniorSwimmers) {
                    int juniorPrice = 1000;
                    System.out.println(member + " Price: " + juniorPrice);
                    log.writeLine("\n" + calender.formattedDate + member + " Price: " + juniorPrice);
                }
            }
            case 2 -> {
                for (Member member : MembersList.seniorSwimmers) {
                    int seniorPrice = 1200;
                    System.out.println(member + " Price: " + seniorPrice);
                    log.writeLine("\n" + calender.formattedDate + member + " Price: " + seniorPrice);
                }
            }
            case 3 -> {
                for (Member member : MembersList.adultSwimmers) {
                    int adultPrice = 1600;
                    System.out.println(member + " Price: " + adultPrice);
                    log.writeLine("\n" + calender.formattedDate + member + " Price: " + adultPrice);
                }
            }
            case 4 -> {
                for (Member member : MembersList.passiveSwimmers) {
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
