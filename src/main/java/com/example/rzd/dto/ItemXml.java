package com.example.rzd.dto;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemXml {
    @XmlAttribute(name = "ID")
    private String id;
    @XmlAttribute(name = "OBJECTID")
    private String objectId;
    @XmlAttribute(name = "PARENTOBJID")
    private String parentObjId;
    @XmlAttribute(name = "CHANGEID")
    private String changeId;
    @XmlAttribute(name = "PREVID")
    private String prevId;
    @XmlAttribute(name = "NEXTID")
    private String nextId;
    @XmlAttribute(name = "UPDATEDATE")
    private String updateDate;
    @XmlAttribute(name = "STARTDATE")
    private String startDate;
    @XmlAttribute(name = "ENDDATE")
    private String endDate;
    @XmlAttribute(name = "ISACTIVE")
    private String isActive;
}
