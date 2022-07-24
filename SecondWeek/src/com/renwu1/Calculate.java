package com.renwu1;//主要运用数据结构中学习到的，中缀表达式转化为后缀表达式
//然后再进行计算

//中缀表达式转化为后缀表达式的方法，遇到数字直接输出，遇到运算字符直接压入栈中
//给+ ，- ，*，/这四个字符字符一个优先级，如果栈里面的运算符的优先级大于等于入栈字符，直接出栈
import java.util.Scanner;
public class Calculate {

    //将输入的中缀表达式转换为后缀表达式
    public static String[] houzhui(String str) {
        String s = "";                  // 用于承接多位数的字符串
        char[] opStack = new char[100];// 静态栈,对输入的操作符进行处理，用于存储运算符
        String[] postQueue = new String[100];// 存储后缀表达式字符串的数组
        int top = -1, j = 0;                // 静态指针top,控制变量j，这里使用数组建立栈
        for (int i = 0; i < str.length(); i++)// 遍历输入的表达式
            // indexof函数，返回字串首次出现的位置；charAt函数返回index位置处的字符；
        {
            if ("0123456789.".indexOf(str.charAt(i)) >= 0) // 遇到数字字符的情况直接入队
            {
                s = "";                 // 作为承接字符，每次开始时都要清空
                for (; i < str.length() && "0123456789.".indexOf(str.charAt(i)) >= 0; i++) {
                    //只要是数字，或者没有超出输入数组的大小的，把数字字符均存储在s中，以便存入后缀栈中
                    s = s + str.charAt(i);
            //做循环主要是为了，如134+3，把超过一位数的数组也存储在起来
                }
                i--;
                postQueue[j] = s;// 数字字符直接加入后缀表达式的数组中
                j++;

            } else if ("(".indexOf(str.charAt(i)) >= 0) {// 遇到左括号，压入栈中
                top++;
                opStack[top] = str.charAt(i);// 左括号入栈
            } else if (")".indexOf(str.charAt(i)) >= 0) {// 遇到右括号，进行出栈操作，直到遇到左括号结束
                for (; ; )
                {
                    if (opStack[top] != '(') {// 栈顶元素不是左括号
                        postQueue[j] = opStack[top] + "";// 栈顶元素出栈
                        j++;
                        top--;

                    } else { // 找到栈顶元素是左括号
                        top--;// 删除栈顶左括号
                        break;// 循环结束
                    }

                }
            } else if ("*%/+-".indexOf(str.charAt(i)) >= 0)// 遇到运算符
            {
                if (top == -1) {// 若栈为空则直接入栈
                    top++;
                    opStack[top] = str.charAt(i);
                } else if ("*%/".indexOf(opStack[top]) >= 0) {// 当栈顶元素为高优先级运算符时,让栈顶元素出栈进入后缀表达式后,当前运算符再入栈
                    postQueue[j] = opStack[top] + "";
                    j++;
                    opStack[top] = str.charAt(i);
                } else {
                    top++;
                    opStack[top] = str.charAt(i);// 当前元素入栈
                }
            }
        }
        while (top != -1) {// 遍历结束后将栈中剩余元素依次出栈进入后缀表达式
            postQueue[j] = opStack[top] + "";
            j++;
            top--;
        }
        return postQueue;
    }

    // 计算后缀表达式，并返回最终结果
    public static String Result(String[] str) {
        String[] Result = new String[100];// 顺序存储的栈，数据类型为字符串
        int Top = -1;                     // 静态指针Top
        for (int i = 0; str[i] != null; i++) {
            if ("+-*%/".indexOf(str[i]) < 0) { //遇到数字，直接入栈
                Top++;
                Result[Top] = str[i];
            }
            if ("+-*%/".indexOf(str[i]) >= 0)// 遇到运算符字符，将栈顶两个元素出栈计算并将结果返回栈顶
            {
                double x, y, n;
                x = Double.parseDouble(Result[Top]);// 顺序出栈两个数字字符串，并转换为double类型
                Top--;
                y = Double.parseDouble(Result[Top]);
                Top--;
                if ("*".indexOf(str[i]) >= 0) {
                    n = y * x;
                    Top++;
                    Result[Top] = String.valueOf(n);// 将运算结果重新入栈

                }
                if ("/".indexOf(str[i]) >= 0) {

                    if (x == 0)// 被除数不允许为0
                    {
                        String s = "error!";
                        return s;
                    } else {
                        n = y / x;
                        Top++;
                        Result[Top] = String.valueOf(n);// 将运算结果重新入栈
                    }
                }
                if ("%".indexOf(str[i]) >= 0) {
                    if (x == 0)// 被除数不允许为0
                    {
                        String s = "error!";
                        return s;
                    } else {
                        n = y % x;
                        Top++;
                        Result[Top] = String.valueOf(n);// 将运算结果重新入栈
                    }
                }
                if ("-".indexOf(str[i]) >= 0) {
                    n = y - x;
                    Top++;
                    Result[Top] = String.valueOf(n);// 将运算结果重新入栈
                }
                if ("+".indexOf(str[i]) >= 0) {
                    n = y + x;
                    Top++;
                    Result[Top] = String.valueOf(n);// 将运算结果重新入栈
                }
            }
        }
        return Result[Top];// 返回最终结果
    }


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.println("请输入正确的表达式:");
//        String BiaoDaShi = in.next();
//        System.out.println(Result(houzhui(BiaoDaShi)));
//    }


}



