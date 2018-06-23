import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// Đây đc coi như là cửa sổ vẽ
public class GameWindow extends JFrame {

    GameCanvas gameCanvas;
    long lastTime = 0;

    public GameWindow() {

//        Cai dat kich thuoc cua so nhin thay
        this.setSize(1024, 600);

//        Khai bao ham setup gamecanvas
        this.setupGameCanvas();

//       Goi ham event
        this.event();

//        Set hien thi
        this.setVisible(true);
    }

    private void setupGameCanvas() {

//        Khoi tao doi tuong giay ve
        this.gameCanvas = new GameCanvas();

//Dua gamecanvas vao window
        this.add(this.gameCanvas);

    }

    //    Khai bao ham keyboardEvent
    private void keyboardEvent() {

        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped");
            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    gameCanvas.player.x -= 8;
                }

                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    gameCanvas.player.x += 8;
                }

                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    gameCanvas.player.y -= 8;
                }

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    gameCanvas.player.y += 8;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyTyped");

            }
        });
    }

    //    Khai Bao ham windowEvent
    private void windowEvent() {

        //        Tat cua so va dong chuong trinh
        this.addWindowListener(new WindowAdapter() {

            @Override

            public void windowClosing(WindowEvent e) {

                System.exit(1);

            }
        });
    }

    //    Khai bao ham chua tat ca cac event
    private void event() {
        this.keyboardEvent();
        this.windowEvent();
    }


    public void gameLoop() {

////        Ve 5 enemy
//        for (int i = 0; i < 5; i++) {
//            this.gameCanvas.createEnemy();
//        }

        while (true) {

            long currentTime = System.nanoTime(); // So mili giay tinh tu 0h 0p 0s ngay 01/01 nam 1970 den gio - Unix Time
//
//      Kiem tra xem thoi gian co dung vs dieu kien hay k

            if (currentTime - lastTime >= 17000000) {

//                Goi ham di chuyen
                this.gameCanvas.runAll();

//                In tat ca cac nhan vat ra
                this.gameCanvas.renderAll();

//                this.gameCanvas.repaint();

//                Lay thoi gian
                this.lastTime = currentTime;
            }

        }
    }
}