package ExceptionExample;

public class TestAuthority {
    protected int a; // protected
    int b; // 缺省

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public TestAuthority(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class Testity extends TestAuthority {
    public Testity(int a, int b) {
        super(a, b);
    }
}

class Begin {
    public static void main(String[] args) {
        TestAuthority one = new TestAuthority(1, 2);
        System.out.println(one.a); //
        Testity two = new Testity(4, 5);
        System.out.println(two.a); // 不是，这本包内的子类还是本身的类还是能使用它的这个protected变量呢
    }
}