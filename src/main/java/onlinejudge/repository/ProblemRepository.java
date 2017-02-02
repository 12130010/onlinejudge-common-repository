package onlinejudge.repository;

import java.math.BigInteger;

import org.springframework.data.repository.PagingAndSortingRepository;

import onlinejudge.domain.Problem;

public interface ProblemRepository extends PagingAndSortingRepository<Problem, BigInteger>{

}
