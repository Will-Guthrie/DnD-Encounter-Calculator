public class Combatant {

    //Character information
    private int AC;
    private int maxHitPoints;
    private int currentHitPoints;
    private int numAttacks;
    private int toHit;
    private int addToDamage;
    private int initiativeMod;
    private Dice damageDice;
    private Dice d20;

    //Stats to track
    private double numWins;
    private double avgHealthRemaining;

    Combatant(int AC, int maxHitPoints, int numAttacks, int toHit, int addToDamage, int damageDice, int initiativeMod) {
        this.AC = AC;
        this.maxHitPoints = maxHitPoints;
        this.currentHitPoints = maxHitPoints;
        this.numAttacks = numAttacks;
        this.toHit = toHit;
        this.addToDamage = addToDamage;
        this.initiativeMod = initiativeMod;
        this.damageDice = new Dice(damageDice);
        this.d20 = new Dice(20);
    }

    private void win() {
        numWins += 1;
        avgHealthRemaining += currentHitPoints;
    }

    //Returns true if the attack kills the target
    public boolean attack(Combatant target) {
        for (int i = 0; i < numAttacks; i++) {
            int attackRoll = this.basicAttackToHit();

            if (attackRoll == (20 + toHit)) { //Critical case, double number of damage dice
                target.setCurrentHitPoints(target.getHitPoints() - (this.basicAttackDamage() + damageDice.roll()));
            } else if (attackRoll == 1 + toHit) { //Natural 1 case, auto miss
                continue;
            } else if (attackRoll > target.getAC()) { //Regular hit case
                target.setCurrentHitPoints(target.getHitPoints() - this.basicAttackDamage());
            } else { //Miss case
                continue;
            }

            if (target.getHitPoints() <= 0) {
                this.win();
                return true;
            }
        }
        return false;
    }

    private int basicAttackDamage() {
        return damageDice.roll() + addToDamage;
    }

    private int basicAttackToHit() {
        return d20.roll() + toHit;
    }

    public int initiativeRoll() {
        return d20.roll() + initiativeMod;
    }

    public void resetHitPoints() {
        this.currentHitPoints = maxHitPoints;
    }

    public int getAC() {
        return AC;
    }

    public int getHitPoints() {
        return currentHitPoints;
    }

    public void setCurrentHitPoints(int hitPoints) {
        this.currentHitPoints = hitPoints;
    }

    public double getNumWins() {
        return numWins;
    }

    public double getAvgHealthRemaining() {
        return avgHealthRemaining;
    }

}
