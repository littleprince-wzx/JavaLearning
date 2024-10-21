
# Java 集合框架与迭代器 (ArrayList, Iterator)

本篇文档基于提供的代码，详细解释了 Java 集合框架中 ArrayList 和迭代器的使用方式，重点讲解了 ArrayList 的常用方法、迭代器的操作及其内部实现。

---

## 1. 数组与 ArrayList（动态数组，类似于vector，其本身也是一个泛型（cpp中的模版类）

- **数组声明与初始化**：
    ```java
    int[] eg1 = new int[5];
    ```
    - 数组一旦声明，长度就固定，无法动态扩展。
    - `eg2 = eg1;` 这种赋值方式会让 `eg2` 和 `eg1` 指向同一片内存区域。

- **ArrayList 初始化与基本操作**：
    - `ArrayList<String> a = new ArrayList<String>();` 初始化容量为10的 ArrayList。
    - **常用方法**：
        1. `add(E e)`：向列表中添加元素。
        2. `size()`：返回元素数量。
        3. `get(int index)`：获取指定索引位置的元素。
        4. `remove(int index)`：删除指定位置的元素，并返回被删除的元素。
    - 示例：
    ```java
    a.add("xiao1");
    a.add("facevalue can be used here");
    System.out.println(a.size()); // 返回列表中的元素数量
    System.out.println(a.get(1)); // 获取索引为 1 的元素
    a.remove(a.get(a.size() - 1)); // 删除最后一个元素
    ```

---

## 2. 迭代器（Iterator）

- **迭代器接口**：`Iterator` 是一个接口，用于遍历集合中的元素。虽然接口无法实例化，但在集合类中会通过内部类实现该接口。
    - **常用方法**：
        1. `next()`：返回容器中的下一个元素。
        2. `hasNext()`：检查是否还有更多元素。
        3. `remove()`：删除当前迭代的元素，但必须先调用 `next()`。
    - **示例**：
    ```java
    Iterator<String> e = a.iterator();
    System.out.println("the deleted element: " + e.next());
    e.remove();
    ```
    - 注意：调用 `remove()` 之前必须先调用 `next()`，否则会抛出 `IllegalStateException` 异常。

---

## 3. ArrayList 与 Iterator 的关系

- 在 `ArrayList` 中，`Iterator` 实际上是通过内部类实现的，迭代器直接操作的是容器内部的对象，而非其副本。

- 示例代码实现了一个简单的自定义 `Iterator` 类：
    ```java
    class egForIterator<E> {
        public int size;
        public E[] elements;

        class Iterator implements java.util.Iterator<E> {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                return elements[index++];
            }

            @Override
            public void remove() {
                // 实现删除逻辑
            }
        }
    }
    ```

---

## 4. 示例代码

```java
package SixthChapterCollectionAndList;
import java.util.*;

public class ArrayListExample {
    private int[] Arrayeg1;

    public static void main(String[] args) {
        int[] eg1= new int[5];
        System.out.println(eg1.length);
        int[] eg2;
        eg2 = eg1;
        System.out.println(eg2.length);
        System.out.println(eg1.equals(eg2));

        System.out.println("---------------------------------");

        ArrayList<String> a = new ArrayList<String>();
        a.add(new String("xiao1"));
        a.add("facevalue can be used here");
        System.out.println(a.size());
        System.out.println(a.get(1));

        System.out.println("---------------------------------");

        a.add("this one is meant to be removed");
        a.add("test remove");
        System.out.println(a.remove(a.get(a.size() - 1)));

        System.out.println("---------------------------------");

        Iterator<String> e = a.iterator();
        System.out.println("the deleted element: " + e.next());
        e.remove();

        System.out.println("---------------------------------");
        System.out.println(a.get(0));
        a.add("what is that");
        System.out.println(a.get(2));

        System.out.println("---------------------------------");

        Iterator<String> k = a.iterator();
        System.out.println(k.next());
    }
}
```

---

## 5. 补充

- **HashSet**：`HashSet<String> hashset = new HashSet<String>();` 基于哈希表实现的集合，不能包含重复元素。
- **迭代器的内部类实现**：ArrayList 中的迭代器通过内部类实现，属于实现 `Iterator` 接口的类，直接操作容器内部对象。

