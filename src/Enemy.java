import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy {
    public BufferedImage image;
    public int x;
    public int y;
    public int width;
    public int height;
    public int velocityx;
    public int velocityy;

    public Enemy(BufferedImage image, int x, int y, int width, int height, int velocityx, int velocityy) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocityx = velocityx;
        this.velocityy = velocityy;
    }

    public void run() {
        this.x += this.velocityx;
        this.y += this.velocityy;
        if (this.x < 0 || this.x > 1014)
            this.velocityx = -this.velocityx;
        if (this.y < 0 || this.y > 575)
            this.velocityy = -this.velocityy;
    }

//    public  void comeback(){
//
//        if(this.x <= 1024){
//            this.x -= this.velocityx;
//        }
//        if (this.x >=0){
//            this.x += this.velocityx;
//        }
//
//        if(this.y >= 0){
//            this.y += this.velocityy;
//        }
//
//        if(this.y <= 600){
//            this.y -= this.velocityy;
//        }
//    }


    public void render(Graphics graphics) {
        graphics.drawImage(
                this.image,
                this.x,
                this.y,
                this.width,
                this.height, null
        );
    }
}
