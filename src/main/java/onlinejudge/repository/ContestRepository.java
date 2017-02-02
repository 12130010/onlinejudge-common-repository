package onlinejudge.repository;

import java.math.BigInteger;

import org.springframework.data.repository.PagingAndSortingRepository;

import onlinejudge.domain.Contest;

public interface ContestRepository extends PagingAndSortingRepository<Contest, BigInteger>{

}
