package EighthChapterIOStream;
//bytheway我在第四单元的时候因为要考虑输入输出异常，所以调过这个库（库是包的集合）
/**
 * 这是第一个
 * 字节流->抽象的输入流输出流——>基本字节流
 */

import java.io.IOException;
import java.io.*;

/**
 * 流是从外部读取数据或者向外输出数据。java把所有的流都封装为数据了。.close()可以关闭流
 * 输入流和输出流就是
 * 输入流：source -- > program
 * 输出流: program--> dest
 * java把所有的数据流分为两种，一种是“字节流”，一种是字符流。
 * 字节流：以一个字节为单位来读写。图像，视频，多媒体数据
 * 字符流：以两个字节为单位读写，每次读取一个字符，适合读写字符串数据（java中用utf-16，一个字符就是两个字节）c语言中char是一个字节，用别的编码方式不好说
 * 然后书上列出来了io包的主要字节流，还有他们的继承关系，一点看不懂。inputstream什么什么的，output
 * 然后列出来了io包的主要字符流。这个我估计用的比较多。reader和writer
 * anyways,底下先给大家展示一下所有输入字节流的抽象基类InputStream
 * 它的方法表我感觉一时半会都用不上，我也找不到示例代码
 */
public class IcodingBytePart1 {
        //以下这个实现为书中示例代码
    public void m(InputStream in){
        try{
            while(true){
                int i=in.read();//input的read方法
                if(i ==-1){
                    return;
                }
                char c=(char)i;
                System.out.println(c);
            }
        }catch (Exception e){

        }

    }

    public static void main(String[] args) {
     //   IcodingBytePart1 i=new IcodingBytePart1();
     //   i.m(System.in);//你这个方法的实现内部有个while，所以一直在输入，你调用了.read()的方法
        //以下是书上的InputStream主要方法表通过其某一个子类的实现
        // 示例数据
        String data = "Hello, InputStream! This is a demonstration of InputStream methods.";
        byte[] byteArray = data.getBytes();//从字符转换为字节

        /**
         * 创建 ByteArrayInputStream，尽管在讲关于inputstream，但是仍然用byte来举例
         */

        ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArray);//初始化，就相当于是在拿这个String data来举示例

        try {
            // 1. read()：读取下一个字节的数据，并返回其整数值
            int singleByte = inputStream.read();
            System.out.println("第一个读取的字节: " + (char) singleByte);

            // 2. read(byte b[])：将多个字节读入字节数组中，并返回实际读取的字节数
            byte[] buffer = new byte[10];
            int bytesRead = inputStream.read(buffer);//这read指的是吧这个inputStream里的数据读到buffer里，buffer只有十个这么大
            System.out.println("读取的字节 (read(byte[])): " + new String(buffer, 0, bytesRead));

            // 3. read(byte[], int off, int len)：从输入流中读取最多 len 个字节，并将其存储在字节数组的指定偏移量 off 处
            byte[] buffer2 = new byte[10];
            /**
             * 这里读完一次之后这个指针还会偏移？不是重新开始读？
             * 它维护一个内部的指针，每次读取都会从读取结束的位置继续读取。
             */
            int bytesRead2 = inputStream.read(buffer2, 0, 5);
            System.out.println("读取的字节 (read(byte[], int off, int len)): " + new String(buffer2, 0, bytesRead2));

            // 4. skip(long n)：跳过并丢弃 n 个字节的数据
            long skippedBytes = inputStream.skip(5);
            System.out.println("跳过的字节数: " + skippedBytes);

            // 5. available()：返回可以从输入流中读取的字节数.
            //但是书上说什么返回流中不阻塞情况下，我都不知道什么是流阻塞？
            int availableBytes = inputStream.available();
            System.out.println("可用字节数: " + availableBytes);

            // 6. mark(int readlimit)：标记当前流的位置，以便后续调用 reset() 方法可以返回到该位置
            inputStream.mark(20);
            byte[] buffer3 = new byte[5];
            inputStream.read(buffer3);
            System.out.println("标记后的字节: " + new String(buffer3));

            // 7. reset()：将流的位置重置为最后一次调用 mark() 方法的位置
            inputStream.reset();
            byte[] buffer4 = new byte[5];
            inputStream.read(buffer4);
            System.out.println("重置后的字节: " + new String(buffer4));

            // 8. markSupported()：检查此输入流是否支持标记和重置操作
            System.out.println("支持标记: " + inputStream.markSupported());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 9. close()：关闭输入流并释放与之关联的系统资源
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();//1不利于写日志测试2如果有链式异常是不容易追踪的。链式异常简单理解，就是catch内部的代码块再throw一个异常
                /*
                import org.slf4j.Logger;
                import org.slf4j.LoggerFactory;
                估计是日志库

                  logger.error("An exception occurred: ", e);
                 */
            }
        }

    }
}
