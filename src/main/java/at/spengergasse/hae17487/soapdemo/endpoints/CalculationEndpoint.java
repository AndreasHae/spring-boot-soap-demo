package at.spengergasse.hae17487.soapdemo.endpoints;

import at.spengergasse.hae17487.soapdemo.schema.AddNumbersRequest;
import at.spengergasse.hae17487.soapdemo.schema.AddNumbersResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CalculationEndpoint {
    private static final String NAMESPACE_URI = "http://spengergasse.at/hae17487/soapdemo/schema";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addNumbersRequest")
    @ResponsePayload
    public AddNumbersResponse addNumbers(@RequestPayload AddNumbersRequest request) {
        var response = new AddNumbersResponse();
        response.setResult(request.getNumber().stream().mapToInt(Integer::intValue).sum());
        return response;
    }
}
