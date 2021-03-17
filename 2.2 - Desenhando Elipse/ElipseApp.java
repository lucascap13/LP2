import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ElipseApp
{
    public static void main (String[] args)
    {
        ElipseFrame frame = new ElipseFrame();
        frame.setVisible(true);
    }
}

class ElipseFrame extends JFrame
{
    Elipse e1;
    Elipse e2;
    Elipse e3;
    Elipse e4;

    ElipseFrame()
    {
        //Pra parar de rodar quando a janela fechar
        this.addWindowListener (
            new WindowAdapter()
            {
                public void windowClosing (WindowEvent e)
                {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Elipse");
        this.setSize(350,350);
        this.e1 = new Elipse(150, 160, 40, 90, Color.black, Color.blue);
        this.e2 = new Elipse(20, 160, 60, 120, Color.green, Color.red);
        this.e3 = new Elipse(150, 50, 50, 30, Color.cyan, Color.magenta);
        this.e4 = new Elipse(260, 240, 50, 90, Color.white, Color.blue);
    }

    public void paint (Graphics g)
    {
        super.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
        this.e4.paint(g);
    }
}

class Elipse
{
    //Propriedades da Elipse
    int x, y;
    int w, h;
    Color fundo;
    Color contorno;

    //Construtor da Elipse
    Elipse (int x, int y, int w, int h, Color fundo, Color contorno)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.fundo = fundo;
        this.contorno = contorno;
    }
    
    void print ()
    {
        System.out.format("Elipse de tamanho (%d, %d) na posicao (%d, %d) \n", this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(fundo);
        g2d.fillOval(this.x, this.y, this.w, this.h);
        g2d.setColor(contorno);
        g2d.drawOval(this.x, this.y, this.w, this.h);

    }
}