package com.example.betterwine.pokedodata.Model;

import java.util.List;

public class Weather {

    /**
     * result : {"realtime":{"wind":{"windspeed":"","direct":"东风","power":"2级","offset":""},"time":"16:00:00","weather":{"humidity":"93","img":"02","info":"阴","temperature":"27"},"dataUptime":"1534405682","date":"2018-08-16","city_code":"101280601","city_name":"深圳","week":"4","moon":"七月初六"},"life":{"date":"2018-08-16","info":{"kongtiao":["部分时间开启","天气热，到中午的时候您将会感到有点热，因此建议在午后较热时开启制冷空调。"],"yundong":["较不宜","有较强降水，建议您选择在室内进行健身休闲运动。"],"ziwaixian":["弱","紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"],"ganmao":["少发","各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"wuran":null,"chuanyi":["热","天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"]}},"weather":[{"date":"2018-08-16","week":"四","nongli":"七月初六","info":{"dawn":["3","阵雨","26","东南风","3-5级","18:56"],"day":["8","中雨","30","持续无风向","微风","06:00","出门记得带伞，行走驾驶做好防滑准备"],"night":["8","中雨","25","持续无风向","微风","18:55","出门记得带伞，行走驾驶做好防滑准备"]}},{"date":"2018-08-17","week":"五","nongli":"七月初七","info":{"dawn":["8","中雨","25","持续无风向","微风","18:55"],"day":["4","雷阵雨","30","持续无风向","微风","06:01","出门记得带伞，行走驾驶做好防滑准备"],"night":["4","雷阵雨","26","持续无风向","微风","18:55","出门记得带伞，行走驾驶做好防滑准备"]}},{"date":"2018-08-18","week":"六","nongli":"七月初八","info":{"dawn":["4","雷阵雨","26","持续无风向","微风","18:55"],"day":["4","雷阵雨","31","持续无风向","微风","06:01"],"night":["4","雷阵雨","26","持续无风向","微风","18:54"]}},{"date":"2018-08-19","week":"日","nongli":"七月初九","info":{"dawn":["4","雷阵雨","26","持续无风向","微风","18:54"],"day":["3","阵雨","32","持续无风向","微风","06:01"],"night":["3","阵雨","27","持续无风向","微风","18:53"]}},{"date":"2018-08-20","week":"一","nongli":"七月初十 ","info":{"dawn":["3","阵雨","27","持续无风向","微风","18:53"],"day":["3","阵雨","32","持续无风向","微风","06:02"],"night":["3","阵雨","27","持续无风向","微风","18:52"]}}],"pm25":{"key":"深圳","show_desc":null,"pm25":{"curPm":"18","pm25":"10","pm10":"18","level":"1","quality":"优","des":"空气很棒，快出门呼吸新鲜空气吧。"},"dateTime":"2018年08月16日15时","cityName":"深圳"},"isForeign":0}
     * error_code : 0
     * reason : Succes
     */

    private ResultBean result;
    private int error_code;
    private String reason;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public static class ResultBean {
        /**
         * realtime : {"wind":{"windspeed":"","direct":"东风","power":"2级","offset":""},"time":"16:00:00","weather":{"humidity":"93","img":"02","info":"阴","temperature":"27"},"dataUptime":"1534405682","date":"2018-08-16","city_code":"101280601","city_name":"深圳","week":"4","moon":"七月初六"}
         * life : {"date":"2018-08-16","info":{"kongtiao":["部分时间开启","天气热，到中午的时候您将会感到有点热，因此建议在午后较热时开启制冷空调。"],"yundong":["较不宜","有较强降水，建议您选择在室内进行健身休闲运动。"],"ziwaixian":["弱","紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"],"ganmao":["少发","各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"wuran":null,"chuanyi":["热","天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"]}}
         * weather : [{"date":"2018-08-16","week":"四","nongli":"七月初六","info":{"dawn":["3","阵雨","26","东南风","3-5级","18:56"],"day":["8","中雨","30","持续无风向","微风","06:00","出门记得带伞，行走驾驶做好防滑准备"],"night":["8","中雨","25","持续无风向","微风","18:55","出门记得带伞，行走驾驶做好防滑准备"]}},{"date":"2018-08-17","week":"五","nongli":"七月初七","info":{"dawn":["8","中雨","25","持续无风向","微风","18:55"],"day":["4","雷阵雨","30","持续无风向","微风","06:01","出门记得带伞，行走驾驶做好防滑准备"],"night":["4","雷阵雨","26","持续无风向","微风","18:55","出门记得带伞，行走驾驶做好防滑准备"]}},{"date":"2018-08-18","week":"六","nongli":"七月初八","info":{"dawn":["4","雷阵雨","26","持续无风向","微风","18:55"],"day":["4","雷阵雨","31","持续无风向","微风","06:01"],"night":["4","雷阵雨","26","持续无风向","微风","18:54"]}},{"date":"2018-08-19","week":"日","nongli":"七月初九","info":{"dawn":["4","雷阵雨","26","持续无风向","微风","18:54"],"day":["3","阵雨","32","持续无风向","微风","06:01"],"night":["3","阵雨","27","持续无风向","微风","18:53"]}},{"date":"2018-08-20","week":"一","nongli":"七月初十 ","info":{"dawn":["3","阵雨","27","持续无风向","微风","18:53"],"day":["3","阵雨","32","持续无风向","微风","06:02"],"night":["3","阵雨","27","持续无风向","微风","18:52"]}}]
         * pm25 : {"key":"深圳","show_desc":null,"pm25":{"curPm":"18","pm25":"10","pm10":"18","level":"1","quality":"优","des":"空气很棒，快出门呼吸新鲜空气吧。"},"dateTime":"2018年08月16日15时","cityName":"深圳"}
         * isForeign : 0
         */

        private RealtimeBean realtime;
        private LifeBean life;
        private Pm25BeanX pm25;
        private int isForeign;
        private List<WeatherBeanX> weather;

        public RealtimeBean getRealtime() {
            return realtime;
        }

        public void setRealtime(RealtimeBean realtime) {
            this.realtime = realtime;
        }

        public LifeBean getLife() {
            return life;
        }

        public void setLife(LifeBean life) {
            this.life = life;
        }

        public Pm25BeanX getPm25() {
            return pm25;
        }

        public void setPm25(Pm25BeanX pm25) {
            this.pm25 = pm25;
        }

        public int getIsForeign() {
            return isForeign;
        }

        public void setIsForeign(int isForeign) {
            this.isForeign = isForeign;
        }

        public List<WeatherBeanX> getWeather() {
            return weather;
        }

        public void setWeather(List<WeatherBeanX> weather) {
            this.weather = weather;
        }

        public static class RealtimeBean {
            /**
             * wind : {"windspeed":"","direct":"东风","power":"2级","offset":""}
             * time : 16:00:00
             * weather : {"humidity":"93","img":"02","info":"阴","temperature":"27"}
             * dataUptime : 1534405682
             * date : 2018-08-16
             * city_code : 101280601
             * city_name : 深圳
             * week : 4
             * moon : 七月初六
             */

            private WindBean wind;
            private String time;
            private WeatherBean weather;
            private String dataUptime;
            private String date;
            private String city_code;
            private String city_name;
            private String week;
            private String moon;

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public WeatherBean getWeather() {
                return weather;
            }

            public void setWeather(WeatherBean weather) {
                this.weather = weather;
            }

            public String getDataUptime() {
                return dataUptime;
            }

            public void setDataUptime(String dataUptime) {
                this.dataUptime = dataUptime;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getCity_code() {
                return city_code;
            }

            public void setCity_code(String city_code) {
                this.city_code = city_code;
            }

            public String getCity_name() {
                return city_name;
            }

            public void setCity_name(String city_name) {
                this.city_name = city_name;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getMoon() {
                return moon;
            }

            public void setMoon(String moon) {
                this.moon = moon;
            }

            public static class WindBean {
                /**
                 * windspeed :
                 * direct : 东风
                 * power : 2级
                 * offset :
                 */

                private String windspeed;
                private String direct;
                private String power;
                private String offset;

                public String getWindspeed() {
                    return windspeed;
                }

                public void setWindspeed(String windspeed) {
                    this.windspeed = windspeed;
                }

                public String getDirect() {
                    return direct;
                }

                public void setDirect(String direct) {
                    this.direct = direct;
                }

                public String getPower() {
                    return power;
                }

                public void setPower(String power) {
                    this.power = power;
                }

                public String getOffset() {
                    return offset;
                }

                public void setOffset(String offset) {
                    this.offset = offset;
                }
            }

            public static class WeatherBean {
                /**
                 * humidity : 93
                 * img : 02
                 * info : 阴
                 * temperature : 27
                 */

                private String humidity;
                private String img;
                private String info;
                private String temperature;

                public String getHumidity() {
                    return humidity;
                }

                public void setHumidity(String humidity) {
                    this.humidity = humidity;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getInfo() {
                    return info;
                }

                public void setInfo(String info) {
                    this.info = info;
                }

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }
            }
        }

        public static class LifeBean {
            /**
             * date : 2018-08-16
             * info : {"kongtiao":["部分时间开启","天气热，到中午的时候您将会感到有点热，因此建议在午后较热时开启制冷空调。"],"yundong":["较不宜","有较强降水，建议您选择在室内进行健身休闲运动。"],"ziwaixian":["弱","紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"],"ganmao":["少发","各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"],"xiche":["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"],"wuran":null,"chuanyi":["热","天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"]}
             */

            private String date;
            private InfoBean info;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public InfoBean getInfo() {
                return info;
            }

            public void setInfo(InfoBean info) {
                this.info = info;
            }

            public static class InfoBean {
                /**
                 * kongtiao : ["部分时间开启","天气热，到中午的时候您将会感到有点热，因此建议在午后较热时开启制冷空调。"]
                 * yundong : ["较不宜","有较强降水，建议您选择在室内进行健身休闲运动。"]
                 * ziwaixian : ["弱","紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"]
                 * ganmao : ["少发","各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"]
                 * xiche : ["不宜","不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"]
                 * wuran : null
                 * chuanyi : ["热","天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"]
                 */

                private Object wuran;
                private List<String> kongtiao;
                private List<String> yundong;
                private List<String> ziwaixian;
                private List<String> ganmao;
                private List<String> xiche;
                private List<String> chuanyi;

                public Object getWuran() {
                    return wuran;
                }

                public void setWuran(Object wuran) {
                    this.wuran = wuran;
                }

                public List<String> getKongtiao() {
                    return kongtiao;
                }

                public void setKongtiao(List<String> kongtiao) {
                    this.kongtiao = kongtiao;
                }

                public List<String> getYundong() {
                    return yundong;
                }

                public void setYundong(List<String> yundong) {
                    this.yundong = yundong;
                }

                public List<String> getZiwaixian() {
                    return ziwaixian;
                }

                public void setZiwaixian(List<String> ziwaixian) {
                    this.ziwaixian = ziwaixian;
                }

                public List<String> getGanmao() {
                    return ganmao;
                }

                public void setGanmao(List<String> ganmao) {
                    this.ganmao = ganmao;
                }

                public List<String> getXiche() {
                    return xiche;
                }

                public void setXiche(List<String> xiche) {
                    this.xiche = xiche;
                }

                public List<String> getChuanyi() {
                    return chuanyi;
                }

                public void setChuanyi(List<String> chuanyi) {
                    this.chuanyi = chuanyi;
                }
            }
        }

        public static class Pm25BeanX {
            /**
             * key : 深圳
             * show_desc : null
             * pm25 : {"curPm":"18","pm25":"10","pm10":"18","level":"1","quality":"优","des":"空气很棒，快出门呼吸新鲜空气吧。"}
             * dateTime : 2018年08月16日15时
             * cityName : 深圳
             */

            private String key;
            private Object show_desc;
            private Pm25Bean pm25;
            private String dateTime;
            private String cityName;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public Object getShow_desc() {
                return show_desc;
            }

            public void setShow_desc(Object show_desc) {
                this.show_desc = show_desc;
            }

            public Pm25Bean getPm25() {
                return pm25;
            }

            public void setPm25(Pm25Bean pm25) {
                this.pm25 = pm25;
            }

            public String getDateTime() {
                return dateTime;
            }

            public void setDateTime(String dateTime) {
                this.dateTime = dateTime;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public static class Pm25Bean {
                /**
                 * curPm : 18
                 * pm25 : 10
                 * pm10 : 18
                 * level : 1
                 * quality : 优
                 * des : 空气很棒，快出门呼吸新鲜空气吧。
                 */

                private String curPm;
                private String pm25;
                private String pm10;
                private String level;
                private String quality;
                private String des;

                public String getCurPm() {
                    return curPm;
                }

                public void setCurPm(String curPm) {
                    this.curPm = curPm;
                }

                public String getPm25() {
                    return pm25;
                }

                public void setPm25(String pm25) {
                    this.pm25 = pm25;
                }

                public String getPm10() {
                    return pm10;
                }

                public void setPm10(String pm10) {
                    this.pm10 = pm10;
                }

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public String getQuality() {
                    return quality;
                }

                public void setQuality(String quality) {
                    this.quality = quality;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }
        }

        public static class WeatherBeanX {
            /**
             * date : 2018-08-16
             * week : 四
             * nongli : 七月初六
             * info : {"dawn":["3","阵雨","26","东南风","3-5级","18:56"],"day":["8","中雨","30","持续无风向","微风","06:00","出门记得带伞，行走驾驶做好防滑准备"],"night":["8","中雨","25","持续无风向","微风","18:55","出门记得带伞，行走驾驶做好防滑准备"]}
             */

            private String date;
            private String week;
            private String nongli;
            private InfoBeanX info;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getNongli() {
                return nongli;
            }

            public void setNongli(String nongli) {
                this.nongli = nongli;
            }

            public InfoBeanX getInfo() {
                return info;
            }

            public void setInfo(InfoBeanX info) {
                this.info = info;
            }

            public static class InfoBeanX {
                private List<String> dawn;
                private List<String> day;
                private List<String> night;

                public List<String> getDawn() {
                    return dawn;
                }

                public void setDawn(List<String> dawn) {
                    this.dawn = dawn;
                }

                public List<String> getDay() {
                    return day;
                }

                public void setDay(List<String> day) {
                    this.day = day;
                }

                public List<String> getNight() {
                    return night;
                }

                public void setNight(List<String> night) {
                    this.night = night;
                }
            }
        }
    }
}
