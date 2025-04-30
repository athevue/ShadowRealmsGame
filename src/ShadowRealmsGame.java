import javax.swing.*;

public class ShadowRealmsGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Shadow Realms Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.add(new GamePanel());
        frame.setVisible(true);
    }
}

