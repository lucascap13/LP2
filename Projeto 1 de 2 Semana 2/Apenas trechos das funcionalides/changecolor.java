//As duas primeiras linhas sao apenas para criar uma lista de tintas e um "foco" somente para as tintas.

ArrayList<Figure> tintas = new ArrayList<Figure>();
Figure balde = null;

//Dentro do ouvinte de teclado adicionei esses dois Else ifs que chamam os métodos implementados dentro de Figure.

                    else if (evt.getKeyCode() == 18 && focus != null && balde != null) //Altera a cor do fundo da figura em foco para a cor selecionada atraves do ALT
                    {
                        focus.changeFundo(balde.r, balde.g, balde.b);
                    }
                    else if (evt.getKeyCode() == 10 && focus != null && balde != null) //Altera a cor do contorno ou fonte para a cor selecionada atraves do ENTER
                    {
                        focus.changeContorno(balde.r, balde.g, balde.b);
                    }


//A partir daqui tem as modificações dentro do método Paint

public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D gfd = (Graphics2D) g;
        tintas.add(new Rect(20,55, 10, 10, 255, 0, 0, 255, 0, 0));          //botao vermelho
        tintas.add(new Rect(40,55, 10, 10, 0, 255, 0, 0, 255, 0));          //botao verde
        tintas.add(new Rect(20,75, 10, 10, 0, 0, 255, 0, 0, 255));          //botao azul
        tintas.add(new Rect(40,75, 10, 10, 255, 20, 145, 255, 20, 145));    //botao rosa
        tintas.add(new Rect(20,95, 10, 10, 255, 255, 255, 255, 255, 255));  //botao branco
        tintas.add(new Rect(40,95, 10, 10, 255, 255, 0, 255, 255, 0));      //botao amarelo

        for(Figure tinta: this.tintas)
        {
            tinta.paint(g);    //Mostra os "botoes" na tela
        }
        
        tituloTintas.paint(g);   //String "Tintas" em cima dos botoes
        dica1.paint(g);
        dica2.paint(g);

        for (Figure fig: this.figs)
        {
            fig.paint(g);
        }
        
        if (focus != null)
        {
            if (focus.getClass().equals(Texto.class))
            {
                gfd.setColor(Color.red);
                gfd.drawRect(focus.x-2, focus.y - 18, focus.w+5, 25);
            }
            else
            {
                gfd.setColor(Color.RED);
                gfd.drawRect(focus.x-2, focus.y-2, focus.w+4, focus.h+4);
            }
        }
        
        if (balde != null)  //focar a tinta selecionada
        {
            gfd.setColor(Color.cyan);
            gfd.drawOval(balde.x-2, balde.y-2, balde.w+4, balde.h+4);
        }
    }
}

