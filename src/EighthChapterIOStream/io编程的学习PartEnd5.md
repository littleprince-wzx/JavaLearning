# io编程就大概是这样了 
# 字节流8.2

## 字节输入输出过滤流
接下来我要进行一个讲解了

` protected FilterInputStream(InputStream in)`
把它得链接到某个数据流上。
`BufferedInputStream,DataInputStream,PushBackStream`
三个继承这个抽象类的具体类

- BufferedInputStream:具有数据缓冲的过滤流，不仅要连接数据流，还要指定缓冲区大小
- ``(InputStream in,int size)``
这就是很经典的一个构造方法。具体什么是InputStream，我也不太清楚

-        byte[] example = scanner.nextLine().getBytes();
        /**
         * 第一种构造方式，传参传一个字节数组，把这个字节数组作为输入流，从指定字节数组里读入
         */
        ByteArrayInputStream byteArrayInputStream1=new ByteArrayInputStream(example);
我现在能链接到的就只有字符数组
常用方法我就不列了，反正

- DataInputStream 这个流直接读取数据流中的int char long 
但我也不会用。到时候看一下最后的文件编程


filterOutStream 过滤输出流
就是前面那俩流加一个printStream，比如那个System.out 就是一个printStream


# 字符流8.3
## 字符输入流
`reader`,`writer` 就是两个重要的抽象类。
然后有一堆乱七八糟的方法定义。
然后讲java 的字符输出流
1 `CharArrayReader`
字符数组reader`(char[] buf)`就这样，然后还有一个带offse int length就很经典

2 `StringReader `对应那个stringBufferInputStream，把字符串作为数据源构造字符输入流

3 `FileReader`，就还是两种构造方法，一种file对象 一种是。

## 字符输出流
- 1 `CharArrayWriter` 他构造并拥有拥有一个内存缓冲区，用与输出字符数组。如果输出字符超过字符数组的容量，系统则会自动扩充字符数组。
两种构造方法，一种无参，一种 int initialSize 
void reset () 把这个里面的count字段设为零。我现在也不知道这个count里到底有啥
- 2 `StringWriter`他也拥有一个自己的字符缓冲区吧，然后可以内存缓冲区里的东西输出为字符串。

- 3 `FileWriter` 这个构造文件输出流。同样的，有两种构造方式
要么File file , `File file,boolean append`,是否为附加模式


## 字符过滤流

- 1 `bufferdReader`, `(Reader in)` `(Reader in , int size )`,指定缓冲区大小 提供 `readline()`方法，可以读取一行文本，可以链接标准输入流
并调用readline来进行逐行读取
```java
public class BasicBytefilter5 {

    public static void main(String[] args) {
        BufferedReader stdin=
        new BufferedReader(new InputStreamReader(System.in));
        try{
            String input = stdin.readLine();
        }catch (IOException exception){

        }
        System.out.println(input);//这样涉及了作用域问题，如果你是把input声明在里面，那你就裂开了
    }
}
突然想提一嘴这个作用域问题，这个try也算一个代码块
```
- 2 `bufferedWriter`,同样两种构造方法  `(Writer out)` 和 `(Writer out ,int size )`那同样是缓冲区
- 3 `printWriter` 有好多好多种构造方法，可以用`File`对象，可以用`String`对象，可用`Writer`对象，可用`output`对象，还可用双参数，`File`加上`String csn`不带自动行刷新，我根本不理解.
  PrintWriter 的构造方法里有一个可以接收文件对象和字符编码字符串的构造函数，用来指定输出时所使用的字符编码。
```java 
PrintWriter(File file, String charsetName) throws FileNotFoundException, UnsupportedEncodingException;
 ```
大概就是这样

# java 文件编程8.4
 我们来看看编者到底想让我们掌握什么。
 