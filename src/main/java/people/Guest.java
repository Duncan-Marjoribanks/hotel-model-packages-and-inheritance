package people;

public class Guest {

    private String name;
    private double wallet;

    public Guest(String name, double wallet){
        this.name = name;
        this.wallet = wallet;
    }

    public String getName(){
        return this.name;
    }

    public double getWallet(){
        return this.wallet;
    }

    public void moneyLeavesWallet(int amount){
        this.wallet -= amount;
    }


}
