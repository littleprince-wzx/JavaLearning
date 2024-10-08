import Example.*;
//这是Second

public class BasicRules {
    private float x;
    private float y;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    //经典setget 加一个构造函数

    public BasicRules(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public BasicRules() {
    }

    public BasicRules(float x) {
        this.x = x;
    }
    public int add(int a,int b,int c){
        return a+b+c;
    }
    public int add(int a,int b){
        return a+b;
    }
    public static int numberOfinstances=0;

    //this就相当于python里的self
    /*
    就开始面向对象了
    1实例化：我后面已经写了一个经典的，调用带参数的构造函数的。这构造函数只要是传入参数不同我就可以一直重载啊.其他方法也是这样的，疯狂重载就行
    2讲解一下，这个first实际上就是一个存储一个对象所在的heap的地址的指针，一个地址变量。
    3p71方法的形式参数和实际参数方式。
    {
    1java干什么都是值传递，而假如参数是一个基本类型，那么你传入一个值，就会拷贝他的副本过去
    2如果是一个引用类型，即指针类型，那么就拿指针来理解。举个例子
    public static void changeOne(Point2D p1)
    { p1=new Point2D（7700.0f,8888.0f;   这肯定是没啥用的，你相当于是把指针copy过去了，然后在那里改变那个副本的值
      p1.setX(400.0f); 这就肯定有用了，因为.就相当于调用了它指定对象的方法

    }
    4方法重载，这都没什么好说的，同名，传入参数不同（类型和个数，然后返回什么值也不一定一样）
    5方法重写，子类把内部实现细节全部修改，但是传入参数和返回值类型应该完全一致
    5static关键字 不同于实例变量，用于修饰类变量，就是这个属性是属于类的，可以不实例化然后调用，调用权限和普通类变量没啥两样
    6static修饰方法 就是静态方法了，类方法，类方法不能访问实例变量，但是能访问类变量,同样，对象可以调用静态方法，类也可以
    类方法没有this,类的实例方法可以调用实例方法和静态方法，而静态方法只能调用静态方法。
    7final 关键字=  c language const关键字
    final 修饰成员方法，则只能被子类继承，不能被子类重写
    final 修饰类则不能被继承
    8
    java 的package 机制
    import java.util.Calendar;
    import java.util.*;
    这是已经写好的包
    java.util包中的类需要显式导入才能使用
    而java.lang 是java各种核心类，无需显式导入，包含Java语言的核心类，如String、Math、Integer、System等。
    9自定义的包
    一 新建一个软件包
    二建立一个类
    三在你想导入的那个类里面这样写
    import Example.TestPackage;
    or
    import Example.*
    10:
    访问权限，我都懒得说了
    public：啥时候都可了
    protected：其他包内子类，同一个包内其他类   你就算是其他包内子类你还是要import过去
    default（缺省）：本包内，同一个包
    private:类内部


     */
    public static void increment()
    {
        numberOfinstances++;
    }

}
class Extends1 extends TestAuthority{
    private int age;

    public Extends1(int age,int a,int b) {
        super(a,b);     //这里得调用父类的构造方法，但我怎么调用不出来呢？因为得直接super()加参数
        this.age = age;
    }
}
class test{
public static void main(String[] args) {
    BasicRules first=new BasicRules(4.2f,(float)4.3);//我是绝对不会推荐第二种赋值方式的。5.6这种数字常规都是double
    BasicRules.numberOfinstances++;//仍然是相同的，你这个private，public是一样限制的
    first.numberOfinstances++;
    first.increment();
    BasicRules.increment();
    System.out.println(BasicRules.numberOfinstances);
    TestPackage second=new TestPackage(1,"jonathan");//单引号居然只能引起字符
    Extends1 third=new Extends1(1,2,3);
    // System.out.println(third.a); 这无论是子类实例还是父类实例都tm无法调用这该死的protected访问权限的变量。但是很神奇的是
    //不是，这本包内的子类还是本身的类还是能使用它的这个protected变量呢，服了算了算了
    //但凡我把a改成那个破public ，System.out.println(third.a);就没问题了
}
}
