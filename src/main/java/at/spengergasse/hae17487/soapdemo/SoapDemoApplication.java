package at.spengergasse.hae17487.soapdemo;

import at.spengergasse.hae17487.soapdemo.persistence.Person;
import at.spengergasse.hae17487.soapdemo.persistence.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@RequiredArgsConstructor

@SpringBootApplication
public class SoapDemoApplication {

    private final PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(SoapDemoApplication.class, args);
    }

    @PostConstruct
    public void init() {
        var people = List.of(
                Person.builder().name("Joseph").age(35).occupation("Programmer").company("Microsoft").build(),
                Person.builder().name("Alex").age(21).occupation("Marketing intern").company("WeBound").build(),
                Person.builder().name("Christoph").age(41).occupation("Manager").company("Billa").build(),
                Person.builder().name("Florian").age(29).occupation("Senior programmer").company("SalesForce").build(),
                Person.builder().name("Elliot").age(23).occupation("Cybersecurity consultant").company("EvilCorp").build()
        );
        personRepository.saveAll(people);
    }

}
