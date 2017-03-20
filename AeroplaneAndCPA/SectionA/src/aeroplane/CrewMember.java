package aeroplane;

/**
 * Created by joan on 19/3/2017.
 */
public class CrewMember extends Passenger {


    public CrewMember(String firstName, String surname) {
        super(firstName, surname, "Crew Members");
    }

    public boolean isAdult() {
        return true;
    }
}
