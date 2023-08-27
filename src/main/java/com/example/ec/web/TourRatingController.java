package com.example.ec.web;

<<<<<<< HEAD
import com.example.ec.domain.TourRating;
import com.example.ec.service.TourRatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractMap;
=======
import com.example.ec.domain.*;
import com.example.ec.repo.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.*;
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14

/**
 * Tour Rating Controller
 *
 * Created by Mary Ellen Bowman
 */
@RestController
@RequestMapping(path = "/tours/{tourId}/ratings")
public class TourRatingController {
<<<<<<< HEAD
    private static final Logger LOGGER = LoggerFactory.getLogger(TourRatingController.class);
    private TourRatingService tourRatingService;
    private RatingAssembler assembler;

=======
    TourRatingRepository tourRatingRepository;
    TourRepository tourRepository;
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14

    @Autowired
    public TourRatingController(TourRatingService tourRatingService,
                                RatingAssembler assembler) {
        this.tourRatingService = tourRatingService;
        this.assembler = assembler;
    }

    protected TourRatingController() {

    }

    /**
     * Create a Tour Rating.
     *
     * @param tourId
     * @param ratingDto
     */
    @PostMapping
    @PreAuthorize("hasRole('ROLE_CSR')")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTourRating(@PathVariable(value = "tourId") int tourId, @RequestBody @Validated RatingDto ratingDto) {
<<<<<<< HEAD
        LOGGER.info("POST /tours/{}/ratings", tourId);
        tourRatingService.createNew(tourId, ratingDto.getCustomerId(), ratingDto.getScore(), ratingDto.getComment());
    }

    /**
     * Create Several Tour Ratings for one tour, score and several customers.
     *
     * @param tourId
     * @param score
     * @param customers
     */
    @PostMapping("/{score}")
    @PreAuthorize("hasRole('ROLE_CSR')")
    @ResponseStatus(HttpStatus.CREATED)
    public void createManyTourRatings(@PathVariable(value = "tourId") int tourId,
                                      @PathVariable(value = "score") int score,
                                      @RequestParam("customers") Integer customers[]) {
        LOGGER.info("POST /tours/{}/ratings/{}", tourId, score);
        tourRatingService.rateMany(tourId, score, customers);
    }

     /**
     * Lookup a the Ratings for a tour.
     *
     * @param tourId
     * @param pageable
     * @param pagedAssembler
     * @return HATEOAS enabled page of ratings.
     */
    @GetMapping
    public PagedResources<RatingDto> getAllRatingsForTour(@PathVariable(value = "tourId") int tourId, Pageable pageable,
                                                          PagedResourcesAssembler pagedAssembler) {
        LOGGER.info("GET /tours/{}/ratings", tourId);
        Page<TourRating> tourRatingPage = tourRatingService.lookupRatings(tourId, pageable);
        PagedResources<RatingDto> result =  pagedAssembler.toResource(tourRatingPage, assembler);
        return result;
=======
        Tour tour = verifyTour(tourId);
        tourRatingRepository.save(new TourRating( new TourRatingPk(tour, ratingDto.getCustomerId()),
                ratingDto.getScore(), ratingDto.getComment()));
    }

    /**
     * Lookup a the Ratings for a tour.
     *
     * @param tourId
     * @param pageable
     * @return
     */
    @GetMapping
    public Page<RatingDto> getAllRatingsForTour(@PathVariable(value = "tourId") int tourId, Pageable pageable) {
        Tour tour = verifyTour(tourId);
        Page<TourRating> tourRatingPage = tourRatingRepository.findByPkTourId(tour.getId(), pageable);
        List<RatingDto> ratingDtoList = tourRatingPage.getContent().stream().map(tourRating -> toDto(tourRating)).collect(Collectors.toList());
        return new PageImpl<RatingDto>(ratingDtoList, pageable, tourRatingPage.getTotalPages());
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
    }

    /**
     * Calculate the average Score of a Tour.
     *
     * @param tourId
     * @return Tuple of "average" and the average value.
     */
    @GetMapping("/average")
    public AbstractMap.SimpleEntry<String, Double> getAverage(@PathVariable(value = "tourId") int tourId) {
<<<<<<< HEAD
        LOGGER.info("GET /tours/{}/ratings/average", tourId);
        return new AbstractMap.SimpleEntry<String, Double>("average", tourRatingService.getAverageScore(tourId));
=======
        Tour tour = verifyTour(tourId);
        List<TourRating> ratings = tourRatingRepository.findByPkTourId(tourId);
        OptionalDouble average = ratings.stream().mapToInt(TourRating::getScore).average();
        double result = average.isPresent() ? average.getAsDouble():null;
        return new AbstractMap.SimpleEntry<String, Double>("average", result);
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
    }

    /**
     * Update score and comment of a Tour Rating
     *
     * @param tourId
     * @param ratingDto
     * @return The modified Rating DTO.
     */
    @PutMapping
<<<<<<< HEAD
    @PreAuthorize("hasRole('ROLE_CSR')")
    public RatingDto updateWithPut(@PathVariable(value = "tourId") int tourId, @RequestBody @Validated RatingDto ratingDto) {
        LOGGER.info("PUT /tours/{}/ratings", tourId);
        return toDto(tourRatingService.update(tourId, ratingDto.getCustomerId(),
                 ratingDto.getScore(), ratingDto.getComment()));
=======
    public RatingDto updateWithPut(@PathVariable(value = "tourId") int tourId, @RequestBody @Validated RatingDto ratingDto) {
        TourRating rating = verifyTourRating(tourId, ratingDto.getCustomerId());
        rating.setScore(ratingDto.getScore());
        rating.setComment(ratingDto.getComment());
        return toDto(tourRatingRepository.save(rating));
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
    }
    /**
     * Update score or comment of a Tour Rating
     *
     * @param tourId
     * @param ratingDto
     * @return The modified Rating DTO.
     */
    @PatchMapping
<<<<<<< HEAD
    @PreAuthorize("hasRole('ROLE_CSR')")
    public RatingDto updateWithPatch(@PathVariable(value = "tourId") int tourId, @RequestBody @Validated RatingDto ratingDto) {
        LOGGER.info("PATCH /tours/{}/ratings", tourId);
        return toDto(tourRatingService.updateSome(tourId, ratingDto.getCustomerId(),
                 ratingDto.getScore(), ratingDto.getComment()));
=======
    public RatingDto updateWithPatch(@PathVariable(value = "tourId") int tourId, @RequestBody @Validated RatingDto ratingDto) {
        TourRating rating = verifyTourRating(tourId, ratingDto.getCustomerId());
        if (ratingDto.getScore() != null) {
            rating.setScore(ratingDto.getScore());
        }
        if (ratingDto.getComment() != null) {
            rating.setComment(ratingDto.getComment());
        }
        return toDto(tourRatingRepository.save(rating));
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
    }

    /**
     * Delete a Rating of a tour made by a customer
     *
     * @param tourId
     * @param customerId
     */
    @DeleteMapping("/{customerId}")
<<<<<<< HEAD
    @PreAuthorize("hasRole('ROLE_CSR')")
    public void delete(@PathVariable(value = "tourId") int tourId, @PathVariable(value = "customerId") int customerId) {
        LOGGER.info("DELETE /tours/{}/ratings/{}", tourId, customerId);
        tourRatingService.delete(tourId, customerId);
=======
    public void delete(@PathVariable(value = "tourId") int tourId, @PathVariable(value = "customerId") int customerId) {
        TourRating rating = verifyTourRating(tourId, customerId);
        tourRatingRepository.delete(rating);
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14
    }

    /**
     * Convert the TourRating entity to a RatingDto
<<<<<<< HEAD
     *
     * @param tourRating
     * @return RatingDto
     */
    private RatingDto toDto(TourRating tourRating) {
        return assembler.toResource(tourRating);
    }

=======
     *
     * @param tourRating
     * @return RatingDto
     */
    private RatingDto toDto(TourRating tourRating) {
        return new RatingDto(tourRating.getScore(), tourRating.getComment(), tourRating.getPk().getCustomerId());
    }

    /**
     * Verify and return the TourRating for a particular tourId and Customer
     * @param tourId
     * @param customerId
     * @return the found TourRating
     * @throws NoSuchElementException if no TourRating found
     */
    private TourRating verifyTourRating(int tourId, int customerId) throws NoSuchElementException {
        return tourRatingRepository.findByPkTourIdAndPkCustomerId(tourId, customerId)
                .orElseThrow(() ->new NoSuchElementException("Tour-Rating pair for request:"
                    + tourId + " for customer" + customerId));
    }

    /**
     * Verify and return the Tour given a tourId.
     *
     * @param tourId
     * @return the found Tour
     * @throws NoSuchElementException if no Tour found.
     */
    private Tour verifyTour(int tourId) throws NoSuchElementException {
        return tourRepository.findById(tourId).orElseThrow(() ->
                new NoSuchElementException("Tour does not exist " + tourId));
    }

    /**
     * Exception handler if NoSuchElementException is thrown in this Controller
     *
     * @param ex
     * @return Error message String.
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex) {
        return ex.getMessage();

    }
>>>>>>> dbbae867c3d01746c9c131b30d592a7174dded14

}
