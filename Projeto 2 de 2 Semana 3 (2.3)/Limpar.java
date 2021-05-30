
botoes.add(new Botao(13, 20, 350, 85,40, 255,220,200, false, new Texto(20, 380, "Limpar", 1, 136, 68, 0, 0, 0, 25, false)));

//dentro do contexto de mouse pressed

//              ~~~~ Verifica se o botao "Limpar foi clicado" ~~~~
                        if(button.clicked(mousePos.x, mousePos.y) && button.Idn == 13)
                        {
                            figs.clear();
                            repaint();
                        }
