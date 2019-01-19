public class Encounter {

    //TODO: Add support of getting user input/some ui
    private static Combatant PC = new Combatant(19, 50, 2,
            8, 7, 8, 0);
    private static Combatant Monster = new Combatant(16, 70, 2,
            6, 6, 10, 4);

    public static void main (String[] args) {
        int numIterations = 3000000;
        for (int i = 0; i < numIterations; i++) {
            rollInitiative(PC, Monster); //Starts combat until one of the combatants dies
            PC.resetHitPoints();
            Monster.resetHitPoints();
        }

        System.out.println("The PC has a " + PC.getNumWins()/numIterations*100 + "% chance of winning");
        System.out.println("When they won they had an average of " + PC.getAvgHealthRemaining()/PC.getNumWins() +
        " hit points remaining");
    }

    //TODO: Make this function accept an array of Combatants so you can have move than 1v1 combat (figure out targeting)
    private static void rollInitiative(Combatant comb1, Combatant comb2) {
        int comb1Initiative = comb1.initiativeRoll();
        int comb2Initiative = comb2.initiativeRoll();

        if (comb1Initiative == comb2Initiative) { //In tie case, re-roll
            rollInitiative(comb1, comb2);
        } else if (comb1Initiative > comb2Initiative) {
            fightToDeath(comb1, comb2);
        } else {
            fightToDeath(comb2, comb1);
        }
    }

    private static void fightToDeath(Combatant comb1, Combatant comb2) {
        //Trade rounds of attacks until one of them has not hit points left
        while (comb1.getHitPoints() > 0 && comb2.getHitPoints() > 0) {
            if (comb1.attack(comb2)) return;

            if (comb2.attack(comb1)) return;
        }
    }

}
