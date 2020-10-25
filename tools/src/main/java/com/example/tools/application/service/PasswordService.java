package com.example.tools.application.service;

import com.example.tools.application.utils.Passwords;
import com.example.tools.persistence.model.Password;
import com.example.tools.persistence.repository.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author darcy
 * @since 2020/10/25
 **/
@Service
@Validated
public class PasswordService {

    @Autowired
    private PasswordRepository passwordRepository;

    public List<Password> findAll() {
        List<Password> passwords = passwordRepository.findAll();
        return passwords.stream()
                .peek(password -> password.setPassword(Passwords.decode(password.getPassword())))
                .collect(Collectors.toList());
    }

    @Transactional
    public void save(@NotBlank String name, @NotBlank String password) {
        String encode = Passwords.encode(password);
        Password save = passwordRepository.findByName(name)
                .map(oldPassword -> {
                    oldPassword.setPassword(encode);
                    return oldPassword;
                }).orElseGet(() -> {
                    Password newPassword = new Password();
                    newPassword.setName(name);
                    newPassword.setPassword(encode);
                    return newPassword;
                });
        passwordRepository.save(save);
    }
}
