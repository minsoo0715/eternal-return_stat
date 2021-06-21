package dimigo.EternalStat.repository;

import dimigo.EternalStat.domain.Tip;

import java.util.ArrayList;

public interface TipRepository {
    Tip save(Tip tip);
    ArrayList<Tip> findAll();
    Tip findById(int id);
    ArrayList<Tip> findAllByCh(String ch);
    ArrayList<Tip> findAllByType(String type);
    void deleteById(int id);

}

//Tips DB 접근에 사용할 레포지토리 함수들
