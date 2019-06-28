package com.example.AwesomeCompan.demo.controller;

import com.example.AwesomeCompan.demo.entity.Character;
import com.example.AwesomeCompan.demo.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ApiController {
    @Autowired
    CharacterService characterService;

    @GetMapping(value = {"/character"})
    public String characterPage(@RequestParam(required = false, name = "id") Long id, Model model) {
        if (id == null) {
            id = (long) (Math.random() * characterService.findByMaxId());
        }
        Character character = characterService.findCharacter(id);
        model.addAttribute("character", character);
        return "character";
    }

    @GetMapping(value = {"/character/search"})
    public String mainPage(@RequestParam(value = "name") String name, Model model) {
        List<Character> characters = characterService.findByName(name);
        model.addAttribute("characters", characters);
        return "search";
    }

    @GetMapping({"/character/avatar/{id}"})
    @ResponseBody
    public byte[] getImage(@PathVariable Long id) {

        Character character = characterService.findCharacter(id);

        return character.getAvatar();
    }

}
