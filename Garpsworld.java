import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Garpsworld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Garpsworld extends World
{
    private GreenfootSound sound;
    
    /**
     * Constructor for objects of class Garpsworld.
     * 
     */
    public Garpsworld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1); 
        populateTheWorld();
        sound = new GreenfootSound("musicmix.mp3");
    }
    
    protected void populateTheWorld() {
        int teller;
        
        addObject(new Garp(), getWidth() / 2, getHeight() / 2);
        addObject(new Gnomus(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        for(teller = 0; teller < 10; teller ++) {
            addObject(new Diamond(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
        for(teller = 0; teller < 6; teller ++) {
            addObject(new Rock(), Greenfoot.getRandomNumber (getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
        for(teller = 0; teller < 4; teller ++) {
            addObject(new Bomb(), Greenfoot.getRandomNumber (getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
        setPaintOrder(Garp.class, Gnomus.class, Diamond.class, Bomb.class, Rock.class);
    }
    
    public void started() {
        sound.playLoop();
    }
    
    public void stopped() {
        sound.stop();
    }
}
