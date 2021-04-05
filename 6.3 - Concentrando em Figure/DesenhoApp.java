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
                    int xf = rand.nextInt(350);
                    int yf = rand.nextInt(350);
                    int r = rand.nextInt(255);
                    int g = rand.nextInt(255);
                    int b = rand.nextInt(255);
                    int angIni = rand.nextInt(360);
                    int angArc = rand.nextInt(360);
                    int style = rand.nextInt(3);
                    if (evt.getKeyChar() == 'r')
                    {
                        Rect ret = new Rect(x, y, w, h, r, g, b);
                        figs.add(ret);
                    }
                    else if (evt.getKeyChar() == 'e')  //desenha elipse
                    {
                        figs.add(new Ellipse(x, y, w, h, r, g, b));
                    }
                    else if (evt.getKeyChar() == 'l')  //desenha retangulo
                    {
                        figs.add(new Linha(x,y, xf, yf, r, g, b));
                    }
                    else if (evt.getKeyChar() == 'a')  //desenha arco
                    {
                        figs.add(new Arco(x, y, w, h, angIni, angArc, r, g, b));
                    }
                    else if(evt.getKeyChar() == 't')  //escreve texto
                    {
                        Scanner s = new Scanner(System.in);
                        String cadeia = s.nextLine();
                        figs.add(new Texto(x, y, cadeia, style, r, g, b));
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

