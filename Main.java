import java.io.IOException;

public class Main {

    //Attributes
    private boolean isRunning = true;

    //Instances
    Menu generalMenu = new Menu("=====Dolphin swimmers menu=====", "Please choose user: ",
            new String[]{"1. Trainer", "2. Cashier", "3. Chairman", "9. Quit"});
    Log log = new Log();
    Member member = new Member(log);
    Trainer trainer = new Trainer(member);
    Chairman chairman = new Chairman(member);
    Cashier cashier = new Cashier(member);

    //Constructors
    public Main() throws IOException {

    }
    public void run() throws IOException {

        log.writeLine("\nStarting program");

        do {
            generalMenu.printMenu();
            int choice = generalMenu.readChoice();

            switch (choice) {
                case 1 -> trainer.trainerMenu();
                case 2 -> cashier.cashierMenu();
                case 3 -> chairman.chairmanMenu();
                case 9 -> {
                    System.out.println("Quit");
                    log.writeLine("\nClosing program");
                    log.closeFile();
                    isRunning = false;
                }
                default -> {
                    System.out.println("Invalid input");
                    generalMenu.readChoice();
                }
            }
        } while (isRunning);
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}