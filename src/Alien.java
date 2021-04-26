import java.util.Random;
public class Alien {

    int hunger;

    // constructor for alien
    Alien()
    {
        // sets hunger default to 100
        hunger = 100;
    }

    // in charge of managing hunger levels
    boolean eat()
    {
        // makes a random number
        Random rand = new Random();

        if (hunger > 0)
        {
            // makes a random number between 35 and 50
            hunger = hunger -( rand.nextInt(16) + 35);

            // if hunger is less than 0 then it will display as 0
            if (hunger < 0) {
                hunger = 0;
            }
            return true;
        }
        else
        {
            return false;
        }

    }



}
