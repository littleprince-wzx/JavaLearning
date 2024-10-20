package EighthChapterIOStream;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 这是第四个
 */
public class BasicByteStreamOutputFunctionPart4 {
    /**
     * //书上代码第一行
     * 这个getproperty也不知道是要干嘛。。
     *
     *
     *
     */
    private static final String NEW_LINE=System.getProperty("line.separator");
    public static void main(String[] args) {
        /**
         * 一个就直接构建，一个就声明缓冲区大小。
         * 新的字节数组输出流
         */
        Scanner scanner=new Scanner(System.in);
        byte[] bytes=scanner.nextLine().getBytes();

        ByteArrayOutputStream byteArrayOutputStream1=new ByteArrayOutputStream();//默认32字节
        ByteArrayOutputStream byteArrayOutputStream2=new ByteArrayOutputStream(58);//声明的是字节数
        byteArrayOutputStream1.write(5);//把int值给写入缓冲区
        byteArrayOutputStream1.write(bytes,0,4);
        try {
            byteArrayOutputStream1.flush();///我真TM是服了，这居然是个空操作，只有file和socket这个才有意义，我这个纯粹没有操作
        }catch (IOException e) {
         e.printStackTrace();
        }
        System.out.println(byteArrayOutputStream1.size());//这很显然啊，就是5，因为你写入了一个int，然后输入了4个值。



        File file =new File("example.txt");
        /**
         * 文件字节输出流的构造方法。
         * 但是我不是很能理解怎么给文件输出流里传参，然后输出到文件里。这个得后面实现
         * okok，gpt解决了我的问题，用bytearray来把数据用writeto来写入。
         *ENQ 是 ASCII 控制字符 (Enquiry) 的名称，十进制值为 5。在你的代码中，你可能是使用了 byteArrayOutputStream.write(5);，
         * 这会将 5 作为一个字节写入输出流，对应的 ASCII 字符就是 ENQ。
         */
        try {
            FileOutputStream fos1 = new FileOutputStream("output1.txt");//以文件名 "example.txt" 创建一个 FileOutputStream，
            // 用于写入数据。如果文件不存在，则创建文件；如果文件已存在，则会覆盖文件中的内容。，如果append为true，则是补充模式
            FileOutputStream fos2 = new FileOutputStream("output2");
            //在大多数操作系统（如 Windows）中，打开的文件通常会被锁定，因此尝试同时打开多个 FileOutputStream 实例可能会导致文件访问异常。
            // 部分系统会抛出 FileNotFoundException 或其他 IO 异常，因为文件可能已经被另一个进程锁定。
            FileOutputStream fos3 = new FileOutputStream(file);//第二种。如果后面的append为true，则就是链接型输入
            //还有一种我不讲，FileDescriptor，我不知道这是干嘛的，什么文件描述符号处
            byteArrayOutputStream1.writeTo(fos1);
        }catch (IOException e){
            e.printStackTrace();

            //把书上代码复现一下


        }





    }
}
