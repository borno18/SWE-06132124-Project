package game.model;
import java.awt.Color;
import java.awt.Graphics;

public class Player extends Entity {
    private int velocityX;
    private static final int SPEED = 5;
    private static final int BOUNDARY_WIDTH = 400;
    public Player(int x, int y) {
        super(x, y, 60, 15);
        this.velocityX = 0;
    }
    public void setMovingLeft(boolean moving) {
        this.velocityX = moving ? -SPEED : 0;
    }
    public void setMovingRight(boolean moving) {
        this.velocityX = moving ? SPEED : 0;
    }
    @Override
    public void update() {
        x += velocityX;

        if (x < 0) {
            x = 0;
        } else if (x + width > BOUNDARY_WIDTH) {
            x = BOUNDARY_WIDTH - width;
        }
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }
}