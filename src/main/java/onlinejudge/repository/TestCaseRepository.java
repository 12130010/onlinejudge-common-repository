package onlinejudge.repository;

import java.math.BigInteger;

import org.springframework.data.repository.PagingAndSortingRepository;

import onlinejudge.domain.TestCase;

public interface TestCaseRepository extends PagingAndSortingRepository<TestCase, BigInteger>{

}
