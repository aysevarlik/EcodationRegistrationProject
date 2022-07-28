# Registration Project
---
## Proje Açıklaması
* Rest Api kullanılarak kullanıcı kaydı oluşturabilmeniz için oluşturulmuş bir projedir.
* Kayıtlar postman ile JSON formatında ve proje içindeki unit test ile oluşturulabilir.
* Kayıtlı kullanıcılar listelenebilir.
* Kayıtlı kullanıcılara id, isim, soyisim ve emaillerine göre ulaşılabilir.
* Unit testler için başarılı ve başarısız olmak üzere iki class oluşturuldu.
* Database işlemleri için Hibernate(JPA) kullanıldı.
* Sorgulamalar için Named Queries kullanıldı.
* Verilere application.properties dosyasındaki h2-console linkinden ulaşılabilir.

---

## Postman için;

- Post (save)
 - http://localhost:8080/api/v1/users
 - {
    "userName" : "ayse",
    "userSurname" : "varlık",
    "userEmail" : "ayse@gmail.com",
    "userPassword" : "sifre"
    }
- Get (list)
 - http://localhost:8080/api/v1/users
- Get (find)
 - http://localhost:8080/api/v1/users/{id}
- Put (update)
 - http://localhost:8080/api/v1/users/{id}
- Delete
 - http://localhost:8080/api/v1/users/{id}
