package com.javaworld.A1_Core_Java.z_helperbeans;

/**
 * @author Shaik khader
 *
 */
public class RoadBike extends Bicycle {
	// In millimeters (mm)
    private int tyreWidth;

    public RoadBike(int startCadence,
                    int startSpeed,
                    int startGear,
                    int newTyreWidth){
        super(startCadence,
              startSpeed,
              startGear);
        this.setTyreWidth(newTyreWidth);
    }

    public int getTyreWidth(){
      return this.tyreWidth;
    }

    public void setTyreWidth(int newTyreWidth){
        this.tyreWidth = newTyreWidth;
    }
    /**
	 * 
	 */
	public RoadBike() {
	}
	
	//this overrides the parent method
    public void printDescription(){
        super.printDescription();
        System.out.println(" The RoadBike has " + getTyreWidth() +
                " MM tires.");
    }
	

}
