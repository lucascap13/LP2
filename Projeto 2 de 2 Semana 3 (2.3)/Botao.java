import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import figuras.Figure;
import interfaces.iVisible;

public class Botao implements iVisible
{
    protected int Idn, x, y, w, h, r, g, b, fndR, fndG, fndB;
    private Figure simbolo;
    protected boolean focado;
    
    public Botao(int Idn, int x, int y, int w, int h,int r, int g, int b, boolean focado, Figure simbolo)
    {
        this.Idn = Idn;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.r = r;
        this.g = g;
        this.b = b;
        this.focado = focado;
        this.simbolo = simbolo;
        this.fndR = simbolo.rf;
        this.fndG = simbolo.gf;
        this.fndB = simbolo.bf;
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

    public void paint(Graphics g, boolean focado)
    {
        Graphics2D gbd = (Graphics2D) g;
        if(!focado)
        {
            gbd.setColor(new Color(this.r,this.g,this.b));
            gbd.fillRect(this.x,this.y,this.w,this.h);
        }
        else
        {
            gbd.setColor(new Color(200,24,225));
            gbd.fillRect(this.x,this.y,this.w,this.h);
        }
        this.simbolo.paint(g,false);
    }
}
