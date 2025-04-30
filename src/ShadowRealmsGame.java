import javax.swing.*;

public class ShadowRealmsGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Shadow Realms Game"); // Create the window for the game
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Makes sure the app closes when the window is closed
        frame.setSize(600, 400); // Set the size of the game window
        frame.add(new GamePanel()); // Add the GamePanel which has all the game logic and UI
        frame.setVisible(true); // Make the window visible to the player

    }
}


