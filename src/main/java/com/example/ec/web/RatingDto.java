package com.example.ec.web;

<<<<<<< HEAD
import org.springframework.hateoas.ResourceSupport;

=======
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Data Transfer Object for Rating a Tour.
 *
 * Created by Mary Ellen Bowman
 */
<<<<<<< HEAD

public class RatingDto  extends ResourceSupport {
=======
public class RatingDto {
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14

    @Min(0)
    @Max(5)
    private Integer score;

    @Size(max = 255)
    private String comment;

    @NotNull
    private Integer customerId;

    /**
     * Constructor to fully initialize the RatingDto
     *
<<<<<<< HEAD
     * @param score score
     * @param comment comment
     * @param customerId customer identifier
=======
     * @param score
     * @param comment
     * @param customerId
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
     */
    public RatingDto(Integer score, String comment, Integer customerId) {
        this.score = score;
        this.comment = comment;
        this.customerId = customerId;
    }

    protected RatingDto() {}

    public Integer getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

}
