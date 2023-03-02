package cc.ficc.showlist.bean;

public class AppBean {
    private String mainImage;
    private String appImage;
    private String title;
    private String subTitle;
    private String version;
    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAppImage() {
        return appImage;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSubTitle() {
        return subTitle;
    }

    @Override
    public String toString() {
        return "AppBean{" +
                "appImage='" + appImage + '\'' +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", version='" + version + '\'' +
                ", mainImage='" + mainImage + '\'' +
                '}';
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public void setAppImage(String appImage) {
        this.appImage = appImage;
    }

}
