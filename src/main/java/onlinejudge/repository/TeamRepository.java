package onlinejudge.repository;

import java.math.BigInteger;

import org.springframework.data.repository.PagingAndSortingRepository;

import onlinejudge.domain.Team;

public interface TeamRepository extends PagingAndSortingRepository<Team, String> {

}
