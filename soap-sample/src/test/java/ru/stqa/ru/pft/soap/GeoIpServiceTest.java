package ru.stqa.ru.pft.soap;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTest {

  @Test
  public void testMyIp(){
    String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("85.143.144.18");
    assertEquals(ipLocation, "<GeoIP><Country>RU</Country><State>66</State></GeoIP>");
  }
}
