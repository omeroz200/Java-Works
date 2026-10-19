# Floating-Point Literals ve Scientific Notation

## Sınav Odaklı Ders Notu — Java JDK 27

> **Hedef:** Ondalıklı literal türünü bulmak, bilimsel gösterimi çevirmek, kodun derlenip derlenmeyeceğini ve çıktısını yorumlamak.

---

## 1. Kısa Giriş

Java koduna doğrudan yazılan değere **literal (sabit)** denir.

```java
int age = 20;         // integer literal
double pi = 3.14;     // floating-point literal
float heat = 24.5F;   // floating-point literal
```

> **Ana kural:** Ondalıklı literal, sonunda `F/f` yoksa varsayılan olarak `double`dır.

## 2. `float` ve `double`

| Tür | Boyut | Yaklaşık hassasiyet | Literal eki |
|---|---:|---:|---|
| `float` | 32 bit | 6–7 anlamlı basamak | `F/f` |
| `double` | 64 bit | 15–16 anlamlı basamak | `D/d` (isteğe bağlı) |

```java
float a = 3.14F;
double b = 3.14;
double wide = a;     // doğru
float narrow = b;    // hata
```

`double`, genel amaçlı ondalıklı işlemlerde varsayılan tercihtir.

## 3. Floating-Point Literal Yazımları

| Yazım | Tür | Değer |
|---|---|---:|
| `3.14` | `double` | 3.14 |
| `3.14D` | `double` | 3.14 |
| `3.14f` | `float` | yaklaşık 3.14 |
| `10.` | `double` | 10.0 |
| `.5` | `double` | 0.5 |
| `2e3` | `double` | 2000.0 |
| `2e3F` | `float` | 2000.0 |

```java
float price = 19.99;    // HATA
float price = 19.99F;   // DOĞRU
```

## 4. `F/f` ve `D/d` Suffix'leri

| Suffix | Tür | Örnek |
|---|---|---|
| yok | `double` | `7.25` |
| `F/f` | `float` | `7.25F` |
| `D/d` | `double` | `7.25D` |

```text
8.5 → double    8.5F → float
8.5f → float    8.5D → double
```

`D/d` zorunlu değildir. Casting ile suffix aynı şey değildir:

```java
float a = 3.14F;         // literal baştan float
float b = (float) 3.14;  // double, float'a dönüştürülüyor
```

## 5. Scientific Notation

```text
a × 10ⁿ
3e5 = 3 × 10⁵ = 300000
```

Java'da `× 10ⁿ` yerine `e` veya `E` kullanılır.

```java
double a = 2e3;
double b = 2E3;  // ikisi de 2000.0
```

Buradaki `e`, Euler sayısı değil exponent gösteriminin parçasıdır.

## 6. Pozitif ve Negatif Exponent

```text
1.5e3  = 1500     → nokta 3 basamak SAĞA
2.5e-3 = 0.0025   → nokta 3 basamak SOLA
```

| Gösterim | Açılım | Normal sayı |
|---|---|---:|
| `1e2` | 1 × 10² | 100 |
| `4.2e3` | 4.2 × 10³ | 4200 |
| `7e-1` | 7 × 10⁻¹ | 0.7 |
| `3.5e-4` | 3.5 × 10⁻⁴ | 0.00035 |

## 7. Normal Sayı ↔ Scientific Notation

Standart gösterimde `1 ≤ |katsayı| < 10` olur.

```text
450000  = 4.5e5
0.00072 = 7.2e-4
2500    = 2.5e3 = 25e2 = 0.25e4
```

Son satırdakiler eşdeğerdir; standart biçim `2.5e3`tür.

## 8. Scientific Notation'da Tür

```text
5e3 → double     5e3F → float
5E3 → double     5e3D → double
```

```java
double a = 5e3;  // doğru
float b = 5e3F;  // doğru
float c = 5e3;   // hata
```

`5e3`, nokta içermese bile floating-point literal'dır.

## 9. JDK 27: Compact Source File ve `IO.println`

JDK 27'de küçük programlar sınıf bildirimi olmadan **compact source file** olarak yazılabilir. `void main()` başlatılabilir instance main metodudur; `java.lang.IO` basit konsol I/O sağlar.

```java
void main() {
    double pi = 3.14159;
    float temperature = 24.5F;
    double large = 6.02e23;
    double small = 1.6e-19;

    IO.println(pi);
    IO.println(temperature);
    IO.println(large);
    IO.println(small);
}
```

Muhtemel çıktı:

```text
3.14159
24.5
6.02E23
1.6E-19
```

Kaynakta `e`, çıktıda `E` görülmesi değeri değiştirmez.

## 10. Aritmetik İşlemlerde Tür

```java
float a = 2.0F;
double b = 3.0;
double result = a + b;  // doğru
float wrong = a + b;    // hata: sonuç double
```

### Tam sayı bölmesi tuzağı

```java
double x = 5 / 2;      // 2.0
double y = 5.0 / 2;    // 2.5
double z = 5 / 2.0;    // 2.5
```

İlk satırda önce iki `int` bölünür; `2` sonra `double`a çevrilir.

## 11. Precision ve Rounding

Birçok ondalık sayı ikili sistemde tam temsil edilemez.

```java
void main() {
    double result = 0.1 + 0.2;
    IO.println(result); // 0.30000000000000004
}
```

```java
float f = 1.23456789F;  // yaklaşık 1.2345679
double d = 1.23456789;  // yaklaşık 1.23456789
```

Toleranslı karşılaştırma:

```java
double result = 0.1 + 0.2;
IO.println(result == 0.3);                   // false
IO.println(Math.abs(result - 0.3) < 1e-9);  // true
```

> Para gibi tam ondalık doğruluk gereken alanlarda genellikle `BigDecimal` kullanılır.

## 12. Özel Değerler

| Değer | Anlam | Örnek |
|---|---|---|
| `Infinity` | Pozitif sonsuz | `1.0 / 0.0` |
| `-Infinity` | Negatif sonsuz | `-1.0 / 0.0` |
| `NaN` | Sayı değil | `0.0 / 0.0` |

`1 / 0` ise integer division olduğu için `ArithmeticException` oluşturur.

## 13. Yaygın Hatalar

1. `float x = 3.14;` yazmak; doğrusu `3.14F`.
2. Negatif exponent'te noktayı sağa kaydırmak.
3. `3e` yazmak; exponent basamağı zorunludur.
4. Ondalık ayırıcı olarak `3,14` kullanmak; Java'da nokta gerekir.
5. `5 / 2` sonucunu 2.5 sanmak.
6. Floating-point sonuçları her zaman `==` ile karşılaştırmak.
7. `e`yi değişken sanmak.
8. `double` sonucu `float`a doğrudan atamak.

## 14. Çözümlü Örnekler

### Örnek 1

`var value = 7.25F;` → `F` nedeniyle tür `float`.

### Örnek 2

`float rate = 0.75;` → Derlenmez; doğrusu `0.75F`.

### Örnek 3

```text
6.4e4 = 64000
9.2e-3 = 0.0092
0.000045 = 4.5e-5
```

### Örnek 4

```java
void main() {
    double a = 4e2;
    float b = 2.5e-2F;
    IO.println(a);
    IO.println(b);
}
```

Çıktı:

```text
400.0
0.025
```

### Örnek 5

`double result = 7 / 2;` → Önce integer division yapılır; değer `3.0`.

### Örnek 6

`0.1 + 0.2 == 0.3` → Binary temsil farkı nedeniyle `false`.

## 15. Sınav Pratiği — 24 Soru

### A. Literal türünü yaz

1. `3.14`
2. `3.14F`
3. `8.5d`
4. `.25f`
5. `6e4`
6. `6E4F`

### B. Normal sayıya çevir

7. `2e3`
8. `4.5e2`
9. `7e-1`
10. `3.2e-4`
11. `1.25E3`
12. `9E-5`

### C. Scientific notation'a çevir

13. `560000`
14. `0.0072`
15. `81.5`
16. `0.0000003`

### D. Derlenir mi?

17. `float x = 4.2;`
18. `double x = 4.2F;`
19. `float x = 3e2F;`
20. `double x = 3e;`

### E. Çıktıyı bul

21. `double x = 5 / 2; IO.println(x);`
22. `double x = 5.0 / 2; IO.println(x);`
23. `float a = 1.5F; double b = 2.0; IO.println(a + b);`
24. `double x = 0.1 + 0.2; IO.println(Math.abs(x - 0.3) < 1e-9);`

## 16. Cevap Anahtarı

| Soru | Cevap |
|---:|---|
| 1 | `double` |
| 2 | `float` |
| 3 | `double` |
| 4 | `float` |
| 5 | `double` |
| 6 | `float` |
| 7 | `2000` |
| 8 | `450` |
| 9 | `0.7` |
| 10 | `0.00032` |
| 11 | `1250` |
| 12 | `0.00009` |
| 13 | `5.6e5` |
| 14 | `7.2e-3` |
| 15 | `8.15e1` |
| 16 | `3e-7` |
| 17 | Derlenmez; `4.2` double'dır. |
| 18 | Derlenir; float, double'a genişletilir. |
| 19 | Derlenir; değer `300.0F`. |
| 20 | Derlenmez; exponent basamağı eksik. |
| 21 | `2.0` |
| 22 | `2.5` |
| 23 | `3.5` |
| 24 | `true` |

## 17. Son Dakika Kontrol Listesi

- [ ] Suffix yoksa literal `double`dır.
- [ ] `float` literal için `F/f` gerekir.
- [ ] `D/d`, `double` anlamına gelir.
- [ ] `e` ve `E` eşdeğerdir.
- [ ] Pozitif exponent: sağa; negatif exponent: sola.
- [ ] Normal sayı ↔ bilimsel gösterim dönüşümü yapabiliyorum.
- [ ] `5e3` bir floating-point literal'dır.
- [ ] `float` ve `double` hassasiyetini ayırabiliyorum.
- [ ] `5 / 2` ile `5.0 / 2` farkını biliyorum.
- [ ] Floating-point eşitliklerinde temsil farkını hesaba katıyorum.
- [ ] JDK 27 `void main()` ve `IO.println(...)` yazımını tanıyorum.

## 18. Tek Bakışta Özet

```text
3.14 → double       3.14F → float
2e3  → 2000.0       2.5e-3 → 0.0025

Pozitif üs → sağa
Negatif üs → sola

float  → yaklaşık 6–7 anlamlı basamak
double → yaklaşık 15–16 anlamlı basamak

5 / 2 = 2
5.0 / 2 = 2.5
```

> **Sınav stratejisi:** Önce suffix'e bak, türü belirle; exponent işaretini kontrol et; son olarak atama ve işlem türünün geçerli olup olmadığını incele.
