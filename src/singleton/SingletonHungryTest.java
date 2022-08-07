package singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonHungryTest {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        SingletonHungry singletonHungry = SingletonHungry.getInstance();
        SingletonHungry singletonHungry2 = SingletonHungry.getInstance();
//        反射攻击单例模式
//        Constructor<SingletonHungry> declaredConstructor = SingletonHungry.class.getDeclaredConstructor();
//        declaredConstructor.setAccessible(true);
//        SingletonHungry singletonHungry1 = declaredConstructor.newInstance(null);
//        System.out.println(singletonHungry == singletonHungry1);
        System.out.println(singletonHungry == singletonHungry2);

    }
}

class SingletonHungry {
    private static SingletonHungry instance = new SingletonHungry();
    private SingletonHungry() {
//        防止反射攻击
        if (instance != null) {
            throw new RuntimeException("单例模式不允许多次实例化");
        }
    }

    public static SingletonHungry getInstance() {
        return instance;
    }
}