import enums.ConferenceType;
import org.junit.Before;
import org.junit.Test;
import rooms.ConferenceRoom;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    ConferenceRoom conferenceRoom;

    @Before
    public void before() {
        conferenceRoom = new ConferenceRoom("The Conference Room", ConferenceType.SMALL, 50.00);
    }

    @Test
    public void hasName() {
        assertEquals("The Conference Room", conferenceRoom.getName());
    }

    @Test
    public void hasType() {
        assertEquals(ConferenceType.SMALL, conferenceRoom.getType());
    }

    @Test
    public void canGetCapacity() {
        assertEquals(15, conferenceRoom.getCapacity());
    }

    @Test
    public void canGetRate() {
        assertEquals(50.00, conferenceRoom.getRoomRate(), 0.01);
    }
}
