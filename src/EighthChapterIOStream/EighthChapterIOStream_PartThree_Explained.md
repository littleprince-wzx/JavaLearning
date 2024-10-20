
# Java 基本字节流与文件读取 (Part Three)

本篇文档基于提供的代码，详细解释了 Java 中基本字节流 `ByteArrayInputStream` 和 `FileInputStream` 的使用，尤其是在文件编程中的应用。

---

## 1. 基本字节流与构造方法

- **字节流** 是处理二进制数据的重要工具。`ByteArrayInputStream` 和 `FileInputStream` 是两种常用的输入流，分别用于从字节数组和文件中读取数据。

- **构造方法**：
    1. **`ByteArrayInputStream(byte[] buf)`**：使用字节数组作为输入流，读取字节数据。
    2. **`ByteArrayInputStream(byte[] buf, int offset, int length)`**：从指定偏移量 `offset` 开始读取，并读取 `length` 个字节。
    3. **`FileInputStream(File file)`**：从文件对象 `file` 中读取字节数据。
    4. **`FileInputStream(String name)`**：通过文件名 `name` 指定文件路径来读取数据。

    - 注意：如果你定义了有参构造函数，Java 不会再提供无参构造函数。

---

## 2. 字节数组输入流

- **`ByteArrayInputStream`**：允许我们使用字节数组作为输入源，模拟数据的读取。
    - 第一种构造方式：从字节数组读取数据。
    - 第二种构造方式：从指定偏移量开始读取指定长度的字节。

- **示例代码**：
    ```java
    Scanner scanner = new Scanner(System.in);
    byte[] example = scanner.nextLine().getBytes();

    // 第一种构造方式
    ByteArrayInputStream byteArrayInputStream1 = new ByteArrayInputStream(example);

    // 第二种构造方式，指定偏移量和长度
    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(example, 0, 5);
    ```

---

## 3. 文件输入流

- **`FileInputStream`**：用于从文件中读取字节数据。
    - **两种构造方式**：
        1. 通过 `File` 对象指定文件路径。
        2. 直接通过文件名字符串指定路径，支持相对路径和绝对路径。
    - 文件读取时，常见的异常是 `FileNotFoundException` 和 `IOException`。

- **示例代码**：
    ```java
    File file = new File("example.txt");
    try {
        // 使用 File 对象构建
        FileInputStream fileInputStream1 = new FileInputStream(file);
    } catch (FileNotFoundException fileNotFoundException) {
        System.out.println("file is not found!!");
    }

    try (FileInputStream fileInputStream1 = new FileInputStream("example.txt")) {
        System.out.println("Reading file with File object.");
    } catch (FileNotFoundException fileNotFoundException) {
        System.out.println("file is not found!!");
    } catch (IOException e) {
        System.out.println("解决一下经典的这个io异常");
    }
    ```

---

## 4. 总结

- **字节流** 在处理二进制数据时非常重要，`ByteArrayInputStream` 用于从字节数组中读取数据，`FileInputStream` 用于从文件中读取数据。
- 在文件编程中，处理文件未找到和 IO 异常是必不可少的步骤。
