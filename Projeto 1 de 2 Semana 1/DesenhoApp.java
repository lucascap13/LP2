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
    Figure focus = null;
    Random rand = new Random();

    DesenhoFrame ()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.darkGray);
        this.setTitle("Figuras Diversas");
        this.setSize(900, 720);

        this.addMouseListener
        (
            new MouseAdapter()
            {
                public void mouseClicked(MouseEvent evt)
                {   
                    Point ponto = new Point(getMousePosition());
                    int mouseX = ponto.x; 
                    int mouseY = ponto.y;
                    focus = null;
                    for (Figure fig: figs)
                    {
                        if (fig.getClass().equals(Texto.class))
                        {
                            if((mouseX >= fig.x && mouseX <= (fig.w+fig.x)) && (mouseY <= fig.y && mouseY >= (fig.y-fig.h)))
                            {
                                focus = fig;
                                repaint();
                                break;
                            }
                        }
                        else if((mouseX >= fig.x && mouseX <= (fig.w+fig.x)) && (mouseY >= fig.y && mouseY <= (fig.y+fig.h)))     
                        {
                            focus = fig;
                            repaint();
                            break;
                        }
                        else
                        {
                            focus = null;
                            repaint();
                        }
                    }
                }
            }
        );

        this.addKeyListener
        (
            new KeyAdapter()
            {
                public void keyPressed (KeyEvent evt)
                {
                    int x = rand.nextInt(750);
                    int y = rand.nextInt(570);
                    int w = rand.nextInt(130);
                    int h = rand.nextInt(105);
                    int r = rand.nextInt(255);
                    int g = rand.nextInt(255);
                    int b = rand.nextInt(255);
                    int angIni = rand.nextInt(360);
                    int angArc = rand.nextInt(360);
                    int style = rand.nextInt(3);
                    
                    if (evt.getKeyChar() == 'r')       //desenha retangulo
                    {
                        Rect ret = new Rect(x, y, w, h, r, g, b);
                        figs.add(ret);
                    }
                    else if (evt.getKeyChar() == 'e')  //desenha elipse
                    {
                        figs.add(new Ellipse(x, y, w, h, r, g, b));
                    }
                    else if (evt.getKeyChar() == 'l')  //desenha linha
                    {
                        figs.add(new Linha(x,y, r, g, b, w, h));
                    }
                    else if (evt.getKeyChar() == 'a')  //desenha arco
                    {
                        figs.add(new Arco(x, y, w, h, angIni, angArc, r, g, b));
                    }
                    else if (evt.getKeyChar() == 't')  //escreve texto
                    {
                        Scanner s = new Scanner(System.in);
                        String cadeia = s.nextLine();
                        figs.add(new Texto(x, y, cadeia, style, r, g, b, 0, 0, 0, 0));   //perguntar ao prof se posso fazer de outra forma
                    }
                    repaint();
                }
            }
        );
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D gfd = (Graphics2D) g;
        for (Figure fig: this.figs)
        {
            fig.paint(g);
        }
        
        if (focus != null)
        {
            if (focus.getClass().equals(Texto.class))
            {
                gfd.setColor(Color.red);
                gfd.drawRect(focus.x-2, focus.y - 18, focus.w+5, 25);
            }
            else
            {
                gfd.setColor(Color.RED);
                gfd.drawRect(focus.x-2, focus.y-2, focus.w+4, focus.h+4);
            }
        }
        focus.paint(g);
    }
}

