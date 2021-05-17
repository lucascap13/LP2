package figuras;
import java.awt.*;

public class Ellipse extends Figure
{
    public Ellipse (int x, int y, int w, int h, int r, int g, int b, int rf, int gf, int bf)
    {
        super(x, y, r, g, b, w, h);
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
    
    public boolean clicked(int posX, int posY)
    {
        if((posX >= this.x && posX <= (this.w+this.x)) && (posY >= this.y && posY <= (this.y+this.h)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void Focar (Graphics g)
    {
        Graphics2D gfd = (Graphics2D) g;
        gfd.setColor(Color.RED);
        gfd.drawRect(this.x-2, this.y-2, this.w+4, this.h+4);
        gfd.setColor(Color.CYAN);
        gfd.fillOval(this.x+this.w-4,this.y-3,7,7);
        gfd.fillOval(this.x-3,this.y+this.h-6,7,7);
    }
}
