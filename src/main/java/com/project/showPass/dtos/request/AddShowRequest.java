package com.project.showPass.dtos.request;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data // equivalent to @Getter, @Setter, @ReqArgsCons, @ToString @EqualsAndHashCode
public class AddShowRequest {

    // DTO are lightweight object with custom attributes, act as encapsulator for external system

    private LocalDate showDate;
    private LocalTime showTime;
    private String movieName;
    private Integer theaterId;

}
