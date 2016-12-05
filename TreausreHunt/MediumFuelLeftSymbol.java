import java.awt.Font;
import java.awt.Color;
/**
 * Write a description of class YellowFuelLeftSymbol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MediumFuelLeftSymbol implements FuelLeftInterface
{
    public void drawFuelLeftSymbol(FuelLeftSymbol fuelLeftSymbol, int fuelLeft) {
        fuelLeftSymbol.getImage().clear();
        fuelLeftSymbol.setImage("yellow_rectangle.png");
        fuelLeftSymbol.getImage().scale(250, 50);
        fuelLeftSymbol.getImage().setTransparency(255);
        Font myFont = new Font("Courier New", 1, 20);
        fuelLeftSymbol.getImage().setFont(myFont);
        fuelLeftSymbol.getImage().setColor(Color.BLACK);
        fuelLeftSymbol.getImage().drawString("Fuel Left: " + fuelLeft, 20 ,25 );
   }
}
