
# Java 语法和概念解释

相当于是java的基本入门语法

---

## 1. Java 程序结构和主类

- **主类**：包含 `main` 方法的类被认为是程序的入口点。只要类中包含 `main` 方法，它就可以成为主类。
- **成员变量 vs 局部变量**： 
    - *成员变量* 是属于对象的属性或方法（类中的变量）。
    - *局部变量* 是在局部作用域（如方法、循环）内定义的变量，比如在 `for` 循环中的初始化变量。还有try代码块内也算局部变量。。
- **主方法**：`public static void main(String[] args)` 是程序的主方法，它是程序的入口。可以通过 `args` 接受命令行参数。

---

## 2. Java 数据类型
java的数据大小是固定的！！因为它是在jvm虚拟机上运行的！要先转成字节码！
- Java 提供多种原始数据类型：
    - `byte` (8位), `short` (16位), `int` (32位), `long` (64位),
    - `float` (32位), `double` (64位),
    - `char` (16位),
    - `boolean` (通常占用1个字节，方便寻址)。
- `String` 是一个类，是 Java 标准库的一部分。
- 和 C 一样，变量必须先声明再使用。

---

## 3. 关键字与运算符

- **final**：声明一个常量，与 C 中的 `const` 类似。
- **运算符**：Java 中的运算符与 C 相似，如：
    - `|` (按位或), `&` (按位与), `>>`, `>>>`, `<<` (位移运算),
    - `~` (按位取反), `^` (按位异或)。

---

## 4. 控制流语句

- **if-else**, **switch**：Java 的条件语句和 C 类似。
- **for**, **while**, **continue**, **break**：循环结构在 Java 中和 C 类似。（完全一致）
- **foreach**：用于遍历数组或集合：这个东西只学c可能会比较困难。但是还好
    ```java
    for (int x : arr) {
        System.out.println(x);
    }
    ```
    特别是在二维数组或容器中，foreach 用来遍历内部元素。

---

## 5. 方法与静态方法

- **实例方法**：非静态方法属于类的实例，不能直接从 `main` 方法中调用，必须创建对象实例。
- **静态方法**：静态方法（如 `main`）可以直接调用，不需要创建类实例。

---

## 6. Java 数组

- **一维数组**：
    ```java
    int arr[] = new int[5];
    int month[] = new int[12];
    ```
- **二维数组（锯齿数组）**：Java 的二维数组实际上是数组的数组，因此可以实现锯齿数组，每一行可以有不同的长度。
    ```java
    int a[][] = new int[2][];
    a[0] = new int[]{1, 2};
    a[1] = new int[3];
    ```

---

## 7. 常见错误和最佳实践

- 遍历二维数组时，记住每个元素实际上是另一个数组（或对数组的引用），因此在使用嵌套循环来访问元素时，你的第一个循环变量应该是这样的`int[] x  `：
    ```java
    for (int[] x : a) {
        for (int m : x) {
            System.out.println(m);
        }
    }
    ```
- 注意数组或数据结构的类型。例如，使用 `Arrays.fill()` 时，确保传入的数组类型与方法要求的类型匹配。就是拿一个值赋值到所有元素中

---

## 8. 代码示例

```java
package FirstChapter;

import java.util.Arrays;

public class First {
    private float x;
    private float y;

    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getY() {
        return y;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println("HELLO JAVA");
        int arr[];
        arr = new int[5];
        int month[] = new int[12];
        int a[][] = new int[2][];
        a[0] = new int[]{1, 2};
        a[1] = new int[3];
        int b[][] = {{1, 2, 3}, {1, 2}};
        int c[] = new int[2];

        for (int[] x : a) {
            for (int m : x) {
                System.out.println(m);
            }
        }

        Arrays.fill(c, 5);
        for (int x : c) {
            System.out.println(x);
        }
    }
}
```
