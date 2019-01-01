public class Encounter {

    private static Combatant PC = new Combatant(19, 40, 2, 8, 7, 8);
    private static Combatant Monster = new Combatant(16, 70, 2, 6, 6, 10);

    public static void main (String[] args) {
        for (int i = 0; i < 300000; i++) {
            fightToDeath(PC, Monster);
            PC.setHitPoints(40);
            Monster.setHitPoints(70);
        }

        System.out.println("The PC has a " + PC.getNumWins()/3000 + "% chance of winning"); //FIXME: Magic number division
        System.out.println("When they won they had an average of " + PC.getAvgHealthRemaining()/PC.getNumWins() +
        " hit points remaining");
    }

    private static void fightToDeath(Combatant comb1, Combatant comb2) {
        while (comb1.getHitPoints() > 0 && comb2.getHitPoints() > 0) { //FIXME: Add nat 20s and nat 1s
            if (comb1.attack(comb2)) return;

            if (comb2.attack(comb1)) return;
        }
    }

}
