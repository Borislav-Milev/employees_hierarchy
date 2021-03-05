package com.company;

import com.company.hierarchy.CreateHierarchy;

public class Main {

    public static void main(String[] args) {
        CreateHierarchy build = new CreateHierarchy();
        String[] values = {"1 6", "2 5", "3 6", "4 5", "5 6", "6", "7 1", "8 3", "9 5", "10 1"};
        build.fillMap(values);
    }
}
