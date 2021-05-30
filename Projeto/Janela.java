import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import figuras.*;
import java.util.*;

public class Janela extends JPanel
{
    private static final long serialVersionUID = 1L;
    ArrayList<Figure> figs = new ArrayList<Figure>();                                                                 //Lista de figuras
    ArrayList<Botao> botoes = new ArrayList<Botao>();                                                                 //Lista de botoes
    ArrayList<Texto> dicas = new ArrayList<Texto>();                                                                  //Lista de dicas
    Figure focus = null;                                                                                              //Figura em foco      
    Botao focusB, focusTinta = null;                                                                                  //Botao/Tinta em foco
    int clickX, clickY;                                                                                               //Auxiliares para o drag
    Boolean dicasVisiveis = true;                                                                                     //Marcador das dicas
    Boolean dragging = false;                                                                                         //Verificador de movimento
    Boolean resizing = false;                                                                                         //Verificador de redimensionamento
    
    
    @SuppressWarnings({"resource","unchecked"})  //Apenas para tirar 2 warnings, um na parte de criar o texto e outro na parte de salvar
    
    Janela()
    {
        try
        {
            FileInputStream f = new FileInputStream("proj.bin");
            ObjectInputStream object = new ObjectInputStream(f);
            this.figs = (ArrayList<Figure>) object.readObject();
            object.close();
        } catch(Exception x)
        {
            System.out.printf("ERRO!");
        }
        setFocusable(true);
        setDoubleBuffered(true);

        //              ~~~~ Criação dos Botões ~~~~
        botoes.add(new Botao(1, 20,55,40,40, 0, 0, 0, false, new Rect(27, 61, 25, 25, 0, 0, 0, 220, 220, 255, false)));
        botoes.add(new Botao(2, 65,55,40,40, 0, 0, 0, false, new Arco(75, 60, 25, 30, 220, 220, 255, false)));
        botoes.add(new Botao(3, 20,100,40,40, 0, 0, 0, false, new Ellipse(22, 107, 35, 25, 0,0,0, 220, 220, 255, false)));
        botoes.add(new Botao(4, 65,100,40,40, 0, 0, 0, false, new Texto(75, 133, "T", 1, 220, 220, 255, 0, 0, 35, false)));
        botoes.add(new Botao(5, 20,145,40,40, 0, 0, 0, false, new Linha(25, 150, 220, 220, 255, 30, 30, false)));
        botoes.add(new Botao(6, 65,145,40,40, 0, 0, 0, false, new RoundRect(69, 150, 220, 220, 255, 32, 30, 220, 220, 255, false)));
        botoes.add(new Botao(7, 20,205,40,40, 78, 87, 84, false, new Ellipse(27, 211, 25, 25, 255, 0, 0, 255, 0, 0, false)));
        botoes.add(new Botao(8, 65,205,40,40, 78, 87, 84, false, new Ellipse(72, 211, 25, 25, 0, 255, 0, 0, 255, 0, false)));
        botoes.add(new Botao(9, 20,250,40,40, 78, 87, 84, false, new Ellipse(27, 256, 25, 25, 255, 205, 0, 255, 205, 0, false)));
        botoes.add(new Botao(10, 65,250,40,40, 78, 87, 84, false, new Ellipse(72, 256, 25, 25, 0, 255, 255, 0, 255, 255, false)));
        botoes.add(new Botao(11, 20,295,40,40, 78, 87, 84, false, new Ellipse(27, 301, 25, 25, 255, 0, 255, 255, 0, 255, false)));
        botoes.add(new Botao(12, 65,295,40,40, 78, 87, 84, false, new Ellipse(72, 301, 25, 25, 0, 0, 0, 0, 0, 0, false)));
        focusTinta = botoes.get(botoes.size()-1);
        botoes.add(new Botao(13, 20, 350, 85,40, 255,220,200, false, new Texto(20, 380, "Limpar", 1, 136, 68, 0, 0, 0, 25, false)));

        this.addMouseListener
        (
            new MouseAdapter()
            {
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
                public void mouseReleased(MouseEvent evt)
                {
                    dragging = false;
                    resizing = false;
                }
            }
        );

        this.addMouseMotionListener
        (
            new MouseAdapter()
            {
                public void mouseDragged(MouseEvent evt)
                {
                    Point mousePos = new Point(getMousePosition());

                    if(!dragging)
                    {
                        //              ~~~~ Redimensionar pela ponta superior direita ~~~~
                        if(clickX <= focus.x+focus.w && clickX >= focus.x+focus.w-6 && clickY >= focus.y && clickY <= focus.y+6)
                        {
                            focus.RedimensionarSupDir(mousePos.x, mousePos.y);
                            clickX = mousePos.x;
                            clickY = mousePos.y;
                            resizing = true;
                            repaint();
                        }
                        //              ~~~~ Redimensionar pela ponta inferior esquerda ~~~~
                        else if(clickX >= focus.x && clickX <= focus.x+6 && clickY <= focus.y+focus.h && clickY >= focus.y+focus.h-6 && clickX >= 135)
                        {
                            focus.RedimensionarInfEsq(mousePos.x, mousePos.y);
                            clickX = mousePos.x;
                            clickY = mousePos.y;
                            resizing = true;
                            repaint();
                        }
                        //              ~~~~ Redimensionar pela ponta inferior direita ~~~~
                        if(clickX <= focus.x + focus.w && clickX >= focus.x+focus.w-6 && clickY <= focus.y+focus.h && clickY >= focus.y+focus.h-6)
                        {
                            focus.RedimensionarInfDir(mousePos.x, mousePos.y);
                            clickX = mousePos.x;
                            clickY = mousePos.y;
                            resizing = true;
                            repaint();
                        }
                        //              ~~~~ Redimensionar pela ponta superior esquerda ~~~~
                        else if(clickX >= focus.x && clickX <= focus.x+6 && clickY >= focus.y && clickY <= focus.y+6 && clickX >=135)
                        {
                            focus.RedimensionarSupEsq(mousePos.x, mousePos.y);
                            clickX = mousePos.x;
                            clickY = mousePos.y;
                            resizing = true;
                            repaint();
                        }
                    }
                    if(!resizing)
                    {
                        //              ~~~~ Mover figura com mouse ~~~~
                        if(focus.clicked(clickX, clickY))
                        {
                            focus.MoverMouse(mousePos.x - clickX, mousePos.y - clickY);
                            clickX = mousePos.x;
                            clickY = mousePos.y;
                            dragging = true;
                            repaint();
                        }
                    }
                }
            }
        );

        this.addKeyListener
        (
            new KeyAdapter()
            {
                public void keyPressed (KeyEvent evt)
                {
                    Point mousePos = new Point(getMousePosition());
                    //              ~~~~ Criar Retângulo ~~~~
                    if (evt.getKeyChar() == 'r')
                    {
                        figs.add(new Rect(mousePos.x-25, mousePos.y-40, 50, 90, 255,255,255, focusTinta.fndR, focusTinta.fndG, focusTinta.fndB, false));
                        focus = figs.get(figs.size()-1);
                    }
                    //              ~~~~ Criar Elipse ~~~~
                    else if (evt.getKeyChar() == 'e')
                    {
                        figs.add(new Ellipse(mousePos.x-30, mousePos.y-20, 80, 60, 255, 255, 255,focusTinta.fndR, focusTinta.fndG, focusTinta.fndB, false));
                        focus = figs.get(figs.size()-1);
                    }
                    //              ~~~~ Criar linha ~~~~
                    else if (evt.getKeyChar() == 'l')
                    {
                        figs.add(new Linha(mousePos.x-35, mousePos.y-20, focusTinta.fndR, focusTinta.fndG, focusTinta.fndB, 80, 50, false));
                        focus = figs.get(figs.size()-1);
                    }
                    //              ~~~~ Criar Arco ~~~~
                    else if (evt.getKeyChar() == 'a')
                    {
                        figs.add(new Arco(mousePos.x-20, mousePos.y-20, 100, 80, focusTinta.fndR, focusTinta.fndG, focusTinta.fndB, false));
                        focus = figs.get(figs.size()-1);
                    }
                    //              ~~~~ Criar RoundRect ~~~~
                    else if (evt.getKeyChar() == 'j')
                    {
                        figs.add(new RoundRect(mousePos.x-25, mousePos.y-20, 255, 255, 255, 50, 40, focusTinta.fndR, focusTinta.fndG, focusTinta.fndB, false));
                        focus = figs.get(figs.size()-1);
                    }
                    //              ~~~~ Criar Texto ~~~~
                    else if (evt.getKeyChar() == 't')
                    {
                        Scanner s = new Scanner(System.in);
                        String cadeia = s.nextLine();
                        figs.add(new Texto(mousePos.x+15, mousePos.y+15, cadeia, 2, focusTinta.fndR, focusTinta.fndG, focusTinta.fndB, 0, 0, 20,false));
                        focus = figs.get(figs.size()-1);
                    }
                    //              ~~~~ Mover com Seta para direita ~~~~
                    else if (evt.getKeyCode() == 39 && focus != null)
                    {
                        focus.moverHori(3);
                        repaint();
                    }
                    //              ~~~~ Mover com Seta para Esquerda ~~~~
                    else if(evt.getKeyCode() == 37 && focus != null)
                    {
                        focus.moverHori(-3);
                        repaint();
                    }
                    //              ~~~~ Mover com Seta para baixo ~~~~
                    else if (evt.getKeyCode() == 40 && focus != null)
                    {
                        focus.moverVerti(3);
                        repaint();
                    }
                    //              ~~~~ Mover com Seta para cima ~~~~
                    else if (evt.getKeyCode() == 38 && focus != null)
                    {
                        focus.moverVerti(-3);
                        repaint();
                    }
                    //              ~~~~ Apagar objeto com o DELETE ~~~~
                    else if (evt.getKeyCode() == 127)
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

                    //              ~~~~ Alterar fundo com ALT ~~~~
                    else if (evt.getKeyCode() == 18 && focus != null && focusTinta != null)
                    {
                        focus.changeFundo(focusTinta.fndR, focusTinta.fndG, focusTinta.fndB);
                    }

                    //              ~~~~ Alterar contorno/fonte com ENTER ~~~~
                    else if (evt.getKeyCode() == 10 && focus != null && focusTinta != null)
                    {
                        focus.changeContorno(focusTinta.fndR, focusTinta.fndG, focusTinta.fndB);
                    }
                    //              ~~~~ Exibe/Oculta dicas F2 ~~~~
                    else if (evt.getKeyCode() == 113)
                    {
                        if (dicasVisiveis)
                        {
                            dicasVisiveis = false;
                        }
                        else
                        {
                            dicasVisiveis = true;
                        }
                    }
                    //              ~~~~ Alternar foco com CTRL ~~~~
                    else if (evt.getKeyCode() == 17)
                    {
                        for (Figure fig: figs)
                        {
                            if (focus != fig)
                            {
                                focus=fig;
                                fig.focado = true;
                                figs.remove(fig);
                                figs.add(fig);
                                figs.get(figs.indexOf(fig)-1).focado=false;
                                break;
                            }
                        }
                    }
                    //              ~~~~ Salvar o estado com F7 ~~~~
                    else if (evt.getKeyCode() == 118)
                    {
                        try
                        {
                            FileOutputStream f = new FileOutputStream("proj.bin");
                            ObjectOutputStream object = new ObjectOutputStream(f);
                            object.writeObject(figs);
                            object.flush();
                            object.close();
                        }catch(Exception x)
                        {
                            System.out.printf("ERRO!!");
                        }
                    }
                    repaint();
                }
            }
        );
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D gfd = (Graphics2D) g;
        gfd.setColor(Color.DARK_GRAY);
        gfd.fillRect(0,0,2000,1160);
        //              ~~~~ Instruções ~~~~
        dicas.add(new Texto(5, 540, " Exibir/Ocultar Dicas    [F2]", 0, 255, 180, 0, 0, 0, 10,false)); 
        dicas.add(new Texto(5, 553, "Alterar contorno    [ENTER]", 0, 0, 0, 0, 0,0,10,false));
        dicas.add(new Texto(5, 566, "Alterar o fundo           [ALT]", 0, 0, 0, 0, 0,0,10,false)); 
        dicas.add(new Texto(5, 579, "Alternar o foco         [CTRL]", 0, 0, 0, 0, 0, 0, 10,false)); 
        dicas.add(new Texto(5, 592, "Salvar                           [F7]", 0, 0, 0, 0, 0, 0, 10,false));
        dicas.add(new Texto(5, 605, "Retangulo                      [R]", 0, 0, 0, 0, 0, 0, 10, false));
        dicas.add(new Texto(5, 618, "Elipse                             [E]", 0, 0, 0, 0, 0, 0, 10, false));
        dicas.add(new Texto(5, 631, "Arco                               [A]", 0, 0, 0, 0, 0, 0, 10, false));
        dicas.add(new Texto(5, 644, "Reta                               [L]", 0, 0, 0, 0, 0, 0, 10, false));
        dicas.add(new Texto(5, 657, "Texto                              [T]", 0, 0, 0, 0, 0, 0, 10, false));
        dicas.add(new Texto(5, 670, "Ret Arredondado            [R]", 0, 0, 0, 0, 0, 0, 10, false));
        dicas.add(new Texto(40, 50, "Criar", 0, 136, 68, 0, 0, 0, 20, false));
        dicas.add(new Texto(40, 202, "Pintar", 0, 136, 68, 0, 0, 0, 20, false));
        gfd.setColor(Color.gray);
        gfd.fillRect(0,0,134,1160);
        
        //              ~~~~ Exibir figuras ~~~~
        for (Figure fig: this.figs)
        {
            fig.paint(g,focus == fig);
        }
        //              ~~~~ Exibir dicas ~~~~
        if (dicasVisiveis == true)
        {
            for(Texto dica: this.dicas)
            {
                dica.paint(g,false);
            }
        }
        //              ~~~~ Exibir botões ~~~~ 
        for(Botao button: this.botoes)
        {
            button.paint(g,button == focusB || button == focusTinta);
        }
    }
}
