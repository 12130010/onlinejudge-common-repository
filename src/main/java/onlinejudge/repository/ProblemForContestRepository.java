package onlinejudge.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import onlinejudge.domain.ProblemForContest;

public interface ProblemForContestRepository extends PagingAndSortingRepository<ProblemForContest, String>{

}
