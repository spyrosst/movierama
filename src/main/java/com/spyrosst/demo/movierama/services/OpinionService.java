package com.spyrosst.demo.movierama.services;

import java.util.List;

import com.spyrosst.demo.movierama.domain.Opinion;

public interface OpinionService {

	void manageOpinion(Opinion opinion);

	void deleteAllOpinions();

	List<Opinion> getAllOpinionsByUserId(Long userId);

}
