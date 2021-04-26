import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import figuras.*;
import java.util.*;

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
    private static final long serialVersionUID = 1L;
    ArrayList<Figure> figs = new ArrayList<Figure>();                                                                 //Lista Heterogênea de figuras
    ArrayList<Figure> tintas = new ArrayList<Figure>();                                                               //Lista de tintas
    ArrayList<Texto> dicas = new ArrayList<Texto>();                                                                  //Lista de dicas
    Texto tituloTintas = new Texto(10, 50, " Tintas ", 1, 255, 255, 255, 0, 0, 15);                                   //Titulo para o botao de tintas
    Figure focus = null;                                                                                              //Figura em foco      
    Figure balde = null;                                                                                              //Tinta em foco
    int clickX, clickY;                                                                                               //Auxiliares para o drag
    Boolean dicasVisiveis = true;                                                                                     //Marcador das dicas

    DesenhoFrame ()
    {
        //              ~~~~ Propriedades da tela ~~~~
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.darkGray);
        this.setTitle("Editor Gráfico");
        this.setLocation(480,230);
        this.setSize(900, 720);

        this.addMouseListener
        (
            new MouseAdapter()
            {
                public void mousePressed(MouseEvent evt)
                {   
                    Point mousePos = new Point(getMousePosition());
                    clickX = mousePos.x;
                    clickY = mousePos.y;
                    focus = null;
                    for (Figure fig: figs)
                    {
                        //              ~~~~ Verificar se a figura é um texto e se o click foi dentro do texto ~~~~
                        if (fig.getClass().equals(Texto.class))
                        {
                            if((mousePos.x >= fig.x && mousePos.x <= (fig.w+fig.x)) && (mousePos.y <= fig.y && mousePos.y >= (fig.y-fig.h)))
                            {
                                focus = fig;
                                figs.remove(fig);
                                figs.add(fig);
                                repaint();
                                break;
                            }
                        }
                        //              ~~~~ Focar figura selecionada ~~~~
                        else if((mousePos.x >= fig.x && mousePos.x <= (fig.w+fig.x)) && (mousePos.y >= fig.y && mousePos.y <= (fig.y+fig.h)))     
                        {
                            focus = fig;
                            figs.remove(fig);
                            figs.add(fig);
                            repaint();
                            break;
                        }
                        //              ~~~~ Remover foco ao clicar fora da figura ~~~~
                        else
                        {
                            focus = null;
                            repaint();
                        }
                    }
                    //              ~~~~ Selecionar a tinta ~~~~
                    for (Figure tinta: tintas)
                    {
                        if((mousePos.x >= tinta.x && mousePos.x <= (tinta.w+tinta.x)) && (mousePos.y >= tinta.y && mousePos.y <= (tinta.y+tinta.h)))
                        {
                            balde = tinta;
                            repaint();
                            break;
                        }
                    }
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
                    //              ~~~~ Verificar se é texto para mover de forma especifica ~~~~
                    if(focus.getClass().equals(Texto.class))
                    {
                        focus.movTexto(mousePos.x, mousePos.y);
                        repaint();
                    }
                    //              ~~~~ Redimensionar pela ponta superior direita ~~~~
                    if(mousePos.x >= (focus.x+focus.w)-6 && mousePos.y <= (focus.y)+6)
                    {
                        focus.RedimensionarSupDir(mousePos.x, mousePos.y);
                        repaint();
                    }
                    //              ~~~~ Redimensionar pela ponta inferior esquerda ~~~~
                    else if(mousePos.x <= (focus.x+6) && mousePos.y >= (focus.y+focus.h)-6)
                    {
                        focus.RedimensionarInfEsq(mousePos.x, mousePos.y);
                        repaint();
                    }
                    //              ~~~~ Mover figura ~~~~
                    else if (mousePos.x >= focus.x && mousePos.x < (focus.x + focus.w) && mousePos.y >= focus.y && mousePos.y <= (focus.y+focus.h))
                    {
                        focus.movMouse(mousePos.x - clickX, mousePos.y - clickY);
                        clickX = mousePos.x;
                        clickY = mousePos.y;
                        repaint();
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
                    //              ~~~~ Cria Retângulo ~~~~
                    if (evt.getKeyChar() == 'r')
                    {
                        figs.add(new Rect(mousePos.x, mousePos.y, 50, 90, 0,255,0, 145, 145, 145));
                    }
                    //              ~~~~ Criar Elipse ~~~~
                    else if (evt.getKeyChar() == 'e')
                    {
                        
                        figs.add(new Ellipse(mousePos.x, mousePos.y, 60, 50, 0, 255, 0, 145, 145, 145));
                    }
                    //              ~~~~ Criar linha ~~~~
                    else if (evt.getKeyChar() == 'l')
                    {
                        
                        figs.add(new Linha(mousePos.x, mousePos.y, 0, 255, 0, 50, 20));
                    }
                    //              ~~~~ Criar Arco ~~~~
                    else if (evt.getKeyChar() == 'a')
                    {
                        
                        figs.add(new Arco(mousePos.x, mousePos.y, 100, 80, 0, 255, 0));
                    }
                    //              ~~~~ Criar RoundRect ~~~~
                    else if (evt.getKeyChar() == 'j')
                    {
                        figs.add(new RoundRect(mousePos.x, mousePos.y, 0, 255, 0, 50, 40, 145, 145, 145));
                    }
                    //              ~~~~ Criar Texto ~~~~
                    else if (evt.getKeyChar() == 't')
                    {
                        Scanner s = new Scanner(System.in);
                        String cadeia = s.nextLine();
                        figs.add(new Texto(mousePos.x, mousePos.y, cadeia, 2, 0, 255, 0, 0, 0, 20));
                    }
                    //              ~~~~ Seta para direita ~~~~
                    else if (evt.getKeyCode() == 39 && focus != null)  //Move Horizontalmente através das setas
                    {
                        focus.moverHori(3);
                        repaint();
                    }
                    //              ~~~~ Seta para Esquerda ~~~~
                    else if(evt.getKeyCode() == 37 && focus != null)
                    {
                        focus.moverHori(-3);
                        repaint();
                    }
                    //              ~~~~ Seta para baixo ~~~~
                    else if (evt.getKeyCode() == 40 && focus != null)  //Move Verticalmente através das setas
                    {
                        focus.moverVerti(3);
                        repaint();
                    }
                    //              ~~~~ Seta para cima ~~~~
                    else if (evt.getKeyCode() == 38 && focus != null)
                    {
                        focus.moverVerti(-3);
                        repaint();
                    }
                    //              ~~~~ Deletar objeto com o DELETE ~~~~
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
                    else if (evt.getKeyCode() == 18 && focus != null && balde != null)
                    {
                        focus.changeFundo(balde.r, balde.g, balde.b);
                    }
                    //              ~~~~ Alterar contorno/fonte com ENTER ~~~~
                    else if (evt.getKeyCode() == 10 && focus != null && balde != null)
                    {
                        focus.changeContorno(balde.r, balde.g, balde.b);
                    }
                    //              ~~~~ Exibe/Oculta dicas ~~~~
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
                    repaint();
                }
            }
        );
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D gfd = (Graphics2D) g;
        //              ~~~~ Criação dos botões e dicas~~~~
        tintas.add(new Rect(20,55, 10, 10, 255, 0, 0, 255, 0, 0));                                                       //vermelho
        tintas.add(new Rect(40,55, 10, 10, 0, 255, 0, 0, 255, 0));                                                       //verde
        tintas.add(new Rect(20,75, 10, 10, 0, 0, 255, 0, 0, 255));                                                       //azul
        tintas.add(new Rect(40,75, 10, 10, 255, 20, 145, 255, 20, 145));                                                 //rosa
        tintas.add(new Rect(20,95, 10, 10, 255, 255, 255, 255, 255, 255));                                               //branco
        tintas.add(new Rect(40,95, 10, 10, 255, 255, 0, 255, 255, 0));                                                   //amarelo
        tintas.add(new Rect(20, 115, 10, 10, 0, 0, 0, 0, 0, 0));                                                         //preto
        tintas.add(new Rect(40, 115, 10, 10, 185, 122, 87, 185, 122, 87));                                               //marrom
        dicas.add(new Texto(620, 62, "Para alterar o Contorno ou a Fonte aperte [ENTER]", 1, 255, 255, 80, 0,0,10));     //Como usar os atalhos de pintar
        dicas.add(new Texto(620, 75, "Para alterar o Fundo aperte [ALT]", 1, 255, 255, 80, 0,0,10));                     //Como usar os atalhos de pintar2
        dicas.add(new Texto(620, 88, "O texto não pode ser redimensionado, apenas movido", 1, 255, 255, 80, 0, 0, 10));  //Obs sobre texto
        dicas.add(new Texto(620, 101, "Para alternar o foco automaticamente aperte [CTRL]", 1, 255, 255, 80, 0, 0, 10)); //Como usar o foco automatico
        dicas.add(new Texto(620, 49, "Exibir/Ocultar Dicas:   [F2]", 1, 255, 100, 0, 0, 0, 10)); 
        tituloTintas.paint(g);

        //              ~~~~ Exibir botões ~~~~
        for(Figure tinta: this.tintas)
        {
            tinta.paint(g);
        }
        //              ~~~~ Exibir dicas ~~~~
        if (dicasVisiveis == true)
        {
            for(Texto dica: this.dicas)
            {
                dica.paint(g);
            }
        }
        
        //              ~~~~ Exibir figuras ~~~~
        for (Figure fig: this.figs)
        {
            fig.paint(g);
        }
        
        //              ~~~~ Verificar se foco esta vazio e distinguir se é texto ou outra figura ~~~~
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
                gfd.setColor(Color.CYAN);
                gfd.fillOval(focus.x+focus.w-4,focus.y-3,7,7);
                gfd.fillOval(focus.x-3,focus.y+focus.h-6,7,7);
            }
        }
        //              ~~~~ Verificar se o usuário já selecionou alguma tinta e mostrar na tela a tinta selecionada ~~~~
        if (balde != null)
        {
            gfd.setColor(Color.cyan);
            gfd.drawOval(balde.x-2, balde.y-2, balde.w+4, balde.h+4);
            Texto TintaSelecionada = new Texto(10, 145, " Cor atual", 1, balde.r, balde.g, balde.b, 0, 0, 13);
            TintaSelecionada.paint(g);
        }
    }
}