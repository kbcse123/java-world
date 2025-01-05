package com.javaworld.A4_Advanced_Java._2_Concurrency.A0_Introduction;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Shaik Khader
 */

class Container {
    private String message;
    private boolean access = true;

    public synchronized String consume() {
        // Wait until message is available. Guarded block
        if (access) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        access = true;
        // Notify producer that status has changed.
        notifyAll();
        return message;
    }

    public synchronized void produce(String msg) {
        // Wait until message has been retrieved. Guarded block
        if (!access) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        access = false;
        // Store message.
        message = msg;
        System.out.format("MESSAGE SENT: %s%n", message);
        // Notify consumer that status has changed.
        notifyAll();
    }
}

class TraditionalProducer implements Runnable {
    private Container drop;

    public TraditionalProducer(Container drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        String importantInfo[] = {
                "Mohan like Chicken", "Dane like Pork", "Khader like Mutton"
        };
        for (int i = 0; i < importantInfo.length; i++) {
            drop.produce(importantInfo[i]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        drop.produce("DONE");
    }
}

class TraditionalConsumer implements Runnable {
    private Container drop;

    public TraditionalConsumer(Container drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        String message = "";
        while (!(message = drop.consume()).equals("DONE")) {
            System.out.format("MESSAGE RECEIVED: %s%n", message);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.format("MESSAGE RECEIVED: %s%n", message);
    }
}

class BlockingProducer implements Runnable {
    private final BlockingQueue<String> sharedQueue;
    public BlockingProducer(BlockingQueue<String> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        String importantInfo[] = {
                "Hi", "There", "How", "are", "you?", "What's", "going", "on", "in", "your", "life?"
        };
        try {
            for (int i = 0; i < importantInfo.length; i++) {
                String message = importantInfo[i];
                System.out.format("MESSAGE SENT: %s%n", message);
                sharedQueue.put(importantInfo[i]);
                Thread.sleep(1000);
            }
            sharedQueue.put("Done");
        } catch (InterruptedException ex) {
        }
    }
}

// Consumer Class in Java

class BlockingConsumer implements Runnable {
    private final BlockingQueue<String> sharedQueue;

    public BlockingConsumer(BlockingQueue<String> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        String message = "";
        try {
            while (!(message = sharedQueue.take()).equals("Done")) {
                System.out.format("MESSAGE RECEIVED: %s%n", message);
                Thread.sleep(1000);
            }

        } catch (InterruptedException ex) {
        }
    }
}

class LockingProducer implements Runnable {
    final Queue<String> buffer;
    final Lock lock;
    final Condition cond;
    public LockingProducer(Queue<String> buf, Lock loc, Condition con) {
        buffer = buf;
        lock = loc;
        cond = con;
    }

    @Override
    public void run() {
        String messages[] = {
                "Hi", "There", "How", "are", "you?", "Done"
        };

        try {
            lock.lock();
            for (int i = 0; i < messages.length; ) {
                buffer.add(messages[i]);
                System.out.format("Producer: MESSAGE SENT: %s%n", messages[i]);
                if (++i < messages.length) {
                    System.out.println("Producer: Going to Wait State.");
                    cond.await();
                    System.out.println("Producer: Signalled from consumer.");
                }
                cond.signalAll();
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class LockingConsumer implements Runnable {
    final Queue<String> buffer;
    final Lock lock;
    final Condition cond;

	public LockingConsumer(Queue<String> buf, Lock loc, Condition con) {
        buffer = buf;
        lock = loc;
        cond = con;
    }

    @Override
    public void run() {
        String message = "";
        try {
            lock.lock();
            loop:
            while (true) {
                while (buffer.size() == 0) {
                    System.out.println("Consumer: Going to Wait State.");
                    cond.await();
                    System.out.println("Consumer: Signalled from Producer...");
                }
                message = buffer.poll();
                System.out.format("Consumer: MESSAGE RECEIVED: %s%n", message);
                Thread.sleep(2000);
                cond.signalAll();
                if (message.equals("Done")) {
                    break loop;
                }
            }

        } catch (InterruptedException ex) {
        } finally {
            lock.unlock();
        }
    }
}

public class Z0_ProducerConsumerVariants {

    public static void main(String... args) {
        usingTraditionalApproach();
        //usingExplicitLockingAndExecutors();
        // usingBlockingQueueAndExecutors();
    }

    private static void usingExplicitLockingAndExecutors() {
        Queue<String> buffer = new LinkedList<>();
        Lock lock = new ReentrantLock();
        Condition cond = lock.newCondition();
        try (ExecutorService service = Executors.newFixedThreadPool(2)) {
            service.execute(new LockingProducer(buffer, lock, cond));
            service.execute(new LockingConsumer(buffer, lock, cond));
            service.shutdown();
            while (!service.isTerminated()) {
            }
        }
    }

    private static void usingTraditionalApproach() {
        System.out.println("\n*** usingTraditionalApproach() ***");
        Container sharedObject = new Container();
        Thread producerThread = new Thread(new TraditionalProducer(sharedObject));
        Thread consumerThread = new Thread(new TraditionalConsumer(sharedObject));
        producerThread.start();
        consumerThread.start();
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void usingBlockingQueueAndExecutors() {
        System.out.println("\n*** usingBlockingQueueAndExecutors() ***");
        BlockingQueue<String> sharedQueue = new LinkedBlockingQueue<>();
        try (ExecutorService service = Executors.newFixedThreadPool(2)) {
            service.execute(new BlockingProducer(sharedQueue));
            service.execute(new BlockingConsumer(sharedQueue));
            service.shutdown();
            System.out.println("This will be executed before threads finish...");
            while (!service.isTerminated()) {
            }
        }
        System.out.println("This will be executed after threads finish...");
    }
}
