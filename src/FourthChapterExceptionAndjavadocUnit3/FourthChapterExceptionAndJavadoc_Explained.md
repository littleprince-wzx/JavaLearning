
# Java 异常处理与 Javadoc 示例详解

本篇文档基于提供的代码，详细解释了 Java 异常处理机制、`throw` 关键字的使用、以及如何生成 Javadoc 文档注释。

---

## 1. 异常处理机制简介

Java 的异常处理机制是为了避免频繁的 `if-else` 结构，使代码更简洁，将出现的异常封装成对象并抛出。

- **异常的继承关系**：异常类在 Java 中有复杂的继承体系，详细请参考书籍。常见的异常类如 `IOException`、`RuntimeException`。
- **throw 关键字**：用于手动抛出异常，如果没有捕获，该异常会逐级上抛，直到 `main` 方法，导致程序异常终止。
- **try-catch**：用于捕获异常。`try` 块中编写可能抛出异常的代码，而 `catch` 用于处理对应类型的异常。

---

## 2. throw 关键字与异常捕获

- **throw**：用于手动抛出异常。示例中使用了自定义的 `OutOfRangeException` 异常类。
    ```java
    if (initialValue < 0) {
        throw new OutOfRangeException("Number is not positive");
    }
    ```
- **try-catch-finally**：
    - `try` 块：包含可能抛出异常的代码。
    - `catch` 块：捕获并处理异常。
    - `finally` 块：无论是否有异常，都会执行。

- 示例：
    ```java
    try {
        eg1.positiveInteger(-5);
    } catch (RuntimeException exception1) {
        System.out.println(exception1.getMessage());
    } finally {
        System.out.println("我什么时候都会执行");
    }
    ```

---

## 3. StackTraceElement 和 getStackTrace

- `getStackTrace()`：返回异常的堆栈轨迹信息，包含 `StackTraceElement` 对象，提供详细的错误信息。
    ```java
    StackTraceElement[] elements = exception1.getStackTrace();
    for (StackTraceElement element : elements) {
        System.out.println(element);
    }
    ```

---

## 4. 异常类和 throws 关键字
这个throws是在checkedException里必须声明，RuntimeException可声明可不声明。
- **throws**：在方法声明时使用，提示该方法可能抛出异常，调用者需要处理这些异常。
    ```java
    public static void f() throws Exception {
        throw new Exception("This is the Exception of function f()");
    }
    ```
- **异常信息的获取**：
    - `getMessage()`：返回简短的异常消息。
    - `toString()`：比 `getMessage()` 更详细的异常描述。
    - `printStackTrace()`：将异常的堆栈轨迹输出到标准错误流。

---

## 5. Javadoc 注释与 @see 标签

- **Javadoc 注释**：用于生成 HTML 格式的 API 文档。
    - `@see` 标签：生成 HTML 超链接，指向相关类或方法。
    - `@param`、`@return`、`@throws`：用于描述方法参数、返回值和可能抛出的异常。

示例 Javadoc 注释：
```java
/**
 * 这是一个为了第“7”条内容做代码支撑的示例
 * @author 方镐翔  632077567@qq.com
 * @version 1.0.12
 * @see ExceptionExample.OutOfRangeException
 * @see YiChangmain #readInteger()
 * @see #stdIn 标准输入流
 * @see OutOfRangeException#getA() ;
 */
```

---

## 6. 示例代码

```java
package FourthChapterExceptionAndjavadocUnit3;

import ExceptionExample.OutOfRangeException;
import java.io.*;

public class YiChang {
}

class YiChangmain{

    private int positiveInteger(int initialValue) {
        if (initialValue < 0){
            throw new OutOfRangeException("Number is not positive");
        } else {
            return initialValue;
        }
    }

    private static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter stdErr = new PrintWriter(System.err, true);
    private static PrintWriter stdOut = new PrintWriter(System.out, true);

    public static int readInteger(){
        do{
            try{
                stdErr.print("Enter an integer > ");
                stdErr.flush();
                return Integer.parseInt(stdIn.readLine());
            } catch (NumberFormatException nfe){
                stdErr.println("Invalid number format");
            } catch (IOException ioe){
                ioe.printStackTrace();
                System.exit(1);
            }
        } while(true);
    }

    public static void f() throws Exception {
        throw new Exception("This is the Exception of function f()");
    }

    public static void main(String[] args) {
        YiChangmain eg1 = new YiChangmain();

        try {
            f();
            eg1.positiveInteger(-5);
        } catch (RuntimeException exception1){
            StackTraceElement[] elements = exception1.getStackTrace();
            System.out.println(exception1.getMessage());
            System.out.println("-----------------------");
            System.out.println(exception1.toString());
            System.out.println("-----------------------");
            exception1.printStackTrace();
            for (StackTraceElement element: elements){
                System.out.println(element);
            }
        } catch (Exception exception2){
            exception2.printStackTrace();
        } finally {
            System.out.println("我什么时候都会执行");
        }

        stdOut.println("The value is :" + readInteger());
    }
}
```

