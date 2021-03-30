package com.bank.controller.admin;

import com.bank.dao.model.Client;
import com.bank.service.client_service.client_db.ClientDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final ClientDBService clientDBService;

    @GetMapping("getAll")
    public List<Client> getAllClients() {
        return clientDBService.getAll();
    }
}
