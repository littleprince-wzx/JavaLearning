import java.util.StringTokenizer;

public class StringApi {
    private int a;
    private int b;

    public static void main(String[] args) {
        String s="String is a list of characters";//cpp风格初始化
        String s2=new String("new way of initializaion");//把它当对象初始化（IDEA会提醒你冗余
        System.out.println(s.charAt(2));//返回index处的char值1
        s=s.concat("!");//连接尾部2
        System.out.println(s);
        System.out.println(s.contains("!"));//是否包含3
        System.out.println(s.equals(s2));//判断是否相等
        System.out.println(s.indexOf("is"));//返回子字符串第一次出现处的索引
        s.length();//返回长度
        s.substring(1,2);//返回子字符串，可以指定首尾,inclusive begin,exclusive end
        s.substring(1);
        s.toLowerCase();//
        s.toUpperCase();//都没什么说的，都是简单的转化
        s.trim();//with all the leading and trailing space removed
        System.out.println(s.valueOf(1));//static方法，所以直接String.valueOf即可，但是实例变量也可以引用
        String [] fruit=s.split(" ");
        for(String x:fruit) {
            System.out.println(x);
        }
        StringTokenizer A=new StringTokenizer("THAT IS THAT");


/*


    //基本方法
    //1初始化，常用方法 Charsequence是一个接口，emmmm那书上写了个这个方法boolean contains(CharSequence s)，
    // 2：字符串的链接  s=s.concat("!");//连接尾部2
    //3子字符串的操作， s.substring(1);4字符串比较
    4字符串的比较，只能使用== 或者.equals方法，就算两个字符串内容一样，但是因为他们本质都是指针（引用类型）
    字符串在java 和python中都不是以空字符结尾的，且java和python中字符串是不可变对象，String b【2】=‘b’;是错误的赋值
    而c语言则是可变对象，双引号引起的叫字符串字面量，如果是char* b=“hello world”；那他
    string.h给了一些操作字符串的方法，strcat，strcmp，str
    PRINTF(%s,s)；打印到空字符结束
    anyways，回到java。
    equals如果不重写的话，就只比较地址类型，反正这个是最容易被重写的方法了，比较对象是否相等肯定不能只比较内存地址
    public boolean equals(object o){
    if(o==null){
    return false;}
    else if(o instanceof Person)
    {
    Person person =(Person)o;
    return (this.name).equals(person.name);
    }
    return false;
    这个示例代码也不好，这里的两个人名字相等的意思实际上是两个人名字是同一个
    这个equals 方法后面还会讲，后面还有重写，不多赘述
    5字符串的分隔
    原型函数为public String[] split(String regex,int limit )
    分割完会直接返回一堆堆碎片字符串，然后放在一个数组里，limit指的是份数,可以不用
    如果一个对象隐式或者显式调用了toString，那就是把地址打印出来了
    6StringTokenizer，就是字符串解析更方便的类
    三种构造方法
    1就跟String构造方法一模一样没什么区别，使用默认分隔符
    空格、制表符、换行符、回车符、换页符（默认分隔符）
    2StringTokenizer(String str，String delim)使用自定义分隔符
    3StringTokenizer(String str，String delim，boolean returnDelims)使用自定义分隔符，如果后面那个布尔值为真，那么分隔符也将被包含
    apple
    ,
    orange
    :
    banana
    这样的
    常用方法
    int countTokens（）返回nextToken（）的调用次数
    标记提取：每次调用 nextToken() 方法时，StringTokenizer 返回当前标记，并将内部指针移动到下一个标记的开始位置。
    StringTokenizer 维护一个内部指针来跟踪当前解析的位置，并使用分隔符来确定标记的边界。

    7
    这里提到可以用静态工厂方法来实例化，比如说，额，这里想用split和tokenizer去多样的用字符串来初始化，实例化
    具体静态工厂有什么用我也没搞清楚
    token：标志，代金券，信物，礼券，专用辅币
     */
    //A是一个StringTokenizer对象
        A.countTokens();//返回调用次数
        A.hasMoreElements();//这玩意和hasMoreTokens好像是一样的，都是布尔类型，返回是否还有更多的可用的词汇单元
        A.hasMoreTokens();//这俩都是
        System.out.println(A.nextToken(" "));//是不打印分隔符的
        A.nextElement();//返回了object对象
        A.nextToken();//返回了String对象
       // A.nextToken(" ");//以指定的分隔符来返回下一个词汇单元,分隔符类型为String
        //连续三个next，a直接返回不到字符串了，服了
        StringTokenizer test=new StringTokenizer("THAT IS THAT");
        System.out.println(test.nextToken(" "));
        System.out.println(test.nextToken());

    }
}
