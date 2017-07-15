package org.seckill.dto;

import java.util.List;

/**
 * Created by yezhaoyi on 16/9/24.
 */
public class RoleDto {
    private  String roleName ;
    private List<FunctionDto> functionDtos ;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<FunctionDto> getFunctionDtos() {
        return functionDtos;
    }

    public void setFunctionDtos(List<FunctionDto> functionDtos) {
        this.functionDtos = functionDtos;
    }
}
