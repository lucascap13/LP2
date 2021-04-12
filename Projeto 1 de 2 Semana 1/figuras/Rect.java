package figuras;
import java.awt.*;
import java.util.Random;

public class Rect extends Figure
{
    Random rand = new Random();
    private Color cor_fundo = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));   //Gerar Cor de Fundo Aleatoriamente
    
    public Rect (int x, int y, int w, int h, int r, int g, int b)
    {
        super(x, y, r, g, b, w, h);
    }

    public void paint (Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(cor_fundo);
        g2d.fillRect(x, y, w, h);
        g2d.setColor(new Color(this.r, this.g, this.b));
        g2d.drawRect(this.x,this.y, this.w,this.h);
    }
}
