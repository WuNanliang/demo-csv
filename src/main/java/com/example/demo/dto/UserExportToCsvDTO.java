package com.example.demo.dto;

/**
 * @author wunanliang
 * @date 2017/12/24
 * @since 1.0.0
 */
public class UserExportToCsvDTO {

    /**
     * 用户账号
     */
    private String username;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 用户等级
     */
    private String level;

    public UserExportToCsvDTO(String username, String nickname, String level) {
        this.username = username;
        this.nickname = nickname;
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
