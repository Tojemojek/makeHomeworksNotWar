package pl.kostrowski.mtga.welcome;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

    @RequestMapping("/")
    public String przywitajGrzecznie() {
        return "Witam szanownego użytkownika!";
    }

}
