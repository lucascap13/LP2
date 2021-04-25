//Dentro do paint da Frame

        if (focus != null)
        {
            if (focus.getClass().equals(Texto.class))
            {
                gfd.setColor(Color.red);
                gfd.drawRect(focus.x-2, focus.y - 18, focus.w+5, 25);
            }
            else
            {
                gfd.setColor(Color.RED);
                gfd.drawRect(focus.x-2, focus.y-2, focus.w+4, focus.h+4);
                gfd.setColor(Color.CYAN);
                gfd.fillOval(focus.x+focus.w-4,focus.y-3,7,7);
                gfd.fillOval(focus.x-3,focus.y+focus.h-6,7,7);
            }
