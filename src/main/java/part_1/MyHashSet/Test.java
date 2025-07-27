package part_1.MyHashSet;

public class Test {
    public static void main(String[] args) {
        MyHashSet<String> Set = new MyHashSet<>();

        Set.add("Виктор");
        Set.add("Анастасия");
        Set.add("Елизавета");


        for (String name : Set){
            System.out.println(name);
        }

        System.out.println("/////////////////////////////////////////////////");
        System.out.println("Содержит Анастасия? " +Set.contains("Анастасия"));
        System.out.println("Содержит Андрей? " +Set.contains("Андрей"));
        System.out.println("/////////////////////////////////////////////////");
        Set.remove("Виктор");
        System.out.println("Размер после удаления: " + Set.size());
        System.out.println("/////////////////////////////////////////////////");
        Set.clear();
        System.out.println("Очистка: " + Set.size());
    }
}
