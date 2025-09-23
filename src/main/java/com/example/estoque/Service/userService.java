package com.example.estoque.Service;

import com.example.estoque.models.Usuario;
import com.example.estoque.repository.userRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {
    private final userRepository userRepository;
    public userService(userRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Usuario> listarUsuarios() {
        return userRepository.findAll();
    }

    public Usuario buscarPorId(long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
    }

    public Usuario buscarPorEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
    }
    public Usuario save(Usuario usuario) {
        return userRepository.save(usuario);
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
