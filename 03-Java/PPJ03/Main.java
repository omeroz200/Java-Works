package PPJ03;

public class Main {
    public static void main(String[] args) {
        // 1.challenge
        double sqTwo = Math.sqrt(2);
        double result = sqTwo * sqTwo - 2;
        IO.println(result);

        // 2.challenge
        int x = 5;
        IO.println((x = 4) * x);

        // Because x is assigned first,
        // but y's old value is read first.
        int y = 5;
        IO.println(y * (y = 4));

        // 3.challenge

        int a = 10, b = 5, c = 1, res;

        // Because ++ adds 1 to the value.
        res = a - c++ - ++b;

        IO.println("Result: " + res);


        // 4.challenge

        byte h = 0176;

        IO.println(++h);
        IO.println(h++);
        IO.println(h);


        // 6.challenge
        IO.println(
                (((1 + 2 * 3 + 4) / (5.0 - 6)) + 78)
                        / (9 - (10.0 / 11))
        );

        // 7.challenge

        IO.println('a' + 2);
        IO.println('a' + '2');
        IO.println((char) ('a' + 2));
        IO.println("ppj" + 'a' + '2');
        IO.println("ppj" + 'a' + '\t' + '2');
        IO.println('a' + '2' + "ppj");


        // 8.challenge

        long f = 1_500_000_000L;
        long z = 1_500_000_000L;

        IO.println(a + b);

    }
}