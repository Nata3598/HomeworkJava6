
// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков (ArrayList).
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
//  Например, спросить у пользователя минимальный размер оперативной памяти или конкретный цвет. 
//  Выводить только те ноутбуки, что соответствуют условию

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Task {
    public static void main(String[] args) {
        Notebook notebook1 = new Notebook("Asus", "4", "1000", "Windows", "grey");
        Notebook notebook2 = new Notebook("Asus", "4", "1000", "Lunex", "black");
        Notebook notebook3 = new Notebook("Asus", "4", "2000", "Windows", "black");
        Notebook notebook4 = new Notebook("Asus", "16", "1000", "Windows", "grey");
        Notebook notebook5 = new Notebook("Huawei", "8", "1000", "Windows", "black");

        Set<Notebook> notebooks = new HashSet<>(List.of(notebook1, notebook2,
                notebook3, notebook4, notebook5));

        Map<String, String> sel = selectCriteria();
        sort(sel, notebooks);

    }

    public static Map<String, String> selectCriteria() {
        Map<String, String> resultCriterias = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Вы хотите выбрать критерий? Если да введите 'y', если нет введите 'n'");
            String question = scanner.nextLine();
            if (question.equals("n")) {
                break;
            } else if (question.equals("y")) {

                System.out.println(
                        "Введите цифру, соответствующую необходимому критерию: \n 1 - Название \n 2 - ОЗУ \n 3 - Объем ЖД \n 4 - Операционная система \n 5 - Цвет\n");
                String key = scanner.nextLine();
                System.out.println("Введите значения для выбранного критерия: ");
                String value = scanner.nextLine();

                resultCriterias.put(key, value);
            }
        }
        scanner.close();

        System.out.println(resultCriterias);
        return resultCriterias;

    }

    public static void sort(Map<String, String> criterias, Set<Notebook> notebooks) {

        Set<Notebook> temp = new HashSet<>(notebooks);
        for (Notebook notebook : notebooks) {
            for (Object pair : criterias.keySet()) {

                if (pair.equals("1") && !notebook.getName().equals(criterias.get(pair))) {
                    temp.remove(notebook);
                }
                if (pair.equals("2") && !notebook.getRam().equals(criterias.get(pair))) {
                    temp.remove(notebook);
                }
                if (pair.equals("3") && !notebook.getHardDisk().equals(criterias.get(pair))) {
                    temp.remove(notebook);
                }
                if (pair.equals("4") && !notebook.getOperatingSystem().equals(criterias.get(pair))) {
                    temp.remove(notebook);
                }
                if (pair.equals("5") && !notebook.getColour().equals(criterias.get(pair))) {
                    temp.remove(notebook);
                }

            }
        }

        if (temp.isEmpty()) {
            System.out.println("По введенным критериям ничего не найдено!");
        } else {
            System.out.println("Вот что мы можем предложить:");

            for (Notebook notebook : temp) {
                System.out.println(notebook.toString());
            }

        }

    }

}
