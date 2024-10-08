public class StringApi {
    private int a;
    private int b;

    public static void main(String[] args) {
        String s="String is a list of characters";//cpp风格初始化
        String s2=new String("new way of initializaion");//把它当对象初始化
        System.out.println(s.charAt(2));//返回index处的char值1
        s=s.concat("!");//连接尾部2
        System.out.println(s);
        System.out.println(s.contains("!"));//是否包含3
        System.out.println(s.equals(s2));//判断是否相等
        System.out.println(s.indexOf("is"));//返回子字符串第一次出现处的索引
        s.length();//返回长度
        s.substring(1,2);//返回子字符串，可以指定首尾,inclusive begin,exclusive end
        s.substring(1);
        s.toLowerCase();//
        s.toUpperCase();//都没什么说的，都是简单的转化
        s.trim();//with all the leading and trailing space removed
        System.out.println(s.valueOf(1));//static方法，所以直接String.valueOf即可

    }
/*


    //基本方法
    //1初始化，常用方法 Charsequence是一个接口，emmmm那书上写了个这个方法boolean contains(CharSequence s)，
    // 2：字符串的链接  s=s.concat("!");//连接尾部2
    //3子字符串的操作， s.substring(1);4字符串比较
    4字符串的比较，就比较的搞笑
     */


}
