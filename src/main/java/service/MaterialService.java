package service;

import config.ApplicationConfig;
import dao.impl.MaterialDaoImpl;
import entity.Material;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Service
public class MaterialService {

    //ApplicationConfig applicationConfig = new ApplicationConfig();

    //MaterialDaoImpl materialDao = new MaterialDaoImpl(applicationConfig.dataSource());
    MaterialDaoImpl materialDao = new MaterialDaoImpl();

    public MaterialService() throws SQLException {
    }

    public void createMaterial(Material material) {
        materialDao.createNewMaterial(material);
    }

    public void deleteFromMaterial(Material material) {
        materialDao.deleteFromMaterialByName(material);
    }

    public List<Material> findAllMaterials() {
        return materialDao.findAll();
    }

    public List<Material> findByType(String type) {
        return materialDao.findByType(type);
    }

    public void updateMaterial(Material material, int id) {
        materialDao.updateMaterial(material, id);
    }

    public int getMaterialIDByName(Material material) {
        return materialDao.materialID(material);
    }
}
