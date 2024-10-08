import java.util.Arrays;

public class First {
    private float x;
    private float y;

    /**
     * 这就是很经典的javadoc了，我也懒得写怎么生成了
     * @param x
     */
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
    //经典setget
    /*wtf、s fs s
    这注释风格也是这样*/
    //大部分的语法风格基本和c一致，先在first里把它的语法讲个明白吧
    /*
    1主类是包含程序入口点（即主方法）的嘞，他可以是任意一个类，他只要包含主方法就行。
    2java中有“成员变量” 和“局部变量”，没有全局变量
    3主方法是public static void main(String[] args),可以用命令行给他传参
    4可以导入其他包，其他类，java 中是用包来管理文件的，具体怎么导入后面单独开一点点讲
    5java的数据类型 byte8位 short16位 int32位 long64位 write once ,run any where 所以就永远这么长
      float 32位   double 64位
      char 16位  \n \123八进制 \u1234 16进制  都没什么区别\n \' \"  \t \\ \r
      boolen 布尔 不具体规定，一般来说是一个字节，为了方便寻址(一个字节是最小寻址单位）
      这都是基本数据类型了
      String是个类，标准库的一部分。
      先声明，后使用
      final 关键字
      运算符基本上和c一样，| 按位或 &按位与 >> >>> << ~按位取反 ^按位异或
      if else else if 反正都是一样的
      switch (expression){
      case 常量1：
      执行语句
      break(可选)}
      同样的for,while 也是一样的
      foreach 语句是专业用的
      continue,break 完全一致
      for (int x:arr){
      System.out.println(x);}
      okok,这foreach 循环属于是还得练，因为你得知道你容器里的元素到底是什么，就比如说二维数组它内部的元素就是一堆指针


     */
    public int add(int a,int b){
        return a+b;
    }
    public static void main(String[] args){
        System.out.println("HELLO JAVA");
        int arr[];
        arr =new int[5];
        //就是这样搞一维数组的
        //或者
        int month[]=new int[12];
        //二维数组则是稍微抽象，相当于是指针数组，然后指针指向另一个一维数组，这样就能实现锯齿数组的
        //直接print会调用它的tostring
        int a[][] =new int[2][];
        a[0]=new int[]{1,2};

        a[1]=new int[3];
        int b[][]={{1,2,3},{1,2}};
        //这样居然也是没有问题的
        int c[]=new int[2];

        for(int[] x:a) {//经典错误，因为本身二维数组是一个指针数组，相当于得用这个来遍历
            for(int m:x) {
                System.out.println(m);
            }
        }
        int m=2,n=1;
        //类内非static方法是无法被主函数直接调用的，他是成员方法 add(m,n);
        Arrays.fill(c,5);
        for(int x:c) {//经典错误，因为本身二维数组是一个指针数组，相当于得用这个来遍历

                System.out.println(x);

        }
        //时刻注意传入参数是什么类型的，比如这里的c应该只能是只能持有int类型的数组，不然后面那个就赋不进去

    }


}
