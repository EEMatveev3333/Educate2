package org.example;

public class Account {
    //1. Account имеет поле для имени владельца: String
    private String ownerName;
    //-------------------------------------------------------------------

    //2. Account имеет поле, в котором хранятся пары валюта-количество.
    // Количество валюты хранится в виде целочисленного значения.
    // Валюта должна быть представлена таким образом, чтобы указать можно было только значение из некоторого фиксированного списка значений
    // (конкретный перечень допустимо указать произвольно в коде).
    private String currencySaldoTextList = "";//"[RUB]{0};[USD]{0};[EUR]{0}";
    //-------------------------------------------------------------------

    //3. Создание объекта Account возможно только с указанием имени владельца счета.
    public Account(String ownerName) throws NullPointerException  {
        //Также необходимо реализовать следующие ограничения:
        //        — Имя не может быть null или пустым
        //В случае нарушения ограничений необходимо бросать подходящее исключение.
        if (ownerName != null && !ownerName.trim().isEmpty()) {
            // Обработка строки
            this.ownerName = ownerName;
        }
        else
            throw new NullPointerException("ownerName cannot be null or empty");


    }
    //-------------------------------------------------------------------

    //4. Для имени необходимо сделать геттеры и сеттеры
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    //-------------------------------------------------------------------

    //5. Для пар валюта-количество необходимо сделать только геттер.
    public String getCurrencySaldoTextList() {
        return currencySaldoTextList;
    }
    //-------------------------------------------------------------------

    //6. Необходим метод, который принимает Валюту и её количество и заменяет текущее количество данной Валюты на указанное. Если такой валюты ранее не было – она добавляется в список.
    public void setCurrencySaldoPair(String Currency, int Saldo) throws IllegalArgumentException   {
        //this.ownerName = ownerName;
        if (Saldo < 0)
            throw new IllegalArgumentException("Saldo cannot be negative");

        if (this.currencySaldoTextList.contains("["+ Currency + "]"))
            this.currencySaldoTextList =
                    this.currencySaldoTextList.replaceAll(
                            this.currencySaldoTextList.substring
                                    (this.currencySaldoTextList.indexOf("["+ Currency + "]")  //Currency.length() + 1
                                            , this.currencySaldoTextList.indexOf("[/"+ Currency + "]")
                                    )
                            //"["+ Currency + "]" + Saldo + "[/"+ Currency + "]"
                            ,"["+ Currency + "]" + Saldo// + "[/"+ Currency + "]"
                    );
        else
            this.currencySaldoTextList = this.currencySaldoTextList + "["+ Currency + "]" + Saldo + "[/"+ Currency + "]";
    }



    //        — Количество валюты не может быть отрицательным



    //Необходимо реализовать и приложить модульные тесты, проверяющие выполнение обозначенных требований.


    @Override
    public String toString() {
        return "Account{" +
                "ownerName='" + ownerName + '\'' +
                ", currencySaldoTextList='" + currencySaldoTextList + '\'' +
                '}';
    }
}
