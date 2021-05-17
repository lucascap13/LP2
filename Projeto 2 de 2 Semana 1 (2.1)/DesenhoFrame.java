//Unica mudanca esta na linha 7
class DesenhoFrame extends JFrame
{
    DesenhoFrame ()
    {
        //              ~~~~ Propriedades da tela ~~~~
        add(new Janela());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Editor Gráfico");
        this.setLocation(480,230);
        this.setSize(900, 720);
    }
}
