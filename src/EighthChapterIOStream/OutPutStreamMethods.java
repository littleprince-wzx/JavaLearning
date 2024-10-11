package EighthChapterIOStream;
import java.io.*;
public class OutPutStreamMethods {
    public static void main(String[] args) {
        // 创建一个 ByteArrayOutputStream 对象
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();//无参构造

        try {
            // 使用 write(int b) 方法写入单个字节
            byteArrayOutputStream.write('H');
            byteArrayOutputStream.write('e');
            byteArrayOutputStream.write('l');
            byteArrayOutputStream.write('l');
            byteArrayOutputStream.write('o');

            // 使用 write(byte[]) 方法写入字节数组
            byte[] bytes = " World!".getBytes(); // 将字符串转换为字节数组。 居然没有字符数组？为什么不用字符数组？ emmmm用的这个方法就是返回字节数组的
            //一个字符占两个位置，所以说它就
            byteArrayOutputStream.write(bytes);

            // 使用 write(byte[], int, int) 方法写入字节数组的部分
            byte[] moreBytes = " This is a test.".getBytes();
            byteArrayOutputStream.write(moreBytes, 0, 14); // 只写入前14个字节

            // 调用 flush() 方法
            byteArrayOutputStream.flush(); // 在 ByteArrayOutputStream 中，flush() 不需要做任何事情

            // 获取并打印写入的数据
            String result = byteArrayOutputStream.toString(); // 将字节数组转换为字符串
            System.out.println("写入的数据: " + result);
        } catch (IOException e) {
            e.printStackTrace(); // 打印异常信息
        } finally {
            try {
                byteArrayOutputStream.close(); // 关闭输出流
            } catch (IOException e) {
                e.printStackTrace(); // 打印异常信息
            }
        }
    }
}
