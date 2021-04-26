public class Lab extends Pod {

    String status;
    boolean open = true;
    boolean lock = false;
    int sec;

    // constructor for the variables
    Lab(String n, String col, int e, int t, String s, int se) {
        type = "Lab";
        // pod aspects
        name = n;
        color = col;
        entryCode = e;
        temp = t;

        status = s;
        sec = se;
    }

    // creates the pod info block
    String podInfo() {
        String info = name
                + "\n    Pod Type: " + type
                + "\n    Pod Color: " + color
                + "\n    Pod Entry Code: " + entryCode
                + "\n    Pod Temperature: " + temp
                + "\n    Pod State:  " + status
                + "\n    Pod Security Level: " + sec;


        return info;
    }

    // controls the security level
    void setSecurityLevel(){

        System.out.println("Please set a Security Level for the Lab (Must be 1-3).");
        NumberInput selector = new NumberInput();
        // keeps responses to a number between 1 and 3
        int response = selector.getNumberWithinRange(1, 3);

        if(response == 1){
            sec = 1;
        }else if (response == 2){
            sec = 2;
        }else if (response == 3){
            sec = 3;
        }
        //displays the new security level
        System.out.println("Security level updated to level " + sec + ".");
    }

    // displays if the status of the lab is Accessible or locked
    void isItOpen() {

        System.out.println("Do you want the lab to be Accessible or Locked?");
        System.out.println("1. Unlock\n" +
                "2. Locked\n");
        NumberInput selector = new NumberInput();
        // keeps responses to a number between 1 and 2
        int response = selector.getNumberWithinRange(1, 2);

        if(response == 1) {
            status = "Accessible";
        } else{
            status = "Locked";
        }

    }
}
