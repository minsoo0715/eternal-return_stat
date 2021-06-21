package dimigo.EternalStat.controller;

import dimigo.EternalStat.TipForm;
import dimigo.EternalStat.TipModifyForm;
import dimigo.EternalStat.chForm;
import dimigo.EternalStat.domain.Tip;
import dimigo.EternalStat.service.TipService;
import dimigo.EternalStat.typeForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
public class TipController {

    private TipService ts;

    public TipController(TipService tipService) {
        this.ts = tipService;
    }

    @GetMapping("/tip/create") //팁 생성을 위한 화면으로 매핑
    public String Create() {
        return "createTip";
    }

    @PostMapping("/tip/create") //createTip.html에서 입력받은 데이터를 받는 POST 매핑
    public String CreatePost(TipForm tipForm) {
        Tip tip = new Tip();
        tip.setCh(tipForm.getCh());
        tip.setText(tipForm.getContext());
        tip.setTitle(tipForm.getTitle());
        tip.setType(tipForm.getType());
        ts.createTip(tip); //팁을 DB에 넣음.

        return "redirect:/tip/list";
    }



    @GetMapping("/tip/list")
    public String Tiplist(Model m) { //팁 리스트를 보여주는 매핑
        ArrayList<Tip> tips = ts.getAll();
        m.addAttribute("list", tips);
        return "tip_list";
    }

    @GetMapping(path="tip/view/{Id}")
    public String tip_view(Model m, @PathVariable(name="Id") Integer id) { //팁 목록에서 제목을 눌렀을때 게시물 정보를 보여줌
        Tip tips = ts.GetTipById(id);
        m.addAttribute("data", tips);
        return "tip_bulletin";

    }

    @GetMapping(path="tip/delete/{Id}") //팁을 삭제하기 위한 매핑
    public String tip_delete(Model m, @PathVariable(name="Id") Integer id) {
        ts.deleteTip(id);
        return "tip_list";
    }

    @GetMapping(path="tip/modify/{Id}") //팁을 수정하기 위한 매핑
    public String tip_modify(Model m, @PathVariable(name="Id") Integer id) {
        Tip tip = new Tip();
        tip = ts.GetTipById(id);
        m.addAttribute("data", tip);
        return "modifyTip";
    }

    @PostMapping(path="tip/search/type") //검색 데이터(타입)이 넘어올 포스트 매핑
    public String tip_search_title(Model m, typeForm tf, RedirectAttributes redirectAttributes) {
        ArrayList<Tip> tip = ts.searchTipWithType(tf.getType());
        redirectAttributes.addFlashAttribute("data", tip); //리다이렉트 시 데이터를 보내기 위함
        return "redirect:/tip/searchlist";
    }

    @PostMapping(path="tip/search/ch") //검색 데이터(캐릭터)이 넘어올 포스트 매핑
    public String tip_search_ch(Model m, chForm cf, RedirectAttributes redirectAttributes) {
        ArrayList<Tip> tip = ts.searchTipWithCh(cf.getCh());
        redirectAttributes.addFlashAttribute("data", tip); //리다이렉트 시 데이터를 보내기 위함
        return "redirect:/tip/searchlist";
    }

    @GetMapping(path="tip/searchlist") //검색한 결과를 view로 넘겨주는 겟 매핑
    public String searchList(Model m, @ModelAttribute("data")Tip tip) {
        m.addAttribute("list", tip);
        return "tip_list";
    }

    @PostMapping(path="tip/modify") //팁을 수정하기 위한 포스트 매핑
    public String tip_modify_post(TipModifyForm tipModifyForm) {
        Tip tip = new Tip();
        tip.setId(tipModifyForm.getId());
        tip.setType(tipModifyForm.getType());
        tip.setTitle(tipModifyForm.getTitle());
        tip.setCh(tipModifyForm.getCh());
        tip.setText(tipModifyForm.getContext());
        ts.createTip(tip); //id값을 원래있던 값으로 지정해주면서 update 쿼리가 실행됨..
        return "redirect:/tip/list"; //다시 리스트로 리다이렉팅
    }


}