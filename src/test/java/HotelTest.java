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


import static org.junit.Assert.assertEquals;

public class HotelTest {

    Hotel hotel, hotel2;
    Bedroom bedroom1, bedroom2, bedroom3;
    ConferenceRoom conferenceRoom;
    DiningRoom diningRoom;
    Guest guest1, guest2;


    @Before
    public void before() {
        bedroom1 = new Bedroom(301, BedroomType.SINGLE, 50.00);
        bedroom2 = new Bedroom(200, BedroomType.DOUBLE, 90.00);
        bedroom3 = new Bedroom(300, BedroomType.DOUBLE, 90.00);
        conferenceRoom = new ConferenceRoom("The Conference Room", ConferenceType.SMALL, 50.00);
        diningRoom = new DiningRoom("The Grand Room", DiningType.RESTAURANT);
        hotel = new Hotel();
        hotel2 = new Hotel();
        hotel.addRoom(bedroom1);
        hotel.addRoom(bedroom2);
        hotel.addRoom(conferenceRoom);
        hotel.addRoom(diningRoom);
        guest1 = new Guest("Timmy");
        guest2 = new Guest("Jenny");
    }

    @Test
    public void canAddRoomsToHotel(){
        hotel.addRoom(bedroom3);
        assertEquals(5, hotel.countRooms());
    }

    @Test
    public void canCheckGuestIntoARoom(){
        hotel.checkGuestIntoARoom(bedroom1, guest1);
        assertEquals(1, bedroom1.countGuestsInRoom());
    }

    @Test
    public void canCheckGuestOutOfARoom(){
        hotel.checkGuestIntoARoom(bedroom1, guest1);
        hotel.checkGuestOutOfARoom(bedroom1, guest1);
        assertEquals(0, bedroom1.countGuestsInRoom());
    }

    @Test
    public void canListGuestsStayingInARoom(){
        hotel.checkGuestIntoARoom(bedroom1, guest1);
        hotel.checkGuestIntoARoom(bedroom1, guest2);
        List<Guest> list1 = Arrays.asList(guest1, guest2);
        assertEquals(list1, bedroom1.getGuestList());
    }

    @Test
    public void canCheckIfRoomIsEmpty(){
        assertEquals(true, bedroom1.checkIsEmpty());
    }

    @Test
    public void canCheckIfRoomIsEmptyFail(){
        hotel.checkGuestIntoARoom(bedroom1, guest1);
        assertEquals(false, bedroom1.checkIsEmpty());
    }

    @Test
    public void canSeeListOfVacantRooms(){
        hotel.checkGuestIntoARoom(bedroom1, guest1);
        hotel2.addRoom(bedroom2);
        hotel2.addRoom(conferenceRoom);
        hotel2.addRoom(diningRoom);
        assertEquals(hotel.listVacantRooms(), hotel2.getRooms());
    }

    @Test
    public void canSeeListOfVacantBedrooms(){
        hotel.checkGuestIntoARoom(bedroom1, guest1);
        hotel2.addRoom(bedroom2);
        assertEquals(hotel.listVacantBedrooms(), hotel2.getRooms());
    }


}
