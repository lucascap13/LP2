//Esse metodo esta igual em todas as classes exceto na classe do texto    
public boolean clicked(int posX, int posY)
    {
        if((posX >= this.x && posX <= (this.w+this.x)) && (posY >= this.y && posY <= (this.y+this.h)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
