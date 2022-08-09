/*
 * SNHU IT - 145
 * Project 2
 * Monkey.java
 * Author: Ricahard Elphinstone
 * Modifications: 11/23/2021
 *    Created monkey class.
 */

public class Monkey extends RescueAnimal {
	
   // Attributes
   private String tailLength;
   private String height;
   private String bodyLength;
   private String species;
	
   // Constructor
   public Monkey(String name, String gender, String species,
		   String age, String height, String weight, 
		   String bodyLength, String tailLength, 
		   String acquisitionDate, String acquisitionCountry, 
		   String trainingStatus, boolean reserved, 
		   String inServiceCountry) {
      setName(name);
      setGender(gender);
      setSpecies(species);
      setAge(age);
      setHeight(height);
      setWeight(weight);
      setBodyLength(bodyLength);
	  setTailLength(tailLength);  
	  setAcquisitionDate(acquisitionDate);
	  setAcquisitionLocation(acquisitionCountry);
	  setTrainingStatus(trainingStatus);
	  setReserved(reserved);
	  setInServiceCountry(inServiceCountry);
	  
	  
	  
   }

   // Accessors.
   public String getTailLength() {
      return tailLength;
   }
   public String getHeight() {
      return height;
   }
   public String getBodyLength() {
      return bodyLength;
   }
   public String getSpecies() {
      return species;
   }
	
   // Mutators.
   public void setTailLength(String tailLength) {
      this.tailLength = tailLength;
   }
   public void setHeight(String height) {
      this.height = height;
   }
   public void setBodyLength(String bodyLength) {
      this.bodyLength = bodyLength;
   }
   public void setSpecies(String species) {
      this.species = species;
   }	
}
