public void mousePressed(MouseEvent evt)
                {   
                    Point mousePos = new Point(getMousePosition());
                    clickX = mousePos.x;
                    clickY = mousePos.y;
                    for (Figure fig: figs)
                    {
                        //              ~~~~ Focar figura selecionada ~~~~
                        if(fig.clicked(mousePos.x, mousePos.y))
                        {
                            focus = fig;
                            fig.focado = true;
                            for(Figure fig2:figs) //Garante que eu so tenha uma figura em foco
                            {
                                if(fig2 != fig && fig.focado == true) fig2.focado = false;
                            }
                            figs.remove(fig);
                            figs.add(fig);
                            repaint();
                            break;
                        }
                        //              ~~~~ Remover foco ao clicar fora da figura e fora do menu de botoes ~~~~
                        else
                        {
                            if(mousePos.x >= 135)
                            {
                                fig.focado = false;
                                focus = null;
                                repaint();
                            }
                        }
                    }
                    //              ~~~~ Selecionar botao ~~~~
                    for (Botao button: botoes)
                    {
                        if(button.clicked(mousePos.x, mousePos.y) && button.Idn <= 6)
                        {
                            focusB = button;
                            button.focado = true;
                            repaint();
                            break;
                        }
                        //              ~~~~ Remover botão que esta em foco e criar a figura ~~~~
                        else
                        {
                            if(focusB!=null && mousePos.x >= 135)
                            {
                                switch(focusB.Idn)
                                {
                                    case 1:
                                    figs.add(new Rect(mousePos.x-25, mousePos.y-40, 50, 90, 255,255,255, focusTinta.fndR, focusTinta.fndG, focusTinta.fndB, false));
                                    focus = figs.get(figs.size()-1);
                                    break;
                                    case 2:
                                    figs.add(new Arco(mousePos.x-20, mousePos.y-20, 100, 80,focusTinta.fndR, focusTinta.fndG, focusTinta.fndB, false));
                                    focus = figs.get(figs.size()-1);
                                    break;
                                    case 3:
                                    figs.add(new Ellipse(mousePos.x-30, mousePos.y-20, 80, 60, 255, 255, 255,focusTinta.fndR, focusTinta.fndG, focusTinta.fndB, false));
                                    focus = figs.get(figs.size()-1);
                                    break;
                                    case 4:
                                    Scanner s = new Scanner(System.in);
                                    String cadeia = s.nextLine();
                                    figs.add(new Texto(mousePos.x+15, mousePos.y+15, cadeia, 2,focusTinta.fndR, focusTinta.fndG, focusTinta.fndB, 0, 0, 20,false));
                                    focus = figs.get(figs.size()-1);
                                    break;
                                    case 5:
                                    figs.add(new Linha(mousePos.x-35, mousePos.y-20,focusTinta.fndR, focusTinta.fndG, focusTinta.fndB, 80, 50, false));
                                    focus = figs.get(figs.size()-1);
                                    break;
                                    case 6:
                                    figs.add(new RoundRect(mousePos.x-25, mousePos.y-20, 255, 255, 255, 50, 40, focusTinta.fndR, focusTinta.fndG, focusTinta.fndB, false));
                                    focus = figs.get(figs.size()-1);
                                    break;
                                }
                                button.focado = false;
                                focusB = null;
                                repaint();
                            }
                        }
                        //              ~~~~ Verifica qual cor foi selecionada ~~~~
                        if(button.clicked(mousePos.x, mousePos.y) && button.Idn>=7 && button.Idn <= 12)
                        {
                            focusTinta = button;
                            button.focado = true;
                            repaint();
                            break;
                        }
                        //              ~~~~ Verifica se o botao "Limpar foi clicado" ~~~~
                        if(button.clicked(mousePos.x, mousePos.y) && button.Idn == 13)
                        {
                            figs.clear();
                            repaint();
                        }
                    }
                }
