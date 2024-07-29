# FonetBtTask
# Java Test Automation Project

Bu proje, Fonet Bilgi Teknolojileri iş görüşmesi için verilen bir test otomasyon görevidir. Proje, bir web uygulamasının otomatik test edilmesi amacıyla geliştirilmiştir.

## Proje Açıklaması

Bu proje, Java ve Selenium kullanarak TestNG ve Cucumber framework ile Gherkin dili kullanılarak belirli bir web uygulamasının çeşitli test senaryolarını otomatikleştirmeyi amaçlamaktadır. Proje, uygulamanın ana işlevlerinin doğru çalıştığını doğrulamak için oluşturulmuştur.

## Kurulum Talimatları

1. **Java Kurulumu:**
   - Java JDK'yı [buradan](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) indirin ve kurun.

2. **IntelliJ IDEA Kurulumu:**
   - IntelliJ IDEA'yı [buradan](https://www.jetbrains.com/idea/download/) indirin ve kurun.

3. **Proje Dosyalarını İndirin:**
   - Projenin bulunduğu repository'yi klonlayın. Örneğin: `git clone https://github.com/kullaniciadi/projeadi.git` gibi

4. **Bağımlılıkları Kurun:**
   - Proje dizininde `mvn install` komutunu çalıştırarak Maven bağımlılıklarını yükleyin.
   - src/main/java/driver klasöründe geckoDriver.exe'nin uzantısını güncel haliyle değiştirin.

## Kullanım Talimatları

1. IntelliJ IDEA'da projeyi açın.
2. Test sınıflarını çalıştırarak testleri başlatın. Örneğin, `src/test/java` dizinindeki test sınıflarını sağ tıklayarak `Run` seçeneğini kullanın.
3. Test sonuçlarını console ekranında bulabilirsiniz.

## Test Talimatları

Bu projede, aşağıdaki özellikler ve test senaryoları bulunmaktadır:
- Feature: Product purchasing process
    - Scenario: Go to the demo site and complete a product purchase
- Feature:Validation of products in categories
    - Scenario:Validate phone category products and write them
    - Scenario:Validate laptops category products and write them
    - Scenario:Validate monitors category products and write them

Testleri çalıştırmak için `src/test/java` dizinindeki test sınıflarını kullanabilirsiniz.

## Proje Yapısı

- `src/main/java`: Ana uygulama kodları
- `src/test/java`: Test kodları
- `pom.xml`: Maven yapılandırma dosyası

