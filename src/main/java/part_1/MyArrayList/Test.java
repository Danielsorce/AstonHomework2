package part_1.MyArrayList;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Николай");
        myArrayList.add("Виталий");
        myArrayList.add("Виктория");
        myArrayList.add("Елена");
        myArrayList.add("Никита");

        System.out.println("Изначальный массив:");
        for (int i = 0; i < myArrayList.values.length; i++){
            System.out.println(myArrayList.values[i]);
        }
        System.out.println("/////////////////////////////////////////");
        String Names = myArrayList.get(0);
        System.out.println("Первое имя " + Names.toString());
        System.out.println("////////////////////////////////////////");
        myArrayList.set(1, "Андрей");
        System.out.println("Замена имени на " + myArrayList.get(1));
        for (int i = 0; i < myArrayList.values.length; i++){
            System.out.println(myArrayList.values[i]);
        }
        System.out.println("////////////////////////////////////////");
        String removed =  myArrayList.remove(1);
        System.out.println("Удалено имя "+ removed);
        for (int i = 0; i < myArrayList.values.length; i++){
            System.out.println(myArrayList.values[i]);
        }
        System.out.println("////////////////////////////////////////");
        myArrayList.clear();
        System.out.println("Очищаем массив");

        for (int i = 0; i < myArrayList.values.length; i++){
            System.out.println((String) myArrayList.values[i]);
        }
        System.out.println("////////////////////////////////////////");
        List<String> newList = new ArrayList<>(List.of("Антон", "Денис", "Игорь"));
        myArrayList.addAll(newList);
        System.out.println("Добавляем новые данные " + newList);
        for (int i = 0; i < myArrayList.values.length; i++){
            System.out.println((String) myArrayList.values[i]);
        }
    }
}
