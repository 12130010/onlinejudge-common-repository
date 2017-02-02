package onlinejudge.repository;

import java.math.BigInteger;

import org.springframework.data.repository.PagingAndSortingRepository;

import onlinejudge.domain.ProblemForContest;

public interface ProblemForContestRepository extends PagingAndSortingRepository<ProblemForContest, BigInteger>{

}
