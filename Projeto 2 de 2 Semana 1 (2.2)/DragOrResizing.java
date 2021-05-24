this.addMouseMotionListener
        (
            new MouseAdapter()
            {
                public void mouseDragged(MouseEvent evt)
                {
                    Point mousePos = new Point(getMousePosition());
                    //              ~~~~ Redimensionar pela ponta superior direita ~~~~
                    if(!dragging)
                    {
                        if(clickX >= (focus.x+focus.w)-6 && clickY <= (focus.y)+6)
                        {
                            focus.RedimensionarSupDir(mousePos.x, mousePos.y);
                            clickX = mousePos.x;
                            clickY = mousePos.y;
                            resizing = true;
                            repaint();
                        }
                        //              ~~~~ Redimensionar pela ponta inferior esquerda ~~~~
                        else if(clickX <= (focus.x+6) && clickY >= (focus.y+focus.h)-6)
                        {
                            focus.RedimensionarInfEsq(mousePos.x, mousePos.y);
                            clickX = mousePos.x;
                            clickY = mousePos.y;
                            resizing = true;
                            repaint();
                        }
                        //              ~~~~ Redimensionar pela ponta inferior direita ~~~~
                        else if(clickX <= (focus.x+focus.w+6) && clickY >= (focus.y+focus.h) -6)
                        {
                            focus.RedimensionarInfDir(mousePos.x, mousePos.y);
                            clickX = mousePos.x;
                            clickY = mousePos.y;
                            resizing = true;
                            repaint();
                        }
                        //              ~~~~ Redimensionar pela ponta superior esquerda ~~~~
                        else if(clickX <= (focus.x)+6 && clickY <= (focus.y)+6)
                        {
                            focus.RedimensionarSupEsq(mousePos.x, mousePos.y);
                            clickX = mousePos.x;
                            clickY = mousePos.y;
                            resizing = true;
                            repaint();
                        }
                    }
                    if(!resizing)
                    {
                        if(focus.clicked(clickX, clickY))
                        {
                            focus.MoverMouse(mousePos.x - clickX, mousePos.y - clickY);
                            clickX = mousePos.x;
                            clickY = mousePos.y;
                            dragging = true;
                            repaint();
                        }
                    }
                }
            }
        );
