package dimigo.EternalStat.repository;

        import dimigo.EternalStat.domain.User;

        import java.util.ArrayList;
        import java.util.Optional;

public interface StatRepository {
    User save(User user);
    ArrayList<User> findAll();
    Optional<User> findById(String id);
}

//User DB 접근에 사용할 레포지토리 함수들