package Home_Work_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1. Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.
2. Создать множество ноутбуков.
3. Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
   отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
   “Введите цифру, соответствующую необходимому критерию:
   1 - ОЗУ
   2 - Объём ЖД
   3 - Операционная система
   4 - Цвет …
    Далее нужно запросить минимальные значения для указанных критериев — сохранить параметры фильтрации можно также в Map.
    Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
 */
public class Home_Work_6 {
    public static void main(String[] args) throws IOException {
        Notebook notebook1 = new Notebook("Toshiba", "16Gb",
                "2000Mb", "Linux", "Black");
        Notebook notebook2 = new Notebook("Dell", "32Gb",
                "500Mb", "Windows", "Black");
        Notebook notebook3 = new Notebook("Samsung", "16Gb",
                "2000Mb", "Linux", "Black");
        Notebook notebook4 = new Notebook("Samsung", "256Gb",
                "500Mb", "Windows", "Gray");
        Notebook notebook5 = new Notebook("Lenovo", "16Gb",
                "2000Mb", "Windows", "Black");
        Notebook notebook6 = new Notebook("Dell", "32Gb",
                "1000Mb", "Windows", "Black");
        Notebook notebook7 = new Notebook("Asus", "128Gb",
                "2000Mb", "Linux", "Black");
        Notebook notebook8 = new Notebook("Asus", "32Gb",
                "500Mb", "Windows", "Gray");
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(notebook1);
        notebooks.add(notebook2);
        notebooks.add(notebook3);
        notebooks.add(notebook4);
        notebooks.add(notebook5);
        notebooks.add(notebook6);
        notebooks.add(notebook7);
        notebooks.add(notebook8);
        System.out.println("Ноутбуки в наличии:");
        System.out.println();
        for (Notebook item : notebooks) {
            System.out.println(item);
        }
        System.out.println();

        Set<Notebook> booksForUser = findBooksForUser(notebooks);
        System.out.println("Список ноутбуков, подходящих под заданные пользователем критерии:");
        for (Notebook item : booksForUser) {
            System.out.println(item);
        }
    }

    public static Set<Notebook> findBooksForUser(Set<Notebook> books) throws IOException {

        List<Integer> userFilters = new ArrayList<>();
        List<String> selectUser = new ArrayList<>();
        Map<Integer, String> userSelect = new HashMap<>();
        Map<Integer, String> options = new HashMap<>();
        options.put(1, "brand");
        options.put(2, "volumeRam");
        options.put(3, "volumeHardDisk");
        options.put(4, "operationSystem");
        options.put(5, "color");

        System.out.println("Фильтры для поиска ноутбуков по заданным критериям:");
        System.out.println(options.toString());
        System.out.println();

        System.out.println("Выберите фильтры для выбора ноутбуков, соответствующих вашим критериям.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringBuilder builder = new StringBuilder();
            String option = reader.readLine();
            if (!(option.equalsIgnoreCase("stop"))) {
                int numberOption = Integer.parseInt(option);
                if (numberOption == 1) {
                    userFilters.add(numberOption);
                    System.out.println("Введите название бренда ноутбука.");
                    String brand = reader.readLine();
                    userSelect.put(numberOption, brand);
                    builder = new StringBuilder();
                    builder.append("brand -> ").append(brand);
                    selectUser.add(String.valueOf(builder));
                    builder.setLength(0);
                    System.out.printf("Выберите следующий фильтр, либо наберите %s\n", "stop");
                } else if (numberOption == 2) {
                    userFilters.add(numberOption);
                    System.out.println("Введите минимальный объем оперативной памяти в гигабайтах");
                    String volumeRam = reader.readLine() + "Gb";
                    userSelect.put(numberOption, volumeRam);
                    builder = new StringBuilder();
                    builder.append("volumeRam -> ").append(volumeRam);
                    selectUser.add(String.valueOf(builder));
                    builder.setLength(0);
                    System.out.printf("Выберите следующий фильтр, либо наберите %s\n", "stop");
                } else if (numberOption == 3) {
                    userFilters.add(numberOption);
                    System.out.println("Введите минимальный объем жесткого диска в мегабайтах");
                    String volumeHarddisk = reader.readLine() + "Mb";
                    userSelect.put(numberOption, volumeHarddisk);
                    builder = new StringBuilder();
                    builder.append("volumeHarddisk -> ").append(volumeHarddisk);
                    selectUser.add(String.valueOf(builder));
                    builder.setLength(0);
                    System.out.printf("Выберите следующий фильтр, либо наберите %s\n", "stop");
                } else if (numberOption == 4) {
                    userFilters.add(numberOption);
                    System.out.println("Введите какая операционная система должна быть установлена.");
                    String operationSystem = reader.readLine();
                    userSelect.put(numberOption, operationSystem);
                    builder = new StringBuilder();
                    builder.append("operationSystem -> ").append(operationSystem);
                    selectUser.add(String.valueOf(builder));
                    builder.setLength(0);
                    System.out.printf("Выберите следующий фильтр, либо наберите %s\n", "stop");
                } else if (numberOption == 5) {
                    userFilters.add(numberOption);
                    System.out.println("Введите цвет ноутбука.");
                    String color = reader.readLine();
                    userSelect.put(numberOption, color);
                    builder = new StringBuilder();
                    builder.append("color -> ").append(color);
                    selectUser.add(String.valueOf(builder));
                    builder.setLength(0);
                    System.out.printf("Выберите следующий фильтр, либо наберите %s\n", "stop");
                } else if (numberOption > 5) {
                    System.out.println("Введите критерии для выбора из диапазона от 1 до 5");
                }
            } else if ("stop".equalsIgnoreCase(option)) {
                break;
            }
        }

        System.out.println();
        System.out.println("Параметры ноутбука, выбранные пользователем:");
        System.out.println(selectUser);
        System.out.println();

        Set<Notebook> booksUser = new HashSet<>();
        String brandTemp = "";
        String colorTemp = "";
        String operationSystemTemp = "";
        String volRamTemp = "";
        String volHardDiskTemp = "";
        int volumeRamTemp = 0;
        int volumeHardDiskTemp = 0;

        String brandItem = "";
        String colorItem = "";
        String operationSystemItem = "";
        String volRamItem = "";
        String volHardDiskItem = "";
        int volumeRamItem = 0;
        int volumeHardDiskItem = 0;

        int num = 0;
        for (int i = userFilters.size() - 1; i >= 0; i--) {
            num = userFilters.get(i);
            if (num == 1) {
                brandTemp = userSelect.get(num);
            }
            if (num == 4) {
                operationSystemTemp = userSelect.get(num);
            }
            if (num == 5) {
                colorTemp = userSelect.get(num);
            }
            if (num == 2) {
                volRamTemp = userSelect.get(num);
                volRamTemp = volRamTemp.substring(0, volRamTemp.length() - 2);
                volumeRamTemp = Integer.parseInt(volRamTemp);
            }
            if (num == 3) {
                volHardDiskTemp = userSelect.get(num);
                volHardDiskTemp = volHardDiskTemp.substring(0, volHardDiskTemp.length() - 2);
                volumeHardDiskTemp = Integer.parseInt(volHardDiskTemp);
            }
        }

        for (Notebook item : books) {
            String tempNotebook = String.valueOf(item);
            List<String> list = Arrays.asList(tempNotebook.split(" "));
            brandItem = list.get(0);
            operationSystemItem = list.get(3);
            colorItem = list.get(4);
            volRamItem = list.get(1);
            volRamItem = volRamItem.substring(0, volRamItem.length() - 2);
            volumeRamItem = Integer.parseInt(volRamItem);
            volHardDiskItem = list.get(2);
            volHardDiskItem = volHardDiskItem.substring(0, volHardDiskItem.length() - 2);
            volumeHardDiskItem = Integer.parseInt(volHardDiskItem);

            if(brandTemp.isEmpty()){
                brandItem = brandTemp;
            }
            if(colorTemp.isEmpty()){
                colorItem = colorTemp;
            }
            if(operationSystemTemp.isEmpty()){
                operationSystemItem = operationSystemTemp;
            }
            if(volumeRamTemp == 0){
                volumeRamItem = volumeRamTemp;
            }
            if(volumeHardDiskTemp == 0){
                volumeHardDiskItem = volumeHardDiskTemp;
            }

            if (brandTemp.equalsIgnoreCase(brandItem) &&
                    volumeRamItem >= volumeRamTemp && volumeHardDiskItem >= volumeHardDiskTemp &&
                    operationSystemTemp.equalsIgnoreCase(operationSystemItem) &&
                    colorTemp.equalsIgnoreCase(colorItem)){
                booksUser.add(item);
            }
        }
        return  booksUser;
    }
}
