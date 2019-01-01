public class Encounter {

    private static Combatant PC = new Combatant(1, 1, 1, 8, 7, 8);
    private static Combatant Monster = new Combatant(100, 1, 2, 6, 6, 10);
    private static int numIterations = 300000;

    public static void main (String[] args) {
        for (int i = 0; i < numIterations; i++) {
            fightToDeath(PC, Monster);
            PC.resetHitPoints();
            Monster.resetHitPoints();
        }

        System.out.println("The PC has a " + PC.getNumWins()/numIterations*100 + "% chance of winning");
        System.out.println("When they won they had an average of " + PC.getAvgHealthRemaining()/PC.getNumWins() +
        " hit points remaining");
    }

    private static void fightToDeath(Combatant comb1, Combatant comb2) {
        while (comb1.getHitPoints() > 0 && comb2.getHitPoints() > 0) { //FIXME: Add initiative rolls
            if (comb1.attack(comb2)) return;

            if (comb2.attack(comb1)) return;
        }
    }

}
