package org.GikBrains;

import java.util.Objects;

public class Laptop {
    private int ram; // объем оперативной памяти
    private int hdd; // объем жесткого диска
    private String os; // операционная система
    private String color; // цвет

    public Laptop(int ram, int hdd, String os, String color) {
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "RAM=" + ram +
                " GB, HDD=" + hdd +
                " GB, OS='" + os + '\'' +
                ", Color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return ram == laptop.ram &&
                hdd == laptop.hdd &&
                os.equals(laptop.os) &&
                color.equals(laptop.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ram, hdd, os, color);
    }
}
