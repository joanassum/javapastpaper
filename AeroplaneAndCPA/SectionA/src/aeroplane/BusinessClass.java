package aeroplane;

/**
 * Created by joan on 20/3/2017.
 */
public class BusinessClass extends NonCrew {

    private Luxury luxury;

    public BusinessClass(Luxury luxury, String firstName, String surname, int age) {
        super(firstName, surname, age, "Business Class");
        this.luxury = luxury;
    }

}
