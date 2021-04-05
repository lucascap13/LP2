package figuras;
import java.awt.*;

public class Linha extends Figure
{
    private int xi, xf;
    private int yi, yf;

    public Linha (int xi, int yi, int xf, int yf)
    {
        this.xi = xi;
        this.yi = yi;
        this.xf = xf;
        this.yf = yf;
    }

    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(xi, yi, xf, yf);
    }
}
