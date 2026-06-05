package game.ui;

import game.model.Collectible;
import game.model.Entity;
import game.model.Player;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private final Player player;
    private final List<Entity> entities;
    private final Random random;
    private int score;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);

        player = new Player(WIDTH / 2 - 30, HEIGHT - 40);
        entities = new ArrayList<>();
        entities.add(player);

        random = new Random();
        score = 0;

        setupKeyBindings();

        Timer timer = new Timer(16, this);
        timer.start();
    }

    private void setupKeyBindings() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.setMovingLeft(true);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.setMovingRight(true);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.setMovingLeft(false);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.setMovingRight(false);
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Entity entity : entities) {
            entity.draw(g);
        }

        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 10, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        }

        List<Entity> itemsToRemove = new ArrayList<>();

        for (Entity entity : entities) {
            entity.update();

            if (entity instanceof Collectible collectible) {

                if (collectible.getBounds().intersects(player.getBounds())) {
                    score += 10;
                    itemsToRemove.add(collectible);
                } else if (collectible.isOffScreen(HEIGHT)) {
                    itemsToRemove.add(collectible);
                }
            }
        }

        entities.removeAll(itemsToRemove);
        repaint();
    }
}