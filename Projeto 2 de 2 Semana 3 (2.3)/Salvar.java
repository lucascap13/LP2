//Dentro do construtor da Janela
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
  ...

//Dentro do contexto de ouvinte de teclado.
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
