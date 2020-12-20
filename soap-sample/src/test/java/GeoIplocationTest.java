import com.lavasoft.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeoIplocationTest {

    @Test
    public void testGeoLocationIp() {

        String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("37.144.135.229");
        Assert.assertEquals(ipLocation,"<GeoIP><Country>RU</Country><State>48</State></GeoIP>");
    }
}
