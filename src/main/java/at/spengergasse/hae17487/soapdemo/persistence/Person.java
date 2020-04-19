package at.spengergasse.hae17487.soapdemo.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Person extends AbstractPersistable<Long> {

    private String name;
    private int age;
    private String occupation;
    private String company;

}
