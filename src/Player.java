import java.util.ArrayList;

// The Player class represents the user in the game and inherits from Character
public class Player extends Character {
    private int health;
    private ArrayList<String> inventory; // Holds the player's collected items

    // Constructor sets the player's name and starting health
    public Player(String name, int health) {
        super(name); // call the constructor from Character
        this.health = health;
        inventory = new ArrayList<>(); // start with empty inventory
    }

    // Decreases player's health by the damage taken
    public void loseHealth(int dmg) {
        health -= dmg;
        // Basic print to help debug/check status
        System.out.println("Lost " + dmg + " health. Current health: " + health);
    }

    // Adds an item to the player's inventory
    public void addItem(String item) {
        inventory.add(item);
    }

    // Checks if the player is still alive (health above 0)
    public boolean isAlive() {
        return health > 0;
    }

    // Returns the list of items the player has collected
    public ArrayList<String> getInventory() {
        return inventory;
    }

    // Overrides speak method from Character class
    @Override
    public String speak() {
        return "I am " + name + ", ready to solve this realm's mysteries.";
    }
}
