public class Encounter {

    public static void main (String[] args) {
        Dice d20 = new Dice(20);
        Combatant PC = new Combatant(19, 50, 2, 8, 7, 4);
        Combatant Monster = new Combatant(16, 70, 2, 6, 6, 3);
        Dice pcDice = new Dice(PC.getDamageDice());
        Dice monsterDice = new Dice(Monster.getDamageDice());

        while (PC.getHitPoints() != 0 && Monster.getHitPoints() != 0) {
            
        }

    }

}
