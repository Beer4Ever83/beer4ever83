package tricktactoe;

public interface Symbol<T> {

    public void setSymbol(T s);

    public T getSymbol();

    public boolean equals(Object o);
}
