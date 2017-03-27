package onlinejudge.repository;

import java.math.BigInteger;

import org.springframework.data.repository.PagingAndSortingRepository;

import onlinejudge.domain.Submit;

public interface SubmitRepository extends PagingAndSortingRepository<Submit, String>{

}
