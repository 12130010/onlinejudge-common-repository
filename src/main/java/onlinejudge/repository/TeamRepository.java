package onlinejudge.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import onlinejudge.domain.Team;

public interface TeamRepository extends PagingAndSortingRepository<Team, String> {
	@Query("{'listMember.email': ?0}")
	List<Team> findTeamsByEmailOfMember(String emailOfMember);
}
