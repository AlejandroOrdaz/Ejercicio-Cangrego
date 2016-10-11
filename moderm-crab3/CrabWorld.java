import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrabWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class CrabWorld extends World
{
    public final int TIEMPO_NIVEL = 15;
    private Counter contGusanos;
    private Counter contVidas;
    private Counter contTiempo;
    private SimpleTimer reloj;
    private Crab cangrejo;
    private Lobster langosta;
    
    /**
     * Constructor for objects of class CrabWorld.
     * 
     */
    public CrabWorld()
    {    
        super(560, 560, 1); 
        contGusanos = new Counter ("Gusanos: ");
        addObject (contGusanos, 68, 15);
        contVidas = new Counter ("Vidas: ");
        addObject (contVidas,505, 15);
        contVidas.setValue(3);
        Counter contTiempo = new Counter("Tiempo:");
        addObject(contTiempo,275,15);
        contTiempo.setValue(TIEMPO_NIVEL);
        reloj = new SimpleTimer();
        prepare();
    }
    
    //para iniciar y terminar el tiempo
    public void started()
    {
        reloj.mark();
        System.out.println("Botón Run presionado");
    }
    
    public void stopped()
    {
        System.out.println("Botón Pause presionado");
    }
    
    public void act()
    {
        if(reloj.millisElapsed() > 1000)
        {
            contTiempo.add(-1);
            reloj.mark();
        }
    }
    
    public void incrementaGusanos()
    {
        contGusanos.add(1);
    }
    
    public void decrementaVidas()
    {
        contVidas.add(-1);
    }
    
    public void cangrejoAtrapado()
    {
          decrementaVidas();
          langosta.setLocation(20,30);
          cangrejo.setLocation(214,211);
          if(contVidas.getValue() == 0 || contTiempo.getValue() == 0)
          {
              Label etiquetaFin = new Label("game over",50);
              addObject(etiquetaFin,250,250);
              Greenfoot.stop();
          }  
          if(contGusanos.getValue() == 5)
          {
                  Label etiquetaGanar = new Label ("Winer", 50);
                  addObject(etiquetaGanar, 250,250);
                  Greenfoot.stop();
          }
    }

    public void reiniciaPosCangrego()
    {
        cangrejo.setLocation(214, 221);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        cangrejo = new Crab();
        addObject(cangrejo,286,261);
        Worm worm = new Worm();
        addObject(worm,416,124);
        Worm worm2 = new Worm();
        addObject(worm2,388,399);
        Worm worm3 = new Worm();
        addObject(worm3,498,292);
        Worm worm4 = new Worm();
        addObject(worm4,226,129);
        Worm worm5 = new Worm();
        addObject(worm5,349,39);
        Worm worm6 = new Worm();
        addObject(worm6,122,324);
        Worm worm7 = new Worm();
        addObject(worm7,108,136);
        Worm worm8 = new Worm();
        addObject(worm8,247,384);
        Worm worm9 = new Worm();
        addObject(worm9,101,473);
        Worm worm10 = new Worm();
        addObject(worm10,365,498);
        Worm worm11 = new Worm();
        addObject(worm11,529,436);
        langosta = new Lobster();
        addObject(langosta,328,116);
}
}

