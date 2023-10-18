package com.example.discgolf.controller;

import com.example.discgolf.model.Permission;
import com.example.discgolf.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/permissions")  // Base URL for all endpoints in this controller
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    // Fetch all permissions
    @GetMapping
    public ResponseEntity<List<Permission>> getAllPermissions() {
        return ResponseEntity.ok(permissionService.getAllPermissions());
    }

    // Fetch a specific permission by ID
    @GetMapping("/{id}")
    public ResponseEntity<Permission> getPermissionById(@PathVariable Long id) {
        return permissionService.getPermissionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new permission
    @PostMapping
    public ResponseEntity<Permission> createPermission(@RequestBody Permission permission) {
        return ResponseEntity.ok(permissionService.savePermission(permission));
    }

    // Update a permission
    @PutMapping("/{id}")
    public ResponseEntity<Permission> updatePermission(@PathVariable Long id, @RequestBody Permission updatedPermission) {
        if (!permissionService.getPermissionById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        updatedPermission.setId(id);  // Ensure the ID is set to the one from the path
        return ResponseEntity.ok(permissionService.savePermission(updatedPermission));
    }

    // Delete a permission
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermission(@PathVariable Long id) {
        if (!permissionService.getPermissionById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        permissionService.deletePermission(id);
        return ResponseEntity.noContent().build();  // 204 No Content response
    }
}
