import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel {
    private GameManager gameManager;
    private JTextField inputField;
    private JTextArea displayArea;
    private JButton submitButton;

    public GamePanel() {
        setLayout(new BorderLayout());
        gameManager = new GameManager();  // Set up the game logic handler

        // This area will show all the messages and game info
        displayArea = new JTextArea();
        displayArea.setEditable(false);  // Don't let player type here
        displayArea.setLineWrap(true);   // So the text wraps nicely
        displayArea.setWrapStyleWord(true);  // Wrap at word boundaries
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.CENTER);

        // Field where player types their guess
        inputField = new JTextField();

        // Button to submit the answer
        submitButton = new JButton("Submit");

        // Panel at the bottom to hold input field and button
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(submitButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);

        updateDisplay();  // Show the first riddle and location

        // When player hits "Enter" or clicks submit, check answer
        submitButton.addActionListener(e -> processInput());
        inputField.addActionListener(e -> processInput());
    }

    // This method handles what happens after player types an answer
    private void processInput() {
        String input = inputField.getText().trim();  // Get what they typed
        inputField.setText("");  // Clear the box for the next input

        // If they didn’t type anything or game already ended, just return
        if (input.isEmpty() || gameManager.isGameOver()) return;

        displayArea.append("\nYour guess: " + input + "\n");  // Show what they typed
        String result = gameManager.checkAnswer(input);       // Check the answer
        displayArea.append(result + "\n");                    // Show feedback

        // If game is still going, show the next riddle/location
        if (!gameManager.isGameOver()) {
            updateDisplay();
        }
    }

    // This shows the next clue and NPC when called
    private void updateDisplay() {
        displayArea.append("\nYou arrive at: " + gameManager.getCurrentLocationName() + "\n");
        displayArea.append(gameManager.getCurrentNPC().getName() + " says:\n");
        displayArea.append("\"" + gameManager.getCurrentNPC().getClue() + "\"\n");
    }
}
