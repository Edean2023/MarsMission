public class CrewMember {

    String name;
    int food [];
    Weapon gun;

    // set string values and creates the array for food and also includes the weapon info
    CrewMember(String n, int f[], Weapon g)
    {
        name = n;
        food = f;
        gun = g;
    }

    // returns all of the crew information
    String returnInfo()
    {
        return name + " | Food: [" + food[0] + ", " + food[1] + ", " + food[2] + ", "
                + food[3] + ", " + food[4] + ", " + food[5] + ", " + food[6] + ", " + food[7] + ", "
                + food[8] + ", " + food[9] + ", " + food[10] + ", " + food[11] + "] | " + gun.returnInfo();
    }
}
