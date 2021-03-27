import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import figuras.*;
import java.util.*;

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
    ArrayList <Rect> rs = new ArrayList <Rect>();
    ArrayList <Ellipse> es  = new ArrayList <Ellipse>();

    DesenhoFrame ()
    {
        this.addKeyListener(
            new KeyAdapter()
            {
                public void keyPressed (KeyEvent evt)
                {
                    int codigo = evt.getKeyCode();
                    Random rand = new Random();
                    if (codigo == KeyEvent.VK_R)
                    {
                        int x = rand.nextInt(600);
                        int y = rand.nextInt(350);
                        int w = rand.nextInt(350);
                        int h = rand.nextInt(400);
                        int r = rand.nextInt(250);
                        int g = rand.nextInt(250);
                        int b = rand.nextInt(250);
                        Color fundo = new Color(r, g, b);
                        int r2 = rand.nextInt(250);
                        int g2 = rand.nextInt(250);
                        int b2 = rand.nextInt(250);
                        Color contorno = new Color(r2, g2, b2);
                        rs.add(new Rect(x, y, w, h, fundo, contorno));
                        repaint();
                    }
                    else if (codigo == KeyEvent.VK_E)
                    {
                        int x = rand.nextInt(700);
                        int y = rand.nextInt(300);
                        int w = rand.nextInt(350);
                        int h = rand.nextInt(300);
                        int r = rand.nextInt(250);
                        int g = rand.nextInt(250);
                        int b = rand.nextInt(250);
                        Color fundo = new Color(r, g, b);
                        int r2 = rand.nextInt(250);
                        int g2 = rand.nextInt(250);
                        int b2 = rand.nextInt(250);
                        Color contorno = new Color(r2, g2, b2);
                        es.add(new Ellipse(x, y, w, h, fundo, contorno));
                        repaint();
                    }
                }
            }
        );

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.darkGray);
        this.setTitle("Figuras Diversas");
        this.setSize(1024, 768);
    }

    public void paint (Graphics g)
    {
        super.paint(g);
        for(Rect r: this.rs)
        {
            r.paint(g);
        }
        for(Ellipse e: this.es)
        {
            e.paint(g);
        }
    }
}

