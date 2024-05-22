package co.com.sofka.Constantes;

import java.util.HashMap;

public class HeaderConfiguration {
    public static HashMap<String, Object> headers(){
        HashMap<String, Object> headersCollection = new HashMap<>();
        headersCollection.put("Content-Type","text/xml;charset=UTF-8");
        headersCollection.put("SOAPAction","");
        return headersCollection;
    }
}
