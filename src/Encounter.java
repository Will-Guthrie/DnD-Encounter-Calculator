public class Encounter {

    private static Combatant PC = new Combatant(19, 40, 2, 8, 7, 8);
    private static Combatant Monster = new Combatant(16, 70, 2, 6, 6, 10);

    public static void main (String[] args) {
        for (int i = 0; i < 100000; i++) {
            fightToDeath();
            PC.setHitPoints(40);
            Monster.setHitPoints(70);
        }

        System.out.println("The PC has a " + PC.getNumWins()/1000 + "% chance of winning");
        System.out.println("When they won they had an average of " + PC.getAvgHealthRemaining()/PC.getNumWins() +
        " hit points remaining");
    }

    private static void fightToDeath() {
        while (PC.getHitPoints() > 0 && Monster.getHitPoints() > 0) { //FIXME: Add nat 20s and nat 1s
            for (int i = 0; i < PC.getNumAttacks(); i++) {
                if (PC.basicAttackToHit() > Monster.getAC()) {
                    Monster.setHitPoints(Monster.getHitPoints() - PC.basicAttackDamage());
                    if (Monster.getHitPoints() <= 0) {
//                        System.out.println("The PC has won!");
                        PC.win();
                        return;
                    }
                }
            }

            for (int i = 0; i < Monster.getNumAttacks(); i++) {
                if (Monster.basicAttackToHit() > PC.getAC()) {
                    PC.setHitPoints(PC.getHitPoints() - Monster.basicAttackDamage());
                    if (PC.getHitPoints() <= 0) {
//                        System.out.println("The Monster has won!");
                        Monster.win();
                        return;
                    }
                }
            }
        }
    }



}
