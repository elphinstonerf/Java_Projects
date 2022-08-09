package PetBAG;

public class Dog {
	
	// Instance fields.
	private int dogSpaceNumber;
	private int dogWeight;
	private String grooming;
	
	// Constructor.
	public Dog() {
	dogSpaceNumber = 0;
	dogWeight = 0;
	grooming = "no";
	}
	
	// Mutators.
	public void setDogSpaceNumber(int Number) {
		dogSpaceNumber = Number;	
	}
	public void setDogWeight(int Weight) {
		dogWeight = Weight;
	}
	public void setGrooming(String check) {
		grooming = check;
	}
	
	// Accessors.
	public int getDogSpaceNumber() {
		return dogSpaceNumber;
	}
	public int getDogWeight() {
		return dogWeight;
	}
	public String getGrooming() {
		return grooming;
	}	
}