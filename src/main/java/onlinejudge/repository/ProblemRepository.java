package onlinejudge.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import onlinejudge.domain.Problem;

public interface ProblemRepository extends PagingAndSortingRepository<Problem, String>{
	public List<Problem> findByIdOwner(String idOwner);
}
