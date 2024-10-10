package ExceptionExample;

/**
 * 这就是继承自RuntimeException的自定义异常类，甚至啥都没改写，就是改了个名几乎是，构造方法调用完父类的直接构造了
 * 然后没有额外属性，就是换皮！
 *
 */
public class OutOfRangeException extends RuntimeException {
    public OutOfRangeException(String message) {
        super(message);//经典通过父类的构造器直接进行构造
    }
    //这三行都是为了测试一下我的@see能生成出什么东西来
    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
