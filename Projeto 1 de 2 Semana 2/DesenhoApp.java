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
    ArrayList<Figure> figs = new ArrayList<Figure>();
    ArrayList<Figure> tintas = new ArrayList<Figure>();
    Texto tituloTintas = new Texto(10, 50, " Tintas ", 1, 255,255, 255, 0, 0, 15);                                  //Titulo para o botao de tintas
    Texto dica1 = new Texto(67, 49, "Para alterar o Contorno ou a Fonte aperte [ENTER]", 1, 255, 255, 80, 0,0,10);    //Como usar os atalhos de pintar
    Texto dica2 = new Texto(67, 62, "Para alterar o Fundo aperte [ALT]", 1, 255, 255, 80, 0,0,10);                    //Como usar os atalhos de pintar2
    Figure focus = null;                                                                                                  //Figura em foco
    Figure balde = null;                                                                                                  //Tinta em foco
    Random rand = new Random();

    DesenhoFrame ()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.darkGray);
        this.setTitle("Figuras Diversas");
        this.setLocation(480,230);
        this.setSize(900, 720);

        this.addMouseListener
        (
            new MouseAdapter()
            {
                public void mousePressed(MouseEvent evt)
                {   
                    Point mousePos = new Point(getMousePosition());
                    focus = null;
                    for (Figure fig: figs)
                    {
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
                        else if((mousePos.x >= fig.x && mousePos.x <= (fig.w+fig.x)) && (mousePos.y >= fig.y && mousePos.y <= (fig.y+fig.h)))     
                        {
                            focus = fig;
                            figs.remove(fig);
                            figs.add(fig);
                            repaint();
                            break;
                        }
                        else
                        {
                            focus = null;
                            repaint();
                        }
                    }

                    for (Figure tinta: tintas) //Loop para selecionar a tinta
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
                    focus.movMouse(mousePos.x, mousePos.y);
                    repaint();
                }
            }
        );

        this.addKeyListener
        (
            new KeyAdapter()
            {
                public void keyPressed (KeyEvent evt)
                {
                    int w = rand.nextInt(130);
                    int h = rand.nextInt(105);
                    int r = rand.nextInt(255);
                    int g = rand.nextInt(255);
                    int b = rand.nextInt(255);
                    int angIni = rand.nextInt(360);
                    int angArc = rand.nextInt(360);
                    int style = rand.nextInt(3);
                    int rf = rand.nextInt(255);
                    int gf = rand.nextInt(255);
                    int bf = rand.nextInt(255);
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
                    else if (evt.getKeyCode() == 39 && focus != null || evt.getKeyCode() == 37 && focus != null)  //Move Horizontalmente através das setas
                    {
                        if (evt.getKeyCode() == 39) //Seta para direita
                        {
                            int dx = 3;
                            focus.moverHori(dx);
                        }
                        else
                        {
                            int dx = -3;
                            focus.moverHori(dx);   //Seta para esquerda
                        }
                    }
                    else if (evt.getKeyCode() == 40 && focus != null || evt.getKeyCode() == 38 && focus != null)  //Move Verticalmente através das setas
                    {
                        if (evt.getKeyCode() == 40)
                        {
                            int dy = 3;
                            focus.moverVerti(dy);
                            repaint();
                        }
                        else
                        {
                            int dy = -3;
                            focus.moverVerti(dy);
                            repaint();
                        }
                    }
                    else if (evt.getKeyCode() == 127)   //Deleta um objeto da Lista de Figuras
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
                    else if (evt.getKeyCode() == 18 && focus != null && balde != null) //Altera a cor do fundo da figura em foco para a cor selecionada atraves do ALT
                    {
                        focus.changeFundo(balde.r, balde.g, balde.b);
                    }
                    else if (evt.getKeyCode() == 10 && focus != null && balde != null) //Altera a cor do contorno ou fonte para a cor selecionada atraves do ENTER
                    {
                        focus.changeContorno(balde.r, balde.g, balde.b);
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
        tintas.add(new Rect(20,55, 10, 10, 255, 0, 0, 255, 0, 0));          //botao vermelho
        tintas.add(new Rect(40,55, 10, 10, 0, 255, 0, 0, 255, 0));          //botao verde
        tintas.add(new Rect(20,75, 10, 10, 0, 0, 255, 0, 0, 255));          //botao azul
        tintas.add(new Rect(40,75, 10, 10, 255, 20, 145, 255, 20, 145));    //botao rosa
        tintas.add(new Rect(20,95, 10, 10, 255, 255, 255, 255, 255, 255));  //botao branco
        tintas.add(new Rect(40,95, 10, 10, 255, 255, 0, 255, 255, 0));      //botao amarelo

        for(Figure tinta: this.tintas)
        {
            tinta.paint(g);     //Exibe os  "botoes" na tela
        }
        
        tituloTintas.paint(g);   //String "Tintas" em cima dos botoes
        dica1.paint(g);          //Explica como alterar cor de fundo
        dica2.paint(g);          //Explica como alterar cor da fonte ou contorno

        for (Figure fig: this.figs)
        {
            fig.paint(g);
        }
        
        if (focus != null)
        {
            if (focus.getClass().equals(Texto.class))   //verifica se a funcao em foco é um texto para tratá-la de uma forma especifica
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
        if (balde != null)    //Verifica se o usuario ja selecionou alguma tinta e a coloca em "foco" na variavel balde.
        {
            gfd.setColor(Color.cyan);
            gfd.drawOval(balde.x-2, balde.y-2, balde.w+4, balde.h+4);
        }
    }
}

