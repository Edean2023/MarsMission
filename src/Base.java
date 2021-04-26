import java.util.Scanner;

public class Base {

    String name;
    String location;// sets the bool for isNumber
    Pod pods[] = new Pod[5];
    int total_pods = 0;

    // sets string values for base
    Base(String n, String l)
    {
        name = n;
        location = l;
    }

    // prints all of the base information
    void Info()
    {
        System.out.println("The mission will take place at Base " + name + " located in the " + location);
    }

    // Option menu for pods
    void newPod() {
        int podNumber = 0;
        boolean inRange = false;

        podInfoOut();

        // displays which pods you can choose
        System.out.println("Which Pods would you like to build?\n");
        System.out.println("1. Dorm\n" +
                "2. Cafe\n" +
                "3. Lab\n" +
                "4. Command Center\n" +
                "5. Storage\n");
        System.out.println("Input selection number:");

        // makes sure you can only select a number between 1 and 5
        NumberInput selector = new NumberInput();
        podNumber = selector.getNumberWithinRange(1, 5);

        // controls what goes into the pods
        switch (podNumber) {
            case 1:
                pods[total_pods] = new Dorms(("Pod " + (total_pods + 1)),"grey", 1234, 70, 10,6,5, true);
                break;
            case 2:
                pods[total_pods] = new Cafe(("Pod " + (total_pods + 1)),"Blue", 4523, 72, "Open", true, "Not-prepared", "Not-clean", 10);
                break;
            case 3:
                pods[total_pods] = new Lab(("Pod " + (total_pods + 1)),"Green", 4501, 65, "Accessible",1);
                break;
            case 4:
                pods[total_pods] = new CommandCenter(("Pod " + (total_pods + 1)),"Red", 4521, 72, false,"Functional");
                break;
            case 5:
                pods[total_pods] = new Storage(("Pod " + (total_pods + 1)),"Yellow", 7528, 69, 1000, 50);
                break;
        }

        total_pods++;
    }

    // displays pod info and separates with fancy lines
    void podInfoOut() {
        System.out.println("Current Pods:");

        if (pods != null) {
            for (int i = 0; i < total_pods; i++) {
                System.out.println("---------------------");
                System.out.println(pods[i].podInfo());
            }
        } else {
            System.out.println("\nNone");
        }
    }

    // helps with the building pod percent animation
    void buildPods() {
        boolean results[] = new boolean[pods.length];
        boolean complete = false;
        int time_elapsed = 0, hours_per_loop = 2;
        long time = System.currentTimeMillis();

        do {
            //sets a 500ms delay to make things look nice
            if (System.currentTimeMillis() - time >= 500) {
                System.out.println("\n>----------\n");
                System.out.println("Building Pods | Time Elapsed: " + time_elapsed + "h");
                for (int i = 0; i < pods.length; i++) {
                    //build iteration for each pod
                    results[i] = pods[i].build((i + 1), 2);
                }

                time_elapsed += hours_per_loop;

                complete = true;

                //checks if all of the results are true
                for (int i = 0; i < pods.length; i++) {
                    if (!results[i]) {
                        complete = false;
                    }
                }

                //reset time
                time = System.currentTimeMillis();
            }
        } while (!complete);

        System.out.println("\n Pod Construction Complete!\n");
    }

    // sets the default temperature of all the pods
    void defaultTemp(){
        int temp = 0;
        NumberInput tempSel = new NumberInput();

        System.out.println("What would you like to set the default temperature to (between 50 - 80)?");
        // makes sure the only value you can enter is a number between 50 and 80
        temp = tempSel.getNumberWithinRange(50, 80);
        System.out.println("You have now set the default temperature to " + temp +" degrees.");

        for (int i = 0; i < pods.length; i++) {
            pods[i].temp = temp;
        }
    }


    // disables the pod if the user wishes to
  /*  void disablePod(int podIndex) {
        pods[podIndex - 1].disable();
    } */

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Dorm water control
    void water() {
        for (int i = 0; i < pods.length; i ++) {
            if(pods[i].type == "Dorms") {
                pods[i].controlWater();
            }
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Lab security level control
    void secLevel(){
        for (int i = 0; i < pods.length; i ++) {
            if(pods[i].type == "Lab") {
                pods[i].setSecurityLevel();
            }
        }
    }
    // Lab accessability control
    void accessability(){
        for (int i = 0; i < pods.length; i ++) {
            if(pods[i].type == "Lab") {
                pods[i].isItOpen();
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // command center status control
    void cmStatus(){
        for (int i = 0; i < pods.length; i ++) {
            if(pods[i].type == "CommandCenter") {
                pods[i].commandCenterStatus();
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // storage humidity control
    void storageHumidity(){
        for (int i = 0; i < pods.length; i ++) {
            if(pods[i].type == "Storage") {
                pods[i].changeHumidity();
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // cafe open status control
    void cafeOpen(){
        for (int i = 0; i < pods.length; i ++) {
            if(pods[i].type == "Cafe") {
                pods[i].isCafeOpen();
            }
        }
    }

    // controls water access in cafe
    void waterInCafe(){
        for (int i = 0; i < pods.length; i ++) {
            if(pods[i].type == "Cafe") {
                pods[i].cafeWaterControl();
            }
        }
    }

    // controls meal prep for cafe
    void cafeMeals(){
        for (int i = 0; i < pods.length; i ++) {
            if(pods[i].type == "Cafe") {
                pods[i].cafeMealStatus();
            }
        }
    }

    // cleans cafe
    void cafeClean(){
        for (int i = 0; i < pods.length; i ++) {
            if(pods[i].type == "Cafe") {
                pods[i].cleanCafe();
            }
        }
    }
}