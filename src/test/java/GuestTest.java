import org.junit.Before;
import org.junit.Test;
import people.Guest;

import static org.junit.Assert.assertEquals;

public class GuestTest {

    Guest guest;

    @Before
    public void before(){
        guest = new Guest("Timmy");
    }

    @Test
    public void hasName(){
        assertEquals("Timmy", guest.getName());
    }

}
