package com.example.rzd.dto;

import lombok.Getter;
import lombok.Setter;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "ITEMS")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class ItemsXml {
    @XmlElement(name = "ITEM")
    private List<ItemXml> list;
}
