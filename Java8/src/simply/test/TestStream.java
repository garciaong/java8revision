package simply.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestStream {

    public static void main(String[] args) {
        /**
         * Execution result :
         * 15
         * 15
         * 15
         * 15
         * 15
         * List in string : [potatoes, orange, lemon, bread, sugar]
         * List in string : [potatoes, orange, lemon, bread, sugar]
         * Average : 17.2
         * Sum : 86
         * Maximum product price : 23
         * Minimum product price : 13
         * Number of records : 5
         */

        // Stream.reduce()
        // A terminal operation that performs a reduction on the elements of the stream
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Integer sum = integers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        // Stream.collect()
        // To perform sum using collect terminal operation
        sum = integers.stream()
                .collect(Collectors.summingInt(Integer::intValue));
        System.out.println(sum);
        sum = integers.stream()
                .collect(Collectors.summingInt(i -> i.intValue()));
        System.out.println(sum);

        // Sream.sum()
        sum = integers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);
        sum = integers.stream()
                .mapToInt(i -> i)
                .sum();
        System.out.println(sum);

        List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"), new Product(13, "lemon"),
                new Product(23, "bread"), new Product(13, "sugar"));
        List<String> collectorCollection =
                productList.stream().map(Product::getName).collect(Collectors.toList());
        System.out.println(String.format("List in string : %s", collectorCollection));
        String listToString = productList.stream().map(Product::getName)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(String.format("List in string : %s", listToString));
        double averagePrice = productList.stream()
                .collect(Collectors.averagingInt(Product::getId));
        System.out.println(String.format("Average : %s", averagePrice));
        int summingPrice = productList.stream()
                .collect(Collectors.summingInt(Product::getId));
        System.out.println(String.format("Sum : %d", summingPrice));
        Optional<Product> maxProduct = productList.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Product::getId)));
        System.out.println(String.format("Maximum product price : %d", maxProduct.get().getId()));
        Optional<Product> minProduct = productList.stream()
                .collect(Collectors.minBy(Comparator.comparing(Product::getId)));
        System.out.println(String.format("Minimum product price : %d", minProduct.get().getId()));
        long noOfRecords = productList.stream()
                .collect(Collectors.counting());
        System.out.println(String.format("Number of records : %d", noOfRecords));

    }

}
