package net.hg.trucadas.model.domain.freeswitch;

import java.io.Serializable;

/**
 * 
 * @author hgeraldino
 *
 */
public class FreeSwitchServer implements Serializable {

    private static final long serialVersionUID = 1L;

    private String hostName;

    private String username;

    private String password;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
