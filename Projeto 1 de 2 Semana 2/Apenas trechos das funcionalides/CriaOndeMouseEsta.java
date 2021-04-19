//Dentro do trecho de ouvinte de teclado...

                    Point mousePos = new Point(getMousePosition());
                    
                    if (evt.getKeyChar() == 'r')       //desenha retangulo
                    {
                        figs.add(new Rect(mousePos.x, mousePos.y, w, h, r, g, b, rf, gf, bf));
                    }
                    else if (evt.getKeyChar() == 'e')  //desenha elipse
                    {
                        
                        figs.add(new Ellipse(mousePos.x, mousePos.y, w, h, r, g, b, rf, gf, bf));
                    }
                    else if (evt.getKeyChar() == 'l')  //desenha linha
                    {
                        
                        figs.add(new Linha(mousePos.x, mousePos.y, r, g, b, w, h));
                    }
                    else if (evt.getKeyChar() == 'a')  //desenha arco
                    {
                        
                        figs.add(new Arco(mousePos.x, mousePos.y, w, h, angIni, angArc, r, g, b));
                    }
                    else if (evt.getKeyChar() == 't')  //escreve texto
                    {
                        
                        Scanner s = new Scanner(System.in);
                        String cadeia = s.nextLine();
                        figs.add(new Texto(mousePos.x, mousePos.y, cadeia, style, r, g, b, 0, 0, 20));
                    }
