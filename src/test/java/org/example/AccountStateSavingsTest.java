package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountStateSavingsTest {

    @Test
    @DisplayName("Сохранение состояния счета")
    void saveState() {
        Account account = new Account("Ivanov Ivan Ivanovich");
        account.setCurrencyAmount(Currency.RUB, 100);
        Account.AccountSnapshot snapshot= account.save();
        System.out.println( snapshot.toString());
        account.setCurrencyAmount(Currency.USD, 200);
        System.out.println( account.toString());
        assertEquals("TOLI", snapshot.getOwnerName());
        assertEquals(100, snapshot.getCurrencyMap().get(Currency.RUB));
        assertEquals(200, account.getCurrencyMap().get(Currency.USD));
    }

    @Test
    @DisplayName("Проверка неизменяемости сохранения")
    void testSaveImmutability()  {
        Account account = new Account("Petrov Petr Petrovich");
        account.setCurrencyAmount(Currency.EUR, 100);
        System.out.println( account.toString());
        Account.AccountSnapshot snapshot = account.save();

        Map<Currency, Integer> currencyMap = snapshot.getCurrencyMap();
        // используем Assertions.assertThrows для проверки неизменяемости снимка
        assertThrows(UnsupportedOperationException.class, () -> currencyMap.put(Currency.EUR, 200)  );

        // оригинал остался неизменным
        assertTrue(account.getCurrencyMap().containsKey(Currency.EUR));
        assertEquals(100, account.getCurrencyMap().get(Currency.EUR));
    }

    @Test
    @DisplayName( "Востановление состояния счета из сохранения")
    void loadState() {
        Account account = new Account("Sidorov Sidor Sidorovich");
        account.setCurrencyAmount(Currency.EUR, 100);
        Account.AccountSnapshot snapshot = account.save();  // снимок на 100 EUR
        System.out.println( snapshot.toString());
        account.setCurrencyAmount(Currency.EUR, 200);  //меняем на 200
        System.out.println( account.toString());
        //   account=account.restoreFromSnapshot(snapshot);
        account.restoreFromSnapshot(snapshot);
        System.out.println( "После востановления "+account.toString());
        // проверяем правильность востановления
        assertEquals("TOLI", account.getOwnerName());
        assertTrue(account.getCurrencyMap().containsKey(Currency.EUR)); // проверяем валюта EUR
        assertEquals(100, account.getCurrencyMap().get(Currency.EUR));  //Сумма 100

    }
}