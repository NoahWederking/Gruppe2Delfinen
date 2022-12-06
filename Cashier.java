public class Cashier {

    //Attributes
    private boolean isRunning;
    private final int juniorPrice = 1000;
    private final int seniorPrice = 1200;
    private final int adultPrice = 1600;


    //Instances
    Menu memberMenu = new Menu("PRICE LISTS: ", "Please choose: ", new String[]{
            "1. Junior swimmers." + "\n" +
                    "2. Senior swimmers." + "\n" +
                    "3. Adult swimmers."});
    Menu cashierMenu = new Menu("====Cashier Menu====", "Please choose: ", new String[]
            {"1. View member state", "2. View missing payments", "9. To go back."});

    public Cashier() {
    }

    //Methods
    public void cashierMenu(MembersList membersList, Trainer trainer) {
        cashierMenu.printMenu();
        int choice = cashierMenu.readChoice();
        do {
            switch (choice) {
                case 1 -> viewMembershipState(membersList, trainer);
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
               System.out.println(member.getName() + " " + member.getAge() + " DEBT: " + juniorPrice + " DKK");

           } else if (member.getAge() > 18 && member.getAge() < 60) {
               System.out.println(member.getName() + " " + member.getAge() + " DEBT: " + adultPrice + " DKK");

           } else if (member.getAge() > 60) {
               System.out.println(member.getName() + " " + member.getAge() + " DEBT: " + seniorPrice + " DKK");
           }
        }
    }

    public void viewMembershipState(MembersList membersList, Trainer trainer) {
        memberMenu.printMenu();
        int chooseList = memberMenu.readChoice();

        switch (chooseList) {
            case 1 -> {
                    trainer.printMembers(membersList.juniorSwimmers,juniorPrice);
            }
            case 2 -> {
                    trainer.printMembers(membersList.seniorswimmers);
                    for (Member member : membersList.seniorSwimmers);
                    System.out.println(" Price: " + seniorPrice);

            }
            case 3 -> {
                for (Member member : membersList.adultSwimmers) {
                    System.out.println(member + " Price: " + adultPrice);
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
                memberMenu.readChoice();
            }
        }
    }
}
