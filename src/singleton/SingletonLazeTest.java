package singleton;

public class SingletonLazeTest {
    public static void main(String[] args) {

        new Thread(() -> {
            SingletonLaze instance = SingletonLaze.getInstance();
            System.out.println(instance);
        }).start();

        new Thread(() -> {
            SingletonLaze instance = SingletonLaze.getInstance();
            System.out.println(instance);
        }).start();

    }
}

class SingletonLaze {
    private volatile static SingletonLaze instance;

    private SingletonLaze() {
    }

    public static SingletonLaze getInstance() {
//        懒汉单例模式双重检验锁
        if (instance == null) {
            synchronized (SingletonLaze.class) {
                if (instance == null) {
                    instance = new SingletonLaze();
                }
            }
        }
        return instance;
    }
}
