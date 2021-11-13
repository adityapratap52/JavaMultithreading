package multithreadingpragram;

public class DeadLockInMainMethod {
    public static void main(String[] args) {
        try {
            System.out.println("Entering in DeadLock---");
            Thread.currentThread().join();
            System.out.println("This Statement will never execute");
        }catch (InterruptedException e){
            // Display the exception along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }
    }
}

/*
The statement “Thread.currentThread().join()”, will tell Main thread to wait for
this thread(i.e. wait for itself) to die.
Thus Main thread wait for itself to die, which is nothing but a deadlock.
 */
