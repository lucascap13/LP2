package figuras;
import java.awt.*;


public class Texto extends Figure
{
    private String cadeia;
    private int estilo;
    public int altura;
    public int largura;

    public Texto(int x, int y, String cadeia, int estilo, int r, int g, int b, int w, int h, int altura, int largura)
    {
        super(x, y, r, g, b, w, h);
        this.cadeia = cadeia;
        this.estilo = estilo;
        this.altura = altura;
    }
    
    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.r, this.g, this.b));
        g.setFont(new Font("FonteShow", estilo, 20));
        g2d.drawString(this.cadeia, this.x, this.y);
        FontMetrics metrics = g.getFontMetrics();
        this.altura = metrics.getHeight();
        this.h = this.altura;
        this.largura = metrics.stringWidth(cadeia);
        this.w = this.largura;
    }
}
