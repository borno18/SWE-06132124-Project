package game.main;

import game.ui.GamePanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Catch the Square");
            GamePanel panel = new GamePanel();

            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.pack(); 
            frame.setLocationRelativeTo(null); 
            frame.setVisible(true);
        });
    }
}