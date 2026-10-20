# Bitwise Operations — Sınav Odaklı Ders Notu ve Pratik

> Bu dosya yalnızca bit düzeyindeki işlemleri ele alır: `AND`, `OR`, `XOR`, `NOT`, sola/sağa kaydırma ve bit maskeleri. Örnekler Java JDK 27 ile uyumludur.

## 1. Bitwise işlem nedir?

Bitwise işlemler, bir tam sayının binary gösterimindeki bitleri tek tek işler.

Örnek olarak:

```text
12₁₀ = 1100₂
10₁₀ = 1010₂
```

Bu iki sayı üzerinde bitwise işlem yapılırken aynı konumdaki bitler karşılaştırılır:

```text
  1100
  1010
  ----
  sonuç
```

Java operatörleri:

| İşlem | Operatör | Kısa anlamı |
|---|---:|---|
| AND | `&` | İki bit de 1 ise 1 |
| OR | `\|` | Bitlerden en az biri 1 ise 1 |
| XOR | `^` | Bitler farklıysa 1 |
| NOT | `~` | Bütün bitleri ters çevirir |
| Sola kaydırma | `<<` | Bitleri sola kaydırır |
| İşaretli sağa kaydırma | `>>` | İşaret bitini koruyarak sağa kaydırır |

> Bitwise `&` ve `|`, logical `&&` ve `||` ile aynı değildir. Bitwise operatörler bitleri; logical operatörler boolean koşulları işler.

---

## 2. İşlemden önce bitleri hizalama

İki sayı farklı uzunluktaysa kısa olanın soluna sıfır eklenir:

```text
5₁₀  =  101₂ = 0101₂
12₁₀ = 1100₂
```

Doğru hizalama:

```text
  0101
  1100
```

Yanlış hizalama, farklı basamakların karşılaştırılmasına ve tamamen yanlış sonuca yol açar.

### Sekiz bitlik çalışma şablonu

Küçük pozitif sayılarda sekiz bit kullanmak okumayı kolaylaştırır:

```text
12 = 00001100
10 = 00001010
```

Her sütunda işlemi ayrı uygula.

---

## 3. AND (`&`)

AND sonucunun 1 olabilmesi için iki bitin de 1 olması gerekir.

| A | B | A & B |
|---:|---:|---:|
| 0 | 0 | 0 |
| 0 | 1 | 0 |
| 1 | 0 | 0 |
| 1 | 1 | 1 |

### Örnek 1 — `12 & 10`

```text
12 = 1100
10 = 1010

     1100
AND  1010
     ----
     1000 = 8
```

```text
12 & 10 = 8
```

### Örnek 2 — `29 & 23`

```text
29 = 11101
23 = 10111

     11101
AND  10111
     -----
     10101 = 21
```

### AND ne işe yarar?

AND çoğunlukla belirli bitleri **seçmek**, yani maskelemek için kullanılır.

```text
Değer:  10110110
Maske:  00001111
AND:    00000110
```

`00001111` maskesi yalnızca son dört biti korur, diğerlerini sıfırlar.

### Bir bit açık mı?

`n` sayısının `k` numaralı biti kontrol edilir:

```java
boolean isSet = (n & (1 << k)) != 0;
```

Bit numaraları sağdan, sıfırdan başlar:

```text
Bit:    7 6 5 4 3 2 1 0
Değer:  1 0 1 1 0 1 1 0
```

---

## 4. OR (`|`)

Bitlerden en az biri 1 ise sonuç 1 olur.

| A | B | A \| B |
|---:|---:|---:|
| 0 | 0 | 0 |
| 0 | 1 | 1 |
| 1 | 0 | 1 |
| 1 | 1 | 1 |

### Örnek 1 — `12 | 10`

```text
12 = 1100
10 = 1010

     1100
OR   1010
     ----
     1110 = 14
```

### Örnek 2 — `20 | 7`

```text
20 = 10100
 7 = 00111

     10100
OR   00111
     -----
     10111 = 23
```

### OR ne işe yarar?

OR belirli bir biti kesin olarak **1 yapmak**, yani açmak için kullanılır:

```java
n = n | (1 << k);
```

Kısa yazım:

```java
n |= (1 << k);
```

Diğer bitler korunur; yalnızca hedef bit 1 yapılır.

---

## 5. XOR (`^`)

Bitler farklıysa sonuç 1, aynıysa 0 olur.

| A | B | A ^ B |
|---:|---:|---:|
| 0 | 0 | 0 |
| 0 | 1 | 1 |
| 1 | 0 | 1 |
| 1 | 1 | 0 |

### Örnek 1 — `12 ^ 10`

```text
12 = 1100
10 = 1010

     1100
XOR  1010
     ----
     0110 = 6
```

### Örnek 2 — `29 ^ 23`

```text
29 = 11101
23 = 10111

     11101
XOR  10111
     -----
     01010 = 10
```

### XOR'un önemli özellikleri

```text
x ^ 0 = x
x ^ x = 0
x ^ y = y ^ x
(x ^ y) ^ y = x
```

### Bir biti tersine çevirme (toggle)

```java
n ^= (1 << k);
```

- Hedef bit 0 ise 1 olur.
- Hedef bit 1 ise 0 olur.
- Diğer bitler değişmez.

### Tekrar etmeyen sayıyı bulma

Bir dizide her sayı iki kez, yalnızca bir sayı bir kez geçiyorsa XOR kullanılabilir:

```java
int[] numbers = {4, 1, 2, 1, 2};
int result = 0;

for (int number : numbers) {
    result ^= number;
}

System.out.println(result); // 4
```

Çünkü çiftler birbirini sıfırlar: `1^1=0`, `2^2=0`, `0^4=4`.

---

## 6. NOT (`~`)

NOT tüm bitleri tersine çevirir:

| A | ~A |
|---:|---:|
| 0 | 1 |
| 1 | 0 |

Dört bitlik teorik örnek:

```text
5 = 0101
~5 = 1010
```

Fakat Java'da `int` 32 bittir. Bu yüzden `~5`, yalnızca dört bit üzerinden yorumlanmaz:

```text
 5 = 00000000 00000000 00000000 00000101
~5 = 11111111 11111111 11111111 11111010
```

Two's complement yorumunda sonuç `-6`'dır.

### Hızlı formül

```text
~x = -x - 1
```

Örnekler:

```text
~5  = -6
~0  = -1
~-1 = 0
~12 = -13
```

### Yalnızca son 8 biti ters çevirmek

```java
int value = 5;
int inverted8Bit = (~value) & 0xFF;

System.out.println(inverted8Bit); // 250
```

```text
00000101
11111010 = 250
```

`& 0xFF`, 32 bitlik sonucun yalnızca son 8 bitini korur.

---

## 7. Sola kaydırma (`<<`)

Bitler sola taşınır, sağdan sıfır girer.

```text
00101100 << 1
= 01011000
```

Taşma olmadığı sürece:

```text
x << n = x · 2ⁿ
```

### Örnekler

```text
5 << 1
0101 → 1010
= 10
```

```text
5 << 3
00000101 → 00101000
= 40

Kontrol: 5 · 2³ = 5 · 8 = 40
```

```text
13 << 2 = 13 · 4 = 52
```

### Java örneği

```java
int x = 5;

System.out.println(x << 1); // 10
System.out.println(x << 2); // 20
System.out.println(x << 3); // 40
```

### Taşma uyarısı

Sola kaydırma her zaman güvenli çarpma değildir. Sabit bit genişliğinin dışına çıkan bitler kaybolur:

```java
int x = 1 << 30;
System.out.println(x);      // 1073741824
System.out.println(x << 1); // -2147483648
```

Matematiksel sonuç pozitif olsa da 32 bit signed `int` taşma yapar.

---

## 8. İşaretli sağa kaydırma (`>>`)

Bitler sağa taşınır. Soldaki boşluklara işaret biti kopyalanır:

- Pozitif sayıda `0` dolar.
- Negatif sayıda `1` dolar.

Pozitif sayılarda:

```text
x >> n ≈ x / 2ⁿ
```

Tam sayı bölmesi nedeniyle kesir kısmı atılır.

### Pozitif örnek

```text
40 = 00101000

40 >> 1 = 00010100 = 20
40 >> 2 = 00001010 = 10
40 >> 3 = 00000101 = 5
```

### Negatif örnek

8 bit üzerinden düşünelim:

```text
-16 = 11110000

-16 >> 1 = 11111000 = -8
-16 >> 2 = 11111100 = -4
```

Soldan `1` doldurulduğu için işaret korunur.

### Negatif tek sayılarda dikkat

Java'nın `>>` işlemi negatif sayılarda aşağıya, yani negatif sonsuza doğru yuvarlamaya benzer:

```java
System.out.println(-5 >> 1); // -3
System.out.println(-5 / 2);  // -2
```

Dolayısıyla negatif sayılarda `x >> 1` ile `x / 2` her zaman aynı değildir.

---

## 9. Bit maskesi nedir?

Maske, belirli bitleri seçmek veya değiştirmek için kullanılan bit desenidir.

Bir biti hedeflemek için temel maske:

```java
int mask = 1 << k;
```

Örneğin `k=3`:

```text
00000001 << 3 = 00001000
```

Sağdan başlayan bit numarası 3 olan konum seçilmiştir.

### Bit işlemlerinin dört temel görevi

| Görev | İfade |
|---|---|
| Biti kontrol et | `(n & (1 << k)) != 0` |
| Biti aç | `n |= (1 << k)` |
| Biti kapat | `n &= ~(1 << k)` |
| Biti tersle | `n ^= (1 << k)` |

---

## 10. Bir biti kontrol etme

`n=44` olsun:

```text
44 = 00101100
```

Bit 3'ü kontrol edelim:

```text
Maske: 1 << 3 = 00001000

Değer: 00101100
Maske: 00001000
AND:   00001000  → sıfır değil → bit açık
```

Java:

```java
int n = 44;
int k = 3;

boolean isSet = (n & (1 << k)) != 0;
System.out.println(isSet); // true
```

Bit 1 için:

```text
Maske: 00000010
Değer: 00101100
AND:   00000000 → bit kapalı
```

---

## 11. Bir biti açma

`n=40` ve bit 2 kapalı olsun:

```text
Değer: 00101000
Maske: 00000100
OR:    00101100
```

```text
40 → 44
```

Java:

```java
int n = 40;
n |= (1 << 2);
System.out.println(n); // 44
```

Bit zaten açıksa OR sonucu değeri değiştirmez.

---

## 12. Bir biti kapatma

Önce hedef bit için maske oluşturulur, sonra maske ters çevrilir:

```java
n &= ~(1 << k);
```

`n=44`, `k=3`:

```text
n:            00101100
1 << 3:       00001000
~(1 << 3):    11110111

00101100
11110111 AND
--------
00100100 = 36
```

Java:

```java
int n = 44;
n &= ~(1 << 3);
System.out.println(n); // 36
```

Ters maske yalnızca hedef konumda 0, diğer konumlarda 1 taşır. AND böylece yalnızca hedef biti kapatır.

---

## 13. Bir biti tersine çevirme

`n=44`, `k=2`:

```text
Değer: 00101100
Maske: 00000100
XOR:   00101000 = 40
```

Bit 2 açıktı ve kapandı. Aynı işlem tekrar uygulanırsa yeniden açılır:

```text
00101000 ^ 00000100 = 00101100
```

Java:

```java
int n = 44;
n ^= (1 << 2); // 40
n ^= (1 << 2); // tekrar 44
```

---

## 14. Birden fazla biti maskeleme

Son dört biti almak:

```java
int lowFourBits = n & 0b0000_1111;
```

### Örnek

```text
n:      10110110
mask:   00001111
AND:    00000110 = 6
```

Ortadaki dört biti almak için önce kaydırıp sonra maskele:

```java
int middleFour = (n >> 2) & 0b1111;
```

### Belirli bir bit aralığını çıkarma

`start` konumundan itibaren `length` bit almak:

```java
int extracted = (value >> start) & ((1 << length) - 1);
```

Örnek: bit 2'den başlayan üç biti al:

```java
int extracted = (value >> 2) & 0b111;
```

---

## 15. Flag mantığı

Bir tam sayının her biti ayrı bir açık/kapalı özelliği temsil edebilir.

```java
static final int READ    = 1 << 0; // 0001
static final int WRITE   = 1 << 1; // 0010
static final int EXECUTE = 1 << 2; // 0100
static final int DELETE  = 1 << 3; // 1000
```

### Birden fazla izin oluşturma

```java
int permissions = READ | WRITE;
// 0001 | 0010 = 0011
```

### İzin ekleme

```java
permissions |= EXECUTE;
// 0011 | 0100 = 0111
```

### İzin kontrol etme

```java
boolean canWrite = (permissions & WRITE) != 0;
```

### İzin kaldırma

```java
permissions &= ~WRITE;
```

### İzni açıp kapatma

```java
permissions ^= DELETE;
```

### Tam Java örneği

```java
public class PermissionFlags {
    static final int READ    = 1 << 0;
    static final int WRITE   = 1 << 1;
    static final int EXECUTE = 1 << 2;
    static final int DELETE  = 1 << 3;

    public static void main(String[] args) {
        int permissions = READ | WRITE;

        permissions |= EXECUTE;

        System.out.println(hasFlag(permissions, READ));   // true
        System.out.println(hasFlag(permissions, DELETE)); // false

        permissions &= ~WRITE;
        System.out.println(hasFlag(permissions, WRITE));  // false
    }

    static boolean hasFlag(int value, int flag) {
        return (value & flag) != 0;
    }
}
```

---

## 16. Tek ve çift sayı kontrolü

Binary'de en sağdaki bit:

- `0` ise sayı çifttir.
- `1` ise sayı tektir.

```java
boolean isEven = (n & 1) == 0;
boolean isOdd  = (n & 1) != 0;
```

Örnek:

```text
14 = 1110 → son bit 0 → çift
15 = 1111 → son bit 1 → tek
```

Negatif sayılarda da çalışır:

```java
System.out.println((-5 & 1) != 0); // true
```

---

## 17. İkinin kuvveti kontrolü

Pozitif bir ikinin kuvvetinin binary gösteriminde yalnızca bir tane `1` vardır:

```text
1  = 0001
2  = 0010
4  = 0100
8  = 1000
16 = 10000
```

`n-1`, bu tek `1` bitini sıfırlar ve sağındaki bitleri 1 yapar:

```text
n     = 1000
n - 1 = 0111
AND   = 0000
```

Java:

```java
static boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
}
```

`n > 0` kontrolü gereklidir; aksi hâlde `0` yanlışlıkla ikinin kuvveti sayılabilir.

---

## 18. En sağdaki 1 bitini temizleme

```java
n & (n - 1)
```

Örnek:

```text
n:       10110000
n - 1:   10101111
AND:     10100000
```

En sağdaki `1` silindi.

Bu özellik bir sayıda kaç tane 1 biti olduğunu saymakta kullanılabilir.

```java
static int countSetBits(int n) {
    int count = 0;

    while (n != 0) {
        n &= (n - 1);
        count++;
    }

    return count;
}
```

Java'nın hazır yöntemi:

```java
int count = Integer.bitCount(n);
```

---

## 19. En sağdaki 1 bitini seçme

```java
n & -n
```

Örnek:

```text
n = 40 = 00101000
n & -n = 00001000 = 8
```

Sonuç, en sağdaki açık bitin sayısal ağırlığıdır. `40` için en sağdaki 1 biti `2³=8` konumundadır.

Bu ifade two's complement özelliğinden yararlanır.

---

## 20. `byte`, `short` ve `char` ile bitwise işlemler

Java'da `byte`, `short` ve `char` üzerinde bitwise işlem yapıldığında operandlar genellikle `int`'e yükseltilir.

```java
byte a = 5;
byte b = 3;

// byte result = a & b; // derleme hatası: sonuç int
byte result = (byte) (a & b);
```

### Unsigned byte görünümü

```java
byte b = (byte) 0b1010_0111;

System.out.println(b);                   // -89
System.out.println(Byte.toUnsignedInt(b)); // 167
```

Son 8 biti güvenli biçimde almak:

```java
int unsigned = b & 0xFF;
```

`0xFF`, binary olarak `11111111` maskesidir.

---

## 21. Java'da kaydırma miktarı

Java, `int` kaydırma miktarının yalnızca son 5 bitini kullanır. Bu nedenle miktar `0–31` aralığına indirgenir:

```java
1 << 32
```

Bu ifade `1 << 0` ile aynıdır ve sonuç `1` olur.

`long` için yalnızca son 6 bit kullanılır; miktar `0–63` aralığına indirgenir:

```java
1L << 64 // 1L << 0 ile aynı
```

Bu davranış sınavlarda şaşırtma sorusu olarak kullanılabilir.

---

## 22. Operatör önceliği ve parantez

Bitwise ifadelerde parantez kullanmak hem hata riskini hem de okuma zorluğunu azaltır.

Tercih et:

```java
boolean isSet = (value & mask) != 0;
int result = (a << 4) | b;
int cleared = value & ~(1 << k);
```

Şundan kaçın:

```java
// Okuması ve önceliği takip etmesi zor:
int result = a << 4 | b;
```

### Bitwise ve logical operatörleri karıştırma

```java
boolean x = true;
boolean y = false;

System.out.println(x && y); // false, kısa devreli logical AND
System.out.println(x & y);  // false, iki taraf da değerlendirilir
```

Tam sayılarda `&&` ve `||` kullanılamaz:

```java
int a = 5;
int b = 3;

int c = a & b;  // doğru
// int d = a && b; // hatalı
```

---

## 23. Bir değeri iki parçaya ayırma

Bir 8 bit değerin üst ve alt dört bitini ayırmak:

```java
int value = 0b1011_0110;

int highNibble = (value >> 4) & 0x0F;
int lowNibble  = value & 0x0F;

System.out.println(highNibble); // 11
System.out.println(lowNibble);  // 6
```

```text
value:       1011 0110
high nibble: 1011 = 11 = B₁₆
low nibble:  0110 =  6
```

İki 4 bit değeri birleştirmek:

```java
int combined = (highNibble << 4) | lowNibble;
```

---

## 24. RGB renk örneği

Bir renk 24 bit içinde `RRGGBB` biçiminde tutulabilir:

```text
0x4A7FC2
  RR GG BB
```

Kanalları çıkarma:

```java
int color = 0x4A7FC2;

int red   = (color >> 16) & 0xFF;
int green = (color >> 8)  & 0xFF;
int blue  = color & 0xFF;

System.out.println(red);   // 74
System.out.println(green); // 127
System.out.println(blue);  // 194
```

Kanalları birleştirme:

```java
int color = (red << 16) | (green << 8) | blue;
```

Her kanal `0–255` aralığında değilse önce `& 0xFF` ile sınırlandırılabilir.

---

## 25. İşlemleri karşılaştıran tam örnek

`a=12`, `b=10`:

```text
a = 1100
b = 1010

a & b = 1000 = 8
a | b = 1110 = 14
a ^ b = 0110 = 6
~a    = -13       (Java int)
a << 1 = 11000 = 24
a >> 1 = 0110  = 6
```

Java:

```java
public class BitwiseSummary {
    public static void main(String[] args) {
        int a = 12;
        int b = 10;

        System.out.println(a & b);  // 8
        System.out.println(a | b);  // 14
        System.out.println(a ^ b);  // 6
        System.out.println(~a);     // -13
        System.out.println(a << 1); // 24
        System.out.println(a >> 1); // 6
    }
}
```

---

## 26. Binary çıktıyı sabit genişlikte gösterme

Java'nın `Integer.toBinaryString` metodu baştaki sıfırları göstermez. Sekiz bitlik çıktı için yardımcı metot:

```java
static String to8BitBinary(int value) {
    return String.format("%8s",
            Integer.toBinaryString(value & 0xFF))
            .replace(' ', '0');
}
```

Kullanım:

```java
System.out.println(to8BitBinary(12));  // 00001100
System.out.println(to8BitBinary(-89)); // 10100111
```

32 bitlik çıktı:

```java
static String to32BitBinary(int value) {
    return String.format("%32s",
            Integer.toBinaryString(value))
            .replace(' ', '0');
}
```

---

## 27. Yaygın hatalar

### 1. Bitleri sağdan hizalamamak

Basamak ağırlıkları sağdan hizalanmalıdır.

### 2. `&` ile `&&` operatörünü karıştırmak

`&` bitwise AND, `&&` boolean ve kısa devreli logical AND'dir.

### 3. `|` ile `||` operatörünü karıştırmak

`|` bitwise OR, `||` logical OR'dur.

### 4. `~5` sonucunu dört bit üzerinden 10 sanmak

Java `int` 32 bittir; `~5=-6` olur. Yalnızca son 4 bit istenirse ayrıca maske gerekir.

### 5. Negatif sayıda sağa kaydırmayı pozitif sayı gibi düşünmek

`>>`, negatif sayılarda soldaki boşluklara `1` doldurarak işareti korur. Sonucu hesaplarken sabit bit genişliği ve two's complement gösterimi dikkate alınmalıdır.

### 6. Bit numarasını soldan başlatmak

Bit numarası sağdan ve sıfırdan başlar.

### 7. Biti kapatmak için yalnızca NOT kullanmak

Doğru işlem `n &= ~(1 << k)` biçimindedir.

### 8. `byte` işleminin `byte` döndüreceğini sanmak

Java küçük tam sayı türlerini işlem sırasında `int`'e yükseltir.

### 9. Sola kaydırmayı her zaman güvenli çarpma sanmak

Taşma hâlinde yüksek bitler kaybolur ve işaret değişebilir.

### 10. Negatif sayıda `>> 1` ile `/ 2` sonucunu aynı sanmak

Negatif tek sayılarda yuvarlama yönleri farklı olabilir.

---

## 28. Sınavda çözüm şablonu

1. Sayıları aynı bit genişliğinde binary yaz.
2. Sağdan hizala.
3. Her sütunda truth table kuralını uygula.
4. Kaydırmada soldan giren biti kontrol et.
5. Sonucun signed mı unsigned mı yorumlanacağını belirle.
6. Sonucu decimal'a çevirerek kontrol et.

Örnek şablon:

```text
İşlem: 25 ^ 14

25 = 11001
14 = 01110

     11001
XOR  01110
     -----
     10111

10111₂ = 23₁₀
```

---

## 29. Çözümlü sınav örnekleri

### Örnek 1 — `25 & 14`

```text
25 = 11001
14 = 01110

     11001
AND  01110
     -----
     01000 = 8
```

### Örnek 2 — `25 | 14`

```text
     11001
OR   01110
     -----
     11111 = 31
```

### Örnek 3 — `25 ^ 14`

```text
     11001
XOR  01110
     -----
     10111 = 23
```

### Örnek 4 — `18 << 2`

```text
18 = 00010010

18 << 2 = 01001000 = 72
Kontrol: 18 · 2² = 72
```

### Örnek 5 — `73 >> 3`

```text
73 = 01001001

73 >> 3 = 00001001 = 9
Kontrol: 73 / 8 = 9, kalan 1
```

### Örnek 6 — Bit 5'i aç

```text
n = 9 = 00001001
mask = 1 << 5 = 00100000

00001001
00100000 OR
--------
00101001 = 41
```

### Örnek 7 — Bit 3'ü kapat

```text
n = 45 = 00101101
mask = ~(1 << 3) = 11110111

00101101
11110111 AND
--------
00100101 = 37
```

---

## 30. Alıştırmalar

### A — Temel operatörler

1. `13 & 9`
2. `13 | 9`
3. `13 ^ 9`
4. `~13` Java `int` olarak kaçtır?
5. `42 & 15`
6. `42 | 15`
7. `42 ^ 15`

### B — Kaydırma

8. `7 << 1`
9. `7 << 4`
10. `96 >> 3`
11. `-32 >> 2`
12. `-48 >> 3`
13. `1 << 8`

### C — Maskeler

14. `n=36` için bit 2 açık mı?
15. `n=36` için bit 3 açık mı?
16. `n=36` değerinde bit 1'i aç.
17. `n=45` değerinde bit 2'yi kapat.
18. `n=40` değerinde bit 3'ü toggle et.
19. `0b11010110` değerinin son dört bitini çıkar.

### D — Kavramlar

20. `x ^ x` neden sıfırdır?
21. `x & 0` sonucu nedir?
22. `x | 0` sonucu nedir?
23. `n & 1` neyi kontrol eder?
24. `(n & (n-1)) == 0` ifadesi hangi ek koşulla ikinin kuvvetini kontrol eder?
25. Negatif bir sayıda `>>` kullanıldığında soldaki boşluklara hangi bit dolar?

### E — Java

26. `(byte) 0b1111_0000` signed decimal olarak kaçtır?
27. Aynı byte `Byte.toUnsignedInt` ile kaç görünür?
28. `byte a=5, b=3; byte c=a&b;` neden derlenmez?
29. `1 << 32` Java'da kaçtır?
30. `Integer.bitCount(0b10110100)` kaç döndürür?

---

## 31. Cevap anahtarı

1. `9`
2. `13`
3. `4`
4. `-14`; çünkü `~x=-x-1`
5. `10`
6. `47`
7. `37`
8. `14`
9. `112`
10. `12`
11. `-8`
12. `-6`
13. `256`
14. Evet; `36=00100100₂`, bit 2 açıktır.
15. Hayır; bit 3 kapalıdır.
16. `38`; `00100100 | 00000010 = 00100110`
17. `41`; `00101101 & 11111011 = 00101001`
18. `32`; `00101000 ^ 00001000 = 00100000`
19. `6`; `11010110 & 00001111 = 00000110`
20. Aynı bitler XOR'da her konumda 0 üretir.
21. `0`
22. `x`
23. Sayının tek mi çift mi olduğunu.
24. `n > 0`
25. İşaret biti olan `1` dolar; böylece sonuç negatif kalır.
26. `-16`
27. `240`
28. `byte` operandlar işlemde `int`'e yükseltilir; açık cast gerekir.
29. `1`; `int` kaydırma miktarında yalnızca son 5 bit kullanılır ve `32 & 31 = 0` olur.
30. `4`

---

## 32. Son dakika özeti

```text
AND  &: iki bit de 1 → 1
OR   |: en az biri 1 → 1
XOR  ^: bitler farklı → 1
NOT  ~: bitleri tersle; ~x = -x-1
<<     : sola kaydır; taşma yoksa ×2ⁿ
>>     : işaretli sağa kaydır
```

```java
// k bitini kontrol et
(n & (1 << k)) != 0

// k bitini aç
n |= (1 << k);

// k bitini kapat
n &= ~(1 << k);

// k bitini tersle
n ^= (1 << k);

// tek/çift
(n & 1) != 0

// pozitif ikinin kuvveti
n > 0 && (n & (n - 1)) == 0
```
