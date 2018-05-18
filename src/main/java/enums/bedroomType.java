package enums;

public enum bedroomType {
    SINGLE(1),
    DOUBLE(2);

    private final int capacity;

    bedroomType(int capacity){
        this.capacity = capacity;
    }

    public int getCapacity(){
        return capacity;
    }
}


