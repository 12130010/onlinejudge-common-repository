package onlinejudge.repository;

import java.math.BigInteger;

import org.springframework.data.repository.PagingAndSortingRepository;

import onlinejudge.domain.ProblemForTeam;

public interface ProblemForTeamRepository extends PagingAndSortingRepository<ProblemForTeam, BigInteger>{

}
