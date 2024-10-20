
# Java 接口与匿名类详解

本篇文档基于提供的代码，详细解释了 Java 接口的概念、接口中的静态和默认方法，以及如何使用匿名类和 Lambda 表达式快速实现接口。

---

## 1. 接口的定义与特点

- **接口 (interface)**：是一种特殊的类，定义了一组抽象方法和常量。
    - 接口无法被实例化，必须通过实现类来实现其方法。
    - 接口支持多继承，一个接口可以继承多个其他接口。
    - **实现多个接口**：类可以实现多个接口，这是接口的一大优势。
    - **常见方法类型**：
        1. **抽象方法**：完全没有方法体，需要实现类提供实现。
        2. **静态方法**：属于接口本身，无法通过实现类的实例调用。
        3. **默认方法 (default)**：已经实现的方法，子类不必重写。

- **接口中的常量**：
    - 接口中定义的变量都是 `public static final`，即常量，即使不显式声明这些修饰符。
    - 示例：
    ```java
    public static final int constOne = 2;
    int constTwo = 2; // 在接口中也是常量
    ```

---

## 2. 接口的实现与多继承

- **实现接口**：一个类可以实现多个接口，并必须实现接口中的抽象方法。
    - 示例：
    ```java
    class TheClassForImplementing implements InterfaceExample {
        @Override
        public void turnOff() {
            System.out.println("turn off");
        }

        @Override
        public void turnOn() {
            System.out.println("turn on");
        }
        
        // 实现父接口的方法
        @Override
        public void fatherOne() {
            System.out.println("that's the method of fatherOne");
        }
    }
    ```

- **多继承接口**：一个接口可以继承多个接口，继承多个接口的方法。
    - 示例：
    ```java
    public interface InterfaceExample extends InterfaceFather1, InterfaceFather2 {
        void turnOff();
        void turnOn();
    }
    ```

---

## 3. 匿名类与 Lambda 表达式

- **匿名类**：匿名类是没有名字的类，通常用于实现接口或继承类。它简化了代码，在创建对象的同时定义类的行为。
    - 匿名类的特点：
        - 没有类名，只能使用一次。
        - 通常用于简化代码，如事件处理或回调。
        - 示例：
        ```java
        InterfaceFather2 eg1 = new InterfaceFather2() {
            @Override
            public void fatherTwo() {
                System.out.println("我是匿名类");
            }
        };
        eg1.fatherTwo();
        ```

- **Lambda 表达式**：Lambda 表达式是匿名类的一种简化形式，通常用于实现函数式接口（只有一个抽象方法的接口）。
    - Lambda 表达式的语法：
    ```java
    InterfaceFather1 eg2 = () -> {
        System.out.println("我是lambda表达式创造的匿名类");
    };
    eg2.fatherOne();
    ```

---

## 4. 示例代码

```java
package SeventhChapterAbstractAndInterface;

public interface InterfaceExample extends InterfaceFather1, InterfaceFather2 {
    void turnOff();
    void turnOn();
    void printOneThing();

    public static final int constOne = 2;
    int constTwo = 2;

    default int addTwoNumbers(int a, int b) {
        return a + b;
    }
}

interface InterfaceFather1 {
    void fatherOne();
}

interface InterfaceFather2 {
    void fatherTwo();
}

class TheClassForImplementing implements InterfaceExample {
    @Override
    public void turnOff() {
        System.out.println("turn off");
    }

    @Override
    public void turnOn() {
        System.out.println("turn on");
    }

    @Override
    public void printOneThing() {
        System.out.println("one thing");
    }

    @Override
    public void fatherOne() {
        System.out.println("that's the method of fatherOne");
    }

    @Override
    public void fatherTwo() {
        System.out.println("that's the method of fatherTwo");
    }

    public static void main(String[] args) {
        InterfaceFather2 eg1 = new InterfaceFather2() {
            @Override
            public void fatherTwo() {
                System.out.println("我是匿名类");
            }
        };
        eg1.fatherTwo();

        InterfaceFather1 eg2 = () -> {
            System.out.println("我是lambda表达式创造的匿名类");
        };
        eg2.fatherOne();
    }
}
```

---

## 5. 总结

- **接口** 是 Java 中定义抽象方法和常量的特殊类，支持多继承。
- **匿名类** 允许我们快速实现接口或继承类，简化代码。
- **Lambda 表达式** 是一种简化匿名类的语法，主要用于实现函数式接口。

