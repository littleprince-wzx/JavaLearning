package FifthChapterUnit4And5;

public class FifthChapter {
    private int Attribute1;
    private String Attribute2;

    public FifthChapter(int attribute1, String attribute2) {
        Attribute1 = attribute1;
        Attribute2 = attribute2;
    }

    public int getAttribute1() {
        return Attribute1;
    }

    public void setAttribute1(int attribute1) {
        Attribute1 = attribute1;
    }

    public String getAttribute2() {
        return Attribute2;
    }

    public void setAttribute2(String attribute2) {
        Attribute2 = attribute2;
    }
    public boolean isEqual(int a, int b){
        if(a==b)
        {
            System.out.println("this is the father's method");
            return true;
        }

        else {
            System.out.println("this is the father's method");
            return false;
        }
    }

}

/**
 * 第四章p160继承关系的java编程实现
 * 刚刚声明这个类它就提醒我没有可用的无形参构造器，正常，因为是子类对象就一定是父类对象
 * 就从这里开始，首先
 * 1，super关键字，大家常用的是super（parameters..*）,调用父类的构造器
 * 当然super.方法名（parameters..*）是可以调用父类方法的。记住，final修饰的父类方法是不能够覆写的
 * 2向上向下转型，upcasting 向上转型怎么样都是合法的，但是转型后的引用类型是没有办法调用子类的方法的
 * 而向下转型则不然，分两种情况，如果本身这个引用就指向子类对象，那随便转，但是如果本身是指向父类的引用，肯定就不能转型
 * 方法的重载就不说了，非常的简单，就只是名字相同，其他没什么相同的
 * 3这里着重讲一下方法重写，父类中的isEqual是相等返回true，子类正好相反
 * 子类重写的方法不能比父类的权限更加严格
 * 异常处理：子类重写的方法可以抛出与父类方法相同的异常或是父类异常的子类，但不能抛出新的或更广泛的异常。@override是标签
 * 书上着重写了 toString和equals两个方法的重写
 * 每次都扯什么UML类图的实现。。我最后把这块总结一下吧，不知道它在干嘛
 * 第五章多态（因为实在太简单了我就在这讲了吧）
 * 1它写了一堆代码告诉我们Triangle，Circle，Square，都可以当做shape对象（基类），所以可以直接被存在一个对象数组里（其实就是指针数组）
 * 2方法的多态性，我都没什么想说的了，就重载重写
 * 3它莫名其妙在这里讲什么继承关系和关联关系，如果既有继承又有关联，推荐直接使用关联优先使用关联关系。因为那个
 * 如果父类发生改变，则会影响子类功能，破坏封装性。如果是关联关系就没有这些问题
 */
class TheSonclass extends FifthChapter{
    public TheSonclass(int attribute1, String attribute2) {
        super(attribute1, attribute2);
    }
    private String SonAttribute2;

    public String getSonAttribute2() {
        return SonAttribute2;
    }

    public void setSonAttribute2(String sonAttribute2) {
        SonAttribute2 = sonAttribute2;
    }

    public int addtwovalues(int a, int b){
        return a+b;
    }

    /**
     * @override 这就是对父类反过来的重写
     * @param a 第一个比较值
     * @param b 第二个比较值
     * @return
     */
    public boolean isEqual(int a, int b)
    {
        if(a==b)
        {
            System.out.println("this is the son's method");
            return false;
        }
        else {
            System.out.println("this is the son's method");
            return false;
        }
    }
}


class TheTestOfSonClass{
    //就是放main函数的
    public static void main(String[] args) {
    FifthChapter eg1Father=new FifthChapter(5,"I am the father");
    TheSonclass eg1Son=new TheSonclass(6,"I am the son");
    //下面尝试赋值
        FifthChapter eg2Fahter=eg1Son;//向上转型没什么问题
        eg2Fahter.toString();
 //这一句就没法跑代码，即便他们只是普通的，一样的指针，但是他们的权限不同，具体怎么实现的我也不知道       eg2Fahter.addtwovalues(1,2);
        eg1Son.addtwovalues(1,2);

    }
}
