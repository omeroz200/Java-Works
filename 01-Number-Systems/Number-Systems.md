/*
==================================================
1. NUMBER SYSTEMS (SAYI SİSTEMLERİ)
   ==================================================

Sayılar farklı tabanlarda gösterilebilir.

Decimal     (Base 10) -> 0,1,2,3,4,5,6,7,8,9
Binary      (Base 2)  -> 0,1
Octal       (Base 8)  -> 0,1,2,3,4,5,6,7
Hexadecimal (Base 16) -> 0-9, A,B,C,D,E,F


1.1 BASE (TABAN) NEDİR?
--------------------------------------------------
Bir sayının hangi sayı sistemine ait olduğunu
belirtmek için sağ altına küçük bir sayı yazılır.

Bu küçük sayıya BASE (TABAN) denir.

ÖRNEKLER:

167₁₀      -> Decimal (Base 10)
10100111₂  -> Binary (Base 2)
247₈       -> Octal (Base 8)
A7₁₆       -> Hexadecimal (Base 16)

Buradaki:

₁₀ -> Sayı 10'luk sistemde yazılmıştır.
₂  -> Sayı 2'lik sistemde yazılmıştır.
₈  -> Sayı 8'lik sistemde yazılmıştır.
₁₆ -> Sayı 16'lık sistemde yazılmıştır.

ÖNEMLİ:
Alttaki küçük sayı, sayının bir parçası değildir.
Sayının hangi tabanda yazıldığını gösterir.

Örneğin:
167₁₀ ifadesindeki ₁₀, 167 ile çarpılmaz.
Sadece sayının decimal olduğunu belirtir.


1.2 NEDEN TABAN YAZIYORUZ?
--------------------------------------------------
Çünkü aynı rakamlar farklı tabanlarda
farklı değerler ifade edebilir.

ÖRNEK:

10₂  = 2₁₀
10₈  = 8₁₀
10₁₀ = 10₁₀
10₁₆ = 16₁₀

Gördüğün gibi hepsinde "10" yazıyor.
Ama tabanları farklı olduğu için
temsil ettikleri değerler de farklıdır.

Bu yüzden sayıların tabanını belirtmek önemlidir.


1.3 TABAN VE BASAMAK DEĞERİ
--------------------------------------------------
Her sayı sisteminde basamak değerleri
o sistemin tabanının kuvvetleriyle hesaplanır.

GENEL FORMÜL:

Basamak değeri = Rakam × Taban^Basamak sırası

Basamak sırası sağdan sola doğru
0, 1, 2, 3 ... şeklinde ilerler.

ÖRNEK 1: 101₂

1 × 2² = 4
0 × 2¹ = 0
1 × 2⁰ = 1

TOPLAM:
4 + 0 + 1 = 5

SONUÇ:
101₂ = 5₁₀


ÖRNEK 2: 25₈

2 × 8¹ = 16
5 × 8⁰ = 5

TOPLAM:
16 + 5 = 21

SONUÇ:
25₈ = 21₁₀


ÖRNEK 3: 1A₁₆

A = 10

1 × 16¹ = 16
A × 16⁰ = 10

TOPLAM:
16 + 10 = 26

SONUÇ:
1A₁₆ = 26₁₀


1.4 HEXADECIMAL HARFLERİ
--------------------------------------------------
Hexadecimal sistemde 16 farklı rakam vardır.

0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F

A = 10
B = 11
C = 12
D = 13
E = 14
F = 15

ÖRNEK:

F₁₆ = 15₁₀
10₁₆ = 16₁₀
FF₁₆ = 255₁₀


1.5 SINAV İÇİN ÖNEMLİ NOTLAR
--------------------------------------------------
1) Sağ alttaki küçük sayı BASE (TABAN) demektir.

2) Taban, sayının hangi sistemde olduğunu gösterir.

3) Taban bir çarpma işlemi değildir.

4) Her tabanda kullanılabilecek rakamlar sınırlıdır.

   Binary      -> 0,1
   Octal       -> 0-7
   Decimal     -> 0-9
   Hexadecimal -> 0-9,A-F

5) Örneğin 128₈ geçersizdir.
   Çünkü octal sistemde 8 rakamı bulunmaz.

6) Taban belirtilmezse günlük matematikte
   sayılar genellikle decimal kabul edilir.

7) Farklı tabanlarda yazılan sayılar
   aynı değeri temsil edebilir.

ÖRNEK:

167₁₀ = 10100111₂ = 247₈ = A7₁₆

==================================================
*/


/*
==================================================
BASE (TABAN) - DETAYLI MANTIK
==================================================

TABAN NEDİR?

Taban, sayı sisteminde kaç farklı rakam
kullanılabileceğini belirler.

Base 2  -> 2 rakam: 0,1
Base 8  -> 8 rakam: 0-7
Base 10 -> 10 rakam: 0-9
Base 16 -> 16 rakam: 0-9,A-F

ÖRNEK:

101₂  = Binary
101₈  = Octal
101₁₀ = Decimal
101₁₆ = Hexadecimal

Bu sayıların yazılışı aynı olsa da
değerleri farklıdır.

101₂  = 5₁₀
101₈  = 65₁₀
101₁₀ = 101₁₀
101₁₆ = 257₁₀


1. HANGİ SAYIYA BÖLERİZ?
--------------------------------------------------
Decimal'den başka tabana geçerken
HEDEF TABANA böleriz.

Decimal -> Binary      : 2'ye böl
Decimal -> Octal       : 8'e böl
Decimal -> Hexadecimal : 16'ya böl

ÖRNEK: 13₁₀ -> ?₂

13 / 2 = 6 kalan 1
6 / 2 = 3 kalan 0
3 / 2 = 1 kalan 1
1 / 2 = 0 kalan 1

Sonuç: 13₁₀ = 1101₂

NEDEN?

Bir tam sayıyı 2'ye böldüğümüzde
kalan yalnızca 0 veya 1 olabilir.

Bu da binary sistemde kullanılabilen
rakamlara karşılık gelir.

8'e bölündüğünde kalan 0-7 olabilir.
16'ya bölündüğünde kalan 0-15 olabilir.

Hexadecimal sistemde:
10=A, 11=B, 12=C, 13=D, 14=E, 15=F


2. TABANIN KUVVETLERİ
--------------------------------------------------
Bir sayıyı decimal'e çevirirken
kaynak tabanın kuvvetlerini kullanırız.

Binary -> Decimal:
2'nin kuvvetleri

Octal -> Decimal:
8'in kuvvetleri

Hexadecimal -> Decimal:
16'nın kuvvetleri

ÖRNEK: 101₂ -> ?₁₀

1 × 2² = 4
0 × 2¹ = 0
1 × 2⁰ = 1

4 + 0 + 1 = 5₁₀


3. OLASILIK / KOMBİNASYON SAYISI
--------------------------------------------------
FORMÜL:

Farklı kombinasyon sayısı =
Taban ^ Basamak sayısı

Binary, 3 bit:
2³ = 8 kombinasyon

000₂
001₂
010₂
011₂
100₂
101₂
110₂
111₂

Binary, 8 bit:
2⁸ = 256 kombinasyon

Octal, 2 basamak:
8² = 64 kombinasyon

Decimal, 3 basamak:
10³ = 1000 kombinasyon

Hexadecimal, 2 basamak:
16² = 256 kombinasyon

NOT:
Baştaki sıfırlar da kombinasyon
sayılır (örneğin 000₂).


4. EN BÜYÜK SAYI NASIL BULUNUR?
--------------------------------------------------
İşaretsiz ve sabit basamaklı sistemlerde:

En büyük değer = Taban^Basamak - 1

ÖRNEK:

8 bit binary:
2⁸ - 1 = 255₁₀

4 bit binary:
2⁴ - 1 = 15₁₀

2 basamak hexadecimal:
16² - 1 = 255₁₀

3 basamak decimal:
10³ - 1 = 999₁₀


5. ÖNEMLİ FARK
--------------------------------------------------
TABAN:
Sayının hangi sistemde olduğunu belirtir.

Örnek: 101₂

ÜS (EXPONENT):
Bir sayının kaçıncı kuvveti olduğunu belirtir.

Örnek: 2³ = 8

Bunlar birbirinden farklıdır.

==================================================
*/



