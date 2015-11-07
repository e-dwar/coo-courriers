class Main
{
    public static void main (String[] args)
    {
        A<X> a = new A<X>(new X());
        B b = new B(new X());
        System.out.println(b.v());
    }
}
