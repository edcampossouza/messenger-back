package br.com.ecstech.messenger.repository;

import br.com.ecstech.messenger.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    Optional<ApplicationUser> findByUsername(String username);

    List<ApplicationUser> findByAuthorities_Authority(String authority);
}
