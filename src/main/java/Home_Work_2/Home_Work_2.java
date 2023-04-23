package Home_Work_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Home_Work_2 {
    public static void main(String[] args) {
        System.out.println("Результат выполнения кода для задачи 1.");
        String request = "select * from students where ";
        String jsonFilter1 = "{\"name:Ivanov\", \"country:Russia\", \"city:Moscow\", \"age:null\"}";
        String jsonFilter2 = "{\"name:null\", \"country:null\", \"city:null\", \"age:null\"}";
        String jsonFilter3 = "{\"name:Bursaev\", \"country:null\", \"city:Tomsk\", \"age:null\"}";
        System.out.println("Пример 1:");
        ex1(request, jsonFilter1);
        System.out.println("Пример 2:");
        ex1(request, jsonFilter3);
        System.out.println("Пример 3:");
        ex1(request, jsonFilter2);
        System.out.println();
        System.out.println("Результат выполнения кода для задачи 2.");
        String pathDir = "/home/vlad/IdeaProjects/Java_Course_GB/src/main/resources/FolderForExication/";
        ex2(pathDir);
    }

    // Задача 1.
    // Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса,
    // используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
    // Если значение null, то параметр не должен попадать в запрос.

    // Пример 1:
    // Параметры для фильтрации: {"name:Ivanov", "country:Russia", "city:Moscow", "age:null"}
    // Результат: SELECT * FROM USER WHERE name = 'Ivanov' and country = 'Russia' and city = 'Moscow';

    // Пример 2:
    // Параметры для фильтрации: {"name:null", "country:null", "city:null", "age:null"}
    // Результат: SELECT * FROM USER;

    private static void ex1(String req, String json) {
        String[] reqArray = req.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < reqArray.length; i++) {
            if (!reqArray[i].equals("where") && !reqArray[i].equals("students")) {
                sb.append(reqArray[i]).append(" ");
            } else if ((!reqArray[i].equals("where") && (reqArray[i].equals("students")))) {
                reqArray[i] = "user";
                sb.append(reqArray[i]);
            }
        }
        String newReq = sb.toString().toUpperCase();
        sb.setLength(0);
        for (int i = 0; i < json.length(); i++) {
            char temp = json.charAt(i);
            if (temp != '{' && temp != '"' && temp != '}' && temp != ',') {
                sb.append(temp);
            }
        }
        String newJson = sb.toString();
        sb.setLength(0);
        String where = "";
        sb.append(where);
        String[] jsonArr = newJson.split(" ");
        for (int i = 0; i < jsonArr.length; i++) {
            String[] studentData = jsonArr[i].split(":");
            if ((!studentData[1].equals("null"))) {
                sb.append(studentData[0]).append(" = ").append("'").append(studentData[1]).append("'").append(" and ");
            }
        }
        if (sb.length() != 0) {
            sb.setLength(sb.length() - 5);  // убираем из строки крайнee ->  " and "
        }
        where = sb.toString();
        sb.setLength(0);
        String result = "";
        if (where.length() != 0) {
            result = String.valueOf(sb.append(newReq).append(" WHERE ").append(where).append(";"));
        } else {
            result = String.valueOf(sb.append(newReq).append(";"));
        }
        System.out.println(result);
    }

    // Задача 2.
    // Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида:
    // 1 Расширение файла: txt
    // 2 Расширение файла: pdf
    // 3 Расширение файла:
    // 4 Расширение файла: jpg

    private static void ex2(String pathDir) {
        StringBuilder sb = new StringBuilder();
        File file = new File(pathDir);
        if (!(file.isDirectory())) {
            return;
        }
        for (String fileName : file.list()) {
            sb.append(fileName).append(System.lineSeparator());
        }
        try(PrintWriter pw = new PrintWriter("src/main/resources/Files/fileName.txt")) {
            pw.print(sb);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int count = 0;
        String fileName = "";
        sb.setLength(0);
        String[] files = file.list();
        for (String str: files){
            count ++;
            for(int i = 0; i < str.length(); i++){
                char charTemp = str.charAt(i);
                if (charTemp != '.'){
                    sb.append(charTemp);
                }
                else {
                    fileName = sb.toString();
                    sb.setLength(0);
                }
            }
            String extension = sb.toString();
            sb.setLength(0);
            System.out.printf("%d. file -> %s  - >   имеет расширение:  %s\n", count, fileName, extension);
            fileName = "";
            extension = "";
        }
    }
}
