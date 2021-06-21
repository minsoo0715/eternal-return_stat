package dimigo.EternalStat.repository;

import dimigo.EternalStat.domain.Tip;
import org.springframework.data.jpa.repository.JpaRepository;



public interface SpringDataJPATipRepository extends TipRepository, JpaRepository<Tip, Integer> {
}

//Data-jpa를 위해 상속관계를 정함