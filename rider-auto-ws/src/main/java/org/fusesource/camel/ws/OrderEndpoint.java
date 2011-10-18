package org.fusesource.camel.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.fusesource.camel.model.Order;

@WebService(targetNamespace = "http://model.camel.fusesource.org", name = "OrderEndpoint")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface OrderEndpoint {

    @WebResult(name = "result", targetNamespace = "http://model.camel.fusesource.org", partName = "result")
    @WebMethod(action = "http://model.camel.fusesource.org/Order")
    public java.lang.String order(
        @WebParam(partName = "in", name = "order", targetNamespace = "http://model.camel.fusesource.org")
        Order in
    );
}
