package SeventhChapterAbstract;

/**
 * 抽象类讲解
 * 拥有抽象方法的一定是抽象类，抽象方法一定被定义在抽象类中
 * 1但抽象类里不一定有抽象方法！！
 * 2含有抽象方法的类一定是抽象类！
 * 3抽象类的实例没有存在意义，但是它的引用可以指向所有子类对象。：：我想尝试一下能不能拿抽象类的实例调用抽象类的一般实例方法
 * 4抽象类的函数特征建立了一个基本形式
 * 抽象方法：包含方法的名称，参数列表，返回类型，但是不含方法主体
 * 继承抽象类的子类若不是抽象类，则必须重写父类中的所有抽象方法。
 * 可以通过抽象类来声明变量，但是没办法通过其构造函数来构造抽象类实例
 * ：：奇怪了，那抽象类有实例吗？我子类实例化之后能赋给抽象类声明的变量吗？是可以的，就是相当于在用引用类型。
 * ：：那父类可以变量可以调用方法吗?
 */
public abstract class AbstractExample {
    private int age;
    private int a;
    private int b;
    public abstract int addTwoNumbers();//最抽象的一集
    public int addThreeNumbers(int a,int b,int c){
        return a+b+c;
    }

    public AbstractExample(int age, int a, int b) {
        this.age = age;
        this.a = a;
        this.b = b;
    }
    //我想知道，如果父类没有构造方法，子类能不能有构造方法？ 这个问题很笨，无论显式隐式，子类构造时都会先调用父类的构造方法。
    //如果你没有写构造方法，java会自己给你搞一个没有带参数的构造方法

}
class AbstractExampleSon extends AbstractExample{
    private int a1;
    private int b1;
    @Override
    public int addTwoNumbers() {//抽象方法在实现的时候也不能写参数列表，真绝了
        //复习！重写不能分配更弱的访问权限
        return a1+b1;
    }
    public AbstractExampleSon(int age,int a,int b,int a1,int b1){
        super(age, a, b);
        this.a1=a1;
        this.b1=b1;
    }

}
class testforAbstract{
    public static void main(String[] args) {
        AbstractExample example1;
        AbstractExampleSon example2 =new AbstractExampleSon(1,2,3,4,5);
        example1=example2;//完全可以这样复制
        System.out.println(example1.addTwoNumbers());//这父类引用还能调用子类方法，因为它子类里是public

    }
}
