package com.spring.firstjobapp.review;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ReviewService {
	List<Review> getAllReviews(Long companyId);
	boolean addReview(Long companyId,Review review);
	Review getReview(Long companyId,Long reviewId);
	boolean updateReview(Long companyId,Long reviewId,Review updatedReview);
	boolean deleteReview(Long companyId,Long reviewId);
}
