package struct;

import java.util.Scanner;

public class ArrayQueue {
    public static void main(String[] args) {
        methods methods = new methods();
        methods.arrayMethods(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    methods.showQueue();
                    System.out.println("showQueue");
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    methods.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = methods.getQueue();
                        System.out.println("取出的数据是：" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        System.out.println("查看队列头的数据");
                        int i = methods.headQueue();
                        System.out.println("头数据为" + i);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class methods {
    //        数组最大容量
    int maxSize;
    int head;
    int rear;
    int[] arr;
    public void arrayMethods(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        head = 0;
        rear = 0;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == head;
    }

    //        判断队列是否为空
    public boolean isEmpty() {
        return rear == head;
    }

    //        t添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满");
            return;
        }
//           直接将数据加入
        arr[rear] = n;
//            将rear后移，必须考虑取模
        rear = (rear+1) % maxSize;
    }

    //        获取队列的数据，出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空 不能取数据");
        }
//            需要分析出head是指向队列的第一个元素
//            1。先把这个head对应的值保存到一个临时变量
//            2。将head后移
//            3。将临时保存的变量返回
        int temp = arr[head];
        head = (head + 1) % maxSize;
        return temp;
    }

    //        显示所有的数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，无数据");
            return;
        }
//            从head开始遍历，遍历多少个元素

        for (int i = head; i < head + size(); i++) {
            System.out.println(i % maxSize + ":" + arr[i % maxSize]);
        }
    }

    //        求出当前队列有效值个数
    public int size() {
        return (rear + maxSize - head) %maxSize;
    }

    //          显示队列的头数据，
    public int headQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，无数据");
        }
        return arr[head];
    }
}


