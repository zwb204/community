package life.zwb.community.dto;

import lombok.Data;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2019/10/22 13:43
 **/
@Data
public class GithubUser {

    private String name;
    private Long id;
    private String bio;
    private String avatar_url;

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getBio() {
//        return bio;
//    }
//
//    public void setBio(String bio) {
//        this.bio = bio;
//    }
//
//    @Override
//    public String toString() {
//        return "GithubUser{" +
//                "name='" + name + '\'' +
//                ", id=" + id +
//                ", bio='" + bio + '\'' +
//                '}';
//    }
}
