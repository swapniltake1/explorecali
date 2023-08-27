package com.example.ec.domain;

<<<<<<< HEAD
import javax.persistence.*;
=======
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
import java.util.Objects;

/**
 * Rating of a Tour by a Customer
 *
 * Created by Mary Ellen Bowman
 */
@Entity
<<<<<<< HEAD
@Table(name="tour_rating")
public class TourRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @Column(name="customer_id")
    private Integer customerId;

=======
public class TourRating {

    @EmbeddedId
    private TourRatingPk pk;

>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
    @Column(nullable = false)
    private Integer score;

    @Column
    private String comment;

    protected TourRating() {
    }

    /**
     * Create a fully initialized TourRating.
     *
<<<<<<< HEAD
     * @param tour          the tour.
     * @param customerId    the customer identifier.
     * @param score      Integer score (1-5)
     * @param comment    Optional comment from the customer
     */
    public TourRating(Tour tour, Integer customerId, Integer score, String comment) {
        this.tour = tour;
        this.customerId = customerId;
=======
     * @param pk         primiary key of a tour and customer id.
     * @param score      Integer score (1-5)
     * @param comment    Optional comment from the customer
     */
    public TourRating(TourRatingPk pk, Integer score, String comment) {
        this.pk = pk;
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
        this.score = score;
        this.comment = comment;
    }

    /**
     * Create a fully initialized TourRating.
     *
     * @param tour          the tour.
     * @param customerId    the customer identifier.
     * @param score      Integer score (1-5)
     */
    public TourRating(Tour tour, Integer customerId, Integer score) {
        this.tour = tour;
        this.customerId = customerId;
        this.score = score;
        this.comment = toComment(score);
    }

    /**
     * Auto Generate a message for a score.
     *
     * @param score
     * @return
     */
    private String toComment(Integer score) {
        switch (score) {
            case 1:return "Terrible";
            case 2:return "Poor";
            case 3:return "Fair";
            case 4:return "Good";
            case 5:return "Great";
            default: return score.toString();
        }
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TourRating{" +
                "pk=" + pk +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourRating that = (TourRating) o;
        return Objects.equals(pk, that.pk) &&
                Objects.equals(score, that.score) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, score, comment);
    }

    public TourRatingPk getPk() {
        return pk;
    }

    public Integer getScore() {
        return score;
    }

    public String getComment() {
        return comment;
<<<<<<< HEAD
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
=======
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
    }

    public void setPk(TourRatingPk pk) {
        this.pk = pk;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
<<<<<<< HEAD

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourRating that = (TourRating) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(tour, that.tour) &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(score, that.score) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tour, customerId, score, comment);
    }
=======
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
}
