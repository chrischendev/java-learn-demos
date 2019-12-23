package com.chris.algorithm;

import java.util.Stack;

/**
 * Create by Chris Chan
 * Create on 2019/12/20 17:15
 * Use for:
 */
public class Alg20191220 {
    public static void main(String[] args) {
        //test01();
        //int i = checkQuote2("(((()(())())(())");
        //int i = checkQuote2("()))()");
        int i = countAvailableQuote2("((()(())()))(()())");
        System.out.println(i);
    }

    /**
     * 检查合理的括号配对
     * 利用栈来解决
     *
     * @param str
     * @return
     */
    private static int checkQuote(String str) {
        Stack<Integer> stack = new Stack<Integer>();
        for (char chr : str.toCharArray()) {
            if (chr == '(') {
                stack.push(1);
            }
            if (chr == ')') {
                if (stack.size() > 0) {
                    stack.pop();
                } else {
                    return -1;
                }
            }

        }

        return stack.size();
    }

    /**
     * 检查合理的括号配对
     * 利用计数
     *
     * @param str
     * @return
     */
    private static int checkQuote2(String str) {
        int count = 0;
        for (char chr : str.toCharArray()) {
            if (chr == '(') {
                count++;
            }
            if (chr == ')') {
                count--;
                if (count < 0) {
                    return count;
                }
            }

        }

        return count;
    }

    /**
     * 统计有效括号配对子字符串的长度
     * 使用栈
     * 整体有问题，出现在开始左括号过多的情况
     * 还未实现
     * @param str
     * @return
     */
    private static int countAvailableQuote(String str) {
        Stack<Integer> stack = new Stack<Integer>();
        //最近一次有效检查位置前一个下标
        int aIndex = -1;
        stack.push(aIndex);
        //有效检查子串的统计
        int count = 0;
        char[] chars = str.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            char chr = chars[i];
            if (chr == '(') {
                //记录下标
                stack.push(i);
            }
            if (chr == ')') {
                //下标出栈
                stack.pop();
                //如果检查出了问题，计算出长度
                if (stack.size() == 1) {
                    aIndex = -1;
                }
            }

        }
        return 0;
    }

    /**
     * 统计有效括号配对子字符串的长度
     * 使用计数
     * 整体有问题，出现在开始左括号过多的情况
     * 双层循环可以解决问题，但是复杂度增加
     * @param str
     * @return
     */
    private static int countAvailableQuote2(String str) {
        //用来记录检查有效子串
        int count = 0;
        //用来记录记录最新匹配的有效子串的长度
        int aCount = 0;
        //用来记录最长的有效字串长度
        int maxLenth = 0;
        char[] chars = str.toCharArray();
        int length = chars.length;
        for (int j = 0; j < length - 1; j++) {
            for (int i = j; i < length; i++) {
                char chr = chars[i];
                if (chr == '(') {
                    count++;
                    aCount++;
                }
                if (chr == ')') {
                    count--;
                    //如果检查出了问题，将count和aCcount复位，并且把最长的长度记录下来
                    if (count < 0) {
                        maxLenth = aCount > maxLenth ? aCount : maxLenth;
                        count = 0;
                        aCount = 0;
                    } else {
                        //否则继续累加
                        aCount++;
                    }
                }

            }
            //每一次大循环结束，都需要把两个变量复位
            count = 0;
            aCount = 0;
        }
        return maxLenth;
    }

    /*

     */
    private static void test01() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        Integer pop = stack.pop();
        System.out.println(pop);
    }
}
