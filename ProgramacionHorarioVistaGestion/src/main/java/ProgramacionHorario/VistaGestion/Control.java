package ProgramacionHorario.VistaGestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Control {

    @Autowired
    private Servicio s;

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("entrada", new Entrada());
        return "login";
    }

    @PostMapping("/validar")
    public String validar(Entrada ent, Model model) {
        Usuario u = s.validar(ent);

        if (u != null) {
            model.addAttribute("usuario", u);
            return "redirect:/inicio";
        }

        model.addAttribute("error", "ID o contraseña incorrectos");
        model.addAttribute("entrada", ent);
        return "login";
    }

    @GetMapping("/inicio")
    public String menu(Model model) {
        return "inicio";
    }

    @GetMapping("/medicos")
    public String medicos(Model model) {
        model.addAttribute("lista", s.listarMedicos());
        return "medicos";
    }

    @GetMapping("/programacion")
    public String programacion(Model model) {
        model.addAttribute("medicos", s.listarMedicos());
        model.addAttribute("franjas", s.listarFranjas());
        model.addAttribute("programaciones", s.listarProgramaciones());
        return "programacion";
    }

    @PostMapping("/programacion/grabar")
    public String grabarProgramacion(ProgramacionHorario p) {
        s.grabarProgramacion(p);
        return "redirect:/programacion";
    }
}
