package wy.com.myapplication.entity;

/**
 * Created by DELL on 2016/7/5.
 */
public class TuiJian {
    private int id;//帖子ID
    private String profile_image;//用户图像
    private String name;//用户名
    private String created_at;//时间
    private String text;//帖子内容
    private String image0;//图片
    private int type;//帖子类型

    @Override
    public String toString() {
        return "TuiJian{" +
                "id=" + id +
                ", profile_image='" + profile_image + '\'' +
                ", name='" + name + '\'' +
                ", created_at='" + created_at + '\'' +
                ", text='" + text + '\'' +
                ", image0='" + image0 + '\'' +
                ", type=" + type +
                '}';
    }

    public TuiJian(int id, String profile_image, String name, String created_at, String text, String image0, int type) {
        this.id = id;
        this.profile_image = profile_image;
        this.name = name;
        this.created_at = created_at;
        this.text = text;
        this.image0 = image0;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage0() {
        return image0;
    }

    public void setImage0(String image0) {
        this.image0 = image0;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
