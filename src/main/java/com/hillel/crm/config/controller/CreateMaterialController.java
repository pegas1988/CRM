package com.hillel.crm.config.controller;

import com.hillel.crm.config.entity.Material;
import com.hillel.crm.config.service.MaterialService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CreateMaterialController implements Controller{

    MaterialService materialService = new MaterialService();

    public CreateMaterialController() throws SQLException {
    }

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("materialName");
        String quantity = req.getParameter("quantity");
        String colour = req.getParameter("colour");
        String type = req.getParameter("type");
        String price = req.getParameter("price");
        Material material = new Material();
        material.setColour(colour);
        material.setMaterialName(name);
        material.setPrice(Integer.parseInt(price));
        material.setQuantity(Integer.parseInt(quantity));
        material.setType(type);
        //materialService.createMaterial(material);
        return new ControllerResultDto("materialCreated", true);

    }
}
