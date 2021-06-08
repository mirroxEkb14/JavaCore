package Projects.RolePlayingGame.model;

    /*
        This class contains all the necessary fields and methods
        for monsters. Each monster will be inherited from this class
     */

public class Monster extends Entity {

    public Monster(int hp, int force, int agility) {
        super(hp, force, agility);
    }
}
