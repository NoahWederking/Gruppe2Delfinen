public class Cashier {

    //Attributes
    private boolean isRunning;
    private final String juniorPrice = "Price: 1000";
    private final String seniorPrice ="Price: 1200";
    private final String adultPrice = "Price: 1600";



    //Instances

    Menu cashierMenu = new Menu("====Cashier Menu====", "Please choose: ", new String[]
            {"1. View missing payments", "9. To go back."});

    public Cashier() {
    }

    //Methods
    public void cashierMenu(MembersList membersList, Trainer trainer) {
        cashierMenu.printMenu();
        int choice = cashierMenu.readChoice();
        do {
            switch (choice) {
                case 1 -> viewMissingPayments(membersList);
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

}
