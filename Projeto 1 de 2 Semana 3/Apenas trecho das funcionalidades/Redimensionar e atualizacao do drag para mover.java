this.addMouseMotionListener
        (
            new MouseAdapter()
            {
                public void mouseDragged(MouseEvent evt)
                {
                    Point mousePos = new Point(getMousePosition());
                    //              ~~~~ Verificar se é texto para mover de forma especifica ~~~~
                    if(focus.getClass().equals(Texto.class))
                    {
                        focus.movTexto(mousePos.x, mousePos.y);
                        repaint();
                    }
                    //              ~~~~ Redimensionar pela ponta superior direita ~~~~
                    if(mousePos.x >= (focus.x+focus.w)-6 && mousePos.y <= (focus.y)+6)
                    {
                        focus.RedimensionarSupDir(mousePos.x, mousePos.y);
                        repaint();
                    }
                    //              ~~~~ Redimensionar pela ponta inferior esquerda ~~~~
                    else if(mousePos.x <= (focus.x+6) && mousePos.y >= (focus.y+focus.h)-6)
                    {
                        focus.RedimensionarInfEsq(mousePos.x, mousePos.y);
                        repaint();
                    }
                    //              ~~~~ Mover figura ~~~~
                    else if (mousePos.x >= focus.x && mousePos.x < (focus.x + focus.w) && mousePos.y >= focus.y && mousePos.y <= (focus.y+focus.h))
                    {
                        focus.movMouse(mousePos.x - clickX, mousePos.y - clickY);
                        clickX = mousePos.x;
                        clickY = mousePos.y;
                        repaint();
                    }
                }
            }
        );
