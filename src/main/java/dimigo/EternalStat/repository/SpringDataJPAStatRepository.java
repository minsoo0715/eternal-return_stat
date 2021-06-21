package dimigo.EternalStat.repository;

import dimigo.EternalStat.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface SpringDataJPAStatRepository extends StatRepository, JpaRepository<User, String> {

}
//Data-jpa를 위해 상속관계를 정함