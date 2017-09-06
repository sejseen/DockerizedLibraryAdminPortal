package pwr.ktyma.libraryadminportal.adminservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pwr.ktyma.libraryadminportal.adminservice.domain.User;
import pwr.ktyma.libraryadminportal.adminservice.domain.authorise.PasswordResetToken;

import java.util.Date;
import java.util.stream.Stream;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {

    PasswordResetToken findByToken(String token);

    PasswordResetToken findByUser(User user);

    Stream<PasswordResetToken> findAllByExpirationDateLessThan(Date date);

    @Modifying
    @Query(value = "delete from PasswordResetToken t where t.expirationDate <= ?1")
    void deleteAllExpiredSince(Date now);
}
