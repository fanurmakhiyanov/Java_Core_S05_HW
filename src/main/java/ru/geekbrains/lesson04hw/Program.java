package ru.geekbrains.lesson04hw;

import java.util.Arrays;

import static java.lang.Integer.valueOf;

public class Program {

    public static void main(String[] args) {

        String[][] stringArray0 = new String[][]{
                {"5", "8", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "x", "6"},
                {"1", "2", "4", "8"}
        };
        String[][] stringArray1 = new String[][]{
                {"5", "6", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "5", "6"},
                {"1", "2", "4", "8"}
        };
        String[][] stringArray2 = new String[][]{
                {"5", "g", "3"},
                {"1", "2", "3", "4"},
                {"1", "2", "5", "6"},
                {"1", "2", "4", "8"}
        };
        String[][] stringArray3 = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "5", "6"},
                {"1", "2", "4", "8"}
        };

        for (String[] arr : stringArray0) {
            System.out.println(Arrays.deepToString(arr));
        }
        try {
            System.out.println("Сумма элементов массива равна " + transformAndSum(stringArray0));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
        System.out.println("----------------------------------------------------------------------------------------");
        for (String[] arr : stringArray1) {
            System.out.println(Arrays.deepToString(arr));
        }
        try {
            System.out.println("Сумма элементов массива равна " + transformAndSum(stringArray1));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
        System.out.println("----------------------------------------------------------------------------------------");
        for (String[] arr : stringArray2) {
            System.out.println(Arrays.deepToString(arr));
        }
        try {
            System.out.println("Сумма элементов массива равна " + transformAndSum(stringArray2));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
        System.out.println("----------------------------------------------------------------------------------------");
        for (String[] arr : stringArray3) {
            System.out.println(Arrays.deepToString(arr));
        }
        try {
            System.out.println("Сумма элементов массива равна " + transformAndSum(stringArray3));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
    }

    private static int transformAndSum(String[][] in) throws MyArraySizeException, MyArrayDataException {
        int arrDim = 4;
        int sum = 0;

        // Проверяем, что у массива 4 основных измерения
        if (in.length != 4) {
            throw new MyArraySizeException(String.format("Размерность массива должна быть %dх%d.", arrDim, arrDim));
        }
        // Т.к. размерность вложенных массивов может быть не всегда одинакова, то проверяем, что в каждом из 4-х основных измерений находится массив ровно из 4 элементов
        for (int i = 0; i < in.length; i++) {
            if (in[i].length != 4) {
                throw new MyArraySizeException(String.format("Размерность массива должна быть %dх%d.", arrDim, arrDim));
            }
        }

        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[i].length; j++) {
                try {
                    sum += Integer.parseInt(in[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("В позиции [%d][%d] исходного массива находится не целое число. В позиции указано значение %s.", i, j, in[i][j]));
                }
            }
        }
        return sum;
    }
}