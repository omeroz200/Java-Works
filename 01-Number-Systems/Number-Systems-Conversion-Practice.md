# Number Systems — Conversion Practice

> Bu dosyanın amacı konuyu baştan anlatmak değil, dönüşümleri bol örnekle sağlamlaştırmaktır. Her soruda tabanı mutlaka yaz ve sonucu ters işlemle kontrol et.

## 1. Dönüşüm rotasını seç

| Kaynak → Hedef | En hızlı yol |
|---|---|
| Binary → Decimal | 2'nin kuvvetleriyle açılım |
| Octal → Decimal | 8'in kuvvetleriyle açılım |
| Hex → Decimal | 16'nın kuvvetleriyle açılım |
| Decimal → Binary | Art arda 2'ye bölme |
| Decimal → Octal | Art arda 8'e bölme |
| Decimal → Hex | Art arda 16'ya bölme |
| Binary ↔ Octal | 3 bitlik gruplar |
| Binary ↔ Hex | 4 bitlik gruplar |
| Octal ↔ Hex | Binary üzerinden geç |

### Sınavda beş saniyelik karar

1. Hedef decimal mı? **Kuvvetlerle aç.**
2. Kaynak decimal mı? **Hedef tabana böl.**
3. Binary ile octal arasında mı? **3'lü grupla.**
4. Binary ile hex arasında mı? **4'lü grupla.**
5. Octal ile hex arasında mı? **Binary köprüsü kur.**

---

## 2. Binary → Decimal

### Taktik

Sağdan sola kuvvetleri `2⁰, 2¹, 2², ...` yaz. Yalnızca biti `1` olan kuvvetleri topla.

### Örnek 1 — `1011₂`

```text
1011₂
= 1·2³ + 0·2² + 1·2¹ + 1·2⁰
= 8 + 0 + 2 + 1
= 11₁₀
```

### Örnek 2 — `110010₂`

```text
110010₂
= 1·2⁵ + 1·2⁴ + 0·2³ + 0·2² + 1·2¹ + 0·2⁰
= 32 + 16 + 2
= 50₁₀
```

### Örnek 3 — `10110101₂`

```text
10110101₂
= 2⁷ + 2⁵ + 2⁴ + 2² + 2⁰
= 128 + 32 + 16 + 4 + 1
= 181₁₀
```

### Küçük taktik: ağırlıkları üstüne yaz

```text
Ağırlık: 128 64 32 16 8 4 2 1
Bit:       1  0  1  1 0 1 0 1
Toplam:  128 + 32 + 16 + 4 + 1 = 181
```

### Hızlı kontrol

Sekiz bitlik unsigned sonuç `0–255` arasında olmalıdır. En soldaki bit `1` ise unsigned değer en az `128`'dir.

---

## 3. Decimal → Binary

### Yöntem A — Art arda 2'ye bölme

Her adımın kalanını yaz; kalanları aşağıdan yukarı oku.

### Örnek 1 — `25₁₀`

```text
25 ÷ 2 = 12 kalan 1
12 ÷ 2 =  6 kalan 0
 6 ÷ 2 =  3 kalan 0
 3 ÷ 2 =  1 kalan 1
 1 ÷ 2 =  0 kalan 1
```

```text
25₁₀ = 11001₂
```

Kontrol: `16 + 8 + 1 = 25`.

### Örnek 2 — `74₁₀`

```text
74 ÷ 2 = 37 kalan 0
37 ÷ 2 = 18 kalan 1
18 ÷ 2 =  9 kalan 0
 9 ÷ 2 =  4 kalan 1
 4 ÷ 2 =  2 kalan 0
 2 ÷ 2 =  1 kalan 0
 1 ÷ 2 =  0 kalan 1
```

```text
74₁₀ = 1001010₂
```

### Örnek 3 — `200₁₀`

```text
200 ÷ 2 = 100 kalan 0
100 ÷ 2 =  50 kalan 0
 50 ÷ 2 =  25 kalan 0
 25 ÷ 2 =  12 kalan 1
 12 ÷ 2 =   6 kalan 0
  6 ÷ 2 =   3 kalan 0
  3 ÷ 2 =   1 kalan 1
  1 ÷ 2 =   0 kalan 1
```

```text
200₁₀ = 11001000₂
```

### Yöntem B — İkinin kuvvetlerini seçme

`74`'ten küçük en büyük ikinin kuvveti `64`'tür.

```text
74 - 64 = 10
10 - 8  = 2
2 - 2   = 0

64 + 8 + 2 = 74
2⁶ + 2³ + 2¹
= 1001010₂
```

Bu yöntem zihinden çözmede hızlıdır; bölme yöntemi ise daha mekanik ve güvenlidir.

---

## 4. Octal → Decimal

### Taktik

Sağdan sola `8⁰, 8¹, 8², ...` kullan.

### Örnek 1 — `157₈`

```text
157₈
= 1·8² + 5·8¹ + 7·8⁰
= 64 + 40 + 7
= 111₁₀
```

### Örnek 2 — `643₈`

```text
643₈
= 6·8² + 4·8¹ + 3·8⁰
= 384 + 32 + 3
= 419₁₀
```

### Geçerlilik kontrolü

Octal sayıda yalnızca `0–7` kullanılabilir. `128₈` ve `908₈` geçersizdir.

---

## 5. Decimal → Octal

### Örnek 1 — `83₁₀`

```text
83 ÷ 8 = 10 kalan 3
10 ÷ 8 =  1 kalan 2
 1 ÷ 8 =  0 kalan 1
```

```text
83₁₀ = 123₈
```

Kontrol: `1·64 + 2·8 + 3 = 83`.

### Örnek 2 — `500₁₀`

```text
500 ÷ 8 = 62 kalan 4
 62 ÷ 8 =  7 kalan 6
  7 ÷ 8 =  0 kalan 7
```

```text
500₁₀ = 764₈
```

---

## 6. Hexadecimal → Decimal

### Taktik

Önce harfleri sayıya çevir: `A=10`, `B=11`, `C=12`, `D=13`, `E=14`, `F=15`.

### Örnek 1 — `3A₁₆`

```text
3A₁₆
= 3·16¹ + 10·16⁰
= 48 + 10
= 58₁₀
```

### Örnek 2 — `2F7₁₆`

```text
2F7₁₆
= 2·16² + 15·16¹ + 7·16⁰
= 512 + 240 + 7
= 759₁₀
```

### Örnek 3 — `B04₁₆`

```text
B04₁₆
= 11·16² + 0·16¹ + 4·16⁰
= 2816 + 0 + 4
= 2820₁₀
```

Ortadaki sıfırın basamağı kaydırmadığına dikkat et.

---

## 7. Decimal → Hexadecimal

### Örnek 1 — `94₁₀`

```text
94 ÷ 16 = 5 kalan 14 = E
 5 ÷ 16 = 0 kalan 5
```

```text
94₁₀ = 5E₁₆
```

### Örnek 2 — `1000₁₀`

```text
1000 ÷ 16 = 62 kalan 8
  62 ÷ 16 =  3 kalan 14 = E
   3 ÷ 16 =  0 kalan 3
```

```text
1000₁₀ = 3E8₁₆
```

Kontrol:

```text
3·256 + 14·16 + 8 = 768 + 224 + 8 = 1000
```

### Örnek 3 — `4095₁₀`

```text
4095 ÷ 16 = 255 kalan 15 = F
 255 ÷ 16 =  15 kalan 15 = F
  15 ÷ 16 =   0 kalan 15 = F
```

```text
4095₁₀ = FFF₁₆
```

Küçük taktik: `16³ = 4096` olduğu için `4095 = 16³ - 1`, yani üç basamaklı en büyük hex değer `FFF`'tir.

---

## 8. Binary → Octal

### Taktik

Sağdan başlayarak üçlü grupla. En soldaki eksik grubu sıfırla tamamla.

### Örnek 1 — `110101₂`

```text
110 101
 6   5

110101₂ = 65₈
```

### Örnek 2 — `10111001₂`

```text
10 111 001
010 111 001
 2   7   1

10111001₂ = 271₈
```

### Örnek 3 — `11100101101₂`

```text
11 100 101 101
011 100 101 101
 3   4   5   5

11100101101₂ = 3455₈
```

---

## 9. Octal → Binary

### Taktik

Her octal rakamı tam 3 bit yaz. Aradaki sıfırları silme; yalnızca tüm sonucun en başındaki gereksiz sıfırlar atılabilir.

### Örnek 1 — `53₈`

```text
5   3
101 011

53₈ = 101011₂
```

### Örnek 2 — `604₈`

```text
6   0   4
110 000 100

604₈ = 110000100₂
```

Ortadaki `0`, mutlaka `000` olmalıdır.

### Örnek 3 — `1275₈`

```text
1   2   7   5
001 010 111 101

1275₈ = 1010111101₂
```

---

## 10. Binary → Hexadecimal

### Taktik

Sağdan başlayarak dörtlü grupla.

### Örnek 1 — `11011110₂`

```text
1101 1110
 D    E

11011110₂ = DE₁₆
```

### Örnek 2 — `101101011₂`

```text
1 0110 1011
0001 0110 1011
 1    6    B

101101011₂ = 16B₁₆
```

### Örnek 3 — `111111111111₂`

```text
1111 1111 1111
 F    F    F

111111111111₂ = FFF₁₆
```

---

## 11. Hexadecimal → Binary

### Taktik

Her hex rakamı tam 4 bit yaz. Özellikle `0–7` rakamlarının baştaki sıfırlarını grup içinde koru.

### Örnek 1 — `4D₁₆`

```text
4    D
0100 1101

4D₁₆ = 01001101₂ = 1001101₂
```

### Örnek 2 — `A07₁₆`

```text
A    0    7
1010 0000 0111

A07₁₆ = 101000000111₂
```

`0` rakamı burada `0000` grubudur; atlanırsa sayı değişir.

### Örnek 3 — `FACE₁₆`

```text
F    A    C    E
1111 1010 1100 1110

FACE₁₆ = 1111101011001110₂
```

### Dört bitlik mini ezber

```text
A = 1010   B = 1011   C = 1100
D = 1101   E = 1110   F = 1111
```

---

## 12. Octal → Hexadecimal

Doğrudan çevirmeye çalışma. Önce her octal rakamı 3 bite çevir, bitleri birleştir, sağdan 4'lü grupla.

### Örnek 1 — `725₈`

```text
7   2   5
111 010 101

111010101₂
= 0001 1101 0101₂
= 1D5₁₆
```

### Örnek 2 — `3647₈`

```text
3   6   4   7
011 110 100 111

011110100111₂
= 0111 1010 0111₂
= 7A7₁₆
```

---

## 13. Hexadecimal → Octal

Her hex rakamı 4 bite çevir, bitleri birleştir, sağdan 3'lü grupla.

### Örnek 1 — `9E₁₆`

```text
9    E
1001 1110

10011110₂
= 010 011 110₂
= 236₈
```

### Örnek 2 — `2AF₁₆`

```text
2    A    F
0010 1010 1111

001010101111₂
= 001 010 101 111₂
= 1257₈
```

---

## 14. Karışık tam çözüm: aynı değeri dört tabanda yazma

### Örnek — `173₁₀`

#### Decimal → binary

```text
173 = 128 + 32 + 8 + 4 + 1
    = 2⁷ + 2⁵ + 2³ + 2² + 2⁰
    = 10101101₂
```

#### Binary → octal

```text
10101101₂
= 010 101 101₂
= 255₈
```

#### Binary → hex

```text
10101101₂
= 1010 1101₂
= AD₁₆
```

#### Dört yönlü sonuç

```text
173₁₀ = 10101101₂ = 255₈ = AD₁₆
```

#### Üç ayrı kontrol

```text
Binary: 128 + 32 + 8 + 4 + 1 = 173
Octal:  2·64 + 5·8 + 5 = 173
Hex:    10·16 + 13 = 173
```

---

## 15. Signed byte mini örnekleri

8 bit desenin en yüksek biti `0` ise signed ve unsigned değer aynıdır. En yüksek bit `1` ise signed değer:

```text
signed değer = unsigned değer - 256
```

| Bit deseni | Unsigned | Signed |
|---|---:|---:|
| `01010110` | 86 | 86 |
| `10000001` | 129 | -127 |
| `11010110` | 214 | -42 |
| `11110000` | 240 | -16 |

### `-42` değerini 8 bit yazma

```text
+42   = 00101010
tersi = 11010101
+1    = 11010110

-42₁₀ = 11010110₂
```

---

## 16. Java ile sonuçları kontrol etme

Elle çöz; Java'yı yalnızca kontrol için kullan.

```java
public class ConversionCheck {
    public static void main(String[] args) {
        int value = 173;

        System.out.println(Integer.toBinaryString(value)); // 10101101
        System.out.println(Integer.toOctalString(value));  // 255
        System.out.println(Integer.toHexString(value));    // ad

        System.out.println(Integer.parseInt("10101101", 2)); // 173
        System.out.println(Integer.parseInt("255", 8));      // 173
        System.out.println(Integer.parseInt("AD", 16));      // 173
    }
}
```

Genel dönüştürücü:

```java
static String convert(String number, int sourceBase, int targetBase) {
    int decimal = Integer.parseInt(number, sourceBase);
    return Integer.toString(decimal, targetBase).toUpperCase();
}
```

Örnek çağrılar:

```java
convert("725", 8, 16);       // 1D5
convert("9E", 16, 8);        // 236
convert("10110101", 2, 10);  // 181
```

> `Integer.parseInt("0xAD", 16)` hatalıdır. Radix ayrıca veriliyorsa metin `AD` olmalıdır.

---

## 17. En sık yapılan dönüşüm hataları

1. **Kuvvetleri yanlış yönde yazmak:** En sağdaki kuvvet her zaman `0`'dır.
2. **Kalanları yukarıdan aşağı okumak:** Decimal'dan dönüşümde aşağıdan yukarı okunur.
3. **Yanlış sayıya bölmek:** Hedef binary ise 2, octal ise 8, hex ise 16.
4. **Gruplamaya soldan başlamak:** Tam sayılarda sağdan başlanır.
5. **Grup içindeki sıfırı silmek:** `0₈ = 000₂`, `0₁₆ = 0000₂`.
6. **Hex harfini basamak sanmak:** `A7₁₆ = 10·16+7`; `A`, 10'dur.
7. **Octal–hex dönüşümünde grup sınırını korumak:** Önce bitleri birleştir, sonra yeni boyutta yeniden grupla.
8. **Signed/unsigned bilgisini atlamak:** Aynı bit deseni farklı değer verebilir.

---

## 18. Alıştırmalar

### A — Binary ve decimal

1. `11101₂ → ?₁₀`
2. `1001101₂ → ?₁₀`
3. `11010110₂ → ?₁₀` (unsigned)
4. `37₁₀ → ?₂`
5. `99₁₀ → ?₂`
6. `225₁₀ → ?₂`

### B — Octal ve decimal

7. `236₈ → ?₁₀`
8. `701₈ → ?₁₀`
9. `125₁₀ → ?₈`
10. `999₁₀ → ?₈`

### C — Hex ve decimal

11. `7C₁₆ → ?₁₀`
12. `1AF₁₆ → ?₁₀`
13. `254₁₀ → ?₁₆`
14. `2024₁₀ → ?₁₆`

### D — Hızlı gruplama

15. `10111101₂ → ?₈`
16. `10111101₂ → ?₁₆`
17. `507₈ → ?₂`
18. `D3₁₆ → ?₂`
19. `672₈ → ?₁₆`
20. `B6₁₆ → ?₈`

### E — Signed byte

21. `10110101₂` unsigned kaçtır?
22. Aynı desen 8 bit signed kaçtır?
23. `-75` değerini 8 bit two's complement yaz.

### F — Hata avı

24. Bir öğrenci `45₁₀ → binary` için kalanları yukarıdan aşağı okuyup `101101₂` yerine `101101₂` buluyor. Bu örnekte hata neden fark edilmiyor? Başka bir sayıda yöntemin tehlikesini göster.
25. `7A₁₆ = 710₁₀` diyen öğrencinin hatası nedir?
26. `304₈ → binary` dönüşümünde `3 0 4 → 11 0 100` yazmak neden tehlikelidir?

---

## 19. Cevap anahtarı

1. `29₁₀`
2. `77₁₀`
3. `214₁₀`
4. `100101₂`
5. `1100011₂`
6. `11100001₂`
7. `158₁₀`
8. `449₁₀`
9. `175₈`
10. `1747₈`
11. `124₁₀`
12. `431₁₀`
13. `FE₁₆`
14. `7E8₁₆`
15. `275₈`
16. `BD₁₆`
17. `101000111₂`
18. `11010011₂`
19. `1BA₁₆`
20. `266₈`
21. `181₁₀`
22. `181-256=-75₁₀`
23. `10110101₂`
24. `45` için kalan dizisi tesadüfen palindromdur: `101101` tersten de aynıdır. Örneğin `74` için kalanları düz okumak `0101001₂=41` verir; doğru sonuç `1001010₂=74`'tür.
25. `A`, `10` değerindedir fakat yan yana decimal rakam gibi okunmaz: `7A₁₆=7·16+10=122₁₀`.
26. Her octal rakam tam 3 bit olmalıdır: `3 0 4 → 011 000 100`. Grup genişliği korunmazsa basamak sınırları kaybolur.

---

## 20. Son kontrol rutini

Her sorunun sonunda şu üç kontrolü yap:

1. **Rakam kontrolü:** Hedef tabanda yasak rakam kullandın mı?
2. **Büyüklük kontrolü:** Sonuç yaklaşık olarak mantıklı mı?
3. **Ters işlem:** Sonucu kaynak tabana geri çevirdiğinde aynı sayı geliyor mu?

```text
Örnek:
173₁₀ → AD₁₆
Kontrol: A·16 + D = 10·16 + 13 = 173 ✓
```

---

## 21. Derinleştirme: Her soruda kullanılacak çözüm şablonu

İşleme başlamadan önce dört satır yaz:

```text
Kaynak taban : ...
Hedef taban  : ...
Seçilen yol  : ...
Kontrol yolu : ...
```

Örneğin `6D₁₆ → octal` için:

```text
Kaynak taban : 16
Hedef taban  : 8
Seçilen yol  : hex → binary → octal
Kontrol yolu : iki sonucu da decimal'a çevir
```

Bu hazırlık yanlış tabana bölme ve yanlış büyüklükte gruplama hatalarını ciddi biçimde azaltır.

### Sonucun uzunluğunu önceden tahmin et

```text
2⁷ = 128 ≤ 173 < 256 = 2⁸
→ 173 binary'de 8 bittir.

16² = 256 ≤ 1000 < 4096 = 16³
→ 1000 hex'te 3 basamaklıdır.

8³ = 512 ≤ 999 < 4096 = 8⁴
→ 999 octal'da 4 basamaklıdır.
```

Bulduğun sonucun uzunluğu bu tahminle uyuşmuyorsa işlemi tekrar kontrol et.

---

## 22. Aynı dönüşümü iki farklı yöntemle çözme

### `156₁₀ → binary`: bölme yöntemi

```text
156 ÷ 2 = 78 kalan 0
 78 ÷ 2 = 39 kalan 0
 39 ÷ 2 = 19 kalan 1
 19 ÷ 2 =  9 kalan 1
  9 ÷ 2 =  4 kalan 1
  4 ÷ 2 =  2 kalan 0
  2 ÷ 2 =  1 kalan 0
  1 ÷ 2 =  0 kalan 1

Aşağıdan yukarı: 10011100₂
```

### `156₁₀ → binary`: kuvvet seçme yöntemi

```text
156 - 128 = 28
 28 -  16 = 12
 12 -   8 = 4
  4 -   4 = 0

156 = 128 + 16 + 8 + 4
    = 2⁷ + 2⁴ + 2³ + 2²
    = 10011100₂
```

İki bağımsız yöntem aynı sonucu verdiği için cevap doğrulanmış olur.

### `83₁₀ → octal`: iki yol

**Doğrudan sekize bölme:**

```text
83 ÷ 8 = 10 kalan 3
10 ÷ 8 =  1 kalan 2
 1 ÷ 8 =  0 kalan 1

83₁₀ = 123₈
```

**Binary köprüsü:**

```text
83 = 64 + 16 + 2 + 1
83₁₀ = 1010011₂
      = 001 010 011₂
      = 123₈
```

### `254₁₀ → hex`: iki yol

**Onaltıya bölme:**

```text
254 ÷ 16 = 15 kalan 14 = E
 15 ÷ 16 =  0 kalan 15 = F

254₁₀ = FE₁₆
```

**Binary köprüsü:**

```text
254₁₀ = 11111110₂
1111 1110₂ = FE₁₆
```

---

## 23. Sıfırlar ve sabit bit genişliği

### Baştaki sıfırlar

Baştaki sıfırlar sayısal değeri değiştirmez:

```text
00101₂ = 101₂ = 5₁₀
007₈ = 7₈
00AF₁₆ = AF₁₆
```

Fakat soru sabit genişlik isterse sıfırlar yazılmalıdır:

```text
5₁₀ = 101₂
5₁₀, 8 bit  = 00000101₂
5₁₀, 16 bit = 0000000000000101₂
```

### Ortadaki sıfırlar silinemez

```text
A07₁₆ = 1010 0000 0111₂
604₈  = 110 000 100₂
```

Buradaki `0₁₆`, dört bitlik `0000`; `0₈`, üç bitlik `000` grubudur. Bu gruplar atılırsa basamakların yeri ve sayının değeri değişir.

### Neden her hex rakamı dört bit yazılır?

`5₁₆` tek başına `101₂` değerine eşittir. Fakat `A5₁₆` içinde grup sınırını korumak için `5`, `0101` yazılmalıdır:

```text
A    5
1010 0101

A5₁₆ = 10100101₂
```

`1010 101` yazmak grup yapısını bozar.

---

## 24. Octal ve hex arasında çok ayrıntılı örnekler

### `6D₁₆ → octal`

**1. Hex rakamlarını dört bit yaz:**

```text
6    D
0110 1101
```

**2. Bitleri tek dizi hâline getir:**

```text
01101101
```

**3. Sağdan üçlü gruplandır ve solu tamamla:**

```text
01 101 101
001 101 101
```

**4. Grupları octal rakamlara çevir:**

```text
001 = 1
101 = 5
101 = 5

6D₁₆ = 155₈
```

**5. Decimal ile kontrol et:**

```text
6D₁₆ = 6·16 + 13 = 109₁₀
155₈ = 1·64 + 5·8 + 5 = 109₁₀
```

### `347₈ → hexadecimal`

**1. Octal rakamlarını üç bit yaz:**

```text
3   4   7
011 100 111
```

**2. Bitleri birleştir ve sağdan dörtlü grupla:**

```text
011100111
0 1110 0111
0000 1110 0111
```

En soldaki `0000` yalnızca dolgu grubudur ve atılır:

```text
1110 = E
0111 = 7

347₈ = E7₁₆
```

Kontrol:

```text
347₈ = 3·64 + 4·8 + 7 = 231₁₀
E7₁₆ = 14·16 + 7 = 231₁₀
```

---

## 25. Kuvvet sınırları ve ezberlenebilir desenler

| Decimal | Binary | Octal | Hex |
|---:|---:|---:|---:|
| 8 | `1000` | `10` | `8` |
| 15 | `1111` | `17` | `F` |
| 16 | `10000` | `20` | `10` |
| 31 | `11111` | `37` | `1F` |
| 32 | `100000` | `40` | `20` |
| 63 | `111111` | `77` | `3F` |
| 64 | `1000000` | `100` | `40` |
| 127 | `1111111` | `177` | `7F` |
| 128 | `10000000` | `200` | `80` |
| 255 | `11111111` | `377` | `FF` |
| 256 | `100000000` | `400` | `100` |

Genel desenler:

```text
2ⁿ      → binary'de 1 ve arkasından n tane 0
2ⁿ - 1  → binary'de n tane 1
16ᵏ     → hex'te 1 ve arkasından k tane 0
16ᵏ - 1 → hex'te k tane F
8ᵏ      → octal'da 1 ve arkasından k tane 0
8ᵏ - 1  → octal'da k tane 7
```

---

## 26. Kesirli dönüşümleri daha iyi anlama

Tam kısım ve kesirli kısım ayrı çevrilir:

- Tam kısım hedef tabana **bölünür**.
- Kesirli kısım hedef tabanla **çarpılır**.

### `13,625₁₀ → binary`

**Tam kısım:**

```text
13₁₀ = 1101₂
```

**Kesirli kısım:**

```text
0,625 × 2 = 1,25 → 1
0,25  × 2 = 0,5  → 0
0,5   × 2 = 1,0  → 1

0,625₁₀ = 0,101₂
```

**Birleştirme:**

```text
13,625₁₀ = 1101,101₂
```

**Kontrol:**

```text
1101,101₂
= 8 + 4 + 1 + 1/2 + 1/8
= 13 + 0,625
= 13,625₁₀
```

### `10,11₂ → decimal`

```text
10,11₂
= 1·2¹ + 0·2⁰ + 1·2⁻¹ + 1·2⁻²
= 2 + 0,5 + 0,25
= 2,75₁₀
```

### Binary kesri doğrudan hex'e çevirme

Virgülün iki tarafı ayrı ayrı dörtlü gruplanır. Eksik tam grup sola, eksik kesir grubu sağa sıfır eklenerek tamamlanır:

```text
101101,101₂
= 0010 1101 , 1010₂
= 2D,A₁₆
```

Sağa eklenen sıfırlar kesir değerini değiştirmez: `0,1₂ = 0,1000₂`.

---

## 27. Tam kapsamlı dönüşüm zinciri

`45₁₀` değerini bütün sistemlere çevirelim.

```text
45 = 32 + 8 + 4 + 1
45₁₀ = 101101₂
```

```text
101101₂ = 101 101₂ = 55₈
```

```text
101101₂ = 0010 1101₂ = 2D₁₆
```

Geri kontroller:

```text
55₈  = 5·8 + 5 = 45₁₀
2D₁₆ = 2·16 + 13 = 45₁₀
```

```text
45₁₀ = 101101₂ = 55₈ = 2D₁₆
```

---

## 28. Ek karma alıştırmalar

1. `84₁₀` değerini binary, octal ve hex olarak yaz.
2. `11101011₂` değerini decimal, octal ve hex olarak yaz.
3. `572₈` değerini binary, decimal ve hex olarak yaz.
4. `3C9₁₆` değerini binary, octal ve decimal olarak yaz.
5. `21,375₁₀ → binary` dönüşümünü yap.
6. `11010,011₂ → decimal` dönüşümünü yap.
7. `101011,11₂ → hex` dönüşümünü yap.
8. `7B,8₁₆ → binary` dönüşümünü yap.

### Ek cevaplar

1. `84₁₀ = 1010100₂ = 124₈ = 54₁₆`
2. `11101011₂ = 235₁₀ = 353₈ = EB₁₆`
3. `572₈ = 101111010₂ = 378₁₀ = 17A₁₆`
4. `3C9₁₆ = 1111001001₂ = 1711₈ = 969₁₀`
5. `21,375₁₀ = 10101,011₂`
6. `11010,011₂ = 26,375₁₀`
7. `101011,11₂ = 2B,C₁₆`
8. `7B,8₁₆ = 01111011,1000₂`

> Bitwise işlemler bu dosyaya bilinçli olarak eklenmemiştir. AND, OR, XOR, NOT ve shift işlemleri ayrı bir çalışma notunda ele alınacaktır.
