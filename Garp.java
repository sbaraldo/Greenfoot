import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Garp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Garp extends Actor
{
    private GreenfootImage imageLeft;
    private GreenfootImage imageRight;
    
    public Garp()
    {
        imageRight = new GreenfootImage("GarpRight.png");
        imageLeft = new GreenfootImage("GarpLeft.png");

    }
    
    
    /**
     * Act - do whatever the Garp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act () {
        movingAndTurning();
        collectingDiamonds();
        foundBomb();
    }
    
    /****
     * Deze methode vangt op welke pijltjestoets is ingedrukt en
     * beweegt vervolgens Garp
     * Geen parameters
     * Geen teruggave
     */
    protected void movingAndTurning() {
        // Add your action Code here.
        if(Greenfoot.isKeyDown("right")) {
            if(getImage() == imageLeft) {
                setImage(imageRight);
            }
            setRotation(0);
            move(5);
            if(foundRock()) {
                move(-5);
            }
        }
        if(Greenfoot.isKeyDown("left")) {
            if(getImage() == imageRight) {
                setImage(imageLeft);
            }
            setRotation(0);
            move(-5);
            if(foundRock()) {
                move(5);
            }
        }
        if(Greenfoot.isKeyDown("up")) {
            if(getImage() == imageLeft) {
                setImage(imageRight);
            }
            setRotation(-90);
            move(5);
            if(foundRock()) {
                move (-5);
            }
        }
        if(Greenfoot.isKeyDown("down")) {
            if(getImage() == imageLeft) {
                setImage(imageRight);
            }
            setRotation(90);
            move(5);
            if(foundRock()) {
                move(-5);
            }
        }
    }
        
    protected void collectingDiamonds() {
        Actor diamond;
        World world;
        //Op zoek naar de diamanten
        diamond = getOneObjectAtOffset(0,0, Diamond.class);
        if(diamond != null) { //Als Garp een diamant ziet
            world = getWorld(); //In welke wereld leeft Garp
            world.removeObject(diamond); //Verwijder de diamant van de wereld
        }
    }
    
    protected boolean foundRock() {
        Actor rock;
        rock = getOneObjectAtOffset(0,0, Rock.class);
        if(rock != null) {
            return true;
        }
        return false;
    }
    
    public void foundBomb() {
        Actor bomb;
        
        bomb = getOneObjectAtOffset(0, 0, Bomb.class);
        if(bomb != null) {
            getWorld().removeObject(bomb);
            getWorld().addObject( new Explosion(), getX(), getY());
            getWorld().removeObject(this);
        }
    }
         
}
