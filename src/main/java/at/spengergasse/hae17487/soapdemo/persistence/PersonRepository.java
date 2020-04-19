package at.spengergasse.hae17487.soapdemo.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    Set<Person> findByAgeBetween(int minAge, int maxAge);

}
