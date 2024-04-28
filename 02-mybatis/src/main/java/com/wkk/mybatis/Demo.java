package com.wkk.mybatis;

/**
 * TODO 类描述
 *
 * @author weikunkun
 * @since 2022/12/3
 */
public class Demo {
    public static void main(String[] args) {
        String des = "dfa12321afd";
        int i = secondHighest(des);
        System.out.println(i);
    }

    public static int secondHighest(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int first = -1;
        int second = -1;
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(chars[i])) {
                int num = chars[i] - '0';
                if (num > first) {
                    second = first;
                    first = num;
                } else if (num < first && num > second) {
                    second = num;
                }
            }
        }
        return second;
    }
}
