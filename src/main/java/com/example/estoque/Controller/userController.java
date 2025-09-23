package com.example.estoque.Controller;


import com.example.estoque.Service.userService;
import com.example.estoque.models.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class userController {

    private final userService userService;
    public userController(userService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return userService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario buscarbyId(@PathVariable Long id){
        return userService.buscarPorId(id);
    }

    @PostMapping
    public Usuario salvarUser(@RequestBody Usuario usuario){
        return userService.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUser(@PathVariable long id, @RequestBody Usuario usuario){
        usuario.setId(id);
        return userService.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable long id){
        userService.delete(id);
    }
}
