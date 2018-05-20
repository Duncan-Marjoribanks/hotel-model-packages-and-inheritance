import enums.BedroomType;
import enums.ConferenceType;
import enums.DiningType;
import hotel.Hotel;
import org.junit.Before;
import org.junit.Test;
import people.Guest;
import rooms.Bedroom;
import rooms.ConferenceRoom;
import rooms.DiningRoom;
import rooms.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.in;
import static org.junit.Assert.assertEquals;

public class HotelTest {

    Hotel hotel;
    Bedroom bedroom1, bedroom2, bedroom3;
    ConferenceRoom conferenceRoom;
    DiningRoom diningRoom;
    Guest guest, guest2;


    @Before
    public void before() {
        bedroom1 = new Bedroom(301, BedroomType.SINGLE, 50.00);
        bedroom2 = new Bedroom(200, BedroomType.DOUBLE, 90.00);
        bedroom3 = new Bedroom(300, BedroomType.DOUBLE, 90.00);
        conferenceRoom = new ConferenceRoom("The Conference Room", ConferenceType.SMALL, 50.00);
        diningRoom = new DiningRoom("The Grand Room", DiningType.RESTAURANT);
        hotel = new Hotel();
        hotel.addRoom(bedroom1);
        hotel.addRoom(bedroom2);
        hotel.addRoom(conferenceRoom);
        hotel.addRoom(diningRoom);
        guest = new Guest("Timmy");
        guest2 = new Guest("Jenny");
    }

    @Test
    public void canAddRoomsToHotel(){
        hotel.addRoom(bedroom3);
        assertEquals(5, hotel.countRooms());
    }

    @Test
    public void canCheckGuestIntoARoom(){
        hotel.checkGuestIntoARoom(bedroom1, guest);
        assertEquals(1, bedroom1.countGuestsInRoom());
    }

    @Test
    public void canCheckGuestOutOfARoom(){
        hotel.checkGuestIntoARoom(bedroom1, guest);
        hotel.checkGuestOutOfARoom(bedroom1, guest);
        assertEquals(0, bedroom1.countGuestsInRoom());
    }

    @Test
    public void canListGuestsStayingInARoom(){
        hotel.checkGuestIntoARoom(bedroom1, guest);
        hotel.checkGuestIntoARoom(bedroom1, guest2);
        List<Guest> list1 = Arrays.asList(guest, guest2);
        assertEquals(list1, bedroom1.getGuestList());
    }

    
}
