import javax.swing.*;
class DesenhoApp
{
    public static void main (String[] args)
    {
        DesenhoFrame frame = new DesenhoFrame();
        frame.setVisible(true);
    }
}

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
