
# Java 继承与多态编程示例详解

本篇文档基于提供的代码，详细解释了 Java 中的继承关系、多态性，以及如何使用 `super` 关键字和重写父类方法等概念。

---

## 1. 继承关系与 super 关键字

- **super 关键字**：
    - `super(parameters..)`：用于调用父类的构造器。
    - `super.methodName(parameters..)`：用于调用父类的方法。
    - 注意：使用 `final` 修饰的方法无法被子类覆写。

---

## 2. 向上与向下转型
具体来讲就是，如果你本身是一个有很多属性和方法的子类（一般来说子类比父类的东西要多），你可以把它当父类来赋值或使用（相当于就自动屏蔽那些其他方法和属性）。
但是因为他们都是指向同一块堆内存，所以无论怎么样，它本质还是子类对象。这就是向上转型。向下转型同理，你本身得指向的是子类对象你才能向下转型，你一个纯粹的父类是不可能向下转型的。
- **向上转型（upcasting）**：
    - 子类对象可以自动转换为父类引用，称为向上转型，这是合法的操作。
    - 例如：
    ```java
    FifthChapter eg2Father = eg1Son;
    ```
    - 向上转型后，只能访问父类中的方法，无法调用子类独有的方法。
- **向下转型（downcasting）**：
    - 父类对象向子类引用转换需要谨慎。如果父类对象本身指向子类对象，转型是合法的；如果指向的是父类对象，转型会抛出异常。

---

## 3. 方法重载与重写

- **方法重载（overloading）**：方法名相同，但参数列表不同，这是简单的概念。（在相同的类里。一般来说是自己这个类内部）
- **方法重写（overriding）**：子类可以重写父类的方法，重新定义其行为，但不能降低方法的访问权限，且抛出的异常不能比父类更广泛。（在不同类里，一般是子类和父类）

- **示例：父类与子类的 isEqual 方法重写**：
    ```java
    public boolean isEqual(int a, int b) {
        if (a == b) {
            System.out.println("this is the father's method");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isEqual(int a, int b) {
        if (a == b) {
            System.out.println("this is the son's method");
            return false;
        } else {
            return false;
        }
    }
    ```

---

## 4. 多态性与方法的多态性

- 多态性允许我们使用父类引用指向子类对象。（向上向下转型）
- 例如：`Triangle`、`Circle` 和 `Square` 可以被视为 `Shape` 对象，并存储在对象数组中，实现多态性。
- **关联关系与继承关系**：如果一个类既有关联关系，又有继承关系，通常优先使用关联关系。继承关系会影响封装性，当父类发生改变时，子类也会受到影响。
- 思考：如果一个对象被作为父类引用，但是本身指向一个子类对象，那么调用被重写的方法，应该是调用哪个方法呢？父类的实现？还是子类的实现？
```java
class Parent {
    public void show() {
        System.out.println("Parent's show method");
    }
}

class Child extends Parent {
    @Override
    public void show() {
        System.out.println("Child's show method");
    }
}

public class Main {
    public static void main(String[] args) {
        Parent obj = new Child();  // 父类引用指向子类对象
        obj.show();  // 调用的是子类重写的方法
    }

```
- 当然是子类的方法啦！本身就是指向一个子类对象的内存区域。
---

## 5. 示例代码

```java
package FifthChapterUnit4And5;

public class FifthChapter {
    private int Attribute1;
    private String Attribute2;

    public FifthChapter(int attribute1, String attribute2) {
        Attribute1 = attribute1;
        Attribute2 = attribute2;
    }

    public int getAttribute1() {
        return Attribute1;
    }

    public void setAttribute1(int attribute1) {
        Attribute1 = attribute1;
    }

    public String getAttribute2() {
        return Attribute2;
    }

    public void setAttribute2(String attribute2) {
        Attribute2 = attribute2;
    }

    public boolean isEqual(int a, int b) {
        if (a == b) {
            System.out.println("this is the father's method");
            return true;
        } else {
            System.out.println("this is the father's method");
            return false;
        }
    }
}

class TheSonclass extends FifthChapter {
    public TheSonclass(int attribute1, String attribute2) {
        super(attribute1, attribute2);
    }

    private String SonAttribute2;

    public String getSonAttribute2() {
        return SonAttribute2;
    }

    public void setSonAttribute2(String sonAttribute2) {
        SonAttribute2 = sonAttribute2;
    }

    public int addtwovalues(int a, int b) {
        return a + b;
    }

    @Override
    public boolean isEqual(int a, int b) {
        if (a == b) {
            System.out.println("this is the son's method");
            return false;
        } else {
            System.out.println("this is the son's method");
            return false;
        }
    }
}

class TheTestOfSonClass {
    public static void main(String[] args) {
        FifthChapter eg1Father = new FifthChapter(5, "I am the father");
        TheSonclass eg1Son = new TheSonclass(6, "I am the son");
        
        FifthChapter eg2Father = eg1Son; // 向上转型是合法的
        eg2Father.toString();
        eg1Son.addtwovalues(1, 2); // 子类调用自己的方法
    }
}
```

