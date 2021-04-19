public void mouseDragged(MouseEvent evt)
                {
                    Point mousePos = new Point(getMousePosition());
                    focus.movMouse(mousePos.x, mousePos.y);
                    repaint();
                }

//Obs a funcao "movMouse" é definida dentro de Figure da seguinte forma:

public void movMouse(int posX, int posY)
    {
        this.x = posX;
        this.y = posY;
    }
