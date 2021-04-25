Dentro do ouvinte de teclado...

                    //              ~~~~ Alterar foco ~~~~
                    else if (evt.getKeyCode() == 17)
                    {
                        for (Figure fig: figs)
                        {
                            if (focus != fig)
                            {
                                focus=fig;
                                figs.remove(fig);
                                figs.add(fig);
                                break;
                            }
                        }
                    }
