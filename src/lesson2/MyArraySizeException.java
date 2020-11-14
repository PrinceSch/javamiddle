package lesson2;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException{

    public MyArraySizeException(int index) {
        super(index);
    }

    @Override
    public String getMessage() {
        return new String ("Массив не соответствует размеру 4 на 4");
    }
}
