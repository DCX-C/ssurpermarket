package pay;


import static ui.Ui.total;

public class Pay{


    public int item = 0;

    public Pay()
    {

    }



    public float getResult(int in)
    {
        return in-total;
    }

    public float getTotal()
    {
        return total;
    }

    public Pay getPay()
    {
        return this;
    }



}
