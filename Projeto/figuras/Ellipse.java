package figuras;
import java.awt.*;

public class Ellipse extends Figure
{
    public Ellipse (int x, int y, int w, int h, int r, int g, int b, int rf, int gf, int bf, boolean focado)
    {
        super(x, y, r, g, b, w, h,focado);
        this.rf = rf;
        this.gf = gf;
        this.bf = bf;
    }

    public void paint (Graphics g, boolean focado)
    {
        Graphics2D g2d = (Graphics2D) g;
        if(focado)
        {
            g2d.setColor(new Color(rf, gf, bf));
            g2d.fillOval(this.x, this.y, this.w, this.h);
            g2d.setColor(new Color(this.r, this.g, this.b));
            g2d.drawOval(this.x, this.y, this.w, this.h);
            g2d.setColor(Color.RED);
            g2d.drawRect(this.x-2, this.y-2, this.w+4, this.h+4);
            this.focar(g);
        }
        else
        {
            g2d.setColor(new Color(rf, gf, bf));
            g2d.fillOval(this.x, this.y, this.w, this.h);
            g2d.setColor(new Color(this.r, this.g, this.b));
            g2d.drawOval(this.x, this.y, this.w, this.h);
        }
    }
}
