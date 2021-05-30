package figuras;
import java.awt.*;

public class Linha extends Figure
{

    public Linha (int x, int y, int r, int g, int b, int w, int h, boolean focado)
    {
        super(x, y, r, g, b, w, h, focado);
    }

    public void paint(Graphics g, boolean focado)
    {
        Graphics2D g2d = (Graphics2D) g;
        if(focado)
        {
            g2d.setColor(new Color(this.r, this.g, this.b));
            g2d.drawLine(this.x, this.y, this.x+this.w, this.y+this.h);
            g2d.setColor(Color.RED);
            g2d.drawRect(this.x-2, this.y-2, this.w+4, this.h+4);
            this.focar(g);
        }
        else
        {
            g2d.setColor(new Color(this.r, this.g, this.b));
            g2d.drawLine(this.x, this.y, this.x+this.w, this.y+this.h);
        }
    }
}
