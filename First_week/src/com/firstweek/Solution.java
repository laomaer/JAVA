package com.firstweek;

import javax.swing.*;
import java.sql.Array;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {

    private static Lost[] selectByKeyword;

    public static void main(String[] args) throws ParseException {

        Lost[] ArrayLost = new Lost[10];

        Scanner in = new Scanner(System.in);

        int count = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//设置自己的时间格式
        int j;
        do {
            System.out.println("请依次输入丢失物品的地点，类型，颜色，认领地点：\n");
            Date tp =new Date();
            String sp = in.nextLine();
            String ty = in.nextLine();
            String su = in.nextLine();
            String co = in.nextLine();
            ArrayLost[count] = new Lost(tp,sp, ty, su, co);
            count++;
            System.out.println("请问是否继续输入丢失物品信息：(0/1)\n");
            j = in.nextInt();

        } while (j!=0&&count<10);
//
        String startTime = "2020-01-01";
        String endTime = "2022-07-17";

        Date ST = sdf.parse(startTime);
        Date SE = sdf.parse(endTime);

        System.out.println("随机时间");
//
            for (int i = 0; count < ArrayLost.length; i++) {

                long rt = (long) (ST.getTime() + Math.random() * (SE.getTime() - ST.getTime()));

                Date temp ;
                temp = new Date(rt);
                ArrayLost[count] = new Lost();
                ArrayLost[count].setLostTime(temp);
                count++;
            }


        sortLost(ArrayLost);

        for(Lost a:ArrayLost){

            String t = sdf.format(a.getLostTime());
            System.out.println(t);
        }


        System.out.println("请输入丢失物品的基本信息:er");

        String key = in.nextLine();
        Lost[] FindLost = new Lost[10];
        FindLost = selectByKeyword(ArrayLost, key);
        System.out.println(FindLost);


    }

    public static void sortLost(Lost[] lostArray) {

        if (lostArray == null) {
            return;
        }

        Lost LostTemp = new Lost();
        //使用冒泡排序的方法对数组就行排序
        for (int i = 0; i < lostArray.length - 1; i++) {

            for (int j = i + 1; j < lostArray.length; j++) {

                if (lostArray[i].getLostTime().getTime() < lostArray[j].getLostTime().getTime()) {

                    LostTemp = lostArray[i];
                    lostArray[i] = lostArray[j];
                    lostArray[j] = LostTemp;

                }
            }
        }
    }

    public static Lost[] selectByKeyword(Lost[] lostArray, String keyword){

        Lost[] FindItem=new Lost[lostArray.length];
       

        int  Item_Quantity=0;

        //if(lostArray==null){return null;};

        for( Lost item :lostArray)
        {
            if(item.getItemColor().equals(keyword) || item.getLostSpace().equals(keyword) || item.getLostType().equals(keyword)){
                FindItem[Item_Quantity] =new Lost();
                FindItem[Item_Quantity++] =item;
            }

        }

        return FindItem;
    }
}
