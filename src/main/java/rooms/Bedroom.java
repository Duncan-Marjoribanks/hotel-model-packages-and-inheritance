package rooms;

import enums.BedroomType;


public class Bedroom extends Room{

    private int number;
    private BedroomType type;
    private double roomRate;

    public Bedroom(int number, BedroomType type, double roomRate){
        super();
        this.number = number;
        this.type = type;
        this.roomRate = roomRate;
    }

    public int getCapacity(){
        return this.type.getCapacity();
    }

    public BedroomType getType(){
        return this.type;
    }

    public int getNumber(){
        return this.number;
    }

    public double getRoomRate(){
        return this.roomRate;
    }


}
