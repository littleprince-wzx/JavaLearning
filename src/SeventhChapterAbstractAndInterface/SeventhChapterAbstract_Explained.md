
# Java 抽象类与抽象方法详解

本篇文档基于提供的代码，详细解释了 Java 中抽象类的概念、抽象方法的实现，以及抽象类和子类之间的关系。

---

## 1. 抽象类的定义

- **抽象类 (abstract class)**：是包含抽象方法的类，不能直接实例化。其存在是为了定义一套基本框架供子类继承和实现。
    - 抽象类可以包含具体方法（有实现的非抽象方法）。
    - 抽象类可以通过子类进行实例化，子类必须实现抽象类的所有抽象方法，除非子类本身也是抽象类。
    - **抽象方法**：只包含方法签名（方法名、参数列表、返回类型），没有方法体。

- **抽象类的特点**：
    1. 抽象类可以没有抽象方法。
    2. 含有抽象方法的类一定是抽象类。
    3. 抽象类的引用可以指向其子类的实例。
    4. 抽象类可以有构造方法，但不能用于直接构造抽象类的实例。

- **示例**：
    ```java
    public abstract class AbstractExample {
        public abstract int addTwoNumbers();
        public int addThreeNumbers(int a, int b, int c) {
            return a + b + c;
        }
    }
    ```

---

## 2. 抽象类与子类的关系

- **子类继承抽象类**：
    - 子类必须实现抽象类中的所有抽象方法，除非子类本身也是抽象类。
    - 子类可以调用抽象类中的非抽象方法。
    - 子类在实例化时，会首先调用抽象类的构造方法（即使构造方法没有显式定义）。

- **构造方法与继承**：
    - 抽象类可以有构造方法，但不能用于直接创建实例。
    - 子类在构造时必须调用父类的构造方法。
    - 示例：
    ```java
    public AbstractExample(int age, int a, int b) {
        this.age = age;
        this.a = a;
        this.b = b;
    }

    public AbstractExampleSon(int age, int a, int b, int a1, int b1) {
        super(age, a, b);
        this.a1 = a1;
        this.b1 = b1;
    }
    ```

---

## 3. 抽象方法的实现与重写

- **抽象方法的实现**：
    - 子类必须重写抽象方法并提供实现。
    - 在重写时，不能分配更弱的访问权限。
    - 示例：
    ```java
    @Override
    public int addTwoNumbers() {
        return a1 + b1;
    }
    ```

- **子类调用父类方法**：
    - 即使抽象类中的引用指向子类实例，也可以通过父类引用调用子类实现的方法：
    ```java
    AbstractExample example1;
    AbstractExampleSon example2 = new AbstractExampleSon(1, 2, 3, 4, 5);
    example1 = example2; // 子类实例赋值给抽象类引用
    System.out.println(example1.addTwoNumbers()); // 调用子类方法
    ```

---

## 4. 示例代码

```java
package SeventhChapterAbstractAndInterface;

public abstract class AbstractExample {
    private int age;
    private int a;
    private int b;

    public abstract int addTwoNumbers();
    
    public int addThreeNumbers(int a, int b, int c) {
        return a + b + c;
    }

    public AbstractExample(int age, int a, int b) {
        this.age = age;
        this.a = a;
        this.b = b;
    }
}

class AbstractExampleSon extends AbstractExample {
    private int a1;
    private int b1;

    @Override
    public int addTwoNumbers() {
        return a1 + b1;
    }

    public AbstractExampleSon(int age, int a, int b, int a1, int b1) {
        super(age, a, b);
        this.a1 = a1;
        this.b1 = b1;
    }
}

class TestForAbstract {
    public static void main(String[] args) {
        AbstractExample example1;
        AbstractExampleSon example2 = new AbstractExampleSon(1, 2, 3, 4, 5);
        example1 = example2;
        System.out.println(example1.addTwoNumbers());
    }
}
```

