import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import figuras.*;
import java.util.Random;
import java.util.ArrayList;

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
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();

    DesenhoFrame ()
    {
        this.addKeyListener(
            new KeyAdapter()
            {
                public void keyPressed (KeyEvent evt)
                {
                    int x = rand.nextInt(350);
                    int y = rand.nextInt(350);
                    int w = rand.nextInt(50);
                    int h = rand.nextInt(50);
                    int xf = rand.nextInt(350);  //duvida se posso utilizar pois somente a subclasse "linha" tera isso e nao é algo comum às outras.
                    int yf = rand.nextInt(350);  //duvida se posso utilizar pois somente a subclasse "linha" tera isso e nao é algo comum às outras.
                    if (evt.getKeyChar() == 'r')
                    {
                        Rect r = new Rect(x, y, w, h);
                        figs.add(r);
                    }
                    else if (evt.getKeyChar() == 'e')
                    {
                        figs.add(new Ellipse(x, y, w, h));
                    }
                    else if (evt.getKeyChar() == 'l')
                    {
                        figs.add(new Linha(x,y, y, x));
                    }
                    repaint();
                }
            }
        );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.darkGray);
        this.setTitle("Figuras Diversas");
        this.setSize(350, 350);
    }

    public void paint (Graphics g)
    {
        super.paint(g);
        for (Figure fig: this.figs)
        {
            fig.paint(g);
        }
    }
}

