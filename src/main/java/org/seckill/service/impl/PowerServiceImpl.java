package org.seckill.service.impl;

import org.seckill.dao.AdminRoleMapper;
import org.seckill.dao.RoleAcvicityMapper;
import org.seckill.dto.FunctionDto;
import org.seckill.dto.RoleDto;
import org.seckill.entity.Admin;
import org.seckill.entity.AdminRole;
import org.seckill.entity.RoleAcvicity;
import org.seckill.service.PowerService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yezhaoyi on 16/9/10.
 */
@Service
public class PowerServiceImpl implements PowerService {
    @Resource
    private AdminRoleMapper adminRoleMapper ;
    @Resource
    private RoleAcvicityMapper roleAcvicityMapper;
    public void checkPower(HttpSession session , HttpServletRequest request) {
        Admin admin = (Admin)session.getAttribute("admin");
        Integer adminCode = admin.getAdminCode();
        List<AdminRole>  adminRoles =  adminRoleMapper.selectByAdminCode(adminCode);
        List <RoleDto> roleDtos = new ArrayList<RoleDto>();
        RoleDto roleDto = null ;
        FunctionDto functionDto = null ;
        for(AdminRole adminRole :adminRoles){
            roleDto = new RoleDto();
            roleDto.setRoleName(adminRole.getRoleConfig().getRoleName());
            Integer roleId = adminRole.getRoleId();
            List<RoleAcvicity> roleAcvicities =  roleAcvicityMapper.selectbyRoleId(roleId);
            List<FunctionDto> functionDtos = new ArrayList<FunctionDto>();
            for(RoleAcvicity roleAcvicity:roleAcvicities){
                functionDto = new FunctionDto();
                functionDto.setFunctionName(roleAcvicity.getAcvicityConfig().getAcvicityName());
                functionDto.setFunctionUrl(roleAcvicity.getAcvicityConfig().getAcvicityUrl());
                functionDtos.add(functionDto);
            }
            roleDto.setFunctionDtos(functionDtos);
            roleDtos.add(roleDto);
        }
        request.setAttribute("roleDtos",roleDtos); ;
    }
}
