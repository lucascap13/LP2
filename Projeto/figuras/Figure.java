package figuras;
import java.awt.Graphics;

public abstract class Figure 
{
    public int x;
    public int y;
    public int w;
    public int h;
    public int r, g, b;   //Para cor de contorno
    public int rf, gf, bf;  //Para cor de fundo


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

    public void changeContorno(int cor1, int cor2, int cor3)
    {
        this.r = cor1;
        this.g = cor2;
        this.b = cor3;
    }

    public void changeFundo(int cor1, int cor2, int cor3)
    {
        this.rf = cor1;
        this.gf = cor2;
        this.bf = cor3;
    }

    public void moverHori(int posX)
    {
        this.x = this.x + posX;
    }
    public void moverVerti(int posY)
    {
        this.y = this.y + posY;
    }

    public void movMouse(int posX, int posY)
    {
        this.x += posX;
        this.y += posY;
    }
    public void movTexto(int posX, int posY)
    {
        this.x = posX;
        this.y = posY;
    }
    public void RedimensionarSupDir(int posX, int posY)
    {
        this.h += (this.y - posY);
        if (this.h <= 1)
        {
            this.h = 3;
        }
        else
        {
            this.y = posY;
        }
        this.w = (posX - this.x);
        if (this.w <= 0)
        {
            this.w = 3;
        }

    }
    public void RedimensionarInfEsq(int posX, int posY)
    {
        this.h = (posY - this.y);
        this.w += this.x - posX;
        if (this.w <= 1)
        {
            this.w = 3;
        }
        else
        {
            this.x = posX;
        }
        if (this.h <= 0)
        {
            this.h = 3;
        }
    }
    
}