
public class Cafe extends Pod{
    String open;
    boolean openWater = true;
    String mealPrep;
    String stations;
    String clean;
    String cleanUp;
    int numTables;
    int buildTime;

    Cafe(String n, String col, int e, int t, String o, boolean ow, String m, String cl, int nt){
        type = "Cafe";
        // pod aspects
        name = n;
        color = col;
        entryCode = e;
        temp = t;

        open = o;
        openWater = ow;
        mealPrep = m;
        clean = cl;
        numTables = nt;
    }


    String podInfo() {
        String info = name
                + "\n    Pod Type: " + type
                + "\n    Pod Color: " + color
                + "\n    Pod Entry Code: " + entryCode
                + "\n    Number of tables: " + numTables
                + "\n    Pod State: " + open
                + "\n    Pod Water State: " + openWater
                + "\n    Pod Meal Status: " + mealPrep
                + "\n    Pod Cleanliness: " + clean;

        return info;
    }

    // tells if the cafe is open or closed
    void isCafeOpen() {

        System.out.println("Would you like the cafe to be open or closed?\n");
        System.out.println("1. Open\n" +
                "2. Closed\n");
        NumberInput selector = new NumberInput();
        // can only enter a number between 1 and 2
        int response = selector.getNumberWithinRange(1, 2);

        if(response == 1) {
            open = "Open";
            System.out.println("The cafe is open!\n");
        }else {
            open = "Closed";
            System.out.println("The cafe is closed!\n");
        }
    }

    // controls the water for the cafe
    void cafeWaterControl(){

        System.out.println("Would you liked the water to be turned on or off?");
        System.out.println("Turning the water off will automatically close the cafe");
        System.out.println("1. Water on.\n" +
                "2. Water off\n");
        NumberInput selector = new NumberInput();
        // can only enter a number between 1 and 2
        int response = selector.getNumberWithinRange(1, 2);

        // if water is on, do this
        if (response == 1){
            openWater = true;
            System.out.println("Cafe water is on!\n");
        }else {
            // if the water is off, set openWater to false and close the cafe
            openWater = false;
            open = "closed";
            System.out.println("Cafe water is off!\n");
        }

    }

    void cafeMealStatus(){
        System.out.println("Would you like to prepare meals for the cafe?");
        System.out.println("If meals are not prepared, the cafe will be forced to close.");
        System.out.println("1. Prepare Meals\n" +
                "2. Don't Prepare Meals\n");
        NumberInput selector = new NumberInput();
        // can only enter a number between 1 and 2
        int response = selector.getNumberWithinRange(1, 2);

        if (response == 1) {
            System.out.println("Preparing meals");
            Source.loading();
            mealPrep = "Prepared";
            System.out.println("\nMeals have been prepared!");
        } else {
            open = "Closed";
            mealPrep = "Not-Prepared";
            System.out.println("Meals have not been prepared!\n");
        }

    }

    void cleanCafe(){
        System.out.println("Would you like to clean the cafe?");
        System.out.println("1. Clean Cafe\n" +
                "2. Don't clean cafe\n");
        NumberInput selector = new NumberInput();
        // can only enter a number between 1 and 2
        int response = selector.getNumberWithinRange(1, 2);

        if (response == 1){
            System.out.println("Cleaning cafe");
            Source.loading();
            clean = "Clean";
            System.out.println("\nCafe is clean!");
        }else {
            clean = "Dirty";
            System.out.println("Cafe is not clean!\n");
        }

    }
}
