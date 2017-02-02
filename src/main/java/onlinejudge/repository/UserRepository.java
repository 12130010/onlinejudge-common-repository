package onlinejudge.repository;

import java.math.BigInteger;

import org.springframework.data.repository.PagingAndSortingRepository;

import onlinejudge.domain.User;

public interface UserRepository extends PagingAndSortingRepository<User, BigInteger> {
	public User findUserByEmail(String email);
}