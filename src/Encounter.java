public class Encounter {

    public static void main (String[] args) {
        Combatant PC = new Combatant(19, 20, 2, 8, 7, 8);
        Combatant Monster = new Combatant(16, 70, 2, 6, 6, 10);

        while (PC.getHitPoints() > 0 && Monster.getHitPoints() > 0) { //FIXME: Add nat 20s and nat 1s
            for (int i = 0; i < PC.getNumAttacks(); i++) {
                if (PC.basicAttackToHit() > Monster.getAC()) {
                    Monster.setHitPoints(Monster.getHitPoints() - PC.basicAttackDamage());
                    if (Monster.getHitPoints() <= 0) {
                        System.out.println("The PC has won!");
                        PC.win();
                        return;
                    }
                }
            }

            for (int i = 0; i < Monster.getNumAttacks(); i++) {
                if (Monster.basicAttackToHit() > PC.getAC()) {
                    PC.setHitPoints(PC.getHitPoints() - Monster.basicAttackDamage());
                    if (PC.getHitPoints() <= 0) {
                        System.out.println("The Monster has won!");
                        Monster.win();
                        return;
                    }
                }
            }
        }

    }



}
