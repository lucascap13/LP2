//Dentro do ouvinte de teclado adicionei essa parte para mover a figura em foco atraves das setas. O valor 3 é apenas a quantidade de pixels que ira andar ao clicar uma vez.

                    else if (evt.getKeyCode() == 39 && focus != null || evt.getKeyCode() == 37 && focus != null)  //Move Horizontalmente através das setas
                    {
                        if (evt.getKeyCode() == 39) //Seta para direita
                        {
                            int dx = 3;
                            focus.moverHori(dx);
                        }
                        else
                        {
                            int dx = -3;
                            focus.moverHori(dx);   //Seta para esquerda
                        }
                    }
                    else if (evt.getKeyCode() == 40 && focus != null || evt.getKeyCode() == 38 && focus != null)  //Move Verticalmente através das setas
                    {
                        if (evt.getKeyCode() == 40)
                        {
                            int dy = 3;
                            focus.moverVerti(dy);
                            repaint();
                        }
                        else
                        {
                            int dy = -3;
                            focus.moverVerti(dy);
                            repaint();
                        }
                    }
