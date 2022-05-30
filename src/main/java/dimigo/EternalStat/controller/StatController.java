package dimigo.EternalStat.controller;

import dimigo.EternalStat.dto.StatForm;
import dimigo.EternalStat.domain.User;
import dimigo.EternalStat.service.StatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StatController {

    private StatService ss;

    public StatController(StatService ss) {
        this.ss = ss;
    }


    @GetMapping(path="/Users/refresh/{Id}") //아이디를 받아서 외부 API에서 데이터를 받아오고, DB에 저장
    public String refresh(Model m, @PathVariable(name="Id") String id) {
        User user = ss.loadById(id);
        m.addAttribute("user", user);
        return "search";
    }


    @PostMapping("/Users/ex") //유저 검색을 받는 POST 매핑
    public String extraUserTest(StatForm statForm, RedirectAttributes redirectAttributes){
        String id = statForm.getId();
        User user = ss.Search(id);
        redirectAttributes.addAttribute("user", user); //리다이렉트를 하면서 데이터를 보존함
        return "redirect:/Users/search";
    }

    @GetMapping("/Users/search") //검색 완료됬을때 검색 결과를 화면에 보여주는 매핑
    public String search(Model model, @ModelAttribute("user")User user) { //리다이렉트 속성에서 USER값을 가져옴
        model.addAttribute("user", user);
        System.out.print(user.getId());
        return "search";
    }


}