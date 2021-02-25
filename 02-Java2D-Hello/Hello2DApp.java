import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
        frame.setVisible(true);
    }
}

class Hello2DFrame extends JFrame
{
    public Hello2DFrame (){
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(720, 680);
        getContentPane().setBackground(Color.BLACK);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.cyan);
        g2d.draw3DRect(200, 200, 300, 300, true);
        g2d.drawLine(200,200, 500,500);
        g2d.drawLine(350, 350, 500,200);
        g2d.drawLine(350, 350, 350,500);
        g2d.drawLine(350, 500, 500,200);
        g2d.drawLine(500, 500, 350,200);
        g2d.drawLine(350, 200, 200, 500);
        g2d.drawLine(200, 500, 350,350);
        g2d.setPaint(Color.yellow);
        g2d.drawString("Quantos triângulos você vê ?", 280, 180);
        g2d.setPaint(Color.magenta);
        g2d.drawOval(255,155,200,40);
    }
}