import com.renwu1.Calculate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Calculate calculate = new Calculate();
        Scanner in = new Scanner(System.in);
        System.out.println("请输入正确的表达式:");
        String BiaoDaShi = in.next();
        System.out.println(Calculate.Result(Calculate.houzhui(BiaoDaShi)));
    }
}