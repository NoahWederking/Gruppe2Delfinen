public class Main {
    public void run() {

        /*CompetitveMember cm = new CompetitveMember("Noah",2,"Crawl",4.5,3);
        System.out.println(cm);
        cm.printCompMem();*/

        //Attributes
        boolean isRunning = true;

        //Instances
        Member member = new Member();
        Menu generalMenu = new Menu("=====Dolphin swimmers menu=====", "Please choose user: ",
                new String[]{"1. Trainer", "2. Cashier", "3. Chairman", "9. Quit"});
        Trainer trainer = new Trainer(member);
        Chairman chairman = new Chairman(member);
        Cashier cashier = new Cashier(member);

        do {
            generalMenu.printMenu();
            int choice = generalMenu.readChoice();

            switch (choice) {
                case 1 -> trainer.trainerMenu();
                case 2 -> cashier.cashierMenu();
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