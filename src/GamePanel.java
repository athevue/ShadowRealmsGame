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
        gameManager = new GameManager();

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.CENTER);

        inputField = new JTextField();
        submitButton = new JButton("Submit");
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(submitButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);

        updateDisplay();

        submitButton.addActionListener(e -> processInput());
        inputField.addActionListener(e -> processInput());
    }

    private void processInput() {
        String input = inputField.getText().trim();
        inputField.setText("");
        if (input.isEmpty() || gameManager.isGameOver()) return;

        displayArea.append("\nYour guess: " + input + "\n");
        String result = gameManager.checkAnswer(input);
        displayArea.append(result + "\n");

        if (!gameManager.isGameOver()) {
            updateDisplay();
        }
    }

    private void updateDisplay() {
        displayArea.append("\nYou arrive at: " + gameManager.getCurrentLocationName() + "\n");
        displayArea.append(gameManager.getCurrentNPC().getName() + " says:\n");
        displayArea.append("\"" + gameManager.getCurrentNPC().getClue() + "\"\n");
    }
}
