package com.example.betterwine.pokedodata.Model;

import java.util.List;

public class MovieDetail {
    /**
     * rating : {"max":10,"average":"7.3","numRaters":228684,"min":0}
     * author : [{"name":"黄渤 Bo Huang"}]
     * alt_title : 大富翁
     * image : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2529571873.jpg
     * title : 一出好戏
     * summary : 马进欠下债务，与远房表弟小兴在底层社会摸爬滚打，习惯性的买彩票，企图一夜暴富，并迎娶自己的同事姗姗。一日，公司全体员工出海团建，途中，马进收到了彩票中头奖的信息，六千万！就在马进狂喜自己翻身的日子终于到来之际，一场突如其来的滔天巨浪打破了一切。苏醒过来的众人发现身处荒岛 ，丧失了一切与外界的联系……
     * attrs : {"language":["汉语普通话"],"pubdate":["2018-08-10(中国大陆)"],"title":["一出好戏"],"country":["中国大陆"],"writer":["黄渤 Bo Huang","张冀 Ji Zhang","郭俊立 Junli Guo","查慕春 Muchun Zha","崔斯韦 Siwei Cui","邢爱娜 Aina Xing","黄湛中 Zhanzhong Huang"],"director":["黄渤 Bo Huang"],"cast":["黄渤 Bo Huang","舒淇 Qi Shu","王宝强 Baoqiang Wang","张艺兴 Yixing Zhang","于和伟 Hewei Yu","王迅 Xun Wang","李勤勤 Qinqin Li","李又麟 You-Lin Lee","宁浩 Hao Ning","管虎 Hu Guan","梁静 Jing Liang","徐峥 Zheng Xu","陈德森 Teddy Chan","张磊 Lei Zhang"],"movie_duration":["134分钟"],"year":["2018"],"movie_type":["剧情","喜剧"]}
     * id : https://api.douban.com/movie/26985127
     * mobile_link : https://m.douban.com/movie/subject/26985127/
     * alt : https://movie.douban.com/movie/26985127
     * tags : [{"count":37926,"name":"人性"},{"count":32825,"name":"黑色幽默"},{"count":27564,"name":"荒岛求生"},{"count":16846,"name":"中国大陆"},{"count":16040,"name":"喜剧"},{"count":15504,"name":"2018"},{"count":14766,"name":"剧情"},{"count":10606,"name":"搞笑"}]
     */

    private RatingBean rating;
    private String alt_title;
    private String image;
    private String title;
    private String summary;
    private AttrsBean attrs;
    private String id;
    private String mobile_link;
    private String alt;
    private List<AuthorBean> author;
    private List<TagsBean> tags;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public String getAlt_title() {
        return alt_title;
    }

    public void setAlt_title(String alt_title) {
        this.alt_title = alt_title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public AttrsBean getAttrs() {
        return attrs;
    }

    public void setAttrs(AttrsBean attrs) {
        this.attrs = attrs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile_link() {
        return mobile_link;
    }

    public void setMobile_link(String mobile_link) {
        this.mobile_link = mobile_link;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public List<AuthorBean> getAuthor() {
        return author;
    }

    public void setAuthor(List<AuthorBean> author) {
        this.author = author;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public static class RatingBean {
        /**
         * max : 10
         * average : 7.3
         * numRaters : 228684
         * min : 0
         */

        private int max;
        private String average;
        private int numRaters;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public String getAverage() {
            return average;
        }

        public void setAverage(String average) {
            this.average = average;
        }

        public int getNumRaters() {
            return numRaters;
        }

        public void setNumRaters(int numRaters) {
            this.numRaters = numRaters;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    public static class AttrsBean {
        private List<String> language;
        private List<String> pubdate;
        private List<String> title;
        private List<String> country;
        private List<String> writer;
        private List<String> director;
        private List<String> cast;
        private List<String> movie_duration;
        private List<String> year;
        private List<String> movie_type;

        public List<String> getLanguage() {
            return language;
        }

        public void setLanguage(List<String> language) {
            this.language = language;
        }

        public List<String> getPubdate() {
            return pubdate;
        }

        public void setPubdate(List<String> pubdate) {
            this.pubdate = pubdate;
        }

        public List<String> getTitle() {
            return title;
        }

        public void setTitle(List<String> title) {
            this.title = title;
        }

        public List<String> getCountry() {
            return country;
        }

        public void setCountry(List<String> country) {
            this.country = country;
        }

        public List<String> getWriter() {
            return writer;
        }

        public void setWriter(List<String> writer) {
            this.writer = writer;
        }

        public List<String> getDirector() {
            return director;
        }

        public void setDirector(List<String> director) {
            this.director = director;
        }

        public List<String> getCast() {
            return cast;
        }

        public void setCast(List<String> cast) {
            this.cast = cast;
        }

        public List<String> getMovie_duration() {
            return movie_duration;
        }

        public void setMovie_duration(List<String> movie_duration) {
            this.movie_duration = movie_duration;
        }

        public List<String> getYear() {
            return year;
        }

        public void setYear(List<String> year) {
            this.year = year;
        }

        public List<String> getMovie_type() {
            return movie_type;
        }

        public void setMovie_type(List<String> movie_type) {
            this.movie_type = movie_type;
        }
    }

    public static class AuthorBean {
        /**
         * name : 黄渤 Bo Huang
         */

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class TagsBean {
        /**
         * count : 37926
         * name : 人性
         */

        private int count;
        private String name;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
