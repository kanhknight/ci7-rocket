import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {
    BufferedImage starImage;
    BufferedImage enemyImage;
    BufferedImage playerImage;

//    BackBuffered
// 1. Cai ma ban se thay
//    2. Cai ma dang sau duoc tinh toan de hien thi
//    Co che lat anh nhu viec ban ve 1 hinh lien tuc leen cac trang cua quyen sach roi sau do lat hinh lien tuc

    BufferedImage backBuffered;
//    Graphics nay la cua buffered nhe'
    Graphics graphics;

    int positionXStar = 1024;
    int positionYStar = 300;

    int positionXEnemy = 0;
    int positionYEnemy = 200;

    int positionXPlayer = 512;
    int positionYPlayer = 300;

//    Camelcase: starImage
//    snakecase: star_image
//    windowcase: StarImage

//    Khai báo giấy vẽ
    public GameCanvas(){

//        Chung ta can co khung ma buffered va dinh dang he mau cho anh se ve len backbuffered
        this.backBuffered = new BufferedImage(1024,600, BufferedImage.TYPE_4BYTE_ABGR);
//        Lay co ve cua backbuffered de dua vao graphics
        this.graphics = this.backBuffered.getGraphics();

//        Khai bao kich thuoc giay ve bang voi cua so
        this.setSize(1024, 600);

//        Load Hinh Anh
//        Tai sao lai nhu the nay ?
//        Boi cos the se crash neu nhu khong co anh hoac anh bij thay the try catch de nam dc loi cua cong viec caan kiem tra

        try {
            this.starImage = ImageIO.read(new File("resources/images/star.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            this.enemyImage = ImageIO.read(new File("resources/images/circle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setVisible(true);


        try {
            this.playerImage = ImageIO.read(new File("resources/images/circle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
//    Bat dau khai bao but ve
    protected void paintComponent(Graphics g) {
//        Ve background
//        g.setColor(Color.BLACK);
//        g.fillRect(0,0,1024,600);
//        g.drawImage(this.starImage, positionXStar, positionYStar, 40,40, null);
//        g.drawImage(this.enemyImage, positionXEnemy, positionYEnemy, 10,10,null);
//        g.drawImage(this.playerImage, positionXPlayer, positionYPlayer, 10, 10, null);
//        Mat nguoi co the nhin thay 60 Frame / Giay
//        Chung ta dang de khug hinh chay qua nhanh nen k the nhin thay.
        // Bay gio ta se set 1s ve 60 hinh de co the nhin thay
//         Moi hih xuat hien sap xi trong 0,017s
//        Vay cu 0.017 mu 9 ve 1 hinh

//        Lat to giay len
        g.drawImage(this.backBuffered, 0,0,null);
    }

    public void renderAll(){
        this.graphics.setColor(Color.BLACK);
        this.graphics.fillRect(0,0,1024,600);
        this.graphics.drawImage(this.starImage, positionXStar, positionYStar, 40,40, null);
        this.graphics.drawImage(this.enemyImage, positionXEnemy, positionYEnemy, 10,10,null);
        this.graphics.drawImage(this.playerImage, positionXPlayer, positionYPlayer, 10, 10, null);
        this.repaint();
    }
}
