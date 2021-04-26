
// Ethan Dean
// This will take a couple hours
// It did take a couple hours. (aprox. 3)

import java.util.Scanner; // allows the use of scanners
public class Source
{
    public static void main(String args[])
    {

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        int crew = 0; // sets the int for crew
        boolean isNumber; // sets the bool for isNumber
        int sBox[] = {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
        int rocks = 10;


        // alien array
        Alien aliens[] = {new Alien(), new Alien(), new Alien()};

        int info[]= {4, 12}; // sets an array for the ints that are numbers

        // displays the weapon name, ammo capacity, and type
        Weapon sidearm = new Weapon("Duke MK. 44", 6, "Hand Cannon");
        // displays the base name and the location
        Base marsBase = new Base("Perimeter-AT3", "Alpha Sector");


        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Scanner in = new Scanner(System.in);  // allows for user input for their name
        Scanner c = new Scanner(System.in); // allows input for number of crew members
        Scanner cName = new Scanner(System.in); // allows input of crew member names

        System.out.println("Please input your name. ");  // asks user to input their name
        String name = in.nextLine();  // puts the name in the next line

        System.out.println("Welcome, Captain " +name + ".\n"); // outputs a welcome message with the inputted name

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        do // this loop checks if the input is a number or not
        {
            System.out.println("Please input the number of crew members going on the voyage.\n");
            System.out.println("Must be 4 or more.\n");// asks the user how many crew members they have
            if (c.hasNextInt())
            {
                crew = c.nextInt();
                if(crew >= 4)
                {
                    crew = java.lang.Math.abs(crew);
                    isNumber = true; // gets out of the loop because the input was true
                }else {
                    isNumber = false;
                }
            } else
            {
                System.out.println("Invalid input detected, please input the NUMBER of crew members (Must be 4 or more)."); // displays error message when the user inputs something that isn't a number
                isNumber = false;
                c.next(); // stops loop from being infinite
            }
        }while (!(isNumber)); // loop this while isNumber = false
        System.out.println("Thank you Captain " +name + ", your current number of crew members is " +crew +"."); // Prints the users name and the number of crew members they have

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // this asks for each crew member's name and creates an object for each of them
        CrewMember crewList[] = new CrewMember[crew];
        for(int i =0; i < crew; i++)
        {
            System.out.println("What is the name of crew member " + (i + 1) + "?");
            String temp = cName.nextLine();
            crewList[i] = new CrewMember(temp, sBox, sidearm );
        }

        Ship s = new Ship("Ares 1",name ,crewList);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // calls roster
        s.Roster();
        // calls removeFood
        s.removeFood(1, 2 );

        // adds the user to the number of crew members, multiplies that number by the amount of food each person needs,
        // multiplies that by the number of weeks, and displays the amount of food they will need
        System.out.println("\nYou and your crew will need a total of "+((crew + 1) * info[0] * info[1]) + " lbs worth of food for the mission.");
        marsBase.Info();

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("\nThe food left after the first half week for each crew member. ");
        // calls roster again
        s.Roster();
        System.out.print("\n\nLanding Sequence Initiated. Please wait");

        loading(); // loading animation

        System.out.println("\nLanding sequence completed.\n");
        System.out.println("WARNING: Life forms detected!\n");

        System.out.print("\nFeeding sequence initiated");
        loading(); // loading animation

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // set eating to true
        boolean eating = true;
        // sets starting attempt to 1
        int attempt = 1;

        // responsible for feeding aliens
        while(eating) {
            long original = System.currentTimeMillis();
            while (true) {
                // delays feeding for visual pleasure
                if (System.currentTimeMillis() - original >= 500) {
                    for (int i = 0; i < aliens.length; i++) {
                        eating = aliens[i].eat();

                        if (eating) {
                            rocks -= 1;
                            System.out.println("\nFeeding attempt #" + attempt + ":");
                            System.out.println("Feeding alien #" + (i + 1) + ", " + rocks + " rocks remaining, alien has " + aliens[i].hunger + " hunger remaining");
                            break;
                        }
                    }
                    attempt++;
                    break;
                }
            }
        }
        System.out.println("\n\nFeeding sequence completed with " + rocks + " rock(s) remaining.");

        for(int j = 0; j < 5; j++) {
            marsBase.newPod();
        }
        marsBase.podInfoOut();

        //build the pods
        marsBase.buildPods();


        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        NumberInput numIn = new NumberInput();

       /* System.out.println("\n\nHow many pods would you like to disable before continuing?(between 0 and 5):");
        int disabledPods = numIn.getNumberWithinRange(0, 5);

        // this asks for each crew member's name and creates an object for each of them
        for(int i =0; i < disabledPods; i++)
        {
            System.out.println("What is the number of the pod you would like to disable?");
            int podNum = numIn.getNumberWithinRange(1, 5);

            marsBase.disablePod(podNum);
        }*/
        // this block displays each pods information in the order it should be.
        // podInfoOut displays the pods info and calls it again to refresh the info when updated.
        marsBase.podInfoOut();
        marsBase.defaultTemp(); // default temperature
        marsBase.podInfoOut();
        marsBase.water(); // enable/disable water for dorm
        marsBase.podInfoOut();
        marsBase.secLevel(); // sets security level for the lab
        marsBase.podInfoOut();
        marsBase.accessability(); // sets the accessibility of the lab
        marsBase.podInfoOut();
        marsBase.cmStatus(); // sets the status for the command center (Lock down or not)
        marsBase.podInfoOut();
        marsBase.storageHumidity(); // sets the storage pod humidity level
        marsBase.podInfoOut();
        marsBase.cafeOpen();    // changes if the cafe is opened or closed
        marsBase.waterInCafe(); // changes if the cafe has access to water
        marsBase.cafeMeals();   // cafe meal prep
        marsBase.cafeClean();   // cleans cafe
        marsBase.podInfoOut();
        Rover findRover = new Rover(21);
        findRover.executeSearch();
    }



    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // this makes a sort of loading animation made of 3 periods
    static void loading()
    {
        for(int i=0; i < 3; i++)
        {
            long original = System.currentTimeMillis();
            while (true) {
                // write a period every second until there are 3
                if (System.currentTimeMillis() - original >= 1000) {
                    System.out.print(".");
                    break;
                }
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // pod building 'animation'
    static void percent(){
        System.out.print("Pod Building in progress...");
        for(int i=0; i < 3; i++)
        {
            long original = System.currentTimeMillis();
            while (true) {
                // write a period every second until there are 3
                if (System.currentTimeMillis() - original >= 1000) {
                    System.out.print("\n10%");
                    break;
                }

            }
        }
    }
}











