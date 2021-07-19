package com.life.joker.main;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author zhengdeqi
 * @description 测试1
 * @date 2021/7/9
 */
public class Main1 {

    public static void main(String[] args) {
//        Float f1 = 5.0F;
//        System.out.println(Objects.equals(5.0F, f1));
//
//        Integer i1 = 1;
//        System.out.println(Objects.equals(1, i1));
//
//        Map<String, String> hashMap = new LinkedHashMap<>();
//        hashMap.put("orderId", "1223213");
//        hashMap.put("type", "refund");
//        String jsonStr = JSONUtil.toJsonStr(hashMap);
//        System.out.println(jsonStr);
//        ZonedDateTime zonedDateTime = LocalDate.of(1993, 02, 05).atStartOfDay(ZoneId.systemDefault());
//        int age = DateUtil.age(Date.from(zonedDateTime.toInstant()), new Date());
//        System.out.println(age);
        String idNo = "110101199803073894";
        System.out.println(ageByIdNo(idNo));
    }

    /**
     * 根据身份证计算年龄
     *
     * @param idNo
     * @return
     */
    public static int ageByIdNo(String idNo) {
        String birthday = StringUtils.EMPTY;
        if (StringUtils.isBlank(idNo)) {
            return 0;
        }
        if (idNo.length() == 15) {
            birthday = "19" + idNo.substring(6, 8) + "-" + idNo.substring(8, 10) + "-" + idNo.substring(10, 12);
        } else if (idNo.length() == 18) {
            birthday = idNo.substring(6, 10) + "-" + idNo.substring(10, 12) + "-" + idNo.substring(12, 14);
        }
        return DateUtil.ageOfNow(birthday);
    }
}
