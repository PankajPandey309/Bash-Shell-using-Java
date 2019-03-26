public class DeadLckDemo {
    public static void main(String[] args) {
     DeadLckDemo obj1 = new DeadLckDemo();
     DeadLckDemo obj2 = new DeadLckDemo();
        Thread t1 = new Thread(new ThreadA(obj1, obj2), "Thread-1");
        Thread t2 = new Thread(new ThreadB(obj1, obj2), "Thread-2");
        
        t1.start();
        
        t2.start();
    }
}

class ThreadA implements Runnable{
    private DeadLckDemo obj1;
    private DeadLckDemo obj2;
    ThreadA(DeadLckDemo obj1, DeadLckDemo obj2){
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
    @Override
    public void run() {
        synchronized(obj1){
            System.out.println("" + Thread.currentThread().getName());
            synchronized(obj2){
                System.out.println("Reached here");
            }
        }      
    }   
}

class ThreadB implements Runnable{

    private DeadLckDemo obj1;
    private DeadLckDemo obj2;
    ThreadB(DeadLckDemo obj1, DeadLckDemo obj2){
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
    @Override
    public void run() {
        synchronized(obj2){
            System.out.println("" + Thread.currentThread().getName());
            synchronized(obj1){
                System.out.println("Reached here");
            }
        }   
    }
}