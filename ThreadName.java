class MyThread implements Runnable{
    @Override
    public void run() {
     // Getting thread's name
        System.out.println("Thread Name- " +Thread.currentThread().getName());
        // Getting thread's ID
        System.out.println("Thread ID- " +Thread.currentThread().getId() + " For " + Thread.currentThread().getName());
      
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {                
            e.printStackTrace();
        }        
        System.out.println("Finished with thread");  
    }   
}

public class ThreadName {

 public static void main(String[] args) {
   // Creating 3 threads
   Thread t1 = new Thread(new MyThread());
   t1.setName("Thread-1");
   Thread t2 = new Thread(new MyThread());
   t2.setName("Thread-2");
   Thread t3 = new Thread(new MyThread());
   t3.setName("Thread-3");
   // Starting threads
   t1.start();
   t2.start();
   t3.start();
 }
}
 