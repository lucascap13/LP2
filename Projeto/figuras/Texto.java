package figuras;
import java.awt.*;


public class Texto extends Figure
{
    private String cadeia;
    private int estilo;
    private int tamLetra;

    public Texto(int x, int y, String cadeia, int estilo, int r, int g, int b, int w, int h, int tamLetra, boolean focado)
    {
        super(x, y, r, g, b, w, h, focado);
        this.cadeia = cadeia;
        this.estilo = estilo;
        this.tamLetra = tamLetra;
    }
    
    public void paint(Graphics g, boolean focado)
    {
        Graphics2D g2d = (Graphics2D) g;
        if(focado)
        {
            g2d.setColor(new Color(this.r, this.g, this.b));
            g.setFont(new Font("FonteShow", estilo, tamLetra));
            g2d.drawString(this.cadeia, this.x, this.y);
            FontMetrics metrics = g.getFontMetrics();
            this.h= metrics.getHeight();
            this.w = metrics.stringWidth(cadeia);
            g2d.setColor(Color.red);
            g2d.drawRect(this.x-2, this.y - 18, this.w+5, 25);
        }
        else
        {
            g2d.setColor(new Color(this.r, this.g, this.b));
            g.setFont(new Font("FonteShow", estilo, tamLetra));
            g2d.drawString(this.cadeia, this.x, this.y);
            FontMetrics metrics = g.getFontMetrics();
            this.h= metrics.getHeight();
            this.w = metrics.stringWidth(cadeia);
        }
    }
    
    public boolean clicked(int posX, int posY)
    {
        if((posX >= this.x && posX <= (this.w+this.x)) && (posY <= this.y && posY >= (this.y-this.h)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
