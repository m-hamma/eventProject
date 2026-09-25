package org.hm.controller.rest;
import org.hm.dto.ClientDto;
import org.hm.dto.ProductDto;
import org.hm.dto.RoleDto;
import org.hm.dto.UserDto;
import org.hm.service.ClientService;
import org.hm.service.ProductService;
import org.hm.service.RoleService;
import org.hm.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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
    public Page<UserDto> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);

        return userService.findAll(pageable);
    }
    @GetMapping("/users/{id}")
    public UserDto user(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/roles")
    public Page<RoleDto> roles(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);

        return roleService.findAll(pageable);
    }

    @GetMapping("/roles/{id}")
    public RoleDto role(@PathVariable Long id) {
        return roleService.findById(id);
    }
}