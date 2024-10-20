package EighthChapterIOStream;

import java.io.*;
import java.util.Scanner;

/**
 * 这是第三个
 */
public class BasicByteStreamInputFunctionPart3 {

    public static void main(String[] args) {
        //基本字节流就讲了bytearray,fileinputStream，和过滤流
        /**
         * 只讲了这俩input的构造方法，并没有深入去讲他们的新增方法。
         * 但是我觉得这个input对于文件还是很重要，后面文件编程肯定还要再学
         * 在 Java 中，如果你定义了一个有参构造函数，那么 Java 不会再自动提供默认的无参构造函数。Java 只会在类中没有定义任何构造函数时，自动生成一个无参的默认构造函数。如果你需要无参构造函数，必须手动定义。
         */
        Scanner scanner=new Scanner(System.in);//string才有getbyte
        byte[] example = scanner.nextLine().getBytes();
        /**
         * 第一种构造方式，传参传一个字节数组，把这个字节数组作为输入流，从指定字节数组里读入
         */
        ByteArrayInputStream byteArrayInputStream1=new ByteArrayInputStream(example);
        /**
         * 第二种构造方式，多加了offset和length，就是说从偏移量开始读，读length个
         * offset为0则不偏移
         */
        ByteArrayInputStream byteArrayInputStream2=new ByteArrayInputStream(example,0,5);

        /**
         * 文件读取，也是有两种构造方式，一种是通过一个File对象来制定，一种是通过String来指定。
         * 这文件用相对路径和绝对路径都可以
         */
        File file =new File("example.txt");
        try{
            FileInputStream fileInputStream1=new FileInputStream(file);//用对象构建


        }catch (FileNotFoundException fileNotFoundException){
            System.out.println("file is not found!!");
        }
        try(FileInputStream fileInputStream1=new FileInputStream("example.txt")){
            System.out.println("Reading file with File object.");
            //用对象构建


        }catch (FileNotFoundException fileNotFoundException){
            System.out.println("file is not found!!");
        }
        catch (IOException e){
            System.out.println("解决一下经典的这个io异常");
        }



    }
}
