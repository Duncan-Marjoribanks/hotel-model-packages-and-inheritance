import enums.DiningType;
import org.junit.Before;
import org.junit.Test;
import rooms.DiningRoom;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {

    DiningRoom diningRoom;

    @Before
    public void before(){
    diningRoom = new DiningRoom("The Grand Room", DiningType.RESTAURANT);
    }

    @Test
    public void hasName(){
        assertEquals("The Grand Room", diningRoom.getName());
    }

    @Test
    public void hasType(){
        assertEquals(DiningType.RESTAURANT, diningRoom.getType());
    }

    @Test
    public void canGetCapacity(){
        assertEquals(40, diningRoom.getCapacity());
    }

}
