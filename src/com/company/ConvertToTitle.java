package com.company;

import java.util.*;

public class ConvertToTitle {

    public static void main(String[] args) {
        //int[] arr = {5,2,3};
        //int target = 10;

        System.out.println("Hello Worlds");
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0){
            int col = (columnNumber - 1) % 26 + 1;
            sb.append((char)(col - 1 + 'A'));
            columnNumber = (columnNumber - col) / 26;
        }
        return sb.reverse().toString();
    }
}

