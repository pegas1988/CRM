package com.hillel.crm.config.controller;

import com.hillel.crm.config.entity.Material;
import com.hillel.crm.config.service.MaterialService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteMaterialController implements Controller {
    private MaterialService materialService = new MaterialService();

    public DeleteMaterialController() throws SQLException {
    }

    @Override

    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("materialName");
        Material material = new Material();
        material.setMaterialName(name);
       // materialService.deleteFromMaterial(material);
        req.getSession().setAttribute("material", material);
        return new ControllerResultDto("deleteMaterial", true);

    }
}