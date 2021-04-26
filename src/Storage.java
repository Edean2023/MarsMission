public class Storage extends Pod {

    int capacity;
    int humLevel;

    // constructor for the variables
    Storage (String n, String col, int e, int t, int ca, int hu){
        type = "Storage";
        // pod aspects
        name = n;
        color = col;
        entryCode = e;
        temp = t;

        capacity = ca;
        humLevel = hu;
    }

    // creates the pod info block
    String podInfo() {
        String info = name
                + "\n    Pod Type: " + type
                + "\n    Pod Color: " + color
                + "\n    Pod Entry Code: " + entryCode
                + "\n    Pod Temperature: " + temp
                + "\n    Pod Capacity: " + capacity + " cubic feet"
                + "\n    Pod Humidity Level: " + humLevel;

        return info;
    }

    // changes the rooms humidity level
    void changeHumidity(){
        System.out.println("Current humidity levels are at " + humLevel + "%.\n");
        System.out.println("Would you like to change the humidity level?\n" +
                "1. Yes\n" +
                "2. No\n");
        NumberInput selector = new NumberInput();
        // can only enter a number between 1 and 2
        int response = selector.getNumberWithinRange(1, 2);

        if (response == 1){
            System.out.println("Please type the humidity level you would like. Must be from 0-100");
            NumberInput selector2 = new NumberInput();
            int response2 = selector2.getNumberWithinRange(0, 100);
            humLevel = response2;

            System.out.println("Humidity level is now set to " + humLevel + "%.");

        }else {
            System.out.println("Humidity level will remain at " + humLevel + "%.");
        }
    }


}
