// This class represents any character in the game
public abstract class Character {
    protected String name; // name of the character

    // Constructor to set the character's name
    public Character(String name) {
        this.name = name;
    }

    // Getter for the character's name
    public String getName() {
        return name;
    }

    // Abstract method - all subclasses must define how the character "speaks"
    public abstract String speak();
}

