public class Main {
    public void run() {
        Menu generalMenu = new Menu("Dolphin swimmers menu", "Please choose user",
                new String[]{"1. Trainer", "2. Cashier", "3. Chairman", "9. Quite"});


        boolean isRunning = true;
        do {
            generalMenu.printMenu();
            int choice = generalMenu.readChoice();

            switch (choice) {
                case 1 -> System.out.println();
                case 2 -> System.out.println();
                case 3 -> System.out.println();
                case 9 -> {System.out.println("quit");
                    isRunning=false;
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