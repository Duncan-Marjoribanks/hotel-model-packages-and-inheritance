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


import java.util.Arrays;
import java.util.List;


import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Hotel hotel1, hotel2;
    private Bedroom bedroom1, bedroom2, bedroom3;
    private ConferenceRoom conferenceRoom;
    private DiningRoom diningRoom;
    private Guest guest1, guest2;


    @Before
    public void before() {
        bedroom1 = new Bedroom(301, BedroomType.SINGLE, 50.00);
        bedroom2 = new Bedroom(200, BedroomType.DOUBLE, 90.00);
        bedroom3 = new Bedroom(300, BedroomType.DOUBLE, 90.00);
        conferenceRoom = new ConferenceRoom("The Conference Room", ConferenceType.SMALL, 50.00);
        diningRoom = new DiningRoom("The Grand Room", DiningType.RESTAURANT);
        hotel1 = new Hotel();
        hotel2 = new Hotel();
        hotel1.addRoom(bedroom1);
        hotel1.addRoom(bedroom2);
        hotel1.addRoom(conferenceRoom);
        hotel1.addRoom(diningRoom);
        guest1 = new Guest("Timmy");
        guest2 = new Guest("Jenny");
    }

    @Test
    public void canAddRoomsToHotel(){
        hotel1.addRoom(bedroom3);
        assertEquals(5, hotel1.countRooms());
    }

    @Test
    public void canCheckGuestIntoARoom(){
        hotel1.checkGuestIntoARoom(bedroom1, guest1);
        assertEquals(1, hotel1.howManyGuestsInRoom(bedroom1));
    }

    @Test
    public void canCheckGuestIntoARoomFail(){
        hotel1.checkGuestIntoARoom(bedroom1, guest1);
        hotel1.checkGuestIntoARoom(bedroom1, guest2);
        assertEquals(1, hotel1.howManyGuestsInRoom(bedroom1));
    }

    @Test
    public void canCheckGuestOutOfARoom(){
        hotel1.checkGuestIntoARoom(bedroom1, guest1);
        hotel1.checkGuestOutOfARoom(bedroom1, guest1);
        assertEquals(0, hotel1.howManyGuestsInRoom(bedroom1));
    }

    @Test
    public void canListGuestsStayingInARoom(){
        hotel1.checkGuestIntoARoom(bedroom1, guest1);
        hotel1.checkGuestIntoARoom(bedroom1, guest2);
        List<Guest> list1 = Arrays.asList(guest1);
        assertEquals(list1, hotel1.retrieveGuestList(bedroom1));
    }

    @Test
    public void canCheckIfRoomIsEmpty(){
        assertEquals(true, hotel1.isRoomEmpty(bedroom1));
    }

    @Test
    public void canCheckIfRoomIsFull(){
        hotel1.checkGuestIntoARoom(bedroom1, guest1);
        assertEquals(true, hotel1.checkIfRoomIsFull(bedroom1));
    }

    @Test
    public void canCheckIfRoomIsEmptyFail(){
        hotel1.checkGuestIntoARoom(bedroom1, guest1);
        assertEquals(false, hotel1.isRoomEmpty(bedroom1));
    }

    @Test
    public void canSeeListOfVacantRooms(){
        hotel1.checkGuestIntoARoom(bedroom1, guest1);
        hotel2.addRoom(bedroom2);
        hotel2.addRoom(conferenceRoom);
        hotel2.addRoom(diningRoom);
        assertEquals(hotel1.listVacantRooms(), hotel2.getRooms());
    }

    @Test
    public void canSeeListOfVacantBedrooms(){
        hotel1.checkGuestIntoARoom(bedroom1, guest1);
        hotel2.addRoom(bedroom2);
        assertEquals(hotel1.listVacantBedrooms(), hotel2.getRooms());
    }


}
