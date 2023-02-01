package ftmk.bitp3453.OrderApp;

import java.io.Serializable;

public class Order implements Serializable {

//    private int id;
    private int numSandwich;
    private int numCoffee;

    public Order(String numSandwich, String numCoffee) {
//        this.id = Integer.parseInt(id);
        this.numSandwich = Integer.parseInt(numSandwich);
        this.numCoffee = Integer.parseInt(numCoffee);
    }


    public int getNumSandwich() {
        return numSandwich;
    }

    public void setNumSandwich(int numSandwich) {
        this.numSandwich = numSandwich;
    }

    public int getNumCoffee() {
        return numCoffee;
    }

    public void setNumCoffee(int numCoffee) {
        this.numCoffee = numCoffee;
    }

}
