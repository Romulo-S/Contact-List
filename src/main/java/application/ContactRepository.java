package application;

import org.springframework.data.jpa.repository.JpaRepository;
import pojo.Contact;
import pojo.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {
}
