package org.seckill.dto;

import java.util.List;

/**
 * Created by yezhaoyi on 16/9/24.
 */
public class Menu {
    List<RoleDto>roleDtos = null ;

    public List<RoleDto> getRoleDtos() {
        return roleDtos;
    }

    public void setRoleDtos(List<RoleDto> roleDtos) {
        this.roleDtos = roleDtos;
    }
}
