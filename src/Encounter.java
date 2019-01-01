public class Encounter {

    public static void main (String[] args) {
        Dice d20 = new Dice(20);
        Combatant PC = new Combatant(19, 50, 2, 8, 7, 4);
        Combatant Monster = new Combatant(16, 70, 2, 6, 6, 3);
        Dice pcDice = new Dice(PC.getDamageDice());
        Dice monsterDice = new Dice(Monster.getDamageDice());

        while (PC.getHitPoints() > 0 && Monster.getHitPoints() > 0) { //FIXME: Add nat 20s and nat 1s
            for (int i = 0; i < PC.getNumAttacks(); i++) {
                if (d20.roll() + PC.getToHit() > Monster.getAC()) {
                    Monster.setHitPoints(Monster.getHitPoints() - (PC.getAddToDamage() + pcDice.roll()));
                    if (Monster.getHitPoints() <= 0) {
                        System.out.println("The PC has won!");
                        PC.win();
                        return;
                    }
                }
            }

            for (int i = 0; i < Monster.getNumAttacks(); i++) {
                if (d20.roll() + Monster.getToHit() > PC.getAC()) {
                    PC.setHitPoints(PC.getHitPoints() - (Monster.getAddToDamage() + monsterDice.roll()));
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
