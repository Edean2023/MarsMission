import java.util.Random;
import java.util.Scanner; // allows the use of scanners
public class Pod {

    Random rand = new Random();
    //Pod Types
    String type;

    // Pod Aspects
    String name;
    String color;
    boolean enableStatus = false;
    int entryCode;
    int temp;
    // sets build time and total time to 0
    int build_time = 0, total_time = 0;

    Pod() {
        // This is the default constructor
        total_time = rand.nextInt(25) + 24;
    }

    // constructor for variables
    Pod(String ty, String n, String col, int e, int t){
        // pod types
        type = ty;

        // pod aspects
        name = n;
        color = col;

        entryCode = e;
        temp = t;
    }

    // creates pod info block
    String podInfo() {
        String info = name
                + "\n    Pod Type: " + type
                + "\n    Pod Color: " + color
                + "\n    Build Time: " + total_time
                + "\n    Pod Entry Code: " + entryCode
                + "\n    Pod Temperature: " + temp;

        return info;
    }

    // controls the default temperature for all the pods
    void Temperature(){

        int temp = 0;
        Scanner t = new Scanner(System.in);

        System.out.println("What would you like to set the default temperature to?");
        if (t.hasNextInt()){
            temp = t.nextInt();
            System.out.println("You have now set the default temperature to " + temp +" degrees.");
        }

    }

    // enables and disables different pods
    void EnablePod(){
        int disPod = 0;
        boolean isNumber;
        Scanner p = new Scanner(System.in);
        do // this loop checks if the input is a number or not
        {
            System.out.println("Please input the number of pods you would like to disable");        // asks the user how many pod members they have
            if (p.hasNextInt())
            {
                disPod = p.nextInt();
                disPod = java.lang.Math.abs(disPod);
                isNumber = true; // gets out of the loop because the input was true
            } else
            {
                System.out.println("Invalid input detected, please input the NUMBER of pod members."); // displays error message when the user inputs something that isn't a number
                isNumber = false;
                p.next(); // stops loop from being infinite
            }
        }while (!(isNumber)); // loop this while isNumber = false
        System.out.println("Thank you Captain " +name + ", your current number of pods is " + disPod +".");

    }
    // enabled or disabled
    String stat(boolean status){
        if (status) {
            return "Enabled";
        } else {
            return "Disabled";
        }
    }

    // this handles the amount of time it takes to build each pod
    public boolean build(int index, int hours) {
        if (build_time >= total_time) {
            // if the build time is greater than time needed to build pod then the pod is completed
            System.out.println("Pod #" + index + " (" + type + ") build progress: Complete");
            return true;
        } else {
            // displays the build progress to the user
            System.out.println("Pod #" + index + " (" + type + ") build progress: " + (float)(((float)(build_time) / (float)(total_time)) * 100) + "%");

            //increment build time
            build_time += hours;
            return false;
        }
    }

    void disable() {
        enableStatus = false;
    }

    void enable() {
        enableStatus = true;
    }

    // these are here so base and source can access them
    void controlWater(){}
    void setSecurityLevel(){}
    void isItOpen(){}
    void commandCenterStatus(){}
    void changeHumidity(){}
    void isCafeOpen(){}
    void cafeWaterControl(){}
    void cafeMealStatus(){}
    void cleanCafe(){}
}


