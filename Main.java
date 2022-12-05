import java.io.IOException;

public class Main {

    //Attributes
    private boolean isRunning = true;

    //Instances
    Menu generalMenu = new Menu("=====Dolphin swimmers menu=====", "Please choose user: ",
            new String[]{"1. Trainer", "2. Cashier", "3. Chairman", "9. Quit"});
    Log log = new Log();
    Calender calender = new Calender();
    Chairman chairman = new Chairman();
    Trainer trainer = new Trainer();
    Cashier cashier = new Cashier();
    Member member = new Member();
    MembersList membersList = new MembersList();

    //Methods
    public Main() throws IOException {

    }
    public void run() throws IOException {
        membersList.initialize();

        log.writeLine("\n" + calender.formattedDate + " Starting program");

        do {
            generalMenu.printMenu();
            int choice = generalMenu.readChoice();

            switch (choice) {
                case 1 -> trainer.trainerMenu(member, membersList, calender, log);
                case 2 -> cashier.cashierMenu(membersList, calender, log);
                case 3 -> chairman.chairmanMenu(member, membersList, calender, log);
                case 9 -> {
                    System.out.println("Quit");
                    log.writeLine("\n" + calender.formattedDate + " Closing program");
                    log.closeFile();
                    isRunning = false;
                }
                default -> System.out.println("Invalid input");
            }
        } while (isRunning);
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}