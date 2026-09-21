package org.hm.controller.rest;
import org.hm.dto.ClientDto;
import org.hm.dto.ProductDto;
import org.hm.dto.RoleDto;
import org.hm.dto.UserDto;
import org.hm.service.ClientService;
import org.hm.service.ProductService;
import org.hm.service.RoleService;
import org.hm.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/referentiel")
public class ReferentielController {

    private final ProductService productService;
    private final ClientService clientService;
    private final UserService userService;
    private final RoleService roleService;

    public ReferentielController(
            ProductService productService,
            ClientService clientService,
            UserService userService,
            RoleService roleService) {

        this.productService = productService;
        this.clientService = clientService;
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/products")
    public List<ProductDto> products() {
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public ProductDto product(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/clients")
    public List<ClientDto> clients() {
        return clientService.findAll();
    }

    @GetMapping("/clients/{id}")
    public ClientDto client(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @GetMapping("/users")
    public List<UserDto> users() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public UserDto user(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/roles")
    public List<RoleDto> roles() {
        return roleService.findAll();
    }

    @GetMapping("/roles/{id}")
    public RoleDto role(@PathVariable Long id) {
        return roleService.findById(id);
    }
}