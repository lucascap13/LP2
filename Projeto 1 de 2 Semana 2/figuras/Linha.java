package figuras;
import java.awt.*;

public class Linha extends Figure
{

    public Linha (int x, int y, int r, int g, int b, int w, int h)
    {
        super(x, y, r, g, b, w, h);
    }

    Point pontoInicial = new Point(this.x, this.y);
    Point pontoFinal = new Point((this.x + this.w), (this.y+this.h));
    
    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.r, this.g, this.b));
        g2d.drawLine(this.x, this.y, pontoFinal.x, pontoFinal.y);     
    }
}
