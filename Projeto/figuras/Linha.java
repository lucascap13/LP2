package figuras;
import java.awt.*;

public class Linha extends Figure
{

    public Linha (int x, int y, int r, int g, int b, int w, int h)
    {
        super(x, y, r, g, b, w, h);
    }

    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.r, this.g, this.b));
        g2d.drawLine(this.x, this.y, this.x+this.w, this.y+this.h);     
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
