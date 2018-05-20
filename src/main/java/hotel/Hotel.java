package hotel;


import people.Guest;
import rooms.Bedroom;
import rooms.ConferenceRoom;
import rooms.Room;

import java.util.ArrayList;
import java.util.List;


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

    public ArrayList<Room> getRooms(){
        return rooms;
    }

    public int countRooms(){
        return rooms.size();
    }

    public boolean checkIfRoomIsFull(Room room){
        return room.checkIfFull();
    }

    public int howManyGuestsInRoom(Room room){
        return room.countGuestsInRoom();
    }

    public List<Guest> retrieveGuestList(Room room){
        return room.getGuestList();
    }

    public void checkGuestIntoARoom(Room room, Guest guest){
        if (isRoomHireable(room)){
            if (room.getGuestList().size() < room.getCapacity()){
                    room.addGuest(guest);
            }
        }
    }

    public void checkGuestOutOfARoom(Room room, Guest guest){
        room.removeGuest(guest);
    }

    public boolean isRoomEmpty(Room room){
        return room.checkIsEmpty();
    }

    public ArrayList <Room> listVacantRooms(){
        for (Room room : rooms){
            if (room.checkIsEmpty()){
                vacantRooms.add(room);
            }
        }
        return vacantRooms;
    }

    private boolean isRoomABedroom(Room room){
        return room instanceof Bedroom;
    }

    private boolean isRoomAConferenceRoom(Room room){
        return room instanceof ConferenceRoom;
    }

    public boolean isRoomHireable(Room room){
        return (isRoomABedroom(room) || isRoomAConferenceRoom(room));
    }

    public ArrayList <Room> listVacantBedrooms(){
        for (Room room : rooms){
            if (room.checkIsEmpty()){
                if (isRoomABedroom(room)){
                vacantBedrooms.add(room);}
            }
        }
        return vacantBedrooms;
    }

    
}

