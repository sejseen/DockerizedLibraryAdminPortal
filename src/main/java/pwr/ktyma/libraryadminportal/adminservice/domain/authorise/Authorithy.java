package pwr.ktyma.libraryadminportal.adminservice.domain.authorise;

import org.springframework.security.core.GrantedAuthority;

public class Authorithy implements GrantedAuthority {

    private final String authorithy;

    public Authorithy(String authorithy) {
        this.authorithy = authorithy;
    }

    @Override
    public String getAuthority() {
        return this.authorithy;
    }

}
