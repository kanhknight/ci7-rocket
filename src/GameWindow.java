import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// Đây đc coi như là cửa sổ vẽ
public class GameWindow extends JFrame {

    GameCanvas gameCanvas;
    long lastTime = 0;

    public GameWindow(){
        this.setSize(1024, 600);
//        Khoi tao doi tuong giay ve
        this.gameCanvas = new GameCanvas();
//Dua gamecanvas vao window
        this.add(this.gameCanvas);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped");
            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode()==KeyEvent.VK_LEFT){
                    gameCanvas.positionXPlayer -=3;
                }

                if (e.getKeyCode()==KeyEvent.VK_RIGHT){
                    gameCanvas.positionXPlayer +=3;
                }

                if (e.getKeyCode()==KeyEvent.VK_UP){
                    gameCanvas.positionYPlayer -=3;
                }

                if (e.getKeyCode()==KeyEvent.VK_DOWN){
                    gameCanvas.positionYPlayer +=3;
                }

            }
            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyTyped");

            }
        });

//        Tat cua so va dong chuong trinh
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });

//        Set hien thi
        this.setVisible(true);
    }

    public void gameLoop(){
        while (true){
            long currentTime = System.nanoTime(); // So mili giay tinh tu 0h 0p 0s ngay 01/01 nam 1970 den gio - Unix Time
//            Kiem tra xem thoi gian co dung vs dieu kien hay k
            if(currentTime - lastTime >= 17000000){
                this.gameCanvas.positionXStar -=2;

                this.gameCanvas.positionXEnemy +=3;

                this.gameCanvas.renderAll();
//                this.gameCanvas.repaint();
                this.lastTime = currentTime;
            }

        }
    }
}