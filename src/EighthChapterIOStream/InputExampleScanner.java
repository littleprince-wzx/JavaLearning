package EighthChapterIOStream;
import java.util.Scanner;
public class InputExampleScanner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);//传入的参数居然是一个输入流
        //System.in
        //System.in 是 System 类中的一个静态字段，类型为 InputStream。它实际上是一个指向某个具体 InputStream 子类实例的引用。
        //在 Java 中，System.in 通常指向 BufferedInputStream 或 FileInputStream 的实例，这些类是 InputStream 的具体实现。就是这样的
        System.out.println("输入一个字符");
        String input=scanner.next();//对scanner的理解还不清晰  反正是读取了一行，.next有点像迭代器
        char character = input.charAt(0); // 获取字符串的第一个字符
        System.out.println(input);
        System.out.println(character);

        //scanner 也有很多类似cin ，cin还有.read()的函数，都忘的差不多了反正

    }
}
