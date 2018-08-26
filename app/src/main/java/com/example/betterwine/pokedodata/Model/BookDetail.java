package com.example.betterwine.pokedodata.Model;

import java.util.List;

public class BookDetail {
    /**
     * rating : {"max":10,"numRaters":1666,"average":"8.0","min":0}
     * subtitle :
     * author : ["Magnus Lie Hetland"]
     * pubdate : 2010-7
     * tags : [{"count":1798,"name":"python","title":"python"},{"count":911,"name":"编程","title":"编程"},{"count":554,"name":"Python","title":"Python"},{"count":429,"name":"程序设计","title":"程序设计"},{"count":390,"name":"计算机","title":"计算机"},{"count":363,"name":"脚本语言","title":"脚本语言"},{"count":192,"name":"软件开发","title":"软件开发"},{"count":179,"name":"programming","title":"programming"}]
     * origin_title : Beginning Python: From Novice to Professional, Second Edition
     * image : https://img3.doubanio.com/view/subject/m/public/s4387251.jpg
     * binding : 平装
     * translator : ["司维","曾军崴","谭颖华"]
     * catalog : 第1章 基础知识
     1.1 安装Python
     1.1.1 Windows
     1.1.2 Linux和UNIX
     1.1.3 苹果机（Macintosh）
     1.1.4 其他发布版
     1.1.5 时常关注，保持更新
     1.2 交互式解释器
     1.3 算法是什么
     1.4 数字和表达式
     1.4.1 长整型数
     1.4.2 十六进制和八进制
     1.5 变量
     1.6 语句
     1.7 获取用户输入
     1.8 函数
     1.9 模块
     1.9.1 cmath和复数
     1.9.2 回到future
     1.10 保存并执行程序
     1.10.1 通过命令提示符运行Python脚本
     1.10.2 让脚本像普通程序一样运行
     1.10.3 注释
     1.11 字符串
     1.11.1 单引号字符串和转义引号
     1.11.2 拼接字符串
     1.11.3 字符串表示和repr
     1.11.4 input和rawinpm的比较
     1.11.5 长字符串、原始字符串和Unicode
     1.12 小结
     1.12.1 本章的新函数
     1.12.2 接下来学什么
     第2章 列表和元组
     2.1 序列概览
     2.2 通用序列操作
     2.2.1 索引
     2.2.2 分片
     2.2.3 序列相加
     2.2.4.乘法
     2.2.5 成员资格
     2.2.6 长度、最小值和最大值
     2.3 列表：Python的“苦力”
     2.3.1 list函数
     2.3.2 基本的列表操作
     2.3.3 列表方法
     2.4 元组：不可变序列
     2.4.1 tuple函数
     2.4.2 基本元组操作
     2.4.3 那么，意义何在
     2.5 小结
     2.5.1 本章的新函数
     2.5.2 接下来学什么
     第3章 使用字符串
     3.1 基本字符串操作
     3.2 字符串格式化：精简版
     3.3 字符串格式化：完整版
     3.3.1 简单转换
     3.3.2 字段宽度和精度
     3.3.3 符号、对齐和0填充
     3.4 字符串方法
     3.4.1 f1nd
     3.4.2 join
     3.4.3 jower
     3.4.4 replace
     3.4.5 spl1t
     3.4.6 strlD
     3.4.7 tralqslate
     3.5 小结
     3.5.1 本章的新函数
     3.5.2 接下来学什么
     第4章 字典：当索引不好用时
     4.1 字典的使用
     4.2 创建和使用字典
     4.2.1 dict函数
     4.2.2 基本字典操作
     4.2.3 字典的格式化字符串
     4.2.4 字典方法
     4.3 小结
     4.3.1 本章的新函数
     4.3.2 接下来学什么
     第5章 条件、循环和其他语句
     5.1 print和import的更多信息
     5.1.1 使用逗号输出
     5.1.2 把某件事作为另一件事导入
     5.2 赋值魔法
     5.2.1 序列解包
     5.2.2 链式赋值
     5.2.3 增量赋值
     5.3 语句块：缩排的乐趣
     5.4 条件和条件语句
     5.4.1 这就是布尔变量的作用
     5.4.2 条件执行和if语句
     5.4.3 else子句
     5.4.4 elif子句
     5.4.5 嵌套代码块
     5.4.6 更复杂的条件
     5.4.7 断言
     5.5 循环
     5.5.1 while循环
     5.5.2 for循环
     5.5.3 循环遍历字典元素
     5.5.4 一些迭代工具
     5.5.5 跳出循环
     5.5.6 循环中的else子句
     5.6 列表推导式——轻量级循环
     5.7 三人行
     5.7.1 什么都没发生
     5.7.2 使用del删除
     5.7.3 使用exec和eval执行和求值字符串
     5.8 小结
     5.8.1 本章的新函数
     5.8.2 接下来学什么
     第6章 抽象
     6.1 懒惰即美德
     6.2 抽象和结构
     6.3 创建函数
     6.3.1 记录函数
     6.3.2 并非真正函数的函数
     6.4 参数魔法
     6.4.1 值从哪里来
     6.4.2 我能改变参数吗
     6.4.3 关键字参数和默认值
     6.4.4 收集参数
     6.4.5 反转过程
     6.4.6 练习使用参数
     6.5 作用域
     6.6 递归
     6.6.1 两个经典：阶乘和幂
     6.6.2 另外一个经典：二元查找
     6.7 小结
     6.7.1 本章的新函数
     6.7.2 接下来学什么
     第7章 更加抽象
     7.1 对象的魔力
     7.1.1 多态
     7.1.2 封装
     7.1.3 继承
     7.2 类和类型
     7.2.1 类到底是什么
     7.2.2 创建自己的类
     7.2.3 特性、函数和方法
     7.2.4 类的命名空间
     7.2.5 指定超类
     7.2.6 调查继承
     7.2.7 多个超类
     7.2.8 接口和内省
     7.3 一些关于面向对象设计的思考
     7.4 简明总结
     7.4.1 本章的新函数
     7.4.2 接下来学什么
     第8章 异常
     8.1 什么是异常
     8.2 按自己的方式出错
     8.2.1 raise语句
     8.2.2 自定义异常类
     8.3 捕捉异常
     8.4 不止一个except子句
     8.5 用一个块捕捉两个异常
     8.6 捕捉对象
     8.7 真正的全捕捉
     8.8 万事大吉
     8.9 最后
     8.10 异常和函数
     8.11 异常之禅
     8.12小结
     8.12.1 本章的新函数
     8.12.2 接下来学什么
     第9章 魔法方法、属性和迭代器
     9.1 准备工作
     9.2 构造方法
     9.2.1 重写一般方法和特殊的构造方法
     9.2.2 调用未绑定的超类构造方法
     9.2.3 使用super、函数
     9.3 成员访问
     9.3.1 基本的序列和映射规则
     9.3.2 子类化列表，字典和字符串
     9.4 更多魔力
     9.5 属性
     9.5.1 property函数
     9.5.2 静态方法和类成员方法
     9.5.3 getattr、setattr和它的朋友们
     9.6 迭代器
     9.6.1 迭代器规则
     9.6.2 从迭代器得到序列
     9.7 生成器
     9.7.1 创建生成器
     9.7.2 递归生成器
     9.7.3 通用生成器
     9.7.4 生成器方法
     9.7.5 模拟生成器
     9.8 八皇后问题
     9.8.1 生成器和回溯
     9.8.2 问题
     9.8.3 状态表示
     9.8.4 寻找冲突
     9.8.5 基本情况
     9.8.6 需要递归的情况
     9.8.7 打包
     9.9 小结
     9.9.1 本章的新函数
     9.9.2 接下来学什么
     第10章 充电时刻
     10.1 模块
     10.1.1 模块是程序
     10.1.2 模块用于定义
     10.1.3 让你的模块可用
     10.1.4 包
     10.2 探究模块
     10.2.1 模块中有什么
     10.2.2 用help获取帮助
     10.2.3 文档
     10.2.4 使用源代码
     10.3 标准库：一些最爱
     10.3.1 sys
     10.3.2 OS
     10.3.3 fileinput
     10.3.4 集合、堆和双端队列
     10.3.5 time
     10.3.6 random
     10.3.7 shelve
     10.3.8 re
     10.3.9 其他有趣的标准模块
     10.4 小结
     10.4.1 本章的新函数
     10.4.2 接下来学什么
     第11章 文件和素材
     11.1 打开文件
     11.1.1 文件模式
     11.1.2 缓冲
     11.2 基本文件方法
     11.2.1 读和写
     11.2.2 管式输出
     11.2.3 读写行
     11.2.4 关闭文件
     11.2.5 使用基本文件方法
     11.3 对文件内容进行迭代
     11.3.1 按字节处理
     11.3.2 按行操作
     11.3.3 读取所有内容
     11.3.4 使用fileinput实现懒惰行迭代
     11.3.5 文件迭代器
     11.4 小结
     11.4.1 本章的新函数
     11.4.2 接下来学什么
     第12章 图形用户界面
     12.1 丰富的平台
     12.2 下载和安装wxpytbon
     12.3 创建示例GUI应用程序
     12.3.1 开始
     12.3.2 窗口和组件
     12.3.3 标签、标题和位置
     12.3.4 更智能的布局
     12.3.5 事件处理
     12.3.6 完成了的程序
     12.4 但是我宁愿用
     12.4..1 使用Tkinter
     12.4.2 使用Jython和Swing
     12.4..3 使用其他开发包
     12.5 小结
     第13章 数据库支持
     13.1 Python数据库API
     13.1.1 全局变量
     13.1.2 异常
     13.1.3 连接和游标
     13.1.4 类型
     13.2 SQLite和PySQLite
     13.2.1 入门
     13.2.2 数据库应用程序示例
     13.3 小结
     13.3.1 本章的新函数
     13.3.2 接下来学什么
     第14章 网络编程
     14.1 少数几个网络设计模块
     14.1.1 socket模块
     14.1.2 urllib和urllib2模块
     14.1.3 其他模块
     14.2 SocketServer和它的朋友们
     14.3 多连接
     14.3.1 使用SocketServer进行分叉和线程处理
     14.3.2 带有select和port的异步I／O
     14.4 Twisted
     14.4.1 下裁并安装Twisted
     14.4.2 编写Twisted服务器
     14.5 小结
     14.5.1 本章的新函数
     14.5.2 接下来学什么
     第15章 Python和万维网
     15.1 屏幕抓取
     15.1.1 Tidy和XHTML解析
     ……
     第16章 测试
     第17章 扩展Python
     第18章 程序打包
     第19章 好玩的编程
     第20章 项目1：即时标记
     第21章 项目2：画幅好画
     第22章 项目3：万能的XML
     第23章 项目4：新闻聚合
     第24章 项目5：虚拟茶话会
     第25章 项目6：使用CGI进行远程编辑
     第26章 项目7：自定义电子公告板
     第27章 项目8：使用XML-RPC进行文件共享
     第28章 项目9：文件共享2——GUI版本
     第29章 项目10：DIY街机游戏
     附录A 简明版本
     附录B Python参考手册
     附录C 在线资源
     附录D Python3.0
     * pages : 471
     * images : {"small":"https://img3.doubanio.com/view/subject/s/public/s4387251.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s4387251.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s4387251.jpg"}
     * alt : https://book.douban.com/subject/4866934/
     * id : 4866934
     * publisher : 人民邮电出版社
     * isbn10 : 7115230277
     * isbn13 : 9787115230270
     * title : Python基础教程
     * url : https://api.douban.com/v2/book/4866934
     * alt_title : Beginning Python: From Novice to Professional, Second Edition
     * author_intro : Magnus Lie Hetland是挪威科技大学副教授，教授算法。喜欢钻研新的编程语言，是Python语言的坚定支持者。他写过很多Python方面的书和在线教程，比如深受大家欢迎的网上教程Instant Python。
     * summary : 本书是经典教程的全新改版，作者根据Python 3.0版本的种种变化，全面改写了书中内容，做到既能“瞻前”也能“顾后”。本书层次鲜明、结构严谨、内容翔实，特别是在最后几章，作者将前面讲述的内容应用到了10个引人入胜的项目中，并以模板的形式介绍了项目的开发过程。本书既适合初学者夯实基础，又能帮助Python程序员提升技能，即使是 Python方面的技术专家，也能从书里找到令你耳目一新的东西。
     * series : {"id":"660","title":"图灵程序设计丛书"}
     * price : 69.00元
     */

    private RatingBean rating;
    private String subtitle;
    private String pubdate;
    private String origin_title;
    private String image;
    private String binding;
    private String catalog;
    private String pages;
    private ImagesBean images;
    private String alt;
    private String id;
    private String publisher;
    private String isbn10;
    private String isbn13;
    private String title;
    private String url;
    private String alt_title;
    private String author_intro;
    private String summary;
    private SeriesBean series;
    private String price;
    private List<String> author;
    private List<TagsBean> tags;
    private List<String> translator;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getOrigin_title() {
        return origin_title;
    }

    public void setOrigin_title(String origin_title) {
        this.origin_title = origin_title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlt_title() {
        return alt_title;
    }

    public void setAlt_title(String alt_title) {
        this.alt_title = alt_title;
    }

    public String getAuthor_intro() {
        return author_intro;
    }

    public void setAuthor_intro(String author_intro) {
        this.author_intro = author_intro;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public SeriesBean getSeries() {
        return series;
    }

    public void setSeries(SeriesBean series) {
        this.series = series;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public List<String> getTranslator() {
        return translator;
    }

    public void setTranslator(List<String> translator) {
        this.translator = translator;
    }

    public static class RatingBean {
        /**
         * max : 10
         * numRaters : 1666
         * average : 8.0
         * min : 0
         */

        private int max;
        private int numRaters;
        private String average;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getNumRaters() {
            return numRaters;
        }

        public void setNumRaters(int numRaters) {
            this.numRaters = numRaters;
        }

        public String getAverage() {
            return average;
        }

        public void setAverage(String average) {
            this.average = average;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    public static class ImagesBean {
        /**
         * small : https://img3.doubanio.com/view/subject/s/public/s4387251.jpg
         * large : https://img3.doubanio.com/view/subject/l/public/s4387251.jpg
         * medium : https://img3.doubanio.com/view/subject/m/public/s4387251.jpg
         */

        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class SeriesBean {
        /**
         * id : 660
         * title : 图灵程序设计丛书
         */

        private String id;
        private String title;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class TagsBean {
        /**
         * count : 1798
         * name : python
         * title : python
         */

        private int count;
        private String name;
        private String title;

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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
