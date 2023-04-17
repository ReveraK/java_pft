
package com.lavasoft;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.lavasoft package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _String_QNAME = new QName("http://lavasoft.com/", "string");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.lavasoft
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetIpLocation }
     * 
     */
    public GetIpLocation createGetIpLocation() {
        return new GetIpLocation();
    }

    /**
     * Create an instance of {@link GetIpLocationResponse }
     * 
     */
    public GetIpLocationResponse createGetIpLocationResponse() {
        return new GetIpLocationResponse();
    }

    /**
     * Create an instance of {@link GetIpLocation20 }
     * 
     */
    public GetIpLocation20 createGetIpLocation20() {
        return new GetIpLocation20();
    }

    /**
     * Create an instance of {@link GetIpLocation20Response }
     * 
     */
    public GetIpLocation20Response createGetIpLocation20Response() {
        return new GetIpLocation20Response();
    }

    /**
     * Create an instance of {@link GetLocation }
     * 
     */
    public GetLocation createGetLocation() {
        return new GetLocation();
    }

    /**
     * Create an instance of {@link GetLocationResponse }
     * 
     */
    public GetLocationResponse createGetLocationResponse() {
        return new GetLocationResponse();
    }

    /**
     * Create an instance of {@link GetCountryISO2ByName }
     * 
     */
    public GetCountryISO2ByName createGetCountryISO2ByName() {
        return new GetCountryISO2ByName();
    }

    /**
     * Create an instance of {@link GetCountryISO2ByNameResponse }
     * 
     */
    public GetCountryISO2ByNameResponse createGetCountryISO2ByNameResponse() {
        return new GetCountryISO2ByNameResponse();
    }

    /**
     * Create an instance of {@link GetCountryNameByISO2 }
     * 
     */
    public GetCountryNameByISO2 createGetCountryNameByISO2() {
        return new GetCountryNameByISO2();
    }

    /**
     * Create an instance of {@link GetCountryNameByISO2Response }
     * 
     */
    public GetCountryNameByISO2Response createGetCountryNameByISO2Response() {
        return new GetCountryNameByISO2Response();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://lavasoft.com/", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

}
