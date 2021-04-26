public class Dorms extends Pod {

    int numBeds;
    int numBath;
    int numShow;
    boolean waterControl = true;

    // constructor for the variables
     Dorms (String n, String col, int e, int t, int b, int ba, int s, boolean w) {

         type = "Dorms";
         // pod aspects
         name = n;
         color = col;
         entryCode = e;
         temp = t;

        numBeds = b;
        numBath = ba;
        numShow = s;
        waterControl = w;
    }

    // creates the pod info block
    String podInfo() {
        String info = name
                + "\n    Pod Type: " + type
                + "\n    Pod Color: " + color
                + "\n    Pod Entry Code: " + entryCode
                + "\n    Pod Temperature: " + temp
                + "\n    Number of Beds: " + numBeds
                + "\n    Number of Showers: " + numShow
                + "\n    Number of Lavatories: " + numBath
                + "\n    Water Status: " + stat(waterControl);

        return info;
    }


    // turns the water going to the dorms on and off
    void controlWater(){

        System.out.println("Would you like to enable or disable the water for " + name + "?\n");
        System.out.println("1. Enable\n" +
                "2. Disable\n");
        NumberInput selector = new NumberInput();
        // keeps responses to a number between 1 and 2
        int response = selector.getNumberWithinRange(1, 2);

        if(response == 1) {
            waterControl = true;
        } else{
            waterControl = false;
        }

    }
}

