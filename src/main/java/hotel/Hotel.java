package hotel;

import people.Guest;
import rooms.Room;

import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {

    private ArrayList<Room> rooms;


    public Hotel(){
        this.rooms = new ArrayList <>();
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public int countRooms(){
        return rooms.size();
    }


    public void checkGuestIntoARoom(Room room, Guest guest){
        room.addGuest(guest);
    }

    public void checkGuestOutOfARoom(Room room, Guest guest){
        room.removeGuest(guest);
    }

}
