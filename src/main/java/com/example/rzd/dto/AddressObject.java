package com.example.rzd.dto;

import com.example.rzd.adapters.LocalDateAdapter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressObject {
    @XmlAttribute(name = "ID")
    private String id;
    @XmlAttribute(name = "OBJECTID")
    private String objectId;
    @XmlAttribute(name = "OBJECTGUID")
    private String objectGuid;
    @XmlAttribute(name = "CHANGEID")
    private String changeId;
    @XmlAttribute(name = "NAME")
    private String name;
    @XmlAttribute(name = "TYPENAME")
    private String typeName;
    @XmlAttribute(name = "LEVEL")
    private String level;
    @XmlAttribute(name = "OPERTYPEID")
    private String operTypeId;
    @XmlAttribute(name = "PREVID")
    private String prevId;
    @XmlAttribute(name = "NEXTID")
    private String nextId;
    @XmlAttribute(name = "UPDATEDATE")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate updateDate;
    @XmlAttribute(name = "STARTDATE")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate startDate;
    @XmlAttribute(name = "ENDDATE")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate endDate;
    @XmlAttribute(name = "ISACTUAL")
    private String isactual;
    @XmlAttribute(name = "ISACTIVE")
    private String isactive;
}
