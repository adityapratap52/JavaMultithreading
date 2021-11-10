package multithreadingpragram;


// It will get same values so we must use wait and notify

//class Q{
//    int value;
//    synchronized int get(){
//        System.out.println("Got : "+value);
//        return value;
//    }
//    synchronized void put(int value){
//        System.out.println("Put : "+value);
//        this.value = value;
//    }
//}
//
//class Producer implements Runnable{
//    Q q;
//    Thread thread;
//
//    Producer(Q q){
//        this.q = q;
//        thread = new Thread(this,"Producer");
//    }
//
//    public void run(){
//        int i=0;
//        while (i<5){
//            q.put(i++);
//        }
//    }
//}
//
//class Consumer implements Runnable{
//    Q q;
//    Thread thread;
//
//    Consumer(Q q){
//        this.q = q;
//        thread = new Thread(this,"Consumer");
//    }
//
//    public void run(){
//        int i=0;
//        while (i<5){
//            q.get();
//            i++;
//        }
//    }
//}
//
//public class WaitAndNotify {
//    public static void main(String[] args) {
//        Q q = new Q();
//        Producer producer = new Producer(q);
//        Consumer consumer = new Consumer(q);
//
//        // Starts the thread
//        producer.thread.start();
//        consumer.thread.start();
//    }
//}





class Q{
    int value;
    boolean valueSet = false;

    synchronized int get(){
        while (!valueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
        System.out.println("Got : "+value);
        valueSet = false;
        notify();
        return value;
    }
    synchronized void put(int value){
        while (valueSet){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
        this.value = value;
        System.out.println("Put : "+value);
        valueSet = true;
        notify();
    }
}

class Producer implements Runnable{
    Q q;
    Thread thread;

    Producer(Q q){
        this.q = q;
        thread = new Thread(this,"Producer");
    }

    public void run(){
        int i=0;
        while (i<5){
            q.put(i++);
        }
    }
}

class Consumer implements Runnable{
    Q q;
    Thread thread;

    Consumer(Q q){
        this.q = q;
        thread = new Thread(this,"Consumer");
    }

    public void run(){
        int i=0;
        while (i<5){
            q.get();
            i++;
        }
    }
}

public class WaitAndNotify {
    public static void main(String[] args) {
        Q q = new Q();
        Producer producer = new Producer(q);
        Consumer consumer = new Consumer(q);

        // Starts the thread
        producer.thread.start();
        consumer.thread.start();
    }
}
