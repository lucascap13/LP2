package figuras;
import java.awt.*;

public class Arco
{
    private int x, y;
    private int w, h;
    private int anguloInicial;
    private int anguloArco;
    private Color linha;

    public Arco (int x, int y, int w, int h, int anguloInicial, int anguloArco, Color linha)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.anguloInicial = anguloInicial;
        this.anguloArco = anguloArco;
        this.linha = linha;
    }
    public void paint (Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(linha);
        g2d.drawArc(this.x, this.y, this.w, this.h, this.anguloInicial, this.anguloArco);
    }
}
