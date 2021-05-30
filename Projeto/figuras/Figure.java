package figuras;
import java.awt.*;
import interfaces.iVisible;
import java.io.Serializable;
import java.awt.Graphics2D;
import java.awt.Graphics;

public abstract class Figure implements iVisible, Serializable
{
    public int x;               //Posicao X inicial       
    public int y;               //Posicao Y inicial    
    public int w;               //Largura
    public int h;               //Altura
    protected int r, g, b;         //Para cor de contorno
    public int rf, gf, bf;      //Para cor de fundo
    public boolean focado;      //Para saber se esta focado


    protected Figure(int x, int y, int r, int g, int b, int w, int h, boolean focado)
    {
        this.x = x;
        this.y = y;
        this.r = r;
        this.g = g;
        this.b = b;
        this.w = w;
        this.h = h;
        this.focado = focado;
    }
    
    //Metodos separados nas subclasses
    public abstract void paint(Graphics g, boolean focado);

    //Metodos "Universais"
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

    public void MoverMouse(int posX, int posY)
    {
        if(this.x <135)
        {
            this.x = 136;
        }
        else
        {
            this.x += posX;
            this.y += posY;
        }
    }

    public void RedimensionarSupDir(int posX, int posY)
    {
        this.w = (posX - this.x);
        this.h += (this.y - posY);
        if (this.h <= 15)
        {
            this.h = 15;
        }
        else
        {
            this.y = posY;
        }
        if (this.w <= 15)
        {
            this.w = 15;
        }
    }

    public void RedimensionarSupEsq(int posX, int posY)
    {
        this.w += (this.x - posX);
        if(this.w <=15)
        {
            this.w = 15;
        }
        else 
        {
            this.x = posX;
        }
        this.h += (this.y - posY);
        if(this.h<=15)
        {
            this.h=15;
        }
        else 
        {
            this.y = posY;
        }

    }

    public void RedimensionarInfEsq(int posX, int posY)
    {
        this.h = (posY - this.y);
        this.w += (this.x - posX);
        if (this.w <= 15)
        {
            this.w = 15;
        }
        else
        {
            this.x = posX;
        }
        if (this.h <= 15)
        {
            this.h = 14;
        }
    }

    public void RedimensionarInfDir(int posX, int posY)
    {
        this.h = Math.abs(this.y - posY);
        this.w = Math.abs(posX - this.x);
        if (this.h <= 15)
        {
            this.h = 15;
        }
        if (this.w <= 15)
        {
            this.w = 15;
        }
    }

    public boolean clicked(int posX, int posY)
    {
        if((posX >= this.x && posX <= (this.w+this.x)) && (posY >= this.y && posY <= (this.y+this.h)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void focar(Graphics g)
    {
        Graphics2D gfd = (Graphics2D)g;
        gfd.setColor(Color.cyan);
        gfd.fillRect(this.x, this.y, 6, 6);
        gfd.fillRect(this.x+this.w-6, this.y, 6,6);
        gfd.fillRect(this.x, this.y+this.h-6, 6,6);
        gfd.fillRect(this.x+this.w-6, this.y+this.h-6,6,6);
        gfd.setColor(Color.MAGENTA);
        gfd.drawRect(this.x, this.y, 6, 6);
        gfd.drawRect(this.x+this.w-6, this.y, 6,6);
        gfd.drawRect(this.x, this.y+this.h-6, 6,6);
        gfd.drawRect(this.x+this.w-6, this.y+this.h-6,6,6);
    }
}
