
# Java 面向对象编程及基本规则

此文档基于提供的代码示例，详细解释了 Java 的面向对象编程概念、基本语法以及包机制。

---

## 1. 面向对象编程 (OOP)

- **实例化 (Instantiation)**：通过类创建对象的过程类似于 C 语言的结构体，但类有封装性。对象分配在堆上，结构体分配在静态内存区域。使用带参数的构造函数时，可以重载它来处理不同的参数类型和数量。
    - 代码示例：
    ```java
    BasicRules first = new BasicRules(4.2f, 4.3f);
    ```
- **this 关键字**：类似于 Python 中的 `self`，`this` 指向当前对象。
- 这个this在7中有详解。

---

## 2. 方法重载与重写

- **方法重载 (Overloading)**：同一个方法名可以有多个版本，参数类型或数量不同。
- **方法重写 (Overriding)**：子类可以修改父类的方法实现，要求参数类型和返回值完全一致。
- 代码示例：
    ```java
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }
    ```

---

## 3. static 关键字

- **静态变量**：用 `static` 修饰，属于类本身而不是某个对象的实例，可以直接通过类名访问。
- **静态方法**：不能访问实例变量，但可以访问静态变量，静态方法可以通过类或对象调用。
- 代码示例：
    ```java
    public static int numberOfinstances = 0;

    public static void increment() {
        numberOfinstances++;
    }
    ```

---

## 4. final 关键字

- **final 修饰符**：类似于 C 语言中的 `const`，用于修饰常量。
    - **final 修饰类**：类不能被继承。
    - **final 修饰方法**：方法不能被子类重写。

---

## 5. Java 的 package 机制

- **导入包**：
    - 可以导入其他类或者包，例如：
    ```java
    import java.util.Calendar;
    import java.util.*;
    ```
    - Java 的 `java.lang` 包无需显式导入，包含核心类，如 `String`、`Math`、`System` 等。
- **自定义包**：
    - 使用 `package` 声明包，并在需要的类中使用 `import` 导入包中的类。
    - 代码示例：
    ```java
    import Example.TestPackage;
    ```

---

## 6. 访问权限

- **public**：任何地方都可以访问。
- **protected**：本包内(的所有类）和（无论哪个包里的）子类可以访问。
- **default (缺省)**：仅限于包内访问。
- **private**：只有类内部可以访问。
- 示例：
    ```java
    // protected 属性在子类和本包内类中可用，但不能在外部包中直接访问。
    protected int a;
    ```

---

## 7. 构造函数
如果你不写这个构造函数，这个java会自动提供一个无参的。如果你写了一个有参的构造函数，且还想用无参的构造函数，你还得再重新写一个无参的。
- **构造函数**：用于初始化对象，可以通过重载构造函数来处理不同数量或类型的参数。
    - 示例：
    ```java
    public BasicRules(float x, float y) {
        this.x = x;
        this.y = y;
    }
    ```

---

## 8. 代码示例

```java
package SecondPartUnit3;

import ExceptionExample.*;

public class BasicRules {
    private float x;
    private float y;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public BasicRules(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public BasicRules() {
    }

    public BasicRules(float x) {
        this.x = x;
    }

    public int add(int a,int b,int c) {
        return a+b+c;
    }

    public int add(int a,int b) {
        return a+b;
    }

    public static int numberOfinstances = 0;

    public static void increment() {
        numberOfinstances++;
    }
}

class Extends1 extends TestAuthority {
    private int age;

    public Extends1(int age,int a,int b) {
        super(a,b);
        this.age = age;
    }
}

class test {
    public static void main(String[] args) {
        BasicRules first = new BasicRules(4.2f, 4.3f);
        BasicRules.numberOfinstances++;
        first.numberOfinstances++;
        first.increment();
        BasicRules.increment();
        System.out.println(BasicRules.numberOfinstances);
        TestPackage second = new TestPackage(1, "jonathan");
        Extends1 third = new Extends1(1, 2, 3);
    }
}
```
