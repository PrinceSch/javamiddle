package lesson2;

public class main {

    public static void main(String[] args) {

        String[][] a = {
                {"1", "2", "3", "4", "5"},
                {"1", "2", "3", "4", "5"},
                {"1", "2", "3", "4", "5"},
        };

        String[][] b = {
                {"1", "2", "k", "4"},
                {"1", "2", "S", "4"},
                {"a", "2", "3", "4"},
                {"1", "2", "3", "4"},
        };
        String[][] c = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
        };

        try {
            //arrSum(a); - массив который вызовет MyArraySizeException
            //arrSum(b); - массив который вызовет MyArrayDataException
            arrSum(c);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void arrSum(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int a;
        int sum = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException(arr.length);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException(arr[i].length);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    a = Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(arr[i][j], i, j);
                }
                sum = sum + a;
            }
        }
        System.out.println("Сумма элементов: " + sum);
    }

}