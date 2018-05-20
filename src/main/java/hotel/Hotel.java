package hotel;

import enums.BedroomType;
import people.Guest;
import rooms.Bedroom;
import rooms.Room;

import java.util.ArrayList;

import static enums.BedroomType.DOUBLE;
import static enums.BedroomType.SINGLE;

public class Hotel {

    private ArrayList<Room> rooms;
    private ArrayList<Room> vacantRooms;
    private ArrayList<Room> vacantBedrooms;


    public Hotel(){
        this.rooms = new ArrayList <>();
        this.vacantRooms = new ArrayList <>();
        this.vacantBedrooms = new ArrayList <>();
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public void removeRoom(Room room){
        rooms.remove(room);
    }

    public ArrayList<Room> getRooms() {
        return rooms;
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

    public ArrayList <Room> listVacantRooms(){
        for (Room room : rooms){
            if (room.checkIsEmpty()){
                vacantRooms.add(room);
            }
        }
        return vacantRooms;
    }

    private boolean isRoomABedroom(Room room) {
        if (room instanceof Bedroom) {
            return true;
        }
        return false;
    }

    public ArrayList <Room> listVacantBedrooms(){
        for (Room room : rooms){
            if (room.checkIsEmpty()){
                if (isRoomABedroom(room) == true){
                vacantBedrooms.add(room);}
            }
        }
        return vacantBedrooms;
    }


}

