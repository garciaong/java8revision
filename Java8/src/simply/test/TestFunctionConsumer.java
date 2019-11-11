package simply.test;

import java.util.function.Consumer;
import java.util.function.Function;

public class TestFunctionConsumer {

    public static void main(String [] args) {
        Function<Integer,Double> func = i -> { return Double.valueOf((double)i/2);};
        Consumer<String> cons = s -> { System.out.println(String.format("%s", s)); };
        simply.test.Function<String,Double,String> func2 = (s, d) -> {return String.format(s, d.doubleValue());};
        cons.accept(func2.apply("Final result is : %s", func.apply(3)));
    }
    
}
