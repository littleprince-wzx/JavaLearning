package SixthChapterCollectionAndList;
import java.util.*;//为了用ArrayList容器
/**
 * 关联关系的java实现：数组和collection集合
 * int[] ages;这种声明方式 ages =new int[5];
 * ArrayList一共有四种常用方法。全部写在以下
 *
 */
public class ArrayListExample {
    private int[] Arrayeg1;

    public static void main(String[] args) {
        int[] eg1= new int[5];
        System.out.println(eg1.length);//length就是这个数组对象的类型
        int[] eg2;
        eg2=eg1;
        System.out.println(eg2.length);
        System.out.println(eg1.equals(eg2));
        //这俩互相赋值，两个指针都指向了了同一片内存区域

        ArrayList<String> a= new ArrayList<String>();//initial capacity of ten
        a.add(new String("xiao1"));
        a.add("facevalue can be used here");
        System.out.println(a.size());//返回number of elements
        System.out.println(a.get(1));
        a.add("this one is meant to be removed");
        a.add("test remove");
        System.out.println(a.remove(a.get(a.size()-1)));//remove还会返回一个是否删除成功的标志

        //以下开始讲迭代器
        /*
        E next();//返回容器中第一个元素，在第一次调用的时候，再调用就会是下一个元素了
        boolean hasNext();
        void remove();使用remove之前必须要先调用一次next方法，因为next（）是往后移动一个指针
         */
        Iterator<String>e=a.iterator();

       // e.remove();//这样就会直接报错
        System.out.println("the deleted elements"+e.next());
        e.remove();
        System.out.println(a.get(0));//卧槽，它删除相当于直接把第0给删除了，还把每一个值都往前移动了一个
        a.add("what is that");//在这里修改了一下迭代的东西
        System.out.println(a.get(2));
        String result="initialize";
       // e.next();//你还想用老迭代器来迭代，那就会报错了,currentmodificationexception
        //我立刻就再声明一个迭代器
        Iterator<String> k=a.iterator();
        //最后一个问题，激素hi说如果在循环中
        while(k.hasNext()){

            result = k.next();
            k.remove();
          //  a.add("try to cause serious problems");

        }
        System.out.println(result);





    }
}

/**
 * 这里讲迭代器，即iterator,是一个接口。但是为什么书上说，返回一个iterator对象呢？
 * 接口明明无法实例化，只能够进行“被实现”，这里要提一句什么叫做内部类。内部类，就是在类里面定义的类.一共有四种内部类
 * 1在类里的普通内部类（四种访问权限），private修饰的内部类里的成员，你正常调用不了，但是创建一个内部类对象就可以了。
 * 2在类里的static修饰的静态类：可以访问外部类的静态成员，但不能访问实例成员。
 * 3局部内部类：可以访问外部类的所有成员（包括私有成员）以及方法的局部变量（如果是 final 或有效的最终变量）（就是函数里声明的类，感觉不会有人类这么写）
 * 4匿名内部类，这个后面再讲
 * 我在这实现了一个类似的，但是实现的实际上很烂，几乎没法用，就是为了讲解一下这个iterator和arraylist之间的关系。
 * 然后我在上面讲了迭代器的操作，从我的那个分隔符以下，main里就都是讲iterator的了
 */
class egForIterator<E>{
    public int size;
    public E [] elements;
    private E element;

    class Iterator implements java.util.Iterator<E> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size; // size 是 ArrayList 中元素的数量
        }

        @Override
        public E next() {
            return elements[index++]; // 返回当前元素并移动到下一个
        }

        @Override
        public void remove() {
            // 实现删除逻辑
        }
    }
}

//最后这书上在举iterator例子的时候，示例代码里出现了非常奇怪的HashSet<String>hashset=new HashSet<String>;
//hashset基于哈希map实现，是一个不允许有重复元素的集合


