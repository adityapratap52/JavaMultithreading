package multithreadingpragram;

public class GetPriorityAndSetPriority implements Runnable{
    Thread thread;
    String name;

    GetPriorityAndSetPriority(String name){
        this.name = name;
        thread = new Thread(this,name);
        System.out.println("New Thread : "+thread);
    }

    public void run(){
        try {
            for (int num=5; num>0; num--){
                System.out.println(name+" "+num);
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            System.out.println(name+" interrupted");
        }

        System.out.println(name+" thread exiting");
    }

    public static void main(String[] args) {
        GetPriorityAndSetPriority myPriority1 = new GetPriorityAndSetPriority("One");
        GetPriorityAndSetPriority myPriority2 = new GetPriorityAndSetPriority("Two");
        GetPriorityAndSetPriority myPriority3 = new GetPriorityAndSetPriority("Three");

        System.out.println("Thread One Priority: "+myPriority1.thread.getPriority());
        System.out.println("Thread Two Priority: "+myPriority2.thread.getPriority());
        System.out.println("Thread Three Priority: "+myPriority3.thread.getPriority());

        myPriority1.thread.setPriority(Thread.MIN_PRIORITY);
        myPriority2.thread.setPriority(Thread.MAX_PRIORITY);
        myPriority3.thread.setPriority(Thread.NORM_PRIORITY);

        System.out.println("Thread One new Priority: "+myPriority1.thread.getPriority());
        System.out.println("Thread Two new Priority: "+myPriority2.thread.getPriority());
        System.out.println("Thread Three new Priority: "+myPriority3.thread.getPriority());

        myPriority1.thread.start();
        myPriority2.thread.start();
        myPriority3.thread.start();
    }
}
