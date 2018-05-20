package rooms;

import enums.ConferenceType;


public class ConferenceRoom extends Room{
    
    private String name;
    private ConferenceType type;
    private double roomRate;

    public ConferenceRoom(String name, ConferenceType type, double roomRate){
        super();
        this.name = name;
        this.type = type;
        this.roomRate = roomRate;
    }

    public int getCapacity(){
        return this.type.getCapacity();
    }

    public ConferenceType getType(){
        return this.type;
    }

    public String getName(){
        return this.name;
    }

    public double getRoomRate(){
        return this.roomRate;
    }


}
