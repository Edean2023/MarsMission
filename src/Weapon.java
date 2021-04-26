public class Weapon {

    String name;
    int magSize;
    String type;

    // sets the sting and int values
    Weapon(String n, int m, String t)
    {
        name = n;
        magSize = m;
        type = t;
    }


    // returns all of the gun information
    String returnInfo()
    {
        return "Weapon: [" + name + ", Type: " + type + ", Ammo Capacity: " + magSize + "]";
    }

}
