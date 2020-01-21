

public class test {
    static int a,b;



    public static void main (String[] args)
    {
        teee q[];
        q = new teee[3];
        q[1] = new teee(1);
        q[3] = new teee(4);

        System.out.println(q[1].a);
        System.out.println(q[2].a);



        System.out.println(q[1].a);
        System.out.println(q[2].a);

    }

}
class teee
{
    int a;

    public teee(int x)
    {
        a = x;
    }
    public int get()
    {
        return a;
    }


}
