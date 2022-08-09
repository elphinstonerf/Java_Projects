package PetBAG;

public class Pet { 
	
	// Attributes
	private String petType;
	private String petName;
	private int petAge;
	private int dogSpaces;
	private int catSpaces;
	private int daysStay;
	private int amountDue;
	
	// Constructors
	public Pet() {
		petType = "none";
		petName = "none";
		petAge = 0;
		dogSpaces = 0;
		catSpaces = 0;
		daysStay = 0;
		amountDue = 0;
	}
	
	// Mutators
	public void setPetType(String Type) {
		petType = Type;
	}
	public void setPetName(String Name) {
		petName = Name;
	}
	public void setPetAge(int Age) {
		petAge = Age;
	}
	public void setDogSpaces(int dogNumber) {
		dogSpaces = dogNumber;
	}
	public void setCatSpaces(int catNumber) {
		catSpaces = catNumber;
	}
	public void setDaysStay(int Days) {
		daysStay = Days;
	}
	public void setAmountDue(int Amount) {
		amountDue = Amount;
	}
	
	// Accessors
	public String getPetType() {
		return petType;
	}
	public String getPetName() {
		return petName;
	}
	public int getPetAge() {
		return petAge;
	}
	public int getDogSpaces() {
		return dogSpaces;
	}
	public int getCatSpaces() {
		return catSpaces;
	}
	public int getDaysStay() {
		return daysStay;
	}
	public int getAmountDue() {
		return amountDue;
	}

}
