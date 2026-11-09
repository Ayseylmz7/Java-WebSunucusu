# Java Web Sunucusu

Java ve socket programlama kullanılarak yazılmış basit bir web sunucusudur. **Hiçbir 3. parti bileşen veya kütüphane kullanılmamıştır**, yalnızca Java standart kütüphanesi kullanılmıştır.

> **Ders:** Nesneye Yönelik Programlama (Final Değerlendirme Ödevi )
> **Hazırlayan:** Ayşe Yılmaz
> **Üniversite:** Kırklareli Üniversitesi, Yazılım Mühendisliği

## Projenin Amacı

Sunucuya **1989. porttan** erişilir. Herhangi bir web tarayıcısı sunucuya bağlandığında şu içeriği gösteren bir HTML sayfası alır:

- `H1` boyutunda Ad Soyad
- `H2` boyutunda Öğrenci No
- Renk ve font çeşidi ile biçimlendirilmiş kısa bir biyografi

## Gereksinimler

- JDK 17 veya üstü (proje JDK 21 ile geliştirilmiştir)
- IntelliJ IDEA (veya herhangi bir Java IDE'si)
- Herhangi bir web tarayıcısı

## Çalıştırma

1. Projeyi indirin veya klonlayın:
   ```
   git clone https://github.com/KULLANICI_ADI/REPO_ADI.git
   ```
2. Projeyi IntelliJ IDEA ile açın.
3. `Main` sınıfını çalıştırın. Konsolda şu mesajı görmelisiniz:
   ```
   Sunucu 1989 portunda çalışıyor...
   ```
4. Tarayıcıda şu adresi açın:
   ```
   http://localhost:1989
   ```
5. Sunucuyu durdurmak için IntelliJ'deki kırmızı **Stop** butonuna basın.

## Proje Yapısı

```
src/
├── Main.java            → Programı başlatır
├── Server.java          → Portu dinler, bağlantıları kabul eder
├── RequestHandler.java  → İsteği okur, cevabı tarayıcıya gönderir
├── Page.java            → Sayfa arayüzü (sözleşme)
└── HtmlPage.java        → HTML içeriğini üretir
```

| Sınıf / Arayüz | Görevi |
|---|---|
| `Main` | Nesneleri birbirine bağlar ve sunucuyu başlatır |
| `Server` | `ServerSocket` ile portu dinler, gelen her bağlantı için `RequestHandler` oluşturur |
| `RequestHandler` | Tarayıcının HTTP isteğini okur, HTTP başlığı ve HTML'i geri yazar |
| `Page` | `build()` metodunu tanımlayan arayüz |
| `HtmlPage` | `Page` arayüzünü gerçekler, HTML metnini üretir |

## Nasıl Çalışır?

1. `Server`, 1989. portta `ServerSocket` ile dinlemeye başlar.
2. Tarayıcı `http://localhost:1989` adresine bağlanınca bir `Socket` oluşur.
3. `RequestHandler`, tarayıcının gönderdiği HTTP isteğini okur.
4. `Page` arayüzü üzerinden HTML metni alınır.
5. HTTP başlığı (`200 OK`, `Content-Type: text/html; charset=UTF-8`) ve HTML tarayıcıya yazılır.
6. Bağlantı kapatılır, sunucu yeni bağlantıyı beklemeye devam eder.

## Kullanılan SOLID İlkeleri

- **S (Tek Sorumluluk):** Her sınıfın tek bir görevi vardır. HTML değişirse yalnızca `HtmlPage`, port değişirse yalnızca `Main` değişir.
- **O (Açık/Kapalı):** Yeni bir sayfa eklemek için `Page` arayüzünü gerçekleyen yeni bir sınıf yazmak yeterlidir; `Server` ve `RequestHandler` değiştirilmez.
- **D (Bağımlılığın Tersine Çevrilmesi):** `Server` ve `RequestHandler`, somut `HtmlPage` sınıfına değil `Page` arayüzüne bağlıdır. Somut sınıf yalnızca `Main` içinde oluşturulur.
- **I (Arayüz Ayrımı):** `Page` arayüzü tek metotludur, küçük ve odaklıdır.
- **L (Liskov):** Projede kalıtım hiyerarşisi kurulmadığı için bu ilkeyi ihlal edecek bir durum yoktur.

## Notlar

- Sunucu bağlantıları sırayla işler (tek iş parçacıklı); ödevin kapsamı için yeterlidir.
- Türkçe karakterlerin doğru görünmesi için hem HTTP başlığında hem de HTML içinde `UTF-8` belirtilmiştir.
