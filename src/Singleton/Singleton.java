package Singleton;

public class Singleton {
    public static void main(String[] args) throws InterruptedException {
        final int SIZE = 1000;

        Thread t[] = new Thread[SIZE];
        for(int i = 0; i < SIZE; i++)
        {
            t[i] = new Thread(new R());
            t[i].start();
        }
        for (Thread i : t) {
            i.join();
        }
        System.out.println(SingletonExample.getCount());
    }
}

class R implements Runnable{
    @Override
    public void run() {
        SingletonExample.getInstance();
    }
}

class SingletonExample{
    private static int count = 0;

    private static volatile SingletonExample instance;

    public SingletonExample() {
        count++;
    }

    public static SingletonExample getInstance()
    {
        if(instance == null)
        {
            synchronized (SingletonExample.class)
            {
                if(instance == null)
                    instance = new SingletonExample();
            }
        }
        return instance;
    }

    public static int getCount() {
        return count;
    }
}
