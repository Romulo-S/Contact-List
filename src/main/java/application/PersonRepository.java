package application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pojo.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
}
