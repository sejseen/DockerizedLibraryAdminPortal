package pwr.ktyma.libraryadminportal.adminservice.domain.authorise;

import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@NoArgsConstructor
public class Authorithy implements GrantedAuthority {

    private String authorithy;

    public Authorithy(String authorithy) {
        this.authorithy = authorithy;
    }

    @Override
    public String getAuthority() {
        return this.authorithy;
    }



}
