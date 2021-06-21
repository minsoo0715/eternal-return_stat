package dimigo.EternalStat.service;

import dimigo.EternalStat.domain.Tip;
import dimigo.EternalStat.repository.TipRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TipService {
    TipRepository tipRepository;

    public TipService(TipRepository tipRepository) {
        this.tipRepository = tipRepository;
    }

    public void createTip(Tip tip) {
        tipRepository.save(tip);
    } //팁 생성

    public Tip GetTipById(int id) {
        return tipRepository.findById(id);
    } //팁 받아오기


    public ArrayList<Tip> searchTipWithCh(String ch) {
        return tipRepository.findAllByCh(ch);
    } //팁 검색(캐릭터)

    public ArrayList<Tip> searchTipWithType(String type) {
        return tipRepository.findAllByType(type);
    }
    //팁 검색(종류)

    public ArrayList<Tip> getAll() { //모든 tip들을 다 가져옴
        return tipRepository.findAll();
    }

    public void deleteTip(int id) {
        tipRepository.deleteById(id);
    } //tip을 id를 통해 삭제



}
