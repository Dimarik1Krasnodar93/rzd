package com.example.rzd.config;

import com.example.rzd.dto.AddressObject;
import com.example.rzd.dto.AddressObjects;
import com.example.rzd.dto.ItemXml;
import com.example.rzd.dto.ItemsXml;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@Configuration
public class MainConfig {
    @Value("${xml_path}")
    private String xmlPath;
    private final String objFile = "AS_ADDR_OBJ.XML";
    private final String hierarchyFile = "AS_ADM_HIERARCHY.XML";

    @Bean
    public List<AddressObject> listAddressObjects() {
        return (initFile(new File(String.format("%s\\%s", xmlPath, objFile)), AddressObjects.class)).getList();
    }

    @Bean
    public List<ItemXml> listItems() {
        return (initFile(new File(String.format("%s\\%s", xmlPath, hierarchyFile)), ItemsXml.class)).getList();
    }

    private <T> T initFile(File file, Class<T> clazz) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return clazz.cast(unmarshaller.unmarshal(file));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

}
