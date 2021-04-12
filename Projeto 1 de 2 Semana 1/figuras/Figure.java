package figuras;
import java.awt.Graphics;

public abstract class Figure 
{
    public int x;
    public int y;
    public int w;
    public int h;
    public int r, g, b;   //Para cor de contorno

    protected Figure(int x, int y, int r, int g, int b, int w, int h)
    {
        this.x = x;
        this.y = y;
        this.r = r;
        this.g = g;
        this.b = b;
        this.w = w;
        this.h = h;
    }
    
    public abstract void paint(Graphics g);
}
