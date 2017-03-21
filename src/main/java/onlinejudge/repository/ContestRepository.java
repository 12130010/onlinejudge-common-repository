package onlinejudge.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import onlinejudge.domain.Contest;
import onlinejudge.domain.Problem;

public interface ContestRepository extends PagingAndSortingRepository<Contest, String>{
	public List<Contest> findListContestByAdminID(String adminID);
}
