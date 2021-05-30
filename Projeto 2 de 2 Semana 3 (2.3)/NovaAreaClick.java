//Dentro do contexto de Mouse Motion
if(!dragging)
                    {
                        //              ~~~~ Redimensionar pela ponta superior direita ~~~~
                        if(clickX <= focus.x+focus.w && clickX >= focus.x+focus.w-6 && clickY >= focus.y && clickY <= focus.y+6) //Alteracao aqui
                        {
                            focus.RedimensionarSupDir(mousePos.x, mousePos.y);
                            clickX = mousePos.x;
                            clickY = mousePos.y;
                            resizing = true;
                            repaint();
                        }
                        //              ~~~~ Redimensionar pela ponta inferior esquerda ~~~~
                        else if(clickX >= focus.x && clickX <= focus.x+6 && clickY <= focus.y+focus.h && clickY >= focus.y+focus.h-6 && clickX >= 135)//Alteracao aqui
                        {
                            focus.RedimensionarInfEsq(mousePos.x, mousePos.y);
                            clickX = mousePos.x;
                            clickY = mousePos.y;
                            resizing = true;
                            repaint();
                        }
                        //              ~~~~ Redimensionar pela ponta inferior direita ~~~~
                        if(clickX <= focus.x + focus.w && clickX >= focus.x+focus.w-6 && clickY <= focus.y+focus.h && clickY >= focus.y+focus.h-6)//Alteracao aqui
                        {
                            focus.RedimensionarInfDir(mousePos.x, mousePos.y);
                            clickX = mousePos.x;
                            clickY = mousePos.y;
                            resizing = true;
                            repaint();
                        }
                        //              ~~~~ Redimensionar pela ponta superior esquerda ~~~~
                        else if(clickX >= focus.x && clickX <= focus.x+6 && clickY >= focus.y && clickY <= focus.y+6 && clickX >=135)//Alteracao aqui
                        {
                            focus.RedimensionarSupEsq(mousePos.x, mousePos.y);
                            clickX = mousePos.x;
                            clickY = mousePos.y;
                            resizing = true;
                            repaint();
                        }
                    }
