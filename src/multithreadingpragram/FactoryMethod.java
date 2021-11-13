package multithreadingpragram;

public class FactoryMethod implements Runnable{
    void print(){

        System.out.println("Hello");
    }
    public void run(){
//        for (int i=1; i<11; i++){
//            System.out.println(i);
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        print();
    }

    public static void main(String[] args) {
        Thread t = new Thread();

    }
}
