package simply.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestSorting {

    public static void main(String[] args) {
        /**
         * Print Result
         * 1
         * 2
         * 3
         * A
         * C
         * a
         * b
         * c
         * 
         * c
         * b
         * a
         * C
         * A
         * 3
         * 2
         * 1
         * 
         * Sort by model
         * 10R
         * 10X
         * Mate30
         * Mate30P
         * S10
         * S10+
         * 
         * Sort by price
         * S10
         * 10R
         * S10+
         * Mate30
         * Mate30P
         * 10X
         * 
         * Sort by brand,price desc
         * Mate30P
         * Mate30
         * S10+
         * S10
         * 10X
         * 10R
         * 
         * Sort by brand desc,model
         * 10R
         * 10X
         * S10
         * S10+
         * Mate30
         * Mate30P
         */
        List<String> strings = Arrays.asList("a", "b", "A", "c", "1", "C", "2", "3");
        List<String> results = strings.stream().sorted().collect(Collectors.toList());
        results.forEach(System.out::println);
        System.out.println();
        List<String> results2 = strings.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        results2.forEach(System.out::println);
        System.out.println();
        Phone iphone10x = new Phone("iPhone", "10X", 6000);
        Phone iphone10r = new Phone("iPhone", "10R", 3200);
        Phone galaxyS10 = new Phone("Samsung", "S10", 3000);
        Phone galaxyS10P = new Phone("Samsung", "S10+", 3500);
        Phone huaweiMate30 = new Phone("Huawei", "Mate30", 3500);
        Phone huaweiMate30p = new Phone("Huawei", "Mate30P", 4000);
        Phone galaxyS10P2 = galaxyS10P;
        System.out.println(String.format("Default hashcode for S10+ is %d", galaxyS10P.hashCode()));
        System.out.println(String.format("Default hashcode for S10+ reference is %d", galaxyS10P2.hashCode()));
        System.out.println(String.format("Default hashcode Mate30 is %d", huaweiMate30.hashCode()));
        List<Phone> phones = Arrays.asList(iphone10x, iphone10r, galaxyS10, galaxyS10P, huaweiMate30, huaweiMate30p);
        System.out.println("Sort by model");
        phones.stream().sorted(Comparator.comparing(Phone::getModel)).forEach(p -> System.out.println(p.getModel()));
        System.out.println();
        System.out.println("Sort by price");
        phones.stream().sorted(Comparator.comparing(Phone::getPrice)).forEach(p -> System.out.println(p.getModel()));
        System.out.println();
        System.out.println("Sort by brand,price desc");
        phones.stream().sorted(Comparator.comparing(Phone::getBrand).thenComparing(Comparator.comparing(Phone::getPrice).reversed()))
                .forEach(p -> System.out.println(p.getModel()));
        System.out.println();
        System.out.println("Sort by brand desc,model");// iPhone at top because natural order is 123,ABC,abc and iPhone has small letter i and will be first
                                                       // when sort descending
        phones.stream().sorted(Comparator.comparing(Phone::getBrand).reversed().thenComparing(Comparator.comparing(Phone::getModel)))
                .forEach(p -> System.out.println(p.getModel()));
        System.out.println();
    }

    private static class Phone {
        private String brand;
        private String model;
        private int price;

        public Phone(String brand, String model, int price) {
            super();
            this.brand = brand;
            this.model = model;
            this.price = price;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }

}
