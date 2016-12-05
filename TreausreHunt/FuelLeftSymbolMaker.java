/**
 * Write a description of class FuelLeftSymbolMaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FuelLeftSymbolMaker  
{
   private LowFuelLeftSymbol lowFuelLeftSymbol; 
   private SufficientFuelLeftSymbol sufficientFuelLeftSymbol;
   private MediumFuelLeftSymbol mediumFuelLeftSymbol;

   public FuelLeftSymbolMaker() {
      lowFuelLeftSymbol = new LowFuelLeftSymbol();
      sufficientFuelLeftSymbol = new SufficientFuelLeftSymbol();
      mediumFuelLeftSymbol = new MediumFuelLeftSymbol();
   }

   public void drawLowFuelLeftSymbol(FuelLeftSymbol fuelLeftSymbol, int fuelLeft){
      lowFuelLeftSymbol.drawFuelLeftSymbol(fuelLeftSymbol, fuelLeft);
   }
   public void drawSufficientFuelLeftSymbol(FuelLeftSymbol fuelLeftSymbol, int fuelLeft){
      sufficientFuelLeftSymbol.drawFuelLeftSymbol(fuelLeftSymbol, fuelLeft);
   }
   public void drawMediumFuelLeftSymbol(FuelLeftSymbol fuelLeftSymbol, int fuelLeft){
      mediumFuelLeftSymbol.drawFuelLeftSymbol(fuelLeftSymbol, fuelLeft);
   }
}
