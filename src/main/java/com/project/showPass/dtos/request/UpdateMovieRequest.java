package com.project.showPass.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMovieRequest {

    private Integer movieId;
    private double rating;
    private double duration;

}
