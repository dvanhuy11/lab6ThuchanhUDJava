package fit.hutech.phanthithanhtuyen.BT6.Controller;

import fit.hutech.phanthithanhtuyen.BT6.model.SinhVien;
import fit.hutech.phanthithanhtuyen.BT6.service.SinhVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/sinhvien")
public class SinhVienController {
    @Autowired
    private  SinhVienService sinhVienService;
    @GetMapping("/view")
    public String index(Model model){
        model.addAttribute("listSV", sinhVienService.getAllSV());
        return "layouts/index";
    }
    @GetMapping("/addnew")
    public String add(Model model){
        SinhVien sinhVien = new SinhVien();
        model.addAttribute("sinhvien",sinhVien);
        return "layouts/add";
    }
/*    @PostMapping("/save")
    public String save(@ModelAttribute("sinhvien") SinhVien sinhVien) {
        sinhVienService.saveSV(sinhVien);
        return "redirect:/sinhvien/view";
    }*/
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("sinhvien") SinhVien sinhVien, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
        return "layouts/add";
    }

    sinhVienService.saveSV(sinhVien);
    return "redirect:/sinhvien/view";
    }
    @GetMapping("del/{id}")
    public String removeItem(@PathVariable("id")Long id) {
        sinhVienService.delSV(id);
        return "redirect:/sinhvien/view";
    }

    /*@GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        SinhVien editSV = null;
        for(SinhVien sinhVien : sinhVienService.getAllSV()){
            if(sinhVien.getId().equals(id)){
                editSV = sinhVien;
            }
        }
        if(editSV != null){
            model.addAttribute("sinhvien",editSV);
            return "layouts/edit";
        }else{
            return "not-found";
        }
    }
    @PostMapping ("/edit")
    public String edit(@Valid @ModelAttribute("nv") SinhVien updatedSV
            , BindingResult bindingResult, Model model)throws IOException {
        if(bindingResult.hasErrors()){
            return "layouts/edit";
        }

        for(int i = 0; i<sinhVienService.getAllSV().size();i++){
            SinhVien sinhVien = sinhVienService.getAllSV().get(i);
            if(sinhVien.getId() == updatedSV.getId()){
                sinhVienService.getAllSV().set(i,updatedSV);
                sinhVienService.saveSV(updatedSV);
                break;
            }
        }
        return "redirect:/sinhvien/view";
    }*/
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        SinhVien editSV = sinhVienService.getSVById(id);
        if (editSV != null) {
            model.addAttribute("sinhvien", editSV);
            return "layouts/edit";
        } else {
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("sinhvien") SinhVien updatedSV, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "layouts/edit";
        }

        sinhVienService.saveSV(updatedSV);
        return "redirect:/sinhvien/view";
    }

}