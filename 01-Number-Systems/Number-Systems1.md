# Number Systems — Sınav Odaklı Ders Notu

> Taban alt indisle gösterilir: 167₁₀, 10100111₂, 247₈, A7₁₆.

## 1. Taban mantığı

Taban, kullanılabilen rakamları ve basamak ağırlıklarını belirler.

| Sistem | Taban | Rakamlar | Ağırlıklar |
|---|---:|---|---|
| Binary | 2 | 0, 1 | 2⁰, 2¹, 2², ... |
| Octal | 8 | 0–7 | 8⁰, 8¹, 8², ... |
| Decimal | 10 | 0–9 | 10⁰, 10¹, 10², ... |
| Hexadecimal | 16 | 0–9, A–F | 16⁰, 16¹, 16², ... |

| Hex | A | B | C | D | E | F |
|---|---:|---:|---:|---:|---:|---:|
| Decimal | 10 | 11 | 12 | 13 | 14 | 15 |

Genel açılım:

~~~text
(dₙ...d₂d₁d₀)ᵦ = dₙ·bⁿ + ... + d₂·b² + d₁·b¹ + d₀·b⁰
~~~

Kuvvetler en sağdan 0 ile başlar.

~~~text
10100111₂
= 1·2⁷ + 0·2⁶ + 1·2⁵ + 0·2⁴ + 0·2³ + 1·2² + 1·2¹ + 1·2⁰
= 128 + 32 + 4 + 2 + 1
= 167₁₀
~~~

~~~text
167₁₀ = 10100111₂ = 247₈ = A7₁₆
~~~

## 2. İkinin kuvvetleri, 2ⁿ kombinasyon ve signed byte

| n | 2ⁿ | n | 2ⁿ |
|---:|---:|---:|---:|
| 0 | 1 | 8 | 256 |
| 1 | 2 | 9 | 512 |
| 2 | 4 | 10 | 1.024 |
| 3 | 8 | 11 | 2.048 |
| 4 | 16 | 12 | 4.096 |
| 5 | 32 | 13 | 8.192 |
| 6 | 64 | 14 | 16.384 |
| 7 | 128 | 15 | 32.768 |

Her bit 0 veya 1 olabilir; n bit 2ⁿ farklı desen üretir.

- n bit unsigned: 0 ... 2ⁿ−1
- n bit signed two''s complement: −2ⁿ⁻¹ ... 2ⁿ⁻¹−1
- 8 bit unsigned: 0..255
- 8 bit signed byte: −128..127

| 8 bit desen | Signed | Unsigned |
|---|---:|---:|
| 00000000 | 0 | 0 |
| 01111111 | 127 | 127 |
| 10000000 | −128 | 128 |
| 10100111 | −89 | 167 |
| 11111111 | −1 | 255 |

10100111₂ signed yorumda:

~~~text
−2⁷ + 2⁵ + 2² + 2¹ + 2⁰ = −128 + 32 + 4 + 2 + 1 = −89
~~~

Kısa yol: en yüksek bit 1 ise unsigned değerden 2⁸ çıkar: 167−256=−89.

## 3. Herhangi bir tabandan decimal''a

Her rakamı tabanın ilgili kuvvetiyle çarp ve topla.

### Binary → decimal

~~~text
110101₂ = 1·2⁵ + 1·2⁴ + 0·2³ + 1·2² + 0·2¹ + 1·2⁰
         = 32 + 16 + 4 + 1 = 53₁₀
~~~

### Octal → decimal

~~~text
247₈ = 2·8² + 4·8¹ + 7·8⁰ = 128 + 32 + 7 = 167₁₀
~~~

### Hex → decimal

~~~text
A7₁₆ = 10·16¹ + 7·16⁰ = 160 + 7 = 167₁₀
~~~

## 4. Decimal''dan hedef tabana

Tam sayı hedef tabana art arda bölünür; kalanlar aşağıdan yukarı okunur.

### Neden hedef tabana bölüyoruz?

~~~text
N = b·q + r,   0 ≤ r < b
~~~

b hedef tabandır. r=N mod b, hedef tabanda geçerli bir rakam ve sayının en sağ basamağıdır. Bölüm q üzerinde işlem tekrarlanır. İlk kalan en düşük değerli basamak olduğu için kalanlar tersten okunur. Hedef binary ise 2''ye, octal ise 8''e, hex ise 16''ya bölünür.

### 167₁₀ → binary

| İşlem | Bölüm | Kalan |
|---|---:|---:|
| 167 ÷ 2 | 83 | 1 |
| 83 ÷ 2 | 41 | 1 |
| 41 ÷ 2 | 20 | 1 |
| 20 ÷ 2 | 10 | 0 |
| 10 ÷ 2 | 5 | 0 |
| 5 ÷ 2 | 2 | 1 |
| 2 ÷ 2 | 1 | 0 |
| 1 ÷ 2 | 0 | 1 |

Aşağıdan yukarı: 10100111₂.

### 167₁₀ → octal ve hex

~~~text
167÷8=20 kalan 7
20÷8=2   kalan 4
2÷8=0    kalan 2
→ 247₈

167÷16=10 kalan 7
10÷16=0   kalan 10=A
→ A7₁₆
~~~

## 5. Binary, octal ve hex arasında hızlı dönüşüm

8=2³ olduğundan bir octal rakam 3 bit; 16=2⁴ olduğundan bir hex rakam 4 bittir.

### Binary ↔ octal

~~~text
10100111₂ = 010 100 111₂ = 247₈
247₈ = 010 100 111₂ = 10100111₂
~~~

| Binary | Octal | Binary | Octal |
|---|---:|---|---:|
| 000 | 0 | 100 | 4 |
| 001 | 1 | 101 | 5 |
| 010 | 2 | 110 | 6 |
| 011 | 3 | 111 | 7 |

### Binary ↔ hex

~~~text
10100111₂ = 1010 0111₂ = A7₁₆
A7₁₆ = 1010 0111₂
~~~

| Binary | Hex | Binary | Hex |
|---|---:|---|---:|
| 0000 | 0 | 1000 | 8 |
| 0001 | 1 | 1001 | 9 |
| 0010 | 2 | 1010 | A |
| 0011 | 3 | 1011 | B |
| 0100 | 4 | 1100 | C |
| 0101 | 5 | 1101 | D |
| 0110 | 6 | 1110 | E |
| 0111 | 7 | 1111 | F |

Octal ↔ hex için binary köprüsü:

~~~text
247₈ → 010 100 111₂ → 010100111₂ → 1010 0111₂ → A7₁₆
~~~

Tam sayıda gruplama sağdan başlar; eksik grup sola sıfır eklenerek tamamlanır.

## 6. Kesirli sayılar

Virgülün sağında negatif kuvvetler kullanılır.

~~~text
101.101₂
= 1·2² + 0·2¹ + 1·2⁰ + 1·2⁻¹ + 0·2⁻² + 1·2⁻³
= 5,625₁₀
~~~

Decimal kesir hedef tabanla art arda çarpılır; tam kısımlar yukarıdan aşağı okunur.

~~~text
0,625×2 = 1,25 → 1
0,25 ×2 = 0,5  → 0
0,5  ×2 = 1,0  → 1
0,625₁₀ = 0,101₂
~~~

Her decimal kesrin binary karşılığı sonlu değildir; 0,1₁₀ tekrarlıdır.

## 7. Two''s complement ile negatif sayı

Sabit n bitte −x bulmak için x''i n bit yaz, bitleri tersle, 1 ekle.

~~~text
+89   = 01011001
tersi = 10100110
+1    = 10100111 → −89
~~~

Taşma örneği:

~~~text
01111111 = 127
+      1
---------
10000000 = −128 (8 bit signed)
~~~

## 8. Java JDK 27 örnekleri

### Literaller

~~~java
public class NumberLiterals {
    public static void main(String[] args) {
        int decimal = 167;
        int binary = 0b1010_0111;
        int octal = 0247;
        int hex = 0xA7;

        System.out.println(decimal); // 167
        System.out.println(binary);  // 167
        System.out.println(octal);   // 167
        System.out.println(hex);     // 167
    }
}
~~~

0b binary, 0x hex önekidir. Java''da baştaki 0 octal literal belirtir; 010 decimal 10 değil 8''dir.

### Biçimlendirme ve çözümleme

~~~java
int n = 167;
System.out.println(Integer.toBinaryString(n)); // 10100111
System.out.println(Integer.toOctalString(n));  // 247
System.out.println(Integer.toHexString(n));    // a7

int a = Integer.parseInt("10100111", 2); // 167
int b = Integer.parseInt("247", 8);      // 167
int c = Integer.parseInt("A7", 16);      // 167
~~~

parseInt girdisine 0b yazılmaz. Önekli metinde Integer.decode("0xA7") kullanılabilir.

### Genel dönüştürücü

~~~java
public class BaseConverter {
    static String convert(String value, int sourceBase, int targetBase) {
        int decimal = Integer.parseInt(value, sourceBase);
        return Integer.toString(decimal, targetBase).toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(convert("10100111", 2, 16)); // A7
        System.out.println(convert("247", 8, 2));       // 10100111
        System.out.println(convert("A7", 16, 10));      // 167
    }
}
~~~

### Signed byte ve unsigned görünüm

~~~java
byte signed = (byte) 0b1010_0111;
System.out.println(signed);                     // -89
System.out.println(Byte.toUnsignedInt(signed)); // 167
System.out.printf("%02X%n", Byte.toUnsignedInt(signed)); // A7
~~~

Aynı 8 bit desen signed olarak −89, unsigned olarak 167''dir.

### Negatif int''in son 8 biti

~~~java
int value = -89;
System.out.println(Integer.toBinaryString(value));
// 11111111111111111111111110100111

String last8 = String.format("%8s",
        Integer.toBinaryString(value & 0xFF)).replace('' '', ''0'');
System.out.println(last8); // 10100111
~~~

Java int 32 bit signed''dır. int sınırını aşan sayılarda BigInteger kullanılır:

~~~java
import java.math.BigInteger;

BigInteger n = new BigInteger("11110000111100001111000011110000", 2);
System.out.println(n.toString(16).toUpperCase());
~~~

## 9. Tüm yönlü dönüşüm haritası

| Kaynak → Hedef | Yöntem |
|---|---|
| Binary → Decimal | 2 kuvvetleriyle açılım |
| Octal → Decimal | 8 kuvvetleriyle açılım |
| Hex → Decimal | 16 kuvvetleriyle açılım |
| Decimal → Binary | Art arda 2''ye bölme |
| Decimal → Octal | Art arda 8''e bölme |
| Decimal → Hex | Art arda 16''ya bölme |
| Binary ↔ Octal | 3 bitlik gruplar |
| Binary ↔ Hex | 4 bitlik gruplar |
| Octal ↔ Hex | Binary köprüsü |

Her zaman çalışan genel yol: kaynak taban → decimal → hedef taban.

## 10. Yaygın hatalar

1. Tabanı unutmak: 101₂=5₁₀, fakat 101₁₀=101.
2. Geçersiz rakam kullanmak: 102₂, 89₈ ve 1G₁₆ geçersizdir.
3. Kuvvetleri soldan 0 ile başlatmak; doğrusu sağdan başlamaktır.
4. Bölme kalanlarını düz okumak; doğrusu aşağıdan yukarıdır.
5. Tam sayıyı soldan gruplamak; doğrusu sağdan gruplamaktır.
6. Hex''te A=10 ... F=15 olduğunu unutmak.
7. 2ⁿ ile maksimumu karıştırmak: unsigned maksimum 2ⁿ−1''dir.
8. Signed/unsigned ayrımını unutmak: 11111111₂ unsigned 255, signed byte −1.
9. Java''da baştaki 0''ı unutmak: int x=010 için x=8.
10. Sayının bellekte “decimal” saklandığını sanmak: tabanlar aynı değerin farklı yazımlarıdır.

## 11. Çözümlü örnekler

~~~text
111010₂ = 2⁵+2⁴+2³+2¹ = 58₁₀
2D9₁₆ = 2·16²+13·16+9 = 729₁₀
5B₁₆ = 0101 1011₂ = 001 011 011₂ = 133₈
11101100₂, 8 bit signed: unsigned 236 → 236−256 = −20
~~~

93₁₀ → binary:

~~~text
93÷2=46 k1
46÷2=23 k0
23÷2=11 k1
11÷2=5  k1
5÷2=2   k1
2÷2=1   k0
1÷2=0   k1
~~~

Aşağıdan yukarı: 1011101₂.

## 12. Sınav pratikleri

1. n bit kaç desen üretir?
2. 12 bit unsigned ve signed aralıkları nedir?
3. 10100111₂ nasıl hem 167 hem −89 olabilir?
4. 101101₂ → decimal
5. 11001010₂ → decimal
6. 345₈ → decimal
7. 712₈ → decimal
8. 3F₁₆ → decimal
9. B4₁₆ → decimal
10. 45₁₀ → binary
11. 200₁₀ → binary
12. 156₁₀ → octal
13. 255₁₀ → hex
14. 1000₁₀ → hex
15. 11110110₂ → octal ve hex
16. 671₈ → binary
17. C3₁₆ → binary
18. 725₈ → hex
19. 9E₁₆ → octal
20. 8 bit signed 10000000₂, 11111111₂ ve 11010110₂?
21. −42''nin 8 bit gösterimi?
22. Java''da (byte)200?
23. int x=012 için x?
24. Integer.parseInt("1111",2)?
25. Integer.toHexString(255)?
26. byte b değerini unsigned gösteren metot?

## 13. Cevap anahtarı

1. 2ⁿ
2. Unsigned 0..4095; signed −2048..2047
3. Unsigned 167; signed 167−256=−89
4. 45
5. 202
6. 229
7. 458
8. 63
9. 180
10. 101101₂
11. 11001000₂
12. 234₈
13. FF₁₆
14. 3E8₁₆
15. 366₈ ve F6₁₆
16. 110111001₂
17. 11000011₂
18. 1D5₁₆
19. 236₈
20. −128, −1, −42
21. 11010110₂
22. −56
23. 10
24. 15
25. "ff"
26. Byte.toUnsignedInt(b)

## 14. Son dakika kontrol listesi

- [ ] Tabanı yazdım.
- [ ] Rakamların geçerliliğini kontrol ettim.
- [ ] Kuvvetleri sağdan 0 ile başlattım.
- [ ] Hedef tabana böldüm.
- [ ] Kalanları aşağıdan yukarı okudum.
- [ ] Octal için 3''lü, hex için 4''lü grupladım.
- [ ] Signed/unsigned ve bit genişliğini kontrol ettim.
- [ ] Ters dönüşümle doğruladım.
