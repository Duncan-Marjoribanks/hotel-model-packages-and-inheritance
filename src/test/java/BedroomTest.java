import enums.BedroomType;
import org.junit.Before;
import org.junit.Test;
import people.Guest;
import rooms.Bedroom;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    Bedroom bedroom;
    Guest guest;

    @Before
    public void before() {
        bedroom = new Bedroom(301, BedroomType.SINGLE, 50.00);
        guest = new Guest("Timmy");
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

    @Test
    public void canCountGuestsInRoom(){
        assertEquals(0, bedroom.countGuestsInRoom());
    }

    @Test
    public void canAddGuestToRoom(){
        bedroom.addGuest(guest);
        assertEquals(1, bedroom.countGuestsInRoom());
    }

    @Test
    public void canRemoveguestFromRoom(){
        bedroom.addGuest(guest);
        bedroom.removeGuest(guest);
        assertEquals(0, bedroom.countGuestsInRoom());
    }
}
