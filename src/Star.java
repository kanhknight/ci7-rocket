import java.awt.*;
import java.awt.image.BufferedImage;

public class Star {

    public BufferedImage image;
    public int x;
    public int y;
    public int width;
    public int height;
    public int velocityx;
    public int velocityy;



//Ham Constructor khoi tao doi tuong!
//    Trong mot lop doi tuong co the co nhieu constructor voi dieu kien la khac tham so dau vao
//    Khi gọi cần có tham số đầu vào theo constructor đã khai báo

    public Star(BufferedImage image, int x, int y, int width, int height, int velocityx, int velocityy) {
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
    }

    public void render(Graphics graphics){
        graphics.drawImage(
                this.image,
                this.x,
                this.y,
                this.width,
                this.height,null
                );
    }
}
