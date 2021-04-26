import java.util.Date;
import java.util.Random;
public class Rover {
    int rover_location, total_locations;
    boolean checked_locations[];

    Rover(int locations) {
        //set random seed
        Random rand = new Random(new Date().getTime());

        //set the random rover location to one of the given locations
        rover_location = rand.nextInt(locations) + 0;
        total_locations = locations;
        checked_locations = new boolean[locations];

        for (int i = 0; i < checked_locations.length; i++) {
            checked_locations[i] = false;
        }
    }

    //execute the search of the rover
    void executeSearch() {
        int guess;
        NumberInput in = new NumberInput();

        System.out.println("\nSearching For Rover\n");

        //loop until the user guesses the rover's location correction
        do {
            System.out.println("Please input the quadrant you would like to search (must be between 1 and " + total_locations + "):");
            guess = in.getNumberWithinRange(1, total_locations) - 1;

            //output something if the guess is incorrect
            if (guess != rover_location) {
                //check if the location has already been guessed
                if (checked_locations[guess] == true) {
                    System.out.println("\nThis location has already been guessed.");
                } else {
                    checked_locations[guess] = true;
                }

                System.out.println("\n>---------------------------------<\n");
                System.out.println("Previous Guess Incorrect!");
            }
        } while (guess != rover_location);

        System.out.println("\n>---------------------------------<\n");
        System.out.println("Rover located at " + (rover_location + 1) + "!");
        System.out.println("Ending Simulation...");
    }
}
