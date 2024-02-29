package med.voll.api.controller;

import med.voll.api.doctor.DataRegistrationDoctor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @PostMapping("/register")
    public void register(@RequestBody DataRegistrationDoctor data){
        System.out.println(data);
    }
    @GetMapping
    public String ok(){
        return "ok";
    }
}
