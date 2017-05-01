package onlinejudge.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import onlinejudge.domain.TestCase;

public interface TestCaseRepository extends PagingAndSortingRepository<TestCase, String>{

}
