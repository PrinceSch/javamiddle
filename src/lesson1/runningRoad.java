package lesson1;

public class runningRoad implements tour{

    private int length;

    public runningRoad(int length) {
        this.length = length;
    }


    @Override
    public void takeIt(challenger c) {
        c.run(length);
    }
}
