package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        Account acc1 = new Account("Ivanov Ivan Ivanovich");
        System.out.println(acc1);
        Account acc2 = new Account("Petrov Petr Petrovich");
        System.out.println(acc2);
        Account acc3 = new Account("Sidorov Sidor Sidorovich");
        System.out.println(acc3);

        System.out.println("Hello and welcome!");

        acc1.setCurrencySaldoPair("RUB",100);
        acc1.setCurrencySaldoPair("USD",100);
        acc1.setCurrencySaldoPair("EUR",100);
        System.out.println(acc1);
        acc2.setCurrencySaldoPair("RUB",200);
        System.out.println(acc2);
        acc2.setCurrencySaldoPair("RUB",300);
        System.out.println(acc2);
        acc2.setCurrencySaldoPair("RUB",8888);
        System.out.println(acc2);
        acc3.setCurrencySaldoPair("RUB",300);
        System.out.println(acc3);

        String s = "[RUB]200[/RUB]";
        String Currency = "RUB";
        int Saldo = 8888;
        System.out.println(s);
        s =
                s.replaceAll(
                        s.substring
                                (s.indexOf("["+ Currency + "]")  //Currency.length() + 1
                                        , s.indexOf("[/"+ Currency + "]")
                                )
                        //"["+ Currency + "]" + Saldo + "[/"+ Currency + "]"
                        ,"["+ Currency + "]" + Saldo// + "[/"+ Currency + "]"
                );
        System.out.println(s);
        System.out.println("["+ Currency + "]" + Saldo);
        System.out.println(s.substring
                (s.indexOf("["+ Currency + "]")  //Currency.length() + 1
                        , s.indexOf("[/"+ Currency + "]")
                ));
        System.out.println(s.indexOf("["+ Currency + "]"));
        System.out.println(s.indexOf("[/"+ Currency + "]"));
        System.out.println(                s.replaceAll(
                s.substring
                        (s.indexOf("["+ Currency + "]")  //Currency.length() + 1
                                , s.indexOf("[/"+ Currency + "]")
                        )
                //"["+ Currency + "]" + Saldo + "[/"+ Currency + "]"
                ,"["+ Currency + "]" + Saldo// + "[/"+ Currency + "]"
        ));
        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
//        for (int i = 1; i <= 5; i++) {
//
//            // Press Shift+F9 to start debugging your code. We have set one breakpoint
//            // for you, but you can always add more by pressing Ctrl+F8.
//            System.out.println("i = " + i);
//        }
    }
}