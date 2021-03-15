class Elipse
{
    int eixoMa, eixoMe;
    int xi, yi;
    int xf, yf;
    
    Elipse (int eixoMa, int eixoMe, int xi, int yi, int xf, int yf)
    {
        this.eixoMa = eixoMa;
        this.eixoMe = eixoMe;
        this.xi = xi;
        this.yi = yi;
        this.xf = xf;
        this.yf = yf;
    }

    void print()
    {
        System.out.format("Eixo maior: %d   /   Eixo Menor: %d \n", this.eixoMa, this.eixoMe);
        System.out.format("Vertice inicial: (%d, %d)    /   Vertice final: (%d, %d\n", this.xi, this.yi, this.xf, this.yf);
    }
}

public class elipseApp
{
    public static void main(String [] args)
    {
        Elipse e1 = new Elipse(7, 3, 3, 4, 7,5);
        e1.print();
    }
}