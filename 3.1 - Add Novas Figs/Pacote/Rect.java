package figuras;
import java.awt.*;

public class Rect
{
    private int x, y;
    private int w, h;
    private Color fundo;
    private Color contorno;

    public Rect (int x, int y, int w, int h, Color fundo, Color contorno)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.fundo = fundo;
        this.contorno = contorno;
    }

    public void print ()
    {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n", this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(fundo);
        g2d.fillRect(this.x, this.y, this.w, this.h);
        g2d.setColor(contorno);
        g2d.drawRect(this.x,this.y, this.w,this.h);
    }
}
