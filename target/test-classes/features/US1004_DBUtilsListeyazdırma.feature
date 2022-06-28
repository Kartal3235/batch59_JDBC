
Feature:US1004 kullanici istenen tablodaki istenen field'i listeleyebilir

  Scenario:TC04 kullanici field listesi yazdırabilmeli

    Given kullanici DBUtilis ile HMC veri tabanina baglanir
    And kullanici DBUtilis ile "tHOTEL" tablosundaki "Email" verilerini alir
    And kullanici DBUtilis ile "Email" sutunundaki verileri okur
    And DBUtil ile tum "Email" degerlerini sira numarasi ile yazdirir