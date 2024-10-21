
# Java 类的声明与使用

本篇文档详细讲解了 Java 中类的声明与使用，内容简洁明了，配有丰富的示例代码，以帮助读者快速理解类的基本概念与实践。

---

## 1. 什么是类？

- **类** 是面向对象编程的核心，通过类可以定义对象的属性（成员变量）和行为（成员方法）。
- 类是一种模板，用于创建对象，描述对象的状态和行为。

### 示例：
```java
public class Dog {
    // 属性（成员变量）
    private String name;
    private int age;

    // 构造方法
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 方法（成员方法）
    public void sit() {
        System.out.println(name + " is sitting.");
    }

    public void rollOver() {
        System.out.println(name + " rolled over!");
    }
}
```

在上述代码中，`Dog` 是一个类，`name` 和 `age` 是类的属性，`sit()` 和 `rollOver()` 是类的方法。

---

## 2. 创建类的实例

- 创建类的实例对象时，会调用类的构造方法来初始化对象的状态。

### 示例：
```java
public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog("Buddy", 3);  // 创建对象
        System.out.println(myDog.getName());  // 输出：Buddy
        myDog.sit();  // 输出：Buddy is sitting.
    }
}
```

这里，我们创建了一个 `Dog` 类的实例 `myDog`，并访问它的属性和方法。

---

## 3. 属性与方法

- **属性（成员变量）**：用于存储对象的状态。
- **方法（成员方法）**：定义对象的行为。方法可以访问类的属性，并对属性进行操作。

### 访问属性：
```java
myDog.getName();  // 调用 get 方法访问属性
```

### 调用方法：
```java
myDog.sit();  // 调用方法
```

---

## 4. 封装与访问控制

- **封装** 是面向对象的基本原则之一，通过将属性声明为 `private`，并通过公共的 `getter` 和 `setter` 方法来访问和修改属性。
- 这样可以保护对象的内部状态，防止外部代码直接修改对象的属性。

### 示例：
```java
public class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter 和 Setter 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

---

## 5. 继承

- **继承** 是面向对象编程的重要概念。通过继承，子类可以复用父类的属性和方法，并可以根据需要对其进行扩展或重写。
- 在 Java 中，子类通过 `extends` 关键字继承父类。

### 示例：
```java
// 父类 Car
public class Car {
    private String make;
    private String model;
    private int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getDescription() {
        return year + " " + make + " " + model;
    }
}

// 子类 ElectricCar 继承 Car
public class ElectricCar extends Car {
    private int batteryCapacity;

    public ElectricCar(String make, String model, int year, int batteryCapacity) {
        super(make, model, year);  // 调用父类的构造方法
        this.batteryCapacity = batteryCapacity;
    }

    public void showBatteryInfo() {
        System.out.println("Battery capacity: " + batteryCapacity + " kWh");
    }
}
```

在这个示例中，`ElectricCar` 类继承了 `Car` 类，并扩展了其功能，添加了 `batteryCapacity` 属性和 `showBatteryInfo()` 方法。

---

## 6. 方法重写

- 子类可以重写（override）父类的方法，从而提供自己版本的实现。
- 重写方法时，需要使用 `@Override` 注解，确保方法签名一致。

### 示例：
```java
public class ElectricCar extends Car {
    private int batteryCapacity;

    public ElectricCar(String make, String model, int year, int batteryCapacity) {
        super(make, model, year);
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " (Battery capacity: " + batteryCapacity + " kWh)";
    }
}
```

在这个示例中，`ElectricCar` 类重写了 `Car` 类的 `getDescription()` 方法，并添加了额外的信息。

---

## 7. 完整示例

```java
public class Main {
    public static void main(String[] args) {
        // 创建 Car 对象
        Car car1 = new Car("Toyota", "Corolla", 2020);
        System.out.println(car1.getDescription());  // 输出：2020 Toyota Corolla

        // 创建 ElectricCar 对象
        ElectricCar electricCar1 = new ElectricCar("Tesla", "Model S", 2021, 100);
        System.out.println(electricCar1.getDescription());  // 输出：2021 Tesla Model S (Battery capacity: 100 kWh)
        electricCar1.showBatteryInfo();  // 输出：Battery capacity: 100 kWh
    }
}
```

---

## 总结

- Java 中的类用于定义对象的属性和行为。
- 通过构造方法创建对象实例，并通过方法操作对象的属性。
- 使用继承和方法重写可以扩展类的功能，复用代码。
- 封装通过访问修饰符和 `getter`、`setter` 方法来保护对象的状态。

