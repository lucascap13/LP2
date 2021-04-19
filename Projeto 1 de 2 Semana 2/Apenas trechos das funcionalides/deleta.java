//Mais uma vez dentro do trecho de ouvinte de teclado.

else if (evt.getKeyCode() == 127)   //Deleta um objeto da Lista de Figuras
                    {
                        for (Figure fig:figs)
                        {
                            if (fig == focus)
                            {
                                figs.remove(fig);
                                focus = null;
                                repaint();
                            }
                        }
                    }
