//Essa funcionalidade no projeto encontra-se dentro da frame e faz parte do mouseListener.
public void mouseClicked(MouseEvent evt)
                {   
                    Point ponto = new Point(getMousePosition());
                    int mouseX = ponto.x; 
                    int mouseY = ponto.y;
                    focus = null;
                    for (Figure fig: figs)
                    {
                        if (fig.getClass().equals(Texto.class))  //Verificar se a classe é um texto
                        {
                            if((mouseX >= fig.x && mouseX <= (fig.w+fig.x)) && (mouseY <= fig.y && mouseY >= (fig.y-fig.h))) //Checar a area do texto
                            {
                                focus = fig;
                                repaint();
                                break;
                            }
                        }
                        else if((mouseX >= fig.x && mouseX <= (fig.w+fig.x)) && (mouseY >= fig.y && mouseY <= (fig.y+fig.h))) //Checar a area das demais figuras    
                        {
                            focus = fig;
                            repaint();
                            break;
                        }
                        else    //Desfocar figura ao clicar no fundo da janela
                        {
                            focus = null;
                            repaint();
                        }
                    }
                }
            }
        );
