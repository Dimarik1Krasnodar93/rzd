package com.example.rzd.controller;

import com.example.rzd.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IndexController {
    private final IndexService indexService;
    /**
    * Метод по перенному набору идентификаторов OBJECTID выводит описание адресов на определенную дату
    * @param date дата, на которую выводится описание адресов в формате 2010-01-01
    * @param array переданный набор идентификаторов
    * */
    @GetMapping("/addressesInfo")
    public String getAddressesInfo(@RequestParam("date") String date, @RequestParam("array") String array) {
        return indexService.getAddressesInfo(date, array);
    }

    /**
    * Метод выводит полностью иерархию адресов, с отбором по строке, которая содержится в типе адреса в XML файле
    * @param typeAddress слово, которое должно содержаться в типе адреса
    * */
    @GetMapping("/hierarchy")
    public String getHierarchy(@RequestParam("typeAddress") String typeAddress) {
        return indexService.getHierarchy(typeAddress);
    }
}
