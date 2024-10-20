
# Java 基本字节流与文件输出 (Part Four)

本篇文档基于提供的代码，详细解释了 Java 中基本字节流的输出操作，重点讲解了 `ByteArrayOutputStream` 和 `FileOutputStream` 的使用方法，并演示如何将数据写入文件。

---

## 1. `ByteArrayOutputStream` 与缓冲区

- **`ByteArrayOutputStream`** 是一个用于将数据写入字节数组的输出流。它内部维护了一个自动扩展的字节缓冲区，用于存储数据。
    - 第一种构造方式：创建默认大小为 32 字节的缓冲区。
    - 第二种构造方式：指定缓冲区的初始大小。
    - **示例**：
    ```java
    ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream(); // 默认 32 字节
    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(58); // 指定 58 字节缓冲区
    byteArrayOutputStream1.write(5); // 写入一个 int 值（字节）
    byteArrayOutputStream1.write(bytes, 0, 4); // 写入字节数组中的前 4 个字节
    ```

- **`flush()`**：在 `ByteArrayOutputStream` 中，`flush()` 是空操作，因为数据是写入内存的，只有在 `FileOutputStream` 或 `Socket` 流中才有意义。

---

## 2. `FileOutputStream` 与文件输出

- **`FileOutputStream`**：用于将数据写入文件的字节输出流，可以通过文件名或 `File` 对象来创建。
    - **构造方法**：
        1. **`FileOutputStream(String name)`**：通过文件名创建输出流。如果文件不存在，则创建文件；如果文件存在，默认覆盖原文件。
        2. **`FileOutputStream(File file)`**：通过 `File` 对象创建输出流，类似于第一种方式。
        3. **`FileOutputStream(String name, boolean append)`**：支持追加模式，如果 `append` 为 `true`，则在文件末尾追加数据。
    - **示例**：
    ```java
    FileOutputStream fos1 = new FileOutputStream("output1.txt"); // 通过文件名创建
    FileOutputStream fos3 = new FileOutputStream(file); // 通过 File 对象创建
    byteArrayOutputStream1.writeTo(fos1); // 将 ByteArrayOutputStream 中的数据写入文件
    ```

---

## 3. 示例代码解析

- 代码展示了如何通过 `ByteArrayOutputStream` 构建缓冲区，并通过 `writeTo()` 方法将数据写入文件。
    - 使用 `FileOutputStream` 将字节流数据输出到文件中，支持相对路径和绝对路径。
    - **注意**：在某些操作系统中，尝试同时打开多个 `FileOutputStream` 实例可能会导致文件访问异常。

```java
package EighthChapterIOStream;

import java.io.*;
import java.util.Scanner;

public class BasicByteStreamOutputFunctionPart4 {

    private static final String NEW_LINE = System.getProperty("line.separator");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte[] bytes = scanner.nextLine().getBytes();

        ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream(); // 默认 32 字节缓冲区
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(58); // 指定缓冲区大小
        byteArrayOutputStream1.write(5); // 写入一个字节
        byteArrayOutputStream1.write(bytes, 0, 4); // 写入字节数组中的前 4 个字节

        try {
            byteArrayOutputStream1.flush(); // 空操作，文件输出时才有意义
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File("example.txt");

        try {
            FileOutputStream fos1 = new FileOutputStream("output1.txt"); // 文件输出流
            FileOutputStream fos3 = new FileOutputStream(file); // 通过 File 对象创建输出流
            byteArrayOutputStream1.writeTo(fos1); // 将数据写入文件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

## 4. 总结

- **`ByteArrayOutputStream`** 和 **`FileOutputStream`** 是 Java 中处理字节输出的核心类，分别用于将数据写入内存和文件。
- 在文件输出操作中，`write()` 和 `writeTo()` 是常用的输出方法，`flush()` 主要在文件或网络流中有实际意义。
