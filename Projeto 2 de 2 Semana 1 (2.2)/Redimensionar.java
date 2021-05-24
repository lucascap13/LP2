public abstract class Figure implements iVisible
{
    ...
    
    public void RedimensionarSupEsq(int posX, int posY)
    {
        this.w += (this.x - posX);
        this.h += (this.y - posY);
        this.y = posY;
        this.x = posX;
    }
    
    public void RedimensionarInfDir(int posX, int posY)
    {
        this.h = Math.abs(this.y - posY);
        this.w = Math.abs(posX - this.x);
        if (this.h <= 3)
        {
            this.h = 3;
        }
        if (this.w <= 0)
        {
            this.w = 5;
        }
    }    
}
