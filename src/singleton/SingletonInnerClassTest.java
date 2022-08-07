package singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonInnerClassTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        SingletonInnerClass singletonInnerClass = SingletonInnerClass.getInstance();
        SingletonInnerClass singletonInnerClass1 = SingletonInnerClass.getInstance();
        System.out.println(singletonInnerClass1 == singletonInnerClass);
        Constructor<SingletonInnerClass> declaredConstructor = SingletonInnerClass.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        SingletonInnerClass singletonInnerClass2 = declaredConstructor.newInstance(null);
        System.out.println(singletonInnerClass1 == singletonInnerClass2);
    }
}

class SingletonInnerClass {
//    内部静态类实现单例模式，懒加载。
    private static class InnerClassHolder {
        private static SingletonInnerClass instance = new SingletonInnerClass();
    }

    private SingletonInnerClass() {
        if (InnerClassHolder.instance != null) {
            throw new RuntimeException("单例模式不允许多次实例化");
        }
    }

    public static SingletonInnerClass getInstance() {
        return InnerClassHolder.instance;
    }
}
