package singleton;

public class SingletonEnumTest {
    public static void main(String[] args) {
        SingletonEnum instance = SingletonEnum.INSTANCE;
        SingletonEnum instance2 = SingletonEnum.INSTANCE;
        System.out.println(instance == instance2);
        instance.sayOK();
    }
}

/**
 * 枚举实现单例模式，可以解决反序列化问题，以及反射问题。
 */
enum SingletonEnum{
    INSTANCE;
  public void sayOK(){
      System.out.println("ok");
  }
}
