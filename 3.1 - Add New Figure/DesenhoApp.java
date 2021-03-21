import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import figuras.*;

class DesenhoApp
{
    public static void main (String[] args)
    {
        DesenhoFrame frame = new DesenhoFrame();
        frame.setVisible(true);
    }
}

class DesenhoFrame extends JFrame
{
    private static final long serialVersionUID = 1L;
    Rect r1,r2;
    Ellipse e1, e2, e3;
    Arco a1;

    DesenhoFrame ()
    {
        this.addWindowListener(
            new WindowAdapter()
            {
                public void windowClosing (WindowEvent e)
                {
                    System.exit(0);
                }
            }
        );
        this.getContentPane().setBackground(Color.darkGray);
        this.setTitle("Figuras Diversas");
        this.setSize(1024, 768);
        this.r1 = new Rect(300,300, 200,250, Color.black, Color.red);
        this.e1 = new Ellipse(650, 250, 200, 350, Color.magenta, Color.cyan);
        this.e2 = new Ellipse(813, 80, 20, 35, Color.red, Color.black);
        this.e3 = new Ellipse(862, 80, 20, 35, Color.red, Color.black);
        this.a1 = new Arco(800, 90, 90, 90, 180, 180, Color.white);
    }

    public void paint (Graphics g)
    {
        super.paint(g);
        this.r1.paint(g);
        this.e1.paint(g);
        this.a1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
        this.r2.paint(g);
    }
}

