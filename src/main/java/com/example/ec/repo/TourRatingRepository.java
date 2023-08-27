package com.example.ec.repo;

import com.example.ec.domain.TourRating;
<<<<<<< HEAD
import io.swagger.annotations.Api;
=======
import com.example.ec.domain.TourRatingPk;
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

/**
 * Tour Rating Repository Interface
 *
 * Created by Mary Ellen Bowman
 */
@RepositoryRestResource(exported = false)
<<<<<<< HEAD
public interface TourRatingRepository extends JpaRepository<TourRating, Integer> {
=======
public interface TourRatingRepository extends CrudRepository<TourRating, TourRatingPk> {
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14

    /**
     * Lookup all the TourRatings for a tour.
     *
     * @param tourId is the tour Identifier
     * @return a List of any found TourRatings
     */
<<<<<<< HEAD
    List<TourRating> findByTourId(Integer tourId);
=======
    List<TourRating> findByPkTourId(Integer tourId);
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14

    /**
     * Lookup a page of TourRatings for a tour.
     *
     * @param tourId tourId is the tour Identifier
     * @param pageable details for the desired page
     * @return a Page of any found TourRatings
     */
<<<<<<< HEAD
    Page<TourRating> findByTourId(Integer tourId, Pageable pageable);
=======
    Page<TourRating> findByPkTourId(Integer tourId, Pageable pageable);
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14

    /**
     * Lookup a TourRating by the TourId and Customer Id
     * @param tourId
     * @param customerId
     * @return TourRating if found, null otherwise.
     */
<<<<<<< HEAD
    Optional<TourRating> findByTourIdAndCustomerId(Integer tourId, Integer customerId);
=======
    Optional<TourRating> findByPkTourIdAndPkCustomerId(Integer tourId, Integer customerId);
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
}