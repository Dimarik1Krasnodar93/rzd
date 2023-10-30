package com.example.rzd.controller;

import com.example.rzd.RzdApplication;
import com.example.rzd.service.IndexService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = RzdApplication.class)
class IndexControllerTest {

    @Autowired
    private IndexService indexService;

    @Test
    void getAddressesInfo() {
        String date = "2010-01-01";
        String strArray = "1422396, 1450759, 1449192, 1451562";
        String expected = "1422396: ул Северная\n" +
                "1450759: р-н Заполярный\n" +
                "1449192: п Нельмин Нос\n" +
                "1451562: п Екуша";
        String result = indexService.getAddressesInfo(date, strArray);
        assertEquals(result, expected);
    }

    @Test
    void getAddressesInfo2() {
        String date = "2010-01-01";
        String strArray = "1422396";
        String expected = "1422396: ул Северная";
        String result = indexService.getAddressesInfo(date, strArray);
        assertEquals(result, expected);
    }

    @Test
    void getHierarchyEquals() {
        String typeAddress = "проезд";
        String result = indexService.getHierarchy(typeAddress);
        String expected = "АО Ненецкий, г Нарьян-Мар, проезд Лесопильщиков\n" +
                "АО Ненецкий, г Нарьян-Мар, проезд Брусничный\n" +
                "АО Ненецкий, г Нарьян-Мар, проезд Ноябрьский\n" +
                "АО Ненецкий, г Нарьян-Мар, проезд Им капитана Матросова\n" +
                "АО Ненецкий, г Нарьян-Мар, проезд Торговый\n" +
                "АО Ненецкий, г Нарьян-Мар, проезд Качгортский\n" +
                "АО Ненецкий, рп Искателей, проезд Лая-Вожский\n" +
                "АО Ненецкий, рп Искателей, проезд Песчаный\n" +
                "АО Ненецкий, г Нарьян-Мар, проезд Ветеринарный\n" +
                "АО Ненецкий, г Нарьян-Мар, проезд Стивидоров\n" +
                "АО Ненецкий, рп Искателей, проезд Вертолетный\n" +
                "АО Ненецкий, г Нарьян-Мар, проезд Карьерный\n" +
                "АО Ненецкий, г Нарьян-Мар, проезд Производственный";
        assertEquals(result, expected);
    }
    @Test
    void getHierarchyEmpty() {
        String typeAddress = "несуществующий_тип";
        String result = indexService.getHierarchy(typeAddress);
        String expected = "";
        assertEquals(result, expected);
    }
}