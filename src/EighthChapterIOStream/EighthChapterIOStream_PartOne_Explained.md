
# Java 字节流与 InputStream 示例详解 (Part One)

本篇文档基于提供的代码，详细解释了 Java 中字节流的概念、`InputStream` 的常用方法，以及如何使用 `ByteArrayInputStream` 来演示流的基本操作。

---

## 1. 字节流与字符流

先介绍流这个概念。
```java
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

```
- **字节流 (byte stream)**：以一个字节为单位读写数据，适合处理图像、视频、多媒体等二进制数据。
- **字符流 (character stream)**：以两个字节为单位读写，每次读取一个字符，适合处理文本数据。
    - 在 Java 中，字符流使用 UTF-16 编码，一个字符占两个字节。
    - C 语言中的 `char` 通常是一个字节，编码方式不同。
具体的继承关系还是得看书。
---

## 2. InputStream 类

- **InputStream** 是字节输入流的抽象基类，定义了一系列从数据源（如文件、网络）读取数据的方法。

- **常用方法**：
    1. `read()`：读取一个字节的数据，返回其整数值，读取到末尾时返回 `-1`。
    2. `read(byte[] b)`：读取多个字节并存储到字节数组中，返回实际读取的字节数。
    3. `read(byte[] b, int off, int len)`：从流中读取最多 `len` 个字节，并存储到 `b` 数组中从 `off` 开始的位置。
    4. `skip(long n)`：跳过并丢弃流中 `n` 个字节的数据。
    5. `available()`：返回流中可以不阻塞地读取的字节数。
    6. `mark(int readlimit)`：标记当前流的位置，以便后续调用 `reset()` 返回到该位置。
    7. `reset()`：将流的位置重置为最后一次调用 `mark()` 的位置。
    8. `markSupported()`：检查流是否支持 `mark()` 和 `reset()`。
    9. `close()`：关闭流并释放系统资源。

---

## 3. 示例代码解析

- 通过 `ByteArrayInputStream` 读取字节流：
    - 将字符串转换为字节数组，创建 `ByteArrayInputStream` 进行演示。
    - **read(byte[] b)** 方法：读取字节并存储到数组中。
    - **skip()** 和 **mark()**：跳过字节并标记流的位置。

```java
public class IcodingByte {
    public void m(InputStream in) {
        try {
            while (true) {
                int i = in.read(); // 读取一个字节
                if (i == -1) {
                    return;
                }
                char c = (char) i;
                System.out.println(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 示例数据
        String data = "Hello, InputStream! This is a demonstration of InputStream methods.";
        byte[] byteArray = data.getBytes();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArray);

        try {
            // 1. read()：读取下一个字节的数据
            int singleByte = inputStream.read();
            System.out.println("第一个读取的字节: " + (char) singleByte);

            // 2. read(byte[] b)：将多个字节读入字节数组中
            byte[] buffer = new byte[10];
            int bytesRead = inputStream.read(buffer);
            System.out.println("读取的字节: " + new String(buffer, 0, bytesRead));

            // 3. read(byte[], int off, int len)：从输入流中读取最多 len 个字节
            byte[] buffer2 = new byte[10];
            int bytesRead2 = inputStream.read(buffer2, 0, 5);
            System.out.println("读取的字节: " + new String(buffer2, 0, bytesRead2));

            // 4. skip(long n)：跳过 n 个字节的数据
            long skippedBytes = inputStream.skip(5);
            System.out.println("跳过的字节数: " + skippedBytes);

            // 5. available()：返回可以读取的字节数
            int availableBytes = inputStream.available();
            System.out.println("可用字节数: " + availableBytes);

            // 6. mark(int readlimit)：标记当前流的位置
            inputStream.mark(20);
            byte[] buffer3 = new byte[5];
            inputStream.read(buffer3);
            System.out.println("标记后的字节: " + new String(buffer3));

            // 7. reset()：重置流的位置
            inputStream.reset();
            byte[] buffer4 = new byte[5];
            inputStream.read(buffer4);
            System.out.println("重置后的字节: " + new String(buffer4));

            // 8. markSupported()：检查是否支持 mark 和 reset
            System.out.println("支持标记: " + inputStream.markSupported());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

---

## 4. 总结

- `InputStream` 是处理字节流的核心类，通过其子类可以进行各种字节数据的读取操作。
- `ByteArrayInputStream` 是 `InputStream` 的一个子类，主要用于从字节数组中读取数据，演示了流的常用操作。

