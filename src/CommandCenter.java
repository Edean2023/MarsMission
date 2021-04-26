public class CommandCenter extends Pod {

    boolean lockdown = false;
    String commStatus;

    // constructor for the variables
    CommandCenter(String n, String col, int e, int t, boolean ld, String cs) {
        type = "CommandCenter";
        // pod aspects
        name = n;
        color = col;
        entryCode = e;
        temp = t;

        lockdown = ld;
        commStatus = cs;

    }

    // creates the pod info block
    String podInfo() {
        String info = name
                + "\n    Pod Type: " + type
                + "\n    Pod Color: " + color
                + "\n    Pod Entry Code: " + entryCode
                + "\n    Pod Temperature: " + temp
                + "\n    Command Center Status: " + commStatus;

        return info;
    }

    // controls the command center status
    void commandCenterStatus() {
        System.out.println("Would you like to lock down the Command Center?\n");
        System.out.println("Doing so will cause it to lose functionality\n");
        System.out.println("1. Open\n" +
                "2. Lockdown");
        NumberInput selector = new NumberInput();
        // can only enter a number between 1 and 2
        int response = selector.getNumberWithinRange(1, 2);

        if (response == 1) {
            lockdown = false;
        } else if (response == 2) {
            lockdown = true;
        }

        if(lockdown == true) {
            commStatus = "Lockdown";
        }else if (lockdown == false){
            commStatus = "Functional";
        }

    }
}