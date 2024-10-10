package SixthChapterGenericsEg;

/**
 * 第六章，泛型类
 * 以下的的这个类就是个泛型类，具体怎么定义看我后面的操作。首先先给类后面加泛型类型声明（参数没有上限）
 *
 */
public class GenericsEGclass<A,B> {
    private A element1;
    private B element2;
    public A getElement1()
    {
        return element1;
    }

    public B getElement2() {
        return element2;
    }
    public GenericsEGclass(A element1,B element2)
    {
        this.element1=element1;
        this.element2=element2;
    }
}

/**
 * 如果你写成interface GenericInterface<T>()就错了，因为它只是一个接口，它ide会说为非记录声明了记录标头
 * @param <T>
 */
interface GenericInterface<T>{
    T getValue(T t);
}

/**
 * 泛型方法
 * 就是说其函数类型和形参类型不具体指定，相比于普通方法，要在返回值类型前写类型参数
 */
 class GenericMethod{
     public <t> void f(t parameter) {//说明了这参数是真的可以用小写字母，书上都是大写
         System.out.println(parameter.toString());

     }
     public static <K extends Comparable>K min(K k1,K k2){
         if(k1.compareTo(k2)>0){
             //这个compareTo的description，文档注释写的太好了，简直就是离散数学
             return k1;
         }
         else{
             return k2;
         }
     }


}