package LambdaHomeWork;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {


    public static void main(String[] args) {

        // задача 1

        Predicate<Integer> number2 = new Predicate<Integer> () {
            @Override
            public boolean test(Integer integer) {
                return integer <= 0;
            }
        };

        System.out.println ( number2.test ( -5 ) );
        System.out.println ( number2.test ( 4 ) );


        Predicate<Integer> number = i -> i < 0;
        System.out.println ( number.test ( 6 ) );
        System.out.println ( number.test ( -9 ) );

        // задача 2

        Consumer<String> nameHuman = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Приветсвую вас, " + s);
            }
        };

        nameHuman.accept("Ivan");

        Consumer<String> nameHuman2 = s -> System.out.println("Приветсвую вас, " + s);

        nameHuman2.accept("Igor");

        // задача 3

        Function<Double, Long> rebuildNumber = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {

                return aDouble.longValue();
            }
        };
        System.out.println(rebuildNumber.apply(6.77));

        Function<Double, Long> rebuildNumber2 = aDouble -> aDouble.longValue();
        System.out.println(rebuildNumber2.apply(34.17567));


        Function<Double, Long> rebuildNumber3 = Double::longValue;
        System.out.println(rebuildNumber3.apply(78.5));


        // задача 4


        Supplier<Double> numberSupplier=new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random();
            }
        };
        System.out.println(numberSupplier.get());

        Supplier<Double> numberSupplier2= () -> Math.random();
        System.out.println(numberSupplier2.get());

        Supplier<Double> numberSupplier3= Math::random;
        System.out.println(numberSupplier3.get());



        // задача 5
        Integer parameter = 17;
        Integer parameter2 = -59;
        Predicate<Object> condition = p-> parameter>0;
        Function<Object, String> ifTrue = s -> "Positive number";
        Function<Object, String> ifFalse = s -> "Negative number";
        Function<String,String> result=ternaryOperator ( condition,ifTrue,ifFalse );
        System.out.println (result.apply ( "THE END" ));







    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

return t -> condition.test ( t ) ? ifTrue.apply ( t ): ifFalse.apply ( t );
    }


}
