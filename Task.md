# Lokata bankowa
Napisz moduł do systemu informatycznego, który będzie obliczać zysk z rocznej inwestycji w lokatę bankową. Na wejściu powinna zostać przyjęta kwota inwestowanego kapitału, a na wyjściu pojawić się wartość po zakończeniu lokaty (kapitał wraz z zyskiem). Oprocentowanie lokaty uzależnione jest od inwestowanej kwoty, według poniższego podziału:

 	0,00 < kapitał <= 20 000,00 – oprocentowanie 2% w skali roku
 	20 000,00 < kapitał <= 50 000,00 – oprocentowanie 2,5% w skali roku
	50 000,00 < kapitał <= bez limitu – oprocentowanie 3% w skali roku

Program powinien dobrać przedział dla podanego kapitały początkowego i obliczyć wartość końcową, według poniższego wzoru:

    Kk = Kp + (Kp * Op)
    Kk - Kapitał końcowy
    Kp – Kapitał początkowy
    Op – Oprocentowanie lokaty
    
Nie zapomnij o testach sprawdzających poprawność implementacji.

**Rozwiązanie powinno być wystawione jako PR (Pull request) do gałęzi master**