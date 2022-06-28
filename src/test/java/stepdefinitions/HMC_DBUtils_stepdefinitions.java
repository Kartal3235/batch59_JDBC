package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;

public class HMC_DBUtils_stepdefinitions {

    @Given("kullanici DBUtilis ile HMC veri tabanina baglanir")
    public void kullanici_db_utilis_ile_hmc_veri_tabanina_baglanir() {
        DBUtils.getConnection();

    }
    @Given("kullanici DBUtilis ile {string} tablosundaki {string} verilerini alir")
    public void kullanici_db_utilis_ile_tablosundaki_verilerini_alir(String table, String field) {
        String query="SELECT "+field+" FROM "+ table;
        DBUtils.executeQuery(query);


    }
    @Given("kullanici DBUtilis ile {string} sutunundaki verileri okur")
    public void kullanici_db_utilis_ile_sutunundaki_verileri_okur(String field) throws SQLException {

        DBUtils.getResultset().first();
        System.out.println(DBUtils.getResultset().getString(field));


    }

    @And("DBUtil ile tum {string} degerlerini sira numarasi ile yazdirir")
    public void dbutilIleTumDegerleriniSiraNumarasiIleYazdirir(String field) throws SQLException {

        // 1. derste while loop ile next() methodunu kullanarak liste yazdırmıştık
        // şimdi de for loop ile liste yazdıralım
        DBUtils.getResultset().last();// sona gttik
        int sonsatırNo=DBUtils.getResultset().getRow();

        DBUtils.getResultset().first();// Tekrar başa aldık
        for (int i = 1; i <=sonsatırNo ; i++) {

            System.out.println(i+". kayıt "+DBUtils.getResultset().getString(field));
            DBUtils.getResultset().next();
        }

    }

    @And("DBUtil ile {int}. {string} in {int} olduğunu test eder")
    public void dbutilIleInOlduğunuTestEder(int istenenSiraNo, String field, int ExpectedDeger) throws SQLException {

        DBUtils.getResultset().absolute(istenenSiraNo);
        double actualDeger=DBUtils.getResultset().getDouble(field);
        System.out.println(ExpectedDeger);
        System.out.println(actualDeger);
        Assert.assertTrue(actualDeger==ExpectedDeger);
    }

    @Then("tHOTEL tablosunda IDHotel degeri {int} olan kaydin Email bilgisini {string} yapar")
    public void thotelTablosundaIDHotelDegeriOlanKaydinEmailBilgisiniYapar(int idHotel, String yeninEmail) {


        String updateQuery="update tHOTEL set Email='"+yeninEmail+"' where idHotel="+idHotel+";";
        DBUtils.executeQuery(updateQuery);
    }
}
