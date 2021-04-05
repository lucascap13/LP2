package figuras;
import java.awt.*;

public class Rect extends Figure
{
    private int w, h;

    public Rect (int x, int y, int w, int h, int r, int g, int b)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.r = r;
        this.g = g;
        this.b = b;

    }

    public void paint (Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillRect(x, y, w, h);
        g2d.setColor(new Color(this.r, this.g, this.b));
        g2d.drawRect(this.x,this.y, this.w,this.h);
    }
}
