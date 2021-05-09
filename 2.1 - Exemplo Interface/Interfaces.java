import java.awt.*;

interface Inflatable
{
    int encher(int volume);
    int esvaziar(int volume);
}

interface Throwable
{
    void arremessar(int velocidade);
    void mirar(Point local_alvo);
}

class colchao implements Inflatable
{
    int volume_ini, volume_final;

    public int encher(int volume)
    {
        volume_ini = 0;
        int volume_total = volume + volume_ini;
        return volume_total;
    }
    public int esvaziar(int volume)
    {
        volume_ini = 1000000; //unidade: cm^3, aproximadamente 1m^3
        int volume_final = volume_ini - volume;
        return volume_final;
    }
}

class balao implements Inflatable
{
    int volume_ini, volume_final;

    public int encher(int volume)
    {
        volume_ini = 0;
        int volumeTotal = volume_ini + volume;
        return volumeTotal;
    }
    public int esvaziar(int volume)
    {
        volume_ini = 1000; //unidade: cm^3
        volume_final = volume_ini - volume;
        return volume_final;
    }
}

class boia implements Inflatable
{
    int volume_ini, volume_final;

    public int encher(int volume)
    {
        volume_ini = 0;
        int volumeTotal = volume_ini + volume;
        return volumeTotal;
    }
    public int esvaziar(int volume)
    {
        volume_ini = 10000; //unidade: cm^3
        volume_final = volume_ini - volume;
        return volume_final;
    }
}

class cartaBaralho implements Throwable
{
    int velocidade_carta;
    Point alvo;
    public void arremessar(int velocidade)
    {
        velocidade_carta = velocidade;
    }

    public void mirar(Point local_alvo)
    {
        alvo = local_alvo;
    }
}

class pedra implements Throwable
{
    int energiaCinetica, massa;
    Point alvo;

    public void arremessar(int velocidade)
    {
        massa = 90; //90g;
        energiaCinetica = massa*((velocidade)^2)/2;
    }

    public void mirar(Point local_alvo)
    {
        alvo = local_alvo;
    }
}

class faca implements Throwable
{
    int velocidade_faca;
    Point alvo;

    public void arremessar(int velocidade)
    {
        velocidade_faca = velocidade;
    }
    public void mirar(Point local_alvo)
    {
        alvo = local_alvo;
    }
}
