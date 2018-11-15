package com.easylabs;

public class Main {

    public static void main(String[] args) {
        System.out.println("Для заданной последовательности символов удалить лишние" +
                " пробелы не в начале предложения, разделяющие слова.");
        String text="  This   is               a test  example!";
        System.out.println("Исходная строка:\n"+
                text);
        System.out.println("Результат в варианте №1");
        stringTask(text);
        System.out.println("Результат в варианте №2");
        stringBufferTask(text);

    }

    public static void stringTask(String text){
        //так как стринг не динамический, удалить что-то из него непосредственно мы не можем
        //поэтому будем делать через массив символов
        char array[]=text.toCharArray();
        //находим позицию первой буквы(слова)
        int start=0;
        for (int i = 0; i < array.length; i++) {
            if (Character.isLetter(array[i])){
                start=i;
                break;
            }
        }
        //проверяем с найденной позиции, чтобы не удалить пробелы в начале

        for (int i = start; i < array.length; i++) {
            if (array[i] == ' ') {
                if (array[i + 1] == ' ') {
                    array[i] = '\0';
                    i=start;
                    //проверяем, пока есть повторяющиеся пробелы
                }
            }
        }
        //выводим результат
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]);
        }
        System.out.println();



    }
    public static void stringBufferTask(String text){
        int s=0;//количество пробелов в начале предложения
        for (int i = 0; i <text.length() ; i++) {
            if(text.charAt(i)!=' '){
                break;
            }
            s++;

        }

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i)==' '&&text.charAt(i+1)==' ') {
                text = text.replace("  ", " ");
                i=0;
            }
        }

        String temp="";

        for (int i = 0; i < s; i++) {
            temp+=" ";
        }
        text= temp.concat(text);
        System.out.println(text);

    }
}
