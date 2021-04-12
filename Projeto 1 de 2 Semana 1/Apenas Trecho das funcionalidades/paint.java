//A parte nova é a partir da linha 11, onde desenho retangulo ao redor da figura focada e faço a parte do Z-order.
public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D gfd = (Graphics2D) g;
        for (Figure fig: this.figs)
        {
            fig.paint(g);
        }
        
        if (focus != null)
        {
            if (focus.getClass().equals(Texto.class))  //Focar o texto
            {
                gfd.setColor(Color.red);
                gfd.drawRect(focus.x-2, focus.y - 18, focus.w+5, 25);
            }
            else  //Focar demais figuras
            {
                gfd.setColor(Color.RED);
                gfd.drawRect(focus.x-2, focus.y-2, focus.w+4, focus.h+4);
            }
        }
        focus.paint(g);  //Z-order
    }
