package enums;

public enum ConferenceType {

    SMALL(15),
    LARGE(40);

    private final int capacity;

    ConferenceType(int capacity){
        this.capacity = capacity;
    }

    public int getCapacity(){
        return capacity;
    }
}
