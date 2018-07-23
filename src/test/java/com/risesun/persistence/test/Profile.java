package com.risesun.persistence.test;

public class Profile {
    private int profileId;
    private String nickname;

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "profileId=" + profileId +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
