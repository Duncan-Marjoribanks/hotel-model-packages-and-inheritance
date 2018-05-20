import org.junit.Before;
import org.junit.Test;
import people.Guest;

import static org.junit.Assert.assertEquals;

public class GuestTest {

    Guest guest;

    @Before
    public void before(){
        guest = new Guest("Timmy", 100);
    }

    @Test
    public void hasName(){
        assertEquals("Timmy", guest.getName());
    }

    @Test
    public void hasWallet() { assertEquals(100, guest.getWallet(), 0.01); }

    @Test
    public void moneyCanLeaveWallet(){
        guest.moneyLeavesWallet(40);
        assertEquals(60, guest.getWallet(), 0.01);
    }

}
