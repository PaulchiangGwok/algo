package com.company;

public class MinFlips {

    public static void main(String[] args) {
//        int[] arr = {5,2,3};
        int target = 1010;
        int time = minFlips(58076, 49567, 394506);
//        int[] res = getNoZeroIntegers(target);
        System.out.println();
    }

    public static int minFlips(int a, int b, int c) {
        int count = 0;
        char[] bia = new StringBuffer(Integer.toBinaryString(a)).reverse().toString().toCharArray();
        char[] bib = new StringBuffer(Integer.toBinaryString(b)).reverse().toString().toCharArray();
        char[] bic = new StringBuffer(Integer.toBinaryString(c)).reverse().toString().toCharArray();

        //判断ab 哪个长  长的在上面
        if (bia.length < bib.length) {
            char[] temp = bia;
            bia = bib;
            bib = temp;
        }

        int time = bib.length;
        for (int i = 0; i < time; i++) {
            //FIXME C没有a 这么长 需要保护成0
            if (i >= bic.length) {
                char alast = bia[i];
                char blast = bib[i];
                if (alast != '0') {
                    count++;
                }
                if (blast != '0') {
                    count++;
                }
            } else {
                char clast = bic[i];
                char blast = bib[i];
                char alast = bia[i];
                if (clast == '1') {
                    if (alast == '1' || blast == '1') {
                        continue;
                    } else {
                        count++;
                    }
                } else {
                    //both 0
                    if (alast == '1') {
                        count++;
                    }

                    if (blast == '1') {
                        count++;
                    }
                }
            }
        }

        //对比 a长过b的部分
        for (int i = bib.length; i < bia.length; i++) {
            //FIXME C没有a 这么长 需要保护成0
            if (i >= bic.length) {
                char alast = bia[i];
                if (alast != '0') {
                    count++;
                }
            } else {
                char clast = bic[i];
                char alast = bia[i];
                if (clast != alast) {
                    count++;
                }
            }
        }

        if(bic.length > bia.length){
            for(int i = bia.length;i<bic.length;i++){
                if(bic[i] == '1'){
                    count++;
                }
            }
        }
        return count;
    }
}
