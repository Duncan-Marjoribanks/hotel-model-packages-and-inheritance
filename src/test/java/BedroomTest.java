import enums.BedroomType;
import org.junit.Before;
import org.junit.Test;
import rooms.Bedroom;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    Bedroom bedroom;

    @Before
    public void before() {
        bedroom = new Bedroom(301, BedroomType.SINGLE, 50.00);
    }

    @Test
    public void hasNumber() {
        assertEquals(301, bedroom.getNumber());
    }

    @Test
    public void hasType() {
        assertEquals(BedroomType.SINGLE, bedroom.getType());
    }

    @Test
    public void canGetCapacity() {
        assertEquals(1, bedroom.getCapacity());
    }

    @Test
    public void canGetRate() {
        assertEquals(50.00, bedroom.getRoomRate(), 0.01);
    }
}
