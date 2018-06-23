import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Player {

    public BufferedImage image;
    public int x;
    public int y;
    public int width;
    public int height;
    public int velocityx;
    public int velocityy;

    private Random random;

    public Player(BufferedImage image, int x, int y, int width, int height, int velocityx, int velocityy) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocityx = velocityx;
        this.velocityy = velocityy;
        this.random = new Random();
    }

    public void render(Graphics graphics) {
        graphics.drawImage(
                this.image,
                this.x,
                this.y,
                this.width,
                this.height, null
        );
    }

    public void run() {
        if (this.x > 1004) {
            this.x = 0;
            this.y = this.random.nextInt(558);
        }

        if (this.x < 0) {
            this.x = 1004;
            this.y = this.random.nextInt(558);
        }

        if (this.y > 558) {
            this.x = this.random.nextInt(1004);
            this.y = 0;
        }

        if (this.y < 0) {
            this.x = this.random.nextInt(1004);
            this.y = 558;
        }
    }


}
