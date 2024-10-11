package EighthChapterIOStream;
import java.io.*;
public class OcodingByte {
    public static void main(String[] args) {
        String str="Hello world";
        byte [] b;
        OutputStream out =System.out;//System.out是一个PrintStream 对象，内部实现了缓冲机制
        //在你的代码中，out.write(b) 将字节数组写入到 PrintStream 的缓冲区。此时，数据并没有立即显示在控制台上，而是暂时存储在缓冲区中。
        //只有在调用 out.flush() 时，缓冲区中的数据才会被实际写入到控制台并显示出来
        b=str.getBytes();//很经典了，返回字节数组
        try{
            out.write(b);//一个字节数组中的数据输入到流中
            out.flush();//把缓冲区刷新，且把缓冲区的数据强制送出。（书上这么写的，估计就是送出到控制台？）
        }catch (IOException e){
            System.err.println(e);
        }

    }
}
