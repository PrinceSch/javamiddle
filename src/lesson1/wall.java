package lesson1;

public class wall implements tour{

    private int height;

    public wall(int height) {
        this.height = height;
    }

    @Override
    public void takeIt(challenger c) {
        c.jump(height);
    }
}
