package onlinejudge.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import onlinejudge.domain.User;

public interface UserRepository extends PagingAndSortingRepository<User, String> {
	public User findUserByEmail(String email);
}