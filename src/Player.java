import java.util.ArrayList;

public class Player extends Character {
    private int health;
    private ArrayList<String> inventory;

    public Player(String name, int health) {
        super(name);
        this.health = health;
        inventory = new ArrayList<>();
    }

    public void loseHealth(int dmg) {
        health -= dmg;
        System.out.println("Lost " + dmg + " health. Current health: " + health);
    }

    public void addItem(String item) {
        inventory.add(item);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public ArrayList<String> getInventory() {
        return inventory;
    }

    @Override
    public String speak() {
        return "I am " + name + ", ready to solve this realm's mysteries.";
    }
}
