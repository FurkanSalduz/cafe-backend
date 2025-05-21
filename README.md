# ☕ Cafe Projesi

Bu proje, **cafe yönetim sistemi** için geliştirilmiş backend uygulamasıdır.  
Java Spring Boot kullanılarak geliştirilmiş olup, **ürün ekleme, silme, güncelleme** gibi temel işlemleri yönetmektedir.

Ürün fotoğraflarının depolanması ve yönetimi için AWS'nin **S3 (Simple Storage Service)** servisi kullanılmaktadır. AWS S3, yüksek erişilebilirlik, dayanıklılık ve ölçeklenebilirlik sunan bulut tabanlı bir dosya depolama servisidir. Bu sayede, ürün görselleri doğrudan güvenli bir şekilde bulutta saklanmakta, backend sunucusunun depolama yükü hafifletilmektedir. Fotoğraf yükleme, görüntüleme ve silme işlemleri API aracılığıyla AWS S3 üzerinde etkin biçimde gerçekleştirilmektedir.

---

## 🚀 Özellikler

- 🍽️ **Cafe menüsü yönetimi**: Ürün ekleme, silme, güncelleme ve listeleme   
- 📸 **Ürün fotoğrafları**: AWS S3 ile güvenli ve ölçeklenebilir dosya depolama  
- 🛢️ **Veritabanı**: PostgreSQL ile güçlü ve güvenilir veri yönetimi  
- 🔄 **Mapper kullanımı**: MapStruct ile entity ve DTO dönüşümleri kolaylaştırıldı  
- 🌐 **RESTful API mimarisi**: API endpoint'leri temiz ve anlaşılır şekilde tasarlandı  

---

## 🛠️ Teknolojiler

| Teknoloji          | Açıklama                                      |
|--------------------|-----------------------------------------------|
| Java 17+           | Modern Java sürümü                             |
| Spring Boot        | Hızlı ve kolay backend geliştirme              |
| PostgreSQL         | İlişkisel veritabanı yönetim sistemi           |
| AWS S3             | Ürün görselleri için bulut tabanlı dosya depolama |
| MapStruct          | Entity-DTO dönüşümleri için mapper kütüphanesi |
| Maven / Gradle     | Proje ve bağımlılık yönetimi                    |



