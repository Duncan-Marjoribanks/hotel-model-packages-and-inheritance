package rooms;

import java.util.ArrayList;

public abstract class Room {

    private ArrayList <String> guestList;
    private int capacity;

    public Room(int capacity) {
        this.guestList = guestList;
        this.capacity = capacity;
    }

    public ArrayList <String> getGuestList() {
        return guestList;
    }

    public abstract int getCapacity();


}
