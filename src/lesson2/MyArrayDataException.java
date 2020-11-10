package lesson2;

public class MyArrayDataException extends NumberFormatException{

    private int x, y;
    private String s;

    public MyArrayDataException(String s,int i, int j) {
        this.s = s;
        this.x = j+1;
        this.y = i+1;
    }

    @Override
    public String getMessage() {
        return new String ("В яйчейке "+this.x+", "+this.y+" находится не число "+this.s);
    }
}
