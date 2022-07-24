package com.renwu2;

public class DoubleList {

    /*
     * 建立双链表的结点
     *
     * */
    public class ListNode<T> {

        public T val;  //存储当前结点的变量
        public ListNode Prev; //当前结点的前一个结点
        public ListNode Next; //当前结点的后一个结点

        public ListNode(T val) {//构造器
            this.val = val;
        }
    }

    private ListNode head;  //存储头结点
    private int size = 0; //记录结点的数量,为了便于插入，这里把位置的初始值变为0

    //插入方法
    public boolean add(Object object, int position) {
        //如果是空链表，而且插入的位置不是第一个，则无法插入
        if (this.head == null&&position!=0) {
            return false;
        }
        //判断插入位置是否合理
        if (position > this.size || position < 0) {
            System.out.println("插入的坐标位置不合理");
            return false;
        }

        ListNode node = new ListNode(object);
        //如果插入的是头结点,头结点位置为0
        if (position == 0) {//如果头结点为空，直接放在头结点
            if (this.head == null) {
                this.head = node;
            } else {//如果头结点不是空的，就把这个结点的下一个存储成头结点，头结点的前一个存储为node，最后把node变为
                //头结点
                node.Next = this.head;
                this.head.Prev = node;
                this.head = node;

            }
            this.size++;
            return true;
        }

        //如果插入的位置是最后一个
        if (position == this.size) {

            ListNode temp =this.head;
            while(temp.Next!=null){
                temp=temp.Next;
            }
            //赋给temp头结点的地址，遍历找到最后一个结点，把node插入到最后一个结点的位置
            temp.Next=node;
            node.Prev=temp;
            return true;
        }
        //如果插入的位置是其他位置
        int tp = position;
        ListNode tmp = this.head;

        while(tp>0){
            tmp =tmp.Next;
            tp--;
        }
        node.Next = tmp;
        node.Prev = tmp.Prev;
        tmp.Prev.Next=node;
        tmp.Prev =node;
        return true;
    }

    public void remove(Object object){
        //如果链表为空，则无法删除
        if(this.head==null){
            return;
        }
        //如果删除的为头结点
        if(this.head.val == object){
            this.head = this.head.Next;
            this.head.Prev = null;
            return;
        }

        ListNode tmp = this.head;
        while(tmp!=null){
            //如果找到了
            if(tmp.val == object){
                //如果删除的位置为最后一个
                if(tmp.Next==null){
                    tmp.Prev.Next = null;
                    tmp.Prev = null;
                    return;
                }else {
                    tmp.Prev.Next = tmp.Next;
                    tmp.Next.Prev =tmp.Prev;
                    return;
                }
            }else{
                tmp=tmp.Next;
            }
        }
    }

    //查找出结点的位置，并返回位置
    public int Found(Object object){
        ListNode tmp = this.head;
        int position= 0;
        while(tmp!=null){
            if(tmp.val==object){
                return position;
            }else{
                tmp=tmp.Next;
                position++;
            }
        }
        return -1;
    }
    //遍历列表
    public void BianLiList(){

        if(this.head==null){
            return;
        }
        ListNode tmp =this.head;
        while(tmp.Next!=null) {
            System.out.println(tmp.val);
            tmp = tmp.Next;
        }
    }
    //翻转列表
    public static DoubleList FanList(DoubleList list){
        if(list.head==null){
            return null;
        }

        ListNode tmp = list.head;
        ListNode tmp1;
        while(tmp.Next!=null){
            tmp=tmp.Next;
             tmp1=tmp.Prev.Next;
             tmp.Prev.Next=tmp.Prev.Prev;
             tmp.Prev.Prev =tmp1;
        }
        DoubleList list1 =new DoubleList();
        list1.head =tmp;
        return list1;
    }
}





