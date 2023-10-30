package com.example.rzd.service;

import com.example.rzd.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class IndexService {
    private final List<AddressObject> listAddressObjects;
    private final List<ItemXml> listItems;
    public String getAddressesInfo(String date, String array) {
        LocalDate localDate = LocalDate.parse(date);
        List<String> idList = Arrays.asList(array.split(", "));
        StringBuilder res = new StringBuilder();
        for (AddressObject addressObject : listAddressObjects) {
            if (addressObject.getEndDate().isAfter(localDate) && addressObject.getStartDate().isBefore(localDate) && idList.contains(addressObject.getObjectId())) {
                if (res.length() != 0) {
                    res.append("\n");
                }
                res.append(addressObject.getObjectId());
                res.append(": ");
                res.append(addressObject.getTypeName());
                res.append(" ");
                res.append(addressObject.getName());
            }
        }
        return res.toString();
    }

    public String getHierarchy(String typeAddress) {
        StringBuilder result = new StringBuilder();
        for (AddressObject addressObject : listAddressObjects) {
            if (addressObject.getTypeName().contains(typeAddress)) {
                if (result.length() != 0) {
                    result.append("\n");
                }
                result.append(getAddress(addressObject.getObjectId()));
            }
        }
        return result.toString();
    }

    private StringBuilder getAddress(String objectId) {
        Optional<AddressObject> optionalAddressObject = listAddressObjects
                .stream()
                .dropWhile(i -> !i.getObjectId().equals(objectId))
                .findFirst();
        if (optionalAddressObject.isEmpty()) {
            return new StringBuilder();
        }
        StringBuilder result = new StringBuilder();
        Optional<ItemXml> optionalItem = listItems.stream().dropWhile(i -> !i.getObjectId().equals(objectId))
                .findFirst();
        if (optionalItem.isPresent() && !optionalItem.get().getParentObjId().equals("0")) {
            result.append(getAddress(optionalItem.get().getParentObjId()));
            if (result.length() > 0) {
                result.append(", ");
            }

        }
        result.append(optionalAddressObject.get().getTypeName());
        result.append(" ");
        result.append(optionalAddressObject.get().getName());
        return result;
    }
}
