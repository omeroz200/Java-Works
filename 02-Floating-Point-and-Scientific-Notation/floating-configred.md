# Floating-Point Literals ve Scientific Notation — Sınav Odaklı Ders Notu

> Bu notun amacı Java'da ondalıklı sayıların nasıl yazıldığını, `float` ve `double` arasındaki farkı ve Scientific Notation (Bilimsel Gösterim) mantığını öğrenmektir.

---

## 1. Floating-Point Number Nedir?

Programlamada sayıları genel olarak iki gruba ayırabiliriz:

- Tam sayılar
- Ondalıklı sayılar

Örneğin:

```text
10
25
-8
```

tam sayıdır.

Ama:

```text
3.14
2.5
0.75
-12.8
```

ondalıklı sayılardır.

Java'da ondalıklı sayıları saklamak için temel olarak iki veri tipi kullanılır:

```text
float
double
```

Örnek:

```java
double height = 1.75;
float temperature = 24.5F;
```

---

## 2. Literal Nedir?

Kodun içine doğrudan yazdığımız değerlere **literal** denir.

Örneğin:

```java
int age = 20;
double price = 19.99;
char letter = 'A';
```

Burada:

```text
20
19.99
'A'
```

birer literal'dır.

Ondalıklı bir değer doğrudan kodun içine yazılmışsa buna:

**Floating-Point Literal**

denir.

Örneğin:

```java
3.14
5.5
0.25
12.75
```

floating-point literal örnekleridir.

---

## 3. `float` ve `double`

Java'da iki temel floating-point veri tipi vardır:

| Tür | Boyut | Yaklaşık hassasiyet |
|---|---:|---:|
| `float` | 32 bit | 6–7 anlamlı basamak |
| `double` | 64 bit | 15–16 anlamlı basamak |

`double`, `float`'tan daha fazla hassasiyet sağlar.

Bu yüzden Java'da ondalıklı sayılar için çoğu zaman:

```java
double
```

kullanılır.

> Buradaki "6–7 basamak" veya "15–16 basamak", virgülden sonra kesin olarak o kadar rakam yazılabileceği anlamına gelmez. Yaklaşık **anlamlı basamak hassasiyetini** ifade eder.

---

## 4. Java Ondalıklı Literalları Varsayılan Olarak `double` Kabul Eder

Bu konudaki en önemli kurallardan biri budur.

Java'da:

```java
3.14
```

yazdığımız zaman Java bunu otomatik olarak:

```text
double
```

olarak kabul eder.

Dolayısıyla:

```java
double number = 3.14;
```

doğrudur.

Çünkü:

```text
3.14 → double
number → double
```

Türler uyumludur.

---

## 5. `float` İçin `F` veya `f`

Şunu yazarsak:

```java
float number = 3.14;
```

Java hata verir.

Çünkü:

```text
3.14 → double
```

ama değişken:

```text
float
```

türündedir.

Java'ya bu literal'ın `float` olduğunu söylemek için sonuna:

```text
F
```

veya:

```text
f
```

ekleriz.

Doğru kullanım:

```java
float number = 3.14F;
```

veya:

```java
float number = 3.14f;
```

İkisi tamamen aynı anlama gelir.

### Kısa kural

```text
3.14   → double
3.14F  → float
3.14f  → float
```

---

## 6. `double` İçin `D` veya `d`

`double` literal'ın sonuna istersek:

```text
D
```

veya:

```text
d
```

ekleyebiliriz.

Örneğin:

```java
double a = 3.14;
double b = 3.14D;
double c = 3.14d;
```

Üçü de doğrudur.

Çünkü:

```text
3.14
3.14D
3.14d
```

üçü de `double`'dır.

Ancak `D` yazmak genellikle gerekli değildir.

Çünkü Java zaten:

```text
3.14
```

gibi ondalıklı literalları varsayılan olarak `double` kabul eder.

---

## 7. Floating-Point Literal Örnekleri

| Literal | Tür | Değer |
|---|---|---:|
| `3.14` | `double` | 3.14 |
| `3.14F` | `float` | yaklaşık 3.14 |
| `3.14D` | `double` | 3.14 |
| `10.0` | `double` | 10.0 |
| `10.0F` | `float` | yaklaşık 10.0 |
| `0.5` | `double` | 0.5 |
| `.5` | `double` | 0.5 |
| `5.` | `double` | 5.0 |

Örneğin:

```java
double a = 5.5;
float b = 5.5F;
double c = 10.0;
float d = 0.25F;
```

hepsi doğrudur.

---

# 8. Scientific Notation Nedir?

**Scientific Notation**, Türkçede **Bilimsel Gösterim** demektir.

Çok büyük veya çok küçük sayıları daha kısa şekilde yazmak için kullanılır.

Örneğin:

```text
300000
```

sayısını şöyle yazabiliriz:

```text
3 × 10⁵
```

Çünkü:

```text
10⁵ = 100000
```

ve:

```text
3 × 100000 = 300000
```

Dolayısıyla:

```text
300000 = 3 × 10⁵
```

---

## 9. Java'da Scientific Notation

Java'da:

```text
× 10ⁿ
```

yazmak yerine:

```text
e
```

veya:

```text
E
```

kullanılır.

Örneğin matematikte:

```text
3 × 10⁵
```

Java'da:

```java
3e5
```

şeklinde yazılabilir.

Yani:

```text
3e5
= 3 × 10⁵
= 300000
```

---

## 10. `e` Ne Anlama Geliyor?

Şöyle bir sayı düşünelim:

```text
2.5e3
```

Bunu üç parçaya ayırabiliriz:

```text
2.5  → sayı / katsayı
e    → × 10 üzeri
3    → exponent (üs)
```

Yani:

```text
2.5e3
```

aslında:

```text
2.5 × 10³
```

demektir.

Hesaplarsak:

```text
10³ = 1000

2.5 × 1000 = 2500
```

Sonuç:

```text
2.5e3 = 2500
```

---

## 11. `e` ve `E` Arasında Fark Yoktur

Java'da:

```java
double a = 2e3;
double b = 2E3;
```

aynı değeri temsil eder.

İkisi de:

```text
2 × 10³
```

yani:

```text
2000
```

demektir.

Dolayısıyla:

```text
e = E
```

bilimsel gösterimde aynı işi yapar.

---

# 12. Pozitif Exponent

Exponent pozitif olduğunda ondalık nokta **sağa doğru** hareket eder.

Örneğin:

```text
1.5e3
```

demek:

```text
1.5 × 10³
```

demektir.

Noktayı 3 basamak sağa taşırız:

```text
1.5
15
150
1500
```

Dolayısıyla:

```text
1.5e3 = 1500
```

Başka örnekler:

```text
2e2
= 2 × 10²
= 200
```

```text
5e3
= 5 × 10³
= 5000
```

```text
2.5e2
= 2.5 × 10²
= 250
```

```text
7.2e4
= 7.2 × 10⁴
= 72000
```

### Kural

```text
Pozitif exponent → nokta SAĞA
```

---

# 13. Negatif Exponent

Exponent negatif olduğunda ondalık nokta **sola doğru** hareket eder.

Örneğin:

```text
2.5e-3
```

demek:

```text
2.5 × 10⁻³
```

demektir.

Noktayı 3 basamak sola taşırız:

```text
2.5
0.25
0.025
0.0025
```

Dolayısıyla:

```text
2.5e-3 = 0.0025
```

Başka örnekler:

```text
1e-1 = 0.1
```

```text
1e-2 = 0.01
```

```text
1e-3 = 0.001
```

```text
4e-2 = 0.04
```

```text
3.5e-3 = 0.0035
```

### Kural

```text
Negatif exponent → nokta SOLA
```

---

## 14. Pozitif ve Negatif Exponent Karşılaştırması

| Scientific Notation | Normal sayı |
|---|---:|
| `1e1` | 10 |
| `1e2` | 100 |
| `1e3` | 1000 |
| `2.5e2` | 250 |
| `1e-1` | 0.1 |
| `1e-2` | 0.01 |
| `1e-3` | 0.001 |
| `2.5e-3` | 0.0025 |

Hatırlamak için:

```text
e+ → büyütür → sağa

e- → küçültür → sola
```

Örneğin:

```text
3.5e4  = 35000
3.5e-4 = 0.00035
```

---

# 15. Normal Sayıyı Scientific Notation'a Çevirme

Şimdi tersini yapalım.

Örneğin:

```text
4500
```

sayısını scientific notation'a çevirmek istiyoruz.

Noktayı:

```text
4500.
```

şeklinde düşünebiliriz.

`4.5` elde etmek için noktayı 3 basamak sola taşıyoruz:

```text
4500
→ 450.0
→ 45.0
→ 4.5
```

3 basamak hareket ettiğimiz için:

```text
4500 = 4.5 × 10³
```

Java gösterimi:

```text
4.5e3
```

---

## 16. Küçük Sayıyı Scientific Notation'a Çevirme

Örneğin:

```text
0.0032
```

Bunu:

```text
3.2
```

haline getirmek için noktayı 3 basamak sağa taşıyoruz.

Bu nedenle exponent negatif olur:

```text
0.0032 = 3.2 × 10⁻³
```

Java:

```text
3.2e-3
```

Başka örnek:

```text
0.00045
```

Noktayı 4 basamak sağa taşı:

```text
4.5
```

Dolayısıyla:

```text
0.00045 = 4.5e-4
```

---

## 17. Scientific Notation Örnekleri

| Normal sayı | Scientific Notation |
|---:|---|
| 1000 | `1e3` |
| 2000 | `2e3` |
| 4500 | `4.5e3` |
| 250 | `2.5e2` |
| 72000 | `7.2e4` |
| 0.1 | `1e-1` |
| 0.01 | `1e-2` |
| 0.001 | `1e-3` |
| 0.005 | `5e-3` |
| 0.0025 | `2.5e-3` |

---

# 18. Scientific Notation da Floating-Point Literal'dır

Çok önemli:

```text
5e3
```

içinde nokta olmamasına rağmen Java'da floating-point literal'dır.

Ve varsayılan olarak:

```text
double
```

türündedir.

Yani:

```java
double number = 5e3;
```

doğrudur.

Değeri:

```text
5000
```

olur.

Ama:

```java
float number = 5e3;
```

hata verir.

Çünkü:

```text
5e3 → double
```

Float yapmak için:

```java
float number = 5e3F;
```

yazmalıyız.

---

## 19. Scientific Notation + `F` / `D`

Aynı suffix kuralları scientific notation için de geçerlidir.

```text
5e3    → double
5E3    → double

5e3F   → float
5e3f   → float

5e3D   → double
5e3d   → double
```

Örneğin:

```java
double a = 2.5e3;
float b = 2.5e3F;
double c = 2.5e3D;
```

hepsi geçerlidir.

---

# 20. Doğru ve Yanlış Atamalar

### Örnek 1

```java
double a = 3.14;
```

**Doğru.**

Çünkü:

```text
3.14 → double
a    → double
```

---

### Örnek 2

```java
float a = 3.14;
```

**Yanlış.**

Çünkü `3.14` varsayılan olarak `double`'dır.

Doğrusu:

```java
float a = 3.14F;
```

---

### Örnek 3

```java
double a = 5e3;
```

**Doğru.**

Çünkü:

```text
5e3 → double
```

---

### Örnek 4

```java
float a = 5e3F;
```

**Doğru.**

Çünkü `F` literal'ın `float` olduğunu belirtir.

---

### Örnek 5

```java
float a = 5e3;
```

**Yanlış.**

Çünkü:

```text
5e3 → double
```

---

# 21. `float` → `double`

Bir `float` değerini `double` değişkenine aktarabiliriz.

```java
float small = 3.14F;
double big = small;
```

Bu doğrudur.

Çünkü `double`, `float`'tan daha geniş ve daha hassas bir veri tipidir.

Basit şekilde:

```text
float → double
```

otomatik yapılabilir.

---

## 22. `double` → `float`

Tersi otomatik yapılmaz.

```java
double big = 3.14;
float small = big;
```

Bu hata verir.

Çünkü `double` daha yüksek hassasiyete sahiptir ve `float`'a aktarılırken bilgi kaybı olabilir.

Açıkça dönüştürmek istersek casting kullanabiliriz:

```java
double big = 3.14;
float small = (float) big;
```

Ancak şu aşamada sınav için temel olarak şunu hatırlamak yeterlidir:

```text
float → double  → otomatik olabilir

double → float  → otomatik olmaz
```

---

# 23. JDK 27 ile Java Örneği

JDK 27'de kullandığımız basit program biçimiyle:

```java
void main() {

    double pi = 3.14;
    float temperature = 24.5F;

    double large = 2.5e3;
    double small = 2.5e-3;

    IO.println(pi);
    IO.println(temperature);
    IO.println(large);
    IO.println(small);
}
```

Çıktı:

```text
3.14
24.5
2500.0
0.0025
```

Burada:

```java
double large = 2.5e3;
```

şu anlama gelir:

```text
2.5 × 10³ = 2500
```

ve:

```java
double small = 2.5e-3;
```

şu anlama gelir:

```text
2.5 × 10⁻³ = 0.0025
```

---

# 24. Java Çıktıda Scientific Notation Kullanabilir

Çok büyük veya çok küçük değerlerde Java çıktıyı scientific notation şeklinde gösterebilir.

Örneğin:

```java
void main() {

    double large = 6.02e23;
    double small = 1.6e-19;

    IO.println(large);
    IO.println(small);
}
```

Çıktıda şöyle bir şey görebilirsin:

```text
6.02E23
1.6E-19
```

Buradaki büyük:

```text
E
```

seni şaşırtmasın.

```text
6.02E23
```

ile:

```text
6.02e23
```

aynı değeri ifade eder.

---

# 25. Ek Bilgi — Tam Sayı Bölmesi

Floating-point konularında sık yapılan hatalardan biri:

```java
double result = 5 / 2;
```

yazıp sonucu `2.5` beklemektir.

Ama:

```text
5 → int
2 → int
```

olduğu için önce tam sayı bölmesi yapılır:

```text
5 / 2 = 2
```

Sonra bu değer `double` olur:

```text
2 → 2.0
```

Dolayısıyla:

```java
double result = 5 / 2;
```

sonucu:

```text
2.0
```

olur.

Ondalıklı sonuç istiyorsak:

```java
double result = 5.0 / 2;
```

veya:

```java
double result = 5 / 2.0;
```

kullanabiliriz.

Sonuç:

```text
2.5
```

---

# 26. Ek Bilgi — Floating-Point Hassasiyeti

Bilgisayar bazı ondalıklı sayıları binary sistemde tam olarak temsil edemez.

Örneğin:

```java
void main() {

    double result = 0.1 + 0.2;

    IO.println(result);
}
```

çıktıda:

```text
0.30000000000000004
```

gibi bir değer görülebilir.

Bu Java'nın bozuk hesap yaptığı anlamına gelmez.

Sebebi bazı ondalıklı sayıların binary floating-point sisteminde tam olarak temsil edilememesidir.

Bu konunun ayrıntısını şu aşamada bilmek zorunda değilsin.

Sınav için:

> `float` ve `double` değerleri her zaman matematiksel olarak tamamen kusursuz ondalık temsil sağlamayabilir.

bilgisi yeterlidir.

---

# 27. Yaygın Hatalar

### 1. `float` için `F` yazmayı unutmak

Yanlış:

```java
float number = 3.14;
```

Doğru:

```java
float number = 3.14F;
```

---

### 2. `e` harfini normal bir değişken sanmak

```text
2.5e3
```

şu demektir:

```text
2.5 × 10³
```

---

### 3. Negatif exponent'i negatif sayı sanmak

```text
2e-3
```

negatif sayı değildir.

```text
2e-3
= 2 × 10⁻³
= 0.002
```

Pozitif bir sayıdır.

---

### 4. Exponent yönünü karıştırmak

```text
e3  → sağa

e-3 → sola
```

---

### 5. `3e4` ifadesini `3 × 4` sanmak

Yanlış:

```text
3e4 = 12
```

Doğru:

```text
3e4
= 3 × 10⁴
= 30000
```

---

### 6. Java'da virgül kullanmak

Yanlış:

```java
double x = 3,14;
```

Doğru:

```java
double x = 3.14;
```

Java'da ondalık ayırıcı olarak nokta kullanılır.

---

### 7. `5 / 2` sonucunu `2.5` sanmak

```java
5 / 2
```

iki `int` arasında işlem olduğu için:

```text
2
```

sonucunu verir.

---

# 28. Çözümlü Örnekler

## Örnek 1

Türünü bul:

```text
7.25
```

Suffix yok.

Ondalıklı literal varsayılan olarak `double`:

```text
Cevap: double
```

---

## Örnek 2

Türünü bul:

```text
7.25F
```

Sonunda `F` var:

```text
Cevap: float
```

---

## Örnek 3

Normal sayıya çevir:

```text
6.4e3
```

```text
6.4 × 10³
```

Noktayı 3 basamak sağa:

```text
6.4 → 64 → 640 → 6400
```

Sonuç:

```text
6400
```

---

## Örnek 4

Normal sayıya çevir:

```text
9.2e-3
```

Noktayı 3 basamak sola:

```text
9.2
0.92
0.092
0.0092
```

Sonuç:

```text
0.0092
```

---

## Örnek 5

Scientific notation'a çevir:

```text
45000
```

Noktayı 4 basamak sola taşı:

```text
4.5
```

Sonuç:

```text
4.5e4
```

---

## Örnek 6

Scientific notation'a çevir:

```text
0.00072
```

Noktayı `7.2` elde edene kadar sağa taşı:

```text
0.00072 → 7.2
```

4 basamak hareket etti.

Küçük sayı olduğu için exponent negatif:

```text
7.2e-4
```

---

## Örnek 7

Kod doğru mu?

```java
float number = 2.5e3;
```

Hayır.

Çünkü:

```text
2.5e3 → double
```

Doğrusu:

```java
float number = 2.5e3F;
```

---

## Örnek 8

Çıktıyı bul:

```java
void main() {

    double a = 4e2;
    double b = 2.5e-2;

    IO.println(a);
    IO.println(b);
}
```

Hesap:

```text
4e2 = 400

2.5e-2 = 0.025
```

Çıktı:

```text
400.0
0.025
```

---

# 29. Sınav Pratikleri

## A — Literal Türünü Bul

1. `3.14`
2. `3.14F`
3. `8.5f`
4. `10.0`
5. `10.0D`
6. `0.25F`
7. `5e3`
8. `5e3F`

---

## B — Normal Sayıya Çevir

9. `2e3`
10. `5e2`
11. `1.5e3`
12. `7.2e4`
13. `1e-1`
14. `1e-2`
15. `4e-2`
16. `2.5e-3`
17. `3.2e-4`

---

## C — Scientific Notation'a Çevir

18. `3000`
19. `4500`
20. `250`
21. `72000`
22. `0.1`
23. `0.01`
24. `0.005`
25. `0.0025`

---

## D — Kod Derlenir mi?

26.

```java
double a = 3.14;
```

27.

```java
float b = 3.14;
```

28.

```java
float c = 3.14F;
```

29.

```java
double d = 5e3;
```

30.

```java
float e = 5e3F;
```

31.

```java
float f = 5e3;
```

---

## E — Çıktıyı Bul

32.

```java
void main() {
    double x = 2e3;
    IO.println(x);
}
```

33.

```java
void main() {
    double x = 4.5e2;
    IO.println(x);
}
```

34.

```java
void main() {
    double x = 3e-2;
    IO.println(x);
}
```

35.

```java
void main() {
    double x = 5 / 2;
    IO.println(x);
}
```

36.

```java
void main() {
    double x = 5.0 / 2;
    IO.println(x);
}
```

---

# 30. Cevap Anahtarı

## A — Literal Türleri

```text
1. double
2. float
3. float
4. double
5. double
6. float
7. double
8. float
```

---

## B — Normal Sayılar

```text
9.  2000
10. 500
11. 1500
12. 72000
13. 0.1
14. 0.01
15. 0.04
16. 0.0025
17. 0.00032
```

---

## C — Scientific Notation

```text
18. 3e3
19. 4.5e3
20. 2.5e2
21. 7.2e4
22. 1e-1
23. 1e-2
24. 5e-3
25. 2.5e-3
```

---

## D — Derlenir mi?

```text
26. Doğru
27. Yanlış
28. Doğru
29. Doğru
30. Doğru
31. Yanlış
```

27'nin doğrusu:

```java
float b = 3.14F;
```

31'in doğrusu:

```java
float f = 5e3F;
```

---

## E — Çıktılar

32.

```text
2000.0
```

33.

```text
450.0
```

34.

```text
0.03
```

35.

```text
2.0
```

36.

```text
2.5
```

---

# 31. Son Dakika Kontrol Listesi

Sınavdan önce bunları biliyor ol:

- [ ] Floating-point literal'ın ne olduğunu biliyorum.
- [ ] `float` ve `double` arasındaki temel farkı biliyorum.
- [ ] Ondalıklı literal'ın varsayılan olarak `double` olduğunu biliyorum.
- [ ] `F/f` suffix'inin `float` anlamına geldiğini biliyorum.
- [ ] `D/d` suffix'inin `double` anlamına geldiğini biliyorum.
- [ ] `e` ve `E` ile scientific notation yazabiliyorum.
- [ ] Pozitif exponent'te noktayı sağa taşıyorum.
- [ ] Negatif exponent'te noktayı sola taşıyorum.
- [ ] Normal sayıyı scientific notation'a çevirebiliyorum.
- [ ] Scientific notation'ı normal sayıya çevirebiliyorum.
- [ ] `5e3` ifadesinin `double` olduğunu biliyorum.
- [ ] `5e3F` ifadesinin `float` olduğunu biliyorum.
- [ ] `float → double` dönüşümünün otomatik olabileceğini biliyorum.
- [ ] `double → float` dönüşümünün otomatik olmadığını biliyorum.
- [ ] `5 / 2` ile `5.0 / 2` arasındaki farkı biliyorum.

---

# 32. Tek Bakışta Özet

```text
FLOATING-POINT LITERAL

3.14       → double
3.14D      → double
3.14F      → float


SCIENTIFIC NOTATION

2e3
= 2 × 10³
= 2000

2.5e-3
= 2.5 × 10⁻³
= 0.0025


EXPONENT

Pozitif exponent → nokta SAĞA

Negatif exponent → nokta SOLA


TÜRLER

5e3        → double

5e3F       → float


ATAMA

double x = 3.14;     → DOĞRU

float x = 3.14;      → YANLIŞ

float x = 3.14F;     → DOĞRU


DÖNÜŞÜM

float → double       → otomatik olabilir

double → float       → otomatik olmaz


BÖLME

5 / 2       → 2

5.0 / 2     → 2.5
```

> **Sınav taktiği:** Bir floating-point sorusu gördüğünde önce `F/f/D/d` suffix'ine bak ve türü belirle. Scientific notation varsa `e`den sonraki exponent'in işaretine bak. Pozitifse noktayı sağa, negatifse sola taşı. Son olarak değişkenin türüyle literal'ın uyumlu olup olmadığını kontrol et.