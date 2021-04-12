package figuras;
import java.awt.*;
import java.util.Random;

public class Ellipse extends Figure
{
    Random rand = new Random();
    private Color cor_fundo = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));    //Gerar Cor de Fundo Aleatoriamente

    public Ellipse (int x, int y, int w, int h, int r, int g, int b)
    {
        super(x, y, r, g, b, w, h);
        this.w = w;
        this.h = h;
    }

    public void paint (Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(cor_fundo);
        g2d.fillOval(this.x, this.y, this.w, this.h);
        g2d.setColor(new Color(this.r, this.g, this.b));
        g2d.drawOval(this.x, this.y, this.w, this.h);
        
    }
}
