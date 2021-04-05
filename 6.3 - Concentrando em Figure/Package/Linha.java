package figuras;
import java.awt.*;

public class Linha extends Figure
{
    private int xf;
    private int yf;

    public Linha (int x, int y, int xf, int yf, int r, int g, int b)
    {
        this.x = x;
        this.y = y;
        this.xf = xf;
        this.yf = yf;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.r, this.g, this.b));
        g2d.drawLine(x, y, xf, yf);
    }
}
