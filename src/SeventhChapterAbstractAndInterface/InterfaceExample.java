package SeventhChapterAbstractAndInterface;

/**
 * 接口是一种特殊的类。同样无法实例化，只能够“被实现”complements
 * 接口可以继承别的接口，可以多继承。
 * 一般类在实现接口的时候，可以实现多个接口
 *
 * 1其中最常见的方法是抽象方法，就是完全没有函数体的方法
 * 2接口中有一种方法叫静态方法，就是从属于类的方法
 * 3default方法，是已经实现好了的方法，子类不必要重写的方法,当然子类要进行重写你也拦不住.你甚至不能使用final来进行对函数名的修饰
 * 4接口内一般没有属性，只能定义不能被修改的静态常量(但是你其实不用写那么多修饰符，反正只要是接口里定义的变量，那都是常量
 * 5
 */
public interface InterfaceExample extends InterfaceFather1,InterfaceFather2{
    void turnOff();
    void turnOn();
    void printOneThing();
    public static final int constOne=2;
    int constTwo=2;//这种定义就不用写public static final，因为在接口里的变量都一定是这样的
    default  int addTwoNumbers(int a, int b){
        int result=0;
        result=a+b;
        return result;
    }

}
interface InterfaceFather1{
    void fatherOne();
}
interface InterfaceFather2{
    void fatherTwo();
}
class TheClassForImplementing implements InterfaceExample{
    @Override
    public void turnOff(){
        System.out.println("turn off");

    }
    @Override
    public void turnOn(){
        System.out.println("turn on");
    }
    @Override
    public void printOneThing(){
        System.out.println("one thing");
    }
    @Override
    public void fatherOne(){
        System.out.println("that's the method of fatherOne");
    }
    @Override
    public void fatherTwo(){
        System.out.println("that's the method of fatherTwo");
    }

    /**
     * 就是为了在这里开始讲匿名类， 匿名内部类。内部类已经讲过，不再赘述。匿名类就是只用一次的类。
     * 没有名字：匿名类没有显式的类名。
     * 简化代码：可以在创建对象的同时定义类的行为。
     * 只能使用一次：通常用于临时的、一次性的实现。
     * 这样lambda表达式的含义就十分清楚了，它就是一个，类似于“简化”的方式来快速实现一个匿名类
     * @param args
     */
    public static void main(String[] args) {
        InterfaceFather2 eg1=new InterfaceFather2() {
            @Override
            public void fatherTwo() {
                System.out.println("我是匿名类");
            }
        };
        eg1.fatherTwo();;
        InterfaceFather1 eg2=()->{
            System.out.println("我是lambda表达式创造的匿名类");
        };
        eg2.fatherOne();
    }
    //匿名类在Java中用于快速实现接口或继承类，简化代码结构。它们通常用于需要一次性使用的场景，如事件处理和回调。


}



