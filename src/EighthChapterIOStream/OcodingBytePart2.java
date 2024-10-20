package EighthChapterIOStream;
import java.io.*;

/**
 * 这是第二个
 */
public class OcodingBytePart2 {
    public static void main(String[] args) {
        String str="Hello world";
        byte [] b;
        /**
         * //System.out是一个PrintStream 对象，内部实现了缓冲机制。
         * //具体各种继承关系都在书上p219页
         */
        OutputStream out =System.out;
        /**
         * 这个printstream通常依赖于bufferedoutstream来实现缓冲机制
         * 具体有点复杂，但是核心是用一个字节数组来完成这些问题
         * 缓冲区实现的核心是一个字节数组 buf[]，它会逐步填满写入的字节，直到缓冲区满时将内容写入底层输出流。其实现类似于以下逻辑
         */
        //在你的代码中，out.write(b) 将字节数组写入到 PrintStream 的缓冲区。此时，数据并没有立即显示在控制台上，而是暂时存储在缓冲区中。
        //只有在调用 out.flush() 时，缓冲区中的数据才会被实际写入到控制台并显示出来
        b=str.getBytes();//很经典了，返回字节数组
        try{
            out.write(b);//一个字节数组中的数据输入到流中
            out.flush();//把缓冲区刷新，且把缓冲区的数据强制送出。（书上这么写的，估计就是送出到控制台？）
        }catch (IOException e){
            System.err.println(e);
        }


        /**
         * 再把书上的两个write不同传参的东西写在这里。然后就讲基本字节流
         */
    }
}
