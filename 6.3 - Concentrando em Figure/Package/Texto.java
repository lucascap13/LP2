package figuras;
import java.awt.*;
public class Texto extends Figure
{
    private String cadeia;
    private int estilo;

    public Texto(int x, int y, String cadeia, int estilo, int r, int g, int b)
    {
        this.x = x;
        this.y = y;
        this.cadeia = cadeia;
        this.estilo = estilo;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.r, this.g, this.b));
        g.setFont(new Font("FonteShow", estilo, 20));
        g2d.drawString(this.cadeia, this.x, this.y);
    }
}
