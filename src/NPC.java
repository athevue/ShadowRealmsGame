public class NPC extends Character implements Talkable {
    private String clue, answer, reward;

    public NPC(String name, String clue, String answer, String reward) {
        super(name);
        this.clue = clue;
        this.answer = answer;
        this.reward = reward;
    }

    public String getClue() {
        return clue;
    }

    public String getReward() {
        return reward;
    }

    public boolean checkAnswer(String input) {
        return input.equalsIgnoreCase(answer);
    }

    public String getHint1() {
        switch(answer.toLowerCase()) {
            case "echo": return "It travels without form.";
            case "wolves": return "They howl and travel in packs.";
            case "fire": return "It burns without breath.";
            default: return "";
        }
    }

    public String getHint2() {
        switch(answer.toLowerCase()) {
            case "echo": return "You hear it in valleys.";
            case "wolves": return "Predators of the night.";
            case "fire": return "It needs oxygen but has no lungs.";
            default: return "";
        }
    }

    @Override
    public String speak() {
        return clue;
    }
}
