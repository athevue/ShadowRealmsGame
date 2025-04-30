import java.util.ArrayList;

public class GameManager {
    private Player player;
    private ArrayList<NPC> npcs;
    private int currentIndex;
    private int attempts;

    public GameManager() {
        player = new Player("Hero", 100);
        npcs = new ArrayList<>();
        npcs.add(new NPC("Old Man", "I speak without a mouth and hear without ears. I have no body, but I come alive with wind. What am I?", "echo", "Mysterious Key"));
        npcs.add(new NPC("Wise Woman", "The answer you seek lies at the heart of the forest. But only those who dare face the terror will find it.", "wolves", "Ancient Scroll"));
        npcs.add(new NPC("Cursed Knight", "I stand tall but never grow. I have no lungs yet I need air. What am I?", "fire", "Sword of Strength"));
        currentIndex = 0;
        attempts = 0;
    }

    public boolean isGameOver() {
        return !player.isAlive() || currentIndex >= npcs.size();
    }

    public String getCurrentLocationName() {
        switch (currentIndex) {
            case 0: return "Mysterious Town Square";
            case 1: return "Ancient Forest";
            case 2: return "Cursed Castle";
            default: return "Unknown";
        }
    }

    public NPC getCurrentNPC() {
        return npcs.get(currentIndex);
    }

    public String checkAnswer(String input) {
        NPC npc = getCurrentNPC();
        attempts++;
        if (npc.checkAnswer(input)) {
            player.addItem(npc.getReward());
            String msg = "Correct! You received: " + npc.getReward() + "\n";
            currentIndex++;
            attempts = 0;
            if (currentIndex >= npcs.size()) {
                return msg + "\nYou used " + player.getInventory() + " to lift the curse. You win!";
            }
            return msg + "Proceeding to next location.";
        } else {
            if (attempts == 1) return "Incorrect. Hint: " + npc.getHint1();
            if (attempts == 2) return "Incorrect again. Hint: " + npc.getHint2();
            player.loseHealth(100);
            return "Wrong again. You failed. " + npc.getName() + " delivers judgment.\nYou lost. Game Over.";
        }
    }
}
