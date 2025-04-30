import java.util.ArrayList;

// This class manages the overall flow of the game
public class GameManager {
    private Player player;
    private ArrayList<NPC> npcs; // List of all NPCs in the game
    private int currentIndex;    // Keeps track of current NPC index
    private int attempts;        // Counts how many tries the player made per riddle

    // Constructor sets up the player and initializes NPCs with riddles and rewards
    public GameManager() {
        player = new Player("Hero", 100); // starting health is 100
        npcs = new ArrayList<>();

        // Adding NPCs with their riddle, correct answer, and the item they give
        npcs.add(new NPC(
                "Old Man",
                "I speak without a mouth and hear without ears. I have no body, but I come alive with wind. What am I?",
                "echo",
                "Mysterious Key"
        ));
        npcs.add(new NPC(
                "Wise Woman",
                "The answer you seek lies at the heart of the forest. But only those who dare face the terror will find it.",
                "wolves",
                "Ancient Scroll"
        ));
        npcs.add(new NPC(
                "Cursed Knight",
                "I stand tall but never grow. I have no lungs yet I need air. What am I?",
                "fire",
                "Sword of Strength"
        ));

        currentIndex = 0; // Start from the first NPC
        attempts = 0;     // Reset attempts for the first riddle
    }

    // Game ends if player dies or finishes all riddles
    public boolean isGameOver() {
        return !player.isAlive() || currentIndex >= npcs.size();
    }

    // Gives a description of the player's current location in the game
    public String getCurrentLocationName() {
        switch (currentIndex) {
            case 0: return "Mysterious Town Square";
            case 1: return "Ancient Forest";
            case 2: return "Cursed Castle";
            default: return "Unknown";
        }
    }

    // Gets the current NPC the player is interacting with
    public NPC getCurrentNPC() {
        return npcs.get(currentIndex);
    }

    // Checks if the player's answer is correct and updates the game state
    public String checkAnswer(String input) {
        NPC npc = getCurrentNPC(); // Get the NPC the player is currently facing
        attempts++; // Add to attempts count

        if (npc.checkAnswer(input)) {
            // If answer is right, give the reward and move to next NPC
            player.addItem(npc.getReward());
            String msg = "Correct! You received: " + npc.getReward() + "\n";
            currentIndex++; // move to next NPC
            attempts = 0; // reset attempts for next riddle

            if (currentIndex >= npcs.size()) {
                // Game is finished
                return msg + "\nYou used " + player.getInventory() + " to lift the curse. You win!";
            }

            return msg + "Proceeding to next location.";
        } else {
            // If wrong answer, give hints or end game after 3 tries
            if (attempts == 1) return "Incorrect. Hint: " + npc.getHint1();
            if (attempts == 2) return "Incorrect again. Hint: " + npc.getHint2();

            // Third wrong attempt results in failure
            player.loseHealth(100); // One-shot loss for simplicity
            return "Wrong again. You failed. " + npc.getName() + " delivers judgment.\nYou lost. Game Over.";
        }
    }
}
