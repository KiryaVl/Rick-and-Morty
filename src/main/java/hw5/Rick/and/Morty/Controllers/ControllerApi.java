package hw5.Rick.and.Morty.Controllers;

import hw5.Rick.and.Morty.Domain.Result;
import hw5.Rick.and.Morty.Service.ServiceApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class ControllerApi {

    private final ServiceApi apiService;


    /**
     * Метод вывода всех персонажей из API (~20)
     *
     * @param model
     * @return
     */
    @GetMapping("/start")
    public String showCharacters(Model model) {
        List<Result> characters = apiService.getAllCharacters(); // Изменение здесь
        model.addAttribute("characters", characters);
        return "characters";
    }


    @GetMapping("/")
    public String showRandomCharacters(Model model) {
        List<Result> characters = apiService.getRandomCharacters(20); // Получение 20 случайных персонажей
        model.addAttribute("characters", characters);
        return "characters"; // Возвращает страницу characters.html
    }


    /**
     * Метод поиска персонажа по id
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{id}")
    public String showCharacterDetails(@PathVariable("id") Integer id, Model model) {
        Result character = apiService.getCharacterById(id); // Изменение здесь
        model.addAttribute("character", character);
        return "character";
    }
}
