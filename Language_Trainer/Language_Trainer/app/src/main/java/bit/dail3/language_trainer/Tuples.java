package bit.dail3.language_trainer;

/**
 * Created by dailifeng on 16/3/26.
 */
public class Tuples<T1, T2, T3>
{
    private T1 first;
    private T2 second;
    private T3 third;

    public Tuples(T1 first, T2 second, T3 third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T1 getFirst()
    {
        return first;
    }

    public T2 getSecond()
    {
        return second;
    }

    public T3 getThird()
    {
        return third;
    }
}
