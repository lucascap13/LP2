    public void Focar (Graphics g)
    {
        Graphics2D gfd = (Graphics2D) g;
        gfd.setColor(Color.RED);
        gfd.drawRect(this.x-2, this.y-2, this.w+4, this.h+4);
        gfd.setColor(Color.CYAN);
        gfd.fillOval(this.x+this.w-4,this.y-3,7,7);
        gfd.fillOval(this.x-3,this.y+this.h-6,7,7);
    }
