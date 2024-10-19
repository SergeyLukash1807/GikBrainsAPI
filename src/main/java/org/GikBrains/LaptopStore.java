package org.GikBrains;

import java.util.*;

public class LaptopStore {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop(8, 512, "Windows", "Black"));
        laptops.add(new Laptop(16, 1024, "Linux", "Silver"));
        laptops.add(new Laptop(32, 2048, "macOS", "Gray"));
        laptops.add(new Laptop(8, 256, "Windows", "Red"));
        laptops.add(new Laptop(16, 512, "Linux", "Black"));

        Scanner scanner = new Scanner(System.in);
        Map<String, String> filters = new HashMap<>();

        boolean moreFilters = true;
        while (moreFilters) {
            System.out.println("Введите цифру, соответствующую критерию фильтрации:");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");

            String filter = scanner.nextLine();
            switch (filter) {
                case "1":
                    System.out.println("Введите минимальный объем ОЗУ (ГБ):");
                    filters.put("ram", scanner.nextLine());
                    break;
                case "2":
                    System.out.println("Введите минимальный объем ЖД (ГБ):");
                    filters.put("hdd", scanner.nextLine());
                    break;
                case "3":
                    System.out.println("Введите операционную систему:");
                    filters.put("os", scanner.nextLine());
                    break;
                case "4":
                    System.out.println("Введите цвет:");
                    filters.put("color", scanner.nextLine());
                    break;
                default:
                    System.out.println("Неверный ввод");
            }

            System.out.println("Добавить еще один критерий? (да/нет)");
            moreFilters = scanner.nextLine().equalsIgnoreCase("да");
        }

        filterLaptops(laptops, filters);
    }

    public static void filterLaptops(Set<Laptop> laptops, Map<String, String> filters) {
        for (Laptop laptop : laptops) {
            boolean matches = true;

            if (filters.containsKey("ram")) {
                int minRam = Integer.parseInt(filters.get("ram"));
                if (laptop.getRam() < minRam) {
                    matches = false;
                }
            }

            if (filters.containsKey("hdd")) {
                int minHdd = Integer.parseInt(filters.get("hdd"));
                if (laptop.getHdd() < minHdd) {
                    matches = false;
                }
            }

            if (filters.containsKey("os")) {
                if (!laptop.getOs().equalsIgnoreCase(filters.get("os"))) {
                    matches = false;
                }
            }

            if (filters.containsKey("color")) {
                if (!laptop.getColor().equalsIgnoreCase(filters.get("color"))) {
                    matches = false;
                }
            }

            if (matches) {
                System.out.println(laptop);
            }
        }
    }
}