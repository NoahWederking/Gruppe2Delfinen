public class Main {
    public void run() {

        //Attributes
        boolean isRunning = true;

        //Instances
        Menu generalMenu = new Menu("=====Dolphin swimmers menu=====", "Please choose user: ",
                new String[]{"1. Trainer", "2. Cashier", "3. Chairman", "9. Quit"});
        Trainer trainer = new Trainer();
        Chairman chairman = new Chairman();


        do {
            generalMenu.printMenu();
            int choice = generalMenu.readChoice();

            switch (choice) {
                case 1 -> trainer.trainerMenu();
                case 2 -> System.out.println();
                case 3 -> chairman.chairmanMenu();
                case 9 -> {
                    System.out.println("Quit");
                    isRunning = false;
                }
                default -> {
                    System.out.println("Invalid input");
                    generalMenu.readChoice();
                }
            }
        } while (isRunning);
    }

    public static void main(String[] args) {
        new Main().run();
    }

}