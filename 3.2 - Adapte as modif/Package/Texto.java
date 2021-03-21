package figuras;
import java.awt.*;
public class Texto
{
    private int x, y;
    private Color cor_fonte;
    private String cadeia;
    private int tamanho;
    private int estilo;

    public Texto(int x, int y, String cadeia, int tamanho, int estilo, Color cor_fonte)
    {
        this.x = x;
        this.y = y;
        this.cadeia = cadeia;
        this.tamanho = tamanho;
        this.estilo = estilo;
        this.cor_fonte = cor_fonte;
    }
    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(cor_fonte);
        g.setFont(new Font("FonteShow", estilo, tamanho));
        g2d.drawString(this.cadeia, this.x, this.y);
    }
}
