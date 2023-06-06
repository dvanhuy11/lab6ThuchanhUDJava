package fit.hutech.phanthithanhtuyen.BT6.Controller;

import fit.hutech.phanthithanhtuyen.BT6.model.Khoa;
import fit.hutech.phanthithanhtuyen.BT6.model.SinhVien;
import fit.hutech.phanthithanhtuyen.BT6.service.KhoaService;
import fit.hutech.phanthithanhtuyen.BT6.service.SinhVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/khoa")
public class KhoaController {
    @Autowired
    private KhoaService khoaService;
    @GetMapping("/view")
    public String index(Model model){
        model.addAttribute("listKhoa", khoaService.get());
        return "khoas/index";
    }
    @GetMapping("/addnew")
    public String add(Model model){
        Khoa khoa = new Khoa();
        model.addAttribute("khoa",khoa);
        return "khoas/add";
    }
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("khoa") Khoa khoa, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "khoas/add";
        }

        khoaService.save(khoa);
        return "redirect:/khoa/view";
    }
    @GetMapping("del/{id}")
    public String removeItem(@PathVariable("id")Long id) {
        khoaService.del(id);
        return "redirect:/khoas/view";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Khoa edit = khoaService.getById(id);
        if (edit != null) {
            model.addAttribute("khoa", edit);
            return "khoas/edit";
        } else {
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("khoa") Khoa updated, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "layouts/edit";
        }

        khoaService.save(updated);
        return "redirect:/khoa/view";
    }

}