package figuras;
import java.awt.*;

public class Ellipse extends Figure
{
    public Ellipse (int x, int y, int w, int h, int r, int g, int b, int rf, int gf, int bf)
    {
        super(x, y, r, g, b, w, h);
        this.w = w;
        this.h = h;
        this.rf = rf;
        this.gf = gf;
        this.bf = bf;

    }

    public void paint (Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(rf, gf, bf));
        g2d.fillOval(this.x, this.y, this.w, this.h);
        g2d.setColor(new Color(this.r, this.g, this.b));
        g2d.drawOval(this.x, this.y, this.w, this.h);
        
    }
}
