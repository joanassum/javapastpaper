package aeroplane;

/**
 * Created by joan on 19/3/2017.
 */
public abstract class NonCrew extends Passenger{

    private int age;

    public NonCrew(String firstName, String surname, int age, String type) {
        super(firstName ,surname, type);
        assert age >= 0;
        this.age = age;
    }

    public boolean isAdult() {
        return age >= 18;
    }

}
