package com.spyrosst.demo.movierama.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spyrosst.demo.movierama.domain.Opinion;
import com.spyrosst.demo.movierama.repositories.OpinionRepository;

@Service
@Primary
public class OpinionServiceImpl implements OpinionService {

	@Autowired
	private OpinionRepository opinionRepo;

	@Override
	@Transactional
	public void manageOpinion(Opinion opinion) {
		if (opinion.getOpinion() == 0) {
			opinionRepo.delete(opinion);
		} else {
			opinionRepo.save(opinion);
		}
	}

	@Override
	@Transactional
	public void deleteAllOpinions() {
		opinionRepo.deleteAll();
	}

	@Override
	public List<Opinion> getAllOpinionsByUserId(Long userId) {
		return opinionRepo.findByPostedByUserId(userId);
	}

}
