...
this.addKeyListener
        (
            new KeyAdapter()
            {
                public void keyPressed (KeyEvent evt)
                {
                    Point mousePos = new Point(getMousePosition());
                    //              ~~~~ Cria Retângulo ~~~~
                    if (evt.getKeyChar() == 'r')
                    {
                        figs.add(new Rect(mousePos.x, mousePos.y, 50, 90, 0,255,0, 145, 145, 145));
                        focus = figs.get(figs.size()-1);  //A alteração foi feita nessa linha na chamada de todas as figuras.
                    }
                  ...
                  ...
