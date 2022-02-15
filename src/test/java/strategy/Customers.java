package strategy;

public class Customers {

    private Addition addition;

    public void setAddition(Addition addition) {
        this.addition = addition;
    }

    public void executeAddition(){
        addition.addItem();
    }
}
