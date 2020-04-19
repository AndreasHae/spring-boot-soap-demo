package at.spengergasse.hae17487.soapdemo.endpoints;

import at.spengergasse.hae17487.soapdemo.persistence.PersonRepository;
import at.spengergasse.hae17487.soapdemo.schema.GetPeopleByAgeRequest;
import at.spengergasse.hae17487.soapdemo.schema.GetPeopleResponse;
import at.spengergasse.hae17487.soapdemo.schema.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@RequiredArgsConstructor

@Endpoint
public class PersonEndpoint {
    private static final String NAMESPACE_URI = "http://spengergasse.at/hae17487/soapdemo/schema";

    private final PersonRepository personRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPeopleByAgeRequest")
    @ResponsePayload
    public GetPeopleResponse getPeopleByAge(@RequestPayload GetPeopleByAgeRequest request) {
        var response = new GetPeopleResponse();

        for (var person : personRepository.findByAgeBetween(request.getMinAge(), request.getMaxAge())) {
            var personDTO = new Person();
            personDTO.setName(person.getName());
            personDTO.setAge(person.getAge());
            personDTO.setOccupation(person.getOccupation());
            personDTO.setCompany(person.getCompany());
            response.getPerson().add(personDTO);
        }
        return response;
    }
}