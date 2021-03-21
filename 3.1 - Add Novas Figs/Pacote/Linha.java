package figuras;
import java.awt.*;

public class Linha
{
    private int xi, xf;
    private int yi, yf;
    private Color linha;

    public Linha (int xi, int yi, int xf, int yf, Color linha)
    {
        this.xi = xi;
        this.yi = yi;
        this.xf = xf;
        this.yf = yf;
        this.linha = linha;
    }

    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(linha);
        g2d.drawLine(xi, yi, xf, yf);
    }
}
