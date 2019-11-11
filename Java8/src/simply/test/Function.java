package simply.test;

@FunctionalInterface
public interface Function<X,Y,Z> {

    public String apply(String stringFormat, Double doubleResult);
    
}
