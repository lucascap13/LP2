//Dentro de qualquer uma das figuras

public void paint (Graphics g, boolean focado)
    {
        Graphics2D g2d = (Graphics2D) g;
        if(focado)
        {
            g2d.setColor(new Color(rf, gf, bf));
            g2d.fillRect(x, y, w, h);
            g2d.setColor(new Color(this.r, this.g, this.b));
            g2d.drawRect(this.x,this.y, this.w,this.h);
            g2d.setColor(Color.RED);
            g2d.drawRect(this.x-2, this.y-2, this.w+4, this.h+4);
            this.focar(g);
        }
        else
        {
            g2d.setColor(new Color(rf, gf, bf));
            g2d.fillRect(x, y, w, h);
            g2d.setColor(new Color(this.r, this.g, this.b));
            g2d.drawRect(this.x,this.y, this.w,this.h);
        }
    }
