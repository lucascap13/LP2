//Dentro do Paint da Frame

        //              ~~~~ Verificar se o usuário já selecionou alguma tinta e mostrar na tela a tinta selecionada ~~~~
        if (balde != null)
        {
            gfd.setColor(Color.cyan);
            gfd.drawOval(balde.x-2, balde.y-2, balde.w+4, balde.h+4);
            Texto TintaSelecionada = new Texto(10, 145, " Cor atual", 1, balde.r, balde.g, balde.b, 0, 0, 13);
            TintaSelecionada.paint(g);
        }
