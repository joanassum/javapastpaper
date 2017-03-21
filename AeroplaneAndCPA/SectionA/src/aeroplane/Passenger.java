package aeroplane;

public abstract class Passenger {

	protected String firstName;
	protected String surname;
	protected String type;

	public Passenger(String firstName, String surname, String type) {
	    this.firstName = firstName;
	    this.surname = surname;
	    this.type = type;
    }

    public boolean isDummy() {
		return firstName.equals("XXX") && surname.equals("YYY");
	}


    abstract boolean isAdult();
}
