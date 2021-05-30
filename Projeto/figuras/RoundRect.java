package figuras;
import java.awt.*;

public class RoundRect extends Figure
{
    public RoundRect (int x, int y, int r, int g, int b, int w, int h, int rf, int gf, int bf, boolean focado)
    {
        super(x, y, r, g, b, w, h, focado);
        this.rf = rf;
        this.gf = gf;
        this.bf = bf;

    }
    public void paint (Graphics g, boolean focado)
    {
        Graphics2D g2d = (Graphics2D) g;
        if(focado)
        {
            g2d.setColor(new Color(this.rf, this.gf, this.bf));
            g2d.fillRoundRect(this.x, this.y, this.w, this.h, 60, 25);
            g2d.setColor(new Color(this.r, this.g, this.b));
            g2d.drawRoundRect(this.x, this.y, this.w, this.h, 60, 25);
            g2d.setColor(Color.RED);
            g2d.drawRect(this.x-2, this.y-2, this.w+4, this.h+4);
            this.focar(g);
        }
        else
        {
            g2d.setColor(new Color(this.rf, this.gf, this.bf));
            g2d.fillRoundRect(this.x, this.y, this.w, this.h, 60, 25);
            g2d.setColor(new Color(this.r, this.g, this.b));
            g2d.drawRoundRect(this.x, this.y, this.w, this.h, 60, 25);
        }
    }
}
