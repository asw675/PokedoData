package com.example.betterwine.pokedodata.Model;

import java.util.List;

public class Music {
    /**
     * count : 2
     * start : 0
     * total : 13
     * musics : [{"rating":{"max":10,"average":"7.3","numRaters":2357,"min":0},"author":[{"name":"Avril Lavigne"}],"alt_title":"","image":"https://img1.doubanio.com/view/subject/s/public/s26177217.jpg","tags":[{"count":1129,"name":"AvrilLavigne"},{"count":343,"name":"欧美"},{"count":287,"name":"Pop"},{"count":248,"name":"2013"},{"count":173,"name":"加拿大"},{"count":126,"name":"Single"},{"count":105,"name":"女声"},{"count":85,"name":"Single/EP"}],"mobile_link":"https://m.douban.com/music/subject/24697205/","attrs":{"publisher":["Epic"],"singer":["Avril Lavigne"],"pubdate":["2013-04-09"],"title":["Here's To Never Growing Up"],"media":["CD"],"tracks":["01. Here's To Never Growing Up"],"version":["单曲"]},"title":"Here's To Never Growing Up","alt":"https://music.douban.com/subject/24697205/","id":"24697205"},{"rating":{"max":10,"average":"8.1","numRaters":2073,"min":0},"author":[{"name":"Flunk"}],"alt_title":"","image":"https://img3.doubanio.com/view/subject/s/public/s4716523.jpg","tags":[{"count":624,"name":"Flunk"},{"count":401,"name":"挪威"},{"count":304,"name":"INDIE"},{"count":297,"name":"electronic"},{"count":139,"name":"女声"},{"count":123,"name":"电子"},{"count":103,"name":"Electronica"},{"count":70,"name":"2007"}],"mobile_link":"https://m.douban.com/music/subject/3244686/","attrs":{"publisher":["Beatservice Records"],"singer":["Flunk"],"version":["专辑"],"pubdate":["2007-04-23"],"title":["Personal Stereo"],"media":["Audio CD"],"tracks":["01. Personal Stereo\n02. Heavenly\n03. If We Kiss\n04. Haldi\n05. Sit Down\n06. See You\n07. Two Icicles\n08. Change My Ways\n09. Keep On\n10. 'Diet Of Water And Love' by The Valium Poets"],"discs":["1"]},"title":"Personal Stereo","alt":"https://music.douban.com/subject/3244686/","id":"3244686"}]
     */

    private int count;
    private int start;
    private int total;
    private List<MusicsBean> musics;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<MusicsBean> getMusics() {
        return musics;
    }

    public void setMusics(List<MusicsBean> musics) {
        this.musics = musics;
    }

    public static class MusicsBean {
        /**
         * rating : {"max":10,"average":"7.3","numRaters":2357,"min":0}
         * author : [{"name":"Avril Lavigne"}]
         * alt_title :
         * image : https://img1.doubanio.com/view/subject/s/public/s26177217.jpg
         * tags : [{"count":1129,"name":"AvrilLavigne"},{"count":343,"name":"欧美"},{"count":287,"name":"Pop"},{"count":248,"name":"2013"},{"count":173,"name":"加拿大"},{"count":126,"name":"Single"},{"count":105,"name":"女声"},{"count":85,"name":"Single/EP"}]
         * mobile_link : https://m.douban.com/music/subject/24697205/
         * attrs : {"publisher":["Epic"],"singer":["Avril Lavigne"],"pubdate":["2013-04-09"],"title":["Here's To Never Growing Up"],"media":["CD"],"tracks":["01. Here's To Never Growing Up"],"version":["单曲"]}
         * title : Here's To Never Growing Up
         * alt : https://music.douban.com/subject/24697205/
         * id : 24697205
         */

        private RatingBean rating;
        private String alt_title;
        private String image;
        private String mobile_link;
        private AttrsBean attrs;
        private String title;
        private String alt;
        private String id;
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

        public String getMobile_link() {
            return mobile_link;
        }

        public void setMobile_link(String mobile_link) {
            this.mobile_link = mobile_link;
        }

        public AttrsBean getAttrs() {
            return attrs;
        }

        public void setAttrs(AttrsBean attrs) {
            this.attrs = attrs;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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
             * numRaters : 2357
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
            private List<String> publisher;
            private List<String> singer;
            private List<String> pubdate;
            private List<String> title;
            private List<String> media;
            private List<String> tracks;
            private List<String> version;

            public List<String> getPublisher() {
                return publisher;
            }

            public void setPublisher(List<String> publisher) {
                this.publisher = publisher;
            }

            public List<String> getSinger() {
                return singer;
            }

            public void setSinger(List<String> singer) {
                this.singer = singer;
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

            public List<String> getMedia() {
                return media;
            }

            public void setMedia(List<String> media) {
                this.media = media;
            }

            public List<String> getTracks() {
                return tracks;
            }

            public void setTracks(List<String> tracks) {
                this.tracks = tracks;
            }

            public List<String> getVersion() {
                return version;
            }

            public void setVersion(List<String> version) {
                this.version = version;
            }
        }

        public static class AuthorBean {
            /**
             * name : Avril Lavigne
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
             * count : 1129
             * name : AvrilLavigne
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
}
