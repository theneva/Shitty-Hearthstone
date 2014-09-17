package fu.bar.game;

import fu.bar.card.Minion;

public class ActiveMinion extends Minion {
    private int health;

    public ActiveMinion(final Minion minion) {
        super(minion.getName(), minion.getText(), minion.getCost(),
                minion.getAttack(), minion.getDefaultHealth(), minion.getType());
        this.health = minion.getDefaultHealth();
    }

    public void takeDamage(final int amountOfDamage) {
        this.setHealth(this.getHealth() - amountOfDamage);
    }

    public void attackOtherMinion(final ActiveMinion defender) {
        defender.takeDamage(this.getAttack());
        this.takeDamage(defender.getAttack());
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(final int health) {
        this.health = health;
    }
}
