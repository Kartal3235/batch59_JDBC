 Feature: US1002 kullanıcı DB Utilis ile database bağlantısı yapabilir

   @DBUtils
   Scenario: TC02 kullanıcı Db Utilis ile database'deki bilgileri okur

     Given kullanici DBUtilis ile HMC veri tabanina baglanir
     And kullanici DBUtilis ile "tHOTELROOM" tablosundaki "Price" verilerini alir
    # SELECT Price FROM tHOTELROOM
     And kullanici DBUtilis ile "Price" sutunundaki verileri okur