package com.ec.Zoo.controller;

import com.ec.Zoo.dto.Mensaje;
import com.ec.Zoo.security.dto.NuevoUsuario;
import com.ec.Zoo.security.entity.Usuario;
import com.ec.Zoo.service.UsuariosService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {
    @Autowired
    UsuariosService usuarioService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Usuario>> list(){
        List<Usuario> list = usuarioService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
