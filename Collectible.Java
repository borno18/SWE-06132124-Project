package game.model;
import java.awt.Color;
import java.awt.Graphics;
public class Collectible extends Entity {
    private final int velocityY;
    public Collectible(int x, int y) {
        super(x, y, 15, 15);
        this.velocityY = 3;
    }
    @Override
    public void update() {
        y += velocityY;
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, width, height);
    }
    public boolean isOffScreen(int screenHeight) {
        return y > screenHeight;
    }
}