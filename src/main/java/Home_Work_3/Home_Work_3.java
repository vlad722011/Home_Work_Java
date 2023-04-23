package Home_Work_3;

import java.util.*;

public class Home_Work_3 {
    public static void main(String[] args) {
        System.out.println("Решение задачи 1.");
        ex1();
        System.out.println();
        System.out.println("Решение задачи 2.");
        ex2();
        System.out.println();
        System.out.println("Решение задачи 3.");
        ex3();

    }

    // 1. Создать список типа ArrayList<String>. Поместить в него как строки, так и целые числа.
    // Пройти по списку, найти и удалить целые числа.
    // Пример: {"Яблоко", "11", "13", "Апельсин", "Дыня", "17"} -> {"Яблоко", "Апельсин", "Дыня"}
    private static void ex1() {
        List<Object> someList = new ArrayList<>();
        someList.add("Яблоко");
        someList.add(13);
        someList.add("Апельсин");
        someList.add(33);
        someList.add(17);
        someList.add(0);
        someList.add("Дыня");
        someList.add("Персик");
        someList.add(-1000);
        someList.add(3);
        someList.add("Груша");
        someList.add(1);
        someList.add("Банан");
        someList.add("Маракуйя");
        someList.add(4);
        someList.add(99);
        someList.add(18);
        System.out.println("Исходный список:");
        System.out.println(someList.toString());
        for (int i = 0; i < someList.size(); i++) {
            Object o = someList.get(i);
            if (o.getClass() == Integer.class) {
                someList.remove(someList.get(i));
                i--;
            }
        }
        System.out.println("Итоговый список:");
        System.out.println(someList.toString());
    }


    // Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями.
    // Пройти по списку из предыдущего задания и удалить повторяющиеся элементы.
    private static void ex2() {
        String[] planetsNamesStringArray = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Neptune", "Uranus", "Pluto"};
        List<String> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            list.add(planetsNamesStringArray[random.nextInt(planetsNamesStringArray.length)]);
        }
        System.out.println("Исходный список с повторениями:");
        System.out.println(list);
        list.sort(Comparator.naturalOrder());
        for (int i = 0; i < list.size() - 1; i++) {
            String first = list.get(i);
            String second = list.get(i + 1);
            if (second.equals(first)) {
                list.remove(i);
                i--;
            }
        }
        System.out.println("Итоговый список:");
        System.out.println(list);
    }

    // 3. Каталог товаров книжного магазина сохранен в виде двумерного списка List<ArrayList<String>> так,
    // что на 0-й позиции каждого внутреннего списка содержится название жанра,
    // а на остальных позициях - названия книг. Напишите метод для заполнения данной структуры(можно через консоль).

    // Пример:
    // "Классика", "Преступление и наказание", "Война и мир", "Анна Каренина".
    // "Научная фантастика", "Солярис", "Ночной дозор", "Братья Стругацкие".
    // "Детектив", "Десять негритят".
    // "Фантастика", "Хроники Нарнии", "Гарри Поттер и философский камень", "Грозовой перевал".
    private static void ex3() {

        // При решении задачи исхожу из того, что при появлении в ассортименте какой-то новой книги,
        // данная книга естественно имеет название, и принадлежит какому-то определенному жанру литературы.
        // Соответственно эти данные - это все что мне нужно.

        // Ну и допускаю, что на данный момент у нас в ассортименте имеются книги следующих жанров:
        // Количество жанров может увеличиться, при увеличении ассортимента.
        String[] genres = {"Классика", "Научная фантастика", "Детективы", "Фантастика"};

        // И в каждом из жанров на данный момент имеются следующие книги
        // (при появлении в ассортименте новых книг данные о них будут добавлены в соответствующие массивы):
        String[] classic = {"Преступление и наказание", "Война и мир", "Анна Каренина"};
        String[] scienceFiction = {"Солярис", "Ночной дозор", "Братья Стругацкие"};
        String[] detective = {"Десять негритят"};
        String[] fantastic = {"Хроники Нарнии", "Гарри Поттер и философский камень", "Грозовой перевал"};

        // Все существующие массивы с данными имеющимися у меня преобразую в списки для удобства оперирования в дальнейшем.

        // классика:
        List<String> listClassic = new ArrayList<>();
        listClassic.addAll(Arrays.asList(classic));
        listClassic.add(0, "Классика");

        // научная фантастика:
        List<String> listScienceFiction = new ArrayList<>();
        listScienceFiction.addAll(Arrays.asList(scienceFiction));
        listScienceFiction.add(0, "Научная фантастика");

        // детективы:
        List<String> listDetective = new ArrayList<>();
        listDetective.addAll(Arrays.asList(detective));
        listDetective.add(0, "Детективы");

        // фантастика:
        List<String> listFantastic = new ArrayList<>();
        listFantastic.addAll(Arrays.asList(fantastic));
        listFantastic.add(0, "Фантастика");

        // список жанров литературы:
        List<String> listGenres = new ArrayList<>();
        listGenres.addAll(Arrays.asList(genres));


        // Создаю сам каталог литературы, которая уже есть в ассортименте магазина:
        // и вывожу его на печать:
        System.out.println("Каталог литературы уже существующего ассортимента:");
        System.out.println();
        List<ArrayList<String>> catalog = new ArrayList<>();
        List<String> tempArrayList = new ArrayList<>();

        for (String tempGenre : listGenres) {
            if (tempGenre.equals("Классика")) {
                tempArrayList = listClassic;
            }
            if (tempGenre.equals("Научная фантастика")) {
                tempArrayList = listScienceFiction;
            }
            if (tempGenre.equals("Детективы")) {
                tempArrayList = listDetective;
            }
            if (tempGenre.equals("Фантастика")) {
                tempArrayList = listFantastic;
            }
            catalog.add((ArrayList<String>) tempArrayList);
            String stringArrayList = String.join(", ", tempArrayList);
            System.out.println(stringArrayList);
        }
        System.out.println();

        // ну и собственно вот так бы выглядело добавление новой книги в каталог:
        System.out.println("Добавляем новую книгу в каталог книжного магазина и выводим новый каталог на печать.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название книги:");
        String bookTitle = scanner.nextLine();
        System.out.println("Определите к какому жанру литературы принадлежит данная книга:");
        String bookGenre = scanner.nextLine();
        List<String> listNewGenre = new ArrayList<>();
        for (int i = 0; i < listGenres.size(); i++) {
            if(bookGenre.equals("Классика")){
                listClassic.add(bookTitle);
                break;
            }
            if(bookGenre.equals("Научная фантастика")){
                listScienceFiction.add(bookTitle);
                break;
            }
            if(bookGenre.equals("Детективы")){
                listDetective.add(bookTitle);
                break;
            }
            if(bookGenre.equals("Фантастика")){
                listFantastic.add(bookTitle);
                break;
            }
            if(!listGenres.contains(bookGenre)){
                listGenres.add("Новый жанр");
                listNewGenre.add(bookGenre);
                listNewGenre.add(bookTitle);
                break;
            }
        }

        // Новый каталог, после добавления новой книги:
        System.out.println();
        System.out.println("Обновленный каталог книжного магазина:");
        System.out.println();
        for (int i = 0; i < listGenres.size(); i++) {
            String tempGenre = listGenres.get(i);
            if (tempGenre.equals("Классика")) {
                tempArrayList = listClassic;
            }
            if (tempGenre.equals("Научная фантастика")) {
                tempArrayList = listScienceFiction;
            }
            if (tempGenre.equals("Детективы")) {
                tempArrayList = listDetective;
            }
            if (tempGenre.equals("Фантастика")) {
                tempArrayList = listFantastic;
            }
            if (tempGenre.equals("Новый жанр")) {
                tempArrayList = listNewGenre;
            }
            catalog.add((ArrayList<String>) tempArrayList);
            String stringArrayList = String.join(", ", tempArrayList);
            System.out.println(stringArrayList);
        }
    }
}

