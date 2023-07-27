package com.omar.gestiondestock.dto;

import com.omar.gestiondestock.model.MvtStk;
import com.omar.gestiondestock.model.Role;
import com.omar.gestiondestock.model.Utilisateur;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoleDto {

    private Integer id;

    private String roleName;

    private UtilisateurDto utilisateur;


    public static RoleDto fromEntity(Role role){
        if (role == null){
            return null;
        }
        return RoleDto.builder()
                .id(role.getId())
                .roleName(role.getRoleName())
                .utilisateur(UtilisateurDto.fromEntity(role.getUtilisateur()))
                .build();

    }

    public static Role toEntity(RoleDto roleDto){
        if(roleDto == null){
            return null;
        }

        Role role  = new Role();
        role.setId(roleDto.getId());
        role.setRoleName(roleDto.getRoleName());

        return role;
    }
}
