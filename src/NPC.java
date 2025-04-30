// NPC is a character that gives clues and rewards based on answers
public class NPC extends Character implements Talkable {
    private String clue, answer, reward;

    // Constructor initializes all the necessary info about the NPC
    public NPC(String name, String clue, String answer, String reward) {
        super(name); // call Character constructor
        this.clue = clue;
        this.answer = answer;
        this.reward = reward;
    }

    // This returns the clue (or riddle) the NPC gives
    public String getClue() {
        return clue;
    }

    // This is what the player gets if they answer correctly
    public String getReward() {
        return reward;
    }

    // Checks if the player's input matches the NPC's answer
    public boolean checkAnswer(String input) {
        return input.equalsIgnoreCase(answer); // ignore case for flexibility
    }

    // First hint given after one wrong answer
    public String getHint1() {
        // Hints are specific to each answer
        switch(answer.toLowerCase()) {
            case "echo": return "It travels without form.";
            case "wolves": return "They howl and travel in packs.";
            case "fire": return "It burns without breath.";
            default: return "";
        }
    }

    // Second (stronger) hint if they mess up again
    public String getHint2() {
        switch(answer.toLowerCase()) {
            case "echo": return "You hear it in valleys.";
            case "wolves": return "Predators of the night.";
            case "fire": return "It needs oxygen but has no lungs.";
            default: return "";
        }
    }

    // Overrides speak from Character and Talkable
    @Override
    public String speak() {
        return clue;
    }
}
