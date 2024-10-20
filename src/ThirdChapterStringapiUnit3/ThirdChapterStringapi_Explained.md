
# Java 字符串API及StringTokenizer类使用详解

本篇文档基于提供的代码，解释了Java中`String`类的常见API和`StringTokenizer`类的使用方法。

---

## 1. 字符串初始化

- **两种初始化方式**：
    - C++风格的直接赋值：
    ```java
    String s = "String is a list of characters";
    ```
    - 使用`new`关键字创建字符串对象：
    ```java
    String s2 = new String("new way of initialization");
    ```
    IDEA 会提醒你冗余，因为直接赋值更常用且高效。

---

## 2. 常用字符串方法

- **charAt(int index)**：返回字符串中指定索引处的字符：
    ```java
    s.charAt(2); // 返回字符串中索引为2的字符
    ```
- **concat(String str)**：将字符串连接到原字符串末尾：
    ```java
    s = s.concat("!");
    ```
- **contains(CharSequence s)**：检查字符串中是否包含指定子字符串：
    ```java
    s.contains("!");
    ```
- **equals(Object obj)**：比较两个字符串是否相等。注意：比较的是内容，而不是引用地址。
- **indexOf(String str)**：返回子字符串第一次出现的位置索引：
    ```java
    s.indexOf("is");
    ```
- **length()**：返回字符串的长度。
- **substring(int beginIndex, int endIndex)**：返回子字符串（起始索引包括，结束索引不包括）：
    ```java
    s.substring(1, 2);
    s.substring(1); // 从索引1开始直到结尾
    ```
- **toLowerCase()** 和 **toUpperCase()**：分别将字符串转换为小写和大写。
- **trim()**：去除字符串前后的空白字符。
- **valueOf()**：静态方法，将其他类型转换为字符串：
    ```java
    String.valueOf(1); // 返回 "1"
    ```

---

## 3. 字符串分割

- **split(String regex)**：使用正则表达式分割字符串，返回分割后的字符串数组：
    ```java
    String[] fruit = s.split(" ");
    for (String x : fruit) {
        System.out.println(x);
    }
    ```

---

## 4. StringTokenizer 类

`StringTokenizer`类用于将字符串分割为标记（tokens），提供更灵活的字符串解析方式。它的构造函数和常用方法如下：

- **构造函数**：
    1. `StringTokenizer(String str)`：使用默认分隔符（空格、制表符、换行符等）。
    2. `StringTokenizer(String str, String delim)`：使用自定义分隔符。
    3. `StringTokenizer(String str, String delim, boolean returnDelims)`：使用自定义分隔符，若`returnDelims`为`true`，则分隔符也作为标记返回。

- **常用方法**：
    - `countTokens()`：返回还有多少个标记可供提取。
    - `hasMoreTokens()`：判断是否还有可供提取的标记，返回布尔值。
    - `nextToken()`：提取下一个标记，并将指针移到下一个位置。
    - `nextElement()`：返回下一个标记，类型为`Object`。

```java
StringTokenizer A = new StringTokenizer("THAT IS THAT");
System.out.println(A.nextToken(" ")); // 返回下一个标记，不打印分隔符
A.nextElement(); // 返回Object对象
A.nextToken(); // 返回String对象
```

---

## 5. equals 和 == 的区别

- `==` 比较的是对象引用，只有当两个对象引用相同内存地址时才会返回`true`。
- `equals()` 方法用于比较字符串内容是否相同，默认比较的是对象引用，但通常会被重写来比较内容。

---

## 6. 示例代码

```java
package ThirdChapterStringapiUnit3;

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

```
