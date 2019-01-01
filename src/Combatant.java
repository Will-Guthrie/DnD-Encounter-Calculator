public class Combatant {

    private int AC;
    private int hitPoints;
    private int numAttacks;
    private int toHit;
    private int addToDamage;
    private Dice damageDice;
    private Dice d20;
    private double numWins;
    private double avgHealthRemaining;

    Combatant(int AC, int hitPoints, int numAttacks, int toHit, int addToDamage, int damageDice) {
        this.AC = AC;
        this.hitPoints = hitPoints;
        this.numAttacks = numAttacks;
        this.toHit = toHit;
        this.addToDamage = addToDamage;
        this.damageDice = new Dice(damageDice);
        this.d20 = new Dice(20);
    }

    private void win() {
        numWins++;
        avgHealthRemaining += hitPoints;
    }

    //Returns true if the attack kills the target
    public boolean attack(Combatant target) {
        for (int i = 0; i < numAttacks; i++) {
            if (this.basicAttackToHit() > target.getAC()) {
                target.setHitPoints(target.getHitPoints() - this.basicAttackDamage());
                if (target.getHitPoints() <= 0) {
                    this.win();
                    return true;
                }
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

    public int getAC() {
        return AC;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public double getNumWins() {
        return numWins;
    }

    public double getAvgHealthRemaining() {
        return avgHealthRemaining;
    }

}
