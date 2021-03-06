package figuras;
import java.awt.*;

public class Arco extends Figure
{
    private int w, h;
    private int anguloInicial;
    private int anguloArco;

    public Arco (int x, int y, int w, int h, int anguloInicial, int anguloArco, int r, int g, int b)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.anguloInicial = anguloInicial;
        this.anguloArco = anguloArco;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    public void paint (Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.r, this.g, this.b));
        g2d.drawArc(this.x, this.y, this.w, this.h, this.anguloInicial, this.anguloArco);
    }
}
