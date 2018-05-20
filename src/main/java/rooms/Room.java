package rooms;

import people.Guest;

import java.util.ArrayList;


public abstract class Room {

    protected ArrayList<Guest> guestList;

    public Room() {
        this.guestList = new ArrayList <>();
    }

    public ArrayList <Guest> getGuestList() {
        return guestList;
    }

    public void addGuest(Guest guest){
        this.guestList.add(guest);
    }

    public int countGuestsInRoom() {
        return this.guestList.size();
    }

    public void removeGuest(Guest guest){
        this.guestList.remove(guest);
    }

    public boolean checkIsEmpty(){
        return this.guestList.isEmpty();
    }

    public abstract int getCapacity();

    public boolean checkIfFull(){
        if (this.countGuestsInRoom() >= this.getCapacity()){
            return true;
        }
        return false;

    }


}
