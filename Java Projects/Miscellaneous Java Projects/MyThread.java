package programs;

public class MyThread extends Thread {
    int [] values = {1,2,3,4,5};
    String ThreadName;
    public MyThread(String s) {
        ThreadName = s;
    }
    public void run() {
        for (int i = 0;i < 5;i++) {
            values[i] = values[i] * 2;
            print(values[i]);
            
        }}
        void print(int ii)
        {
        System.out.println(ThreadName  + " m " + ii);
        }
    
}
class MyThread2 extends Thread {
    int [] values = {1,2,3,4,5};
    
    String ThreadName;
    public MyThread2(String s) {
        ThreadName = s;
    }
    public void run() {
        for (int i = 0;i < 5;i++) {
            values[i] = values[i] * 4;
            System.out.println(ThreadName + " " + values[i]);
        }
    }
}
class Test {
    public static void main(String[] arguements) {
        MyThread T1 = new MyThread("Thread 1");
        MyThread2 T2 = new MyThread2("Thread 2");
        T1.start();
        
        T2.start();
    }

}
