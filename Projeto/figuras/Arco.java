package figuras;
import java.awt.*;

public class Arco extends Figure
{
    public Arco (int x, int y, int w, int h, int r, int g, int b, boolean focado)
    {
        super(x, y, r, g, b, w, h, focado);
        this.w = w;
        this.h = h;
    }
    
    public void paint (Graphics g, boolean focado)
    {
        Graphics2D g2d = (Graphics2D) g;
        if(focado)
        {
            g2d.setColor(new Color(this.r, this.g, this.b));
            g2d.drawArc(this.x, this.y, this.w, this.h, 90, 180);
            g2d.setColor(Color.RED);
            g2d.drawRect(this.x-2, this.y-2, this.w+4, this.h+4);
            this.focar(g);
        }
        else
        {
            g2d.setColor(new Color(this.r, this.g, this.b));
            g2d.drawArc(this.x, this.y, this.w, this.h, 90, 180);
        }

    }
}
