package de.htw.berlinwebtech.webtechprojectportal.web;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class Review {
    private Long reviewId;
    private Long reviewerID;
    private Long targetUserID;
    private int rating;
    private String comment;
    private LocalDate date;

}
