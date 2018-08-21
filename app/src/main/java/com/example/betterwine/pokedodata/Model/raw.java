package com.example.betterwine.pokedodata.Model;

import java.util.List;

public class raw {
    /**
     * id : gJ1f6yq/dy+EE228w+hGe2vqzp8cvTcb4rgjVhON2Yc=_1654ce7ba7a:7ab3bfe:4db7ac35
     * keywords : ["汽车交通"]
     * originId : http://36kr.com/p/5148901.html?ktm_source=feed
     * fingerprint : 83709aa3
     * title : Uber海外扩张屡屡折戟，新经济型专车“Chap Chap”能打开非洲市场吗？
     * published : 1534593437000
     * crawled : 1534593579642
     * origin : {"streamId":"feed/http://www.36kr.com/feed","title":"36氪","htmlUrl":"http://36kr.com"}
     * alternate : [{"href":"http://36kr.com/p/5148901.html?ktm_source=feed","type":"text/html"}]
     * author : 咏仪
     * summary : {"content":"<p>据<a href=\"https://www.reuters.com/article/us-kenya-uber/uber-to-push-further-into-east-africa-with-services-like-chap-chap-idUSKBN1L21PF?feedType=RSS&feedName=technologyNews\" target=\"_blank\">路透<\/a>，Uber 上周五表示，今年结束前将再进军两个东非国家，并且将在这些国家重点发展节能的设备，比如已经在肯尼亚投放的经济车型\u201cChap Chap\u201d。<\/p><p>\u201c<a href=\"https://www.urbandictionary.com/define.php?term=chap%21%20chap%21\" target=\"_blank\">Chap Chap<\/a>\u201d在非洲本土的斯瓦西里语中意为\u201c快点！快点！\u201d。Uber 于今年 1 月在非洲推出了新车型 Chap Chap 用于打车服务。为了打通供应链，Uber 与内罗毕的大陆汽车集团（CMC Motors）以及肯尼亚的 Stanbic 银行达成合作，第一代 Chap Chap 选用性价比较高的小轿车铃木奥拓，耗油少，续航好，等级较高的 Uber 司机能够在三年内获得一定程度的资助来买车。<\/p><p>Chap Chap相当省油节能，<span>因此Chap Chap的打车服务价格也相对较低。Chap Chap起步价大概在 100 肯尼亚先令左右（约合 6.8 元人民币），和 UberX 的价格（起步价在 10 元人民币左右）相比便宜不少。<\/span><\/p><p><span><\/span><\/p><p><img width=\"521\" data-img-size-val=\"521,391\" src=\"https://pic.36krcnd.com/201808/18084249/bj6st390oxtcgccv.jpg!heading\"><\/p><p><span>此举被认为是 Uber 以应对肯尼亚当地主要对手之举。<\/span><span>肯尼亚是东非人均收入最高的经济体，也是 Uber 在撒哈拉以南非洲的第二大市场。在当地，Uber 的主要对手是<\/span><span>来自<\/span><span>爱沙尼亚的打车软件 Taxify、内罗毕的 Mondo Ride 与 Little。\\xa0<\/span><\/p><p>打车巨头如 Uber 和滴滴，在海外扩张的过程中本土化是一大问题。无论是和滴滴那场著名的烧钱大战，在东南亚和 Grab、Go-Jek 的激战，还是在俄罗斯与 Yandex NV 的握手言和，都体现出海外扩张之难。<\/p><p>而即便在自家境内，Uber也早已应接不暇，Uber 在美国的竞争对手 Lyft 目前已占据 25% 的市场份额。<\/p><p>在相对来说还没那么多人踏足的非洲大陆，Uber会秉持一贯的高举高打战略，还是换个方法？直接推行 Chap Chap 这样的出行工具或许是牢牢把握住司机端和运营成本的方法，但这种模式相当重，而且目前已经有司机<a href=\"https://techcrunch.com/2018/02/13/uber-launches-a-new-lower-priced-service-called-chap-chap-in-nairobi/?guccounter=1\" target=\"_blank\">抱怨<\/a>，这么低的收费会削减他们的收入。<\/p><p>Uber 的 Chap Chap 首先将会在肯尼亚的内罗毕上线，接下来，Uber 将会把大约 300 辆常规车辆换成 Chap Chap，截止目前就有超过 400 辆 Uber 在内罗毕运营。<\/p>","direction":"ltr"}
     * visual : {"processor":"feedly-nikon-v3.1","url":"https://pic.36krcnd.com/201808/18084249/bj6st390oxtcgccv.jpg!heading","width":800,"height":600,"contentType":"image/jpeg"}
     * unread : true
     */

    private String id;
    private String originId;
    private String fingerprint;
    private String title;
    private long published;
    private long crawled;
    private OriginBean origin;
    private String author;
    private SummaryBean summary;
    private VisualBean visual;
    private boolean unread;
    private List<String> keywords;
    private List<AlternateBean> alternate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getPublished() {
        return published;
    }

    public void setPublished(long published) {
        this.published = published;
    }

    public long getCrawled() {
        return crawled;
    }

    public void setCrawled(long crawled) {
        this.crawled = crawled;
    }

    public OriginBean getOrigin() {
        return origin;
    }

    public void setOrigin(OriginBean origin) {
        this.origin = origin;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public SummaryBean getSummary() {
        return summary;
    }

    public void setSummary(SummaryBean summary) {
        this.summary = summary;
    }

    public VisualBean getVisual() {
        return visual;
    }

    public void setVisual(VisualBean visual) {
        this.visual = visual;
    }

    public boolean isUnread() {
        return unread;
    }

    public void setUnread(boolean unread) {
        this.unread = unread;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<AlternateBean> getAlternate() {
        return alternate;
    }

    public void setAlternate(List<AlternateBean> alternate) {
        this.alternate = alternate;
    }

    public static class OriginBean {
        /**
         * streamId : feed/http://www.36kr.com/feed
         * title : 36氪
         * htmlUrl : http://36kr.com
         */

        private String streamId;
        private String title;
        private String htmlUrl;

        public String getStreamId() {
            return streamId;
        }

        public void setStreamId(String streamId) {
            this.streamId = streamId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getHtmlUrl() {
            return htmlUrl;
        }

        public void setHtmlUrl(String htmlUrl) {
            this.htmlUrl = htmlUrl;
        }
    }

    public static class SummaryBean {
        /**
         * content : <p>据<a href="https://www.reuters.com/article/us-kenya-uber/uber-to-push-further-into-east-africa-with-services-like-chap-chap-idUSKBN1L21PF?feedType=RSS&feedName=technologyNews" target="_blank">路透</a>，Uber 上周五表示，今年结束前将再进军两个东非国家，并且将在这些国家重点发展节能的设备，比如已经在肯尼亚投放的经济车型“Chap Chap”。</p><p>“<a href="https://www.urbandictionary.com/define.php?term=chap%21%20chap%21" target="_blank">Chap Chap</a>”在非洲本土的斯瓦西里语中意为“快点！快点！”。Uber 于今年 1 月在非洲推出了新车型 Chap Chap 用于打车服务。为了打通供应链，Uber 与内罗毕的大陆汽车集团（CMC Motors）以及肯尼亚的 Stanbic 银行达成合作，第一代 Chap Chap 选用性价比较高的小轿车铃木奥拓，耗油少，续航好，等级较高的 Uber 司机能够在三年内获得一定程度的资助来买车。</p><p>Chap Chap相当省油节能，<span>因此Chap Chap的打车服务价格也相对较低。Chap Chap起步价大概在 100 肯尼亚先令左右（约合 6.8 元人民币），和 UberX 的价格（起步价在 10 元人民币左右）相比便宜不少。</span></p><p><span></span></p><p><img width="521" data-img-size-val="521,391" src="https://pic.36krcnd.com/201808/18084249/bj6st390oxtcgccv.jpg!heading"></p><p><span>此举被认为是 Uber 以应对肯尼亚当地主要对手之举。</span><span>肯尼亚是东非人均收入最高的经济体，也是 Uber 在撒哈拉以南非洲的第二大市场。在当地，Uber 的主要对手是</span><span>来自</span><span>爱沙尼亚的打车软件 Taxify、内罗毕的 Mondo Ride 与 Little。\xa0</span></p><p>打车巨头如 Uber 和滴滴，在海外扩张的过程中本土化是一大问题。无论是和滴滴那场著名的烧钱大战，在东南亚和 Grab、Go-Jek 的激战，还是在俄罗斯与 Yandex NV 的握手言和，都体现出海外扩张之难。</p><p>而即便在自家境内，Uber也早已应接不暇，Uber 在美国的竞争对手 Lyft 目前已占据 25% 的市场份额。</p><p>在相对来说还没那么多人踏足的非洲大陆，Uber会秉持一贯的高举高打战略，还是换个方法？直接推行 Chap Chap 这样的出行工具或许是牢牢把握住司机端和运营成本的方法，但这种模式相当重，而且目前已经有司机<a href="https://techcrunch.com/2018/02/13/uber-launches-a-new-lower-priced-service-called-chap-chap-in-nairobi/?guccounter=1" target="_blank">抱怨</a>，这么低的收费会削减他们的收入。</p><p>Uber 的 Chap Chap 首先将会在肯尼亚的内罗毕上线，接下来，Uber 将会把大约 300 辆常规车辆换成 Chap Chap，截止目前就有超过 400 辆 Uber 在内罗毕运营。</p>
         * direction : ltr
         */

        private String content;
        private String direction;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }
    }

    public static class VisualBean {
        /**
         * processor : feedly-nikon-v3.1
         * url : https://pic.36krcnd.com/201808/18084249/bj6st390oxtcgccv.jpg!heading
         * width : 800
         * height : 600
         * contentType : image/jpeg
         */

        private String processor;
        private String url;
        private int width;
        private int height;
        private String contentType;

        public String getProcessor() {
            return processor;
        }

        public void setProcessor(String processor) {
            this.processor = processor;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }
    }

    public static class AlternateBean {
        /**
         * href : http://36kr.com/p/5148901.html?ktm_source=feed
         * type : text/html
         */

        private String href;
        private String type;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
