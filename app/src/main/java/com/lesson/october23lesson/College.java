package com.lesson.october23lesson;

public class College
{
    int logo;
    String name, patron;

    public College(int logo, String name, String patron) {
        this.logo = logo;
        this.name = name;
        this.patron = patron;
    }

    public int getLogo() {
        return logo;
    }

    public String getName() {
        return name;
    }

    public String getPatron() {
        return patron;
    }
}
