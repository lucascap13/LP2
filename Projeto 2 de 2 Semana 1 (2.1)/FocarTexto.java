public void Focar (Graphics g)
    {
        Graphics2D gfd = (Graphics2D) g;
        gfd.setColor(Color.red);
        gfd.drawRect(this.x-2, this.y - 18, this.w+5, 25);
    }
