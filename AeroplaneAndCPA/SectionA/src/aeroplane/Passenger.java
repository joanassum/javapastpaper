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

    abstract boolean isAdult();
}
