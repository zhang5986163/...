package zhangxuelei1506d.week02demo_test;

import com.google.gson.Gson;

import java.util.List;

/**
 * date 2017/9/10
 * author:张学雷(Administrator)
 * functinn:
 */

public class myBean {


    public List<美女Bean> 美女;

    @Override
    public String toString() {
        return "myBean{" +
                "美女=" + 美女 +
                '}';
    }

    public static class 美女Bean {
        /**
         * adtype : 0
         * boardid : comment_bbs
         * clkNum : 0
         * danmu : 1
         * digest : 刘亦菲 美女 芭莎珠宝
         * docid : CPLLK82N9001K82O
         * downTimes : 281
         * hasAD : 1
         * img : http://dmr.nosdn.127.net/dOVN9NBtaOHctPEH53sbcQ==/6896093023029081169.jpg
         * imgType : 0
         * imgsrc : http://dmr.nosdn.127.net/dOVN9NBtaOHctPEH53sbcQ==/6896093023029081169.jpg
         * imgsum : 0
         * picCount : 0
         * pixel : 700*933
         * program : HY
         * prompt : 成功为您推荐20条新内容
         * rank : 0
         * recNews : 0
         * recType : 0
         * refreshPrompt : 0
         * replyCount : 7
         * replyid : CPLLK82N9001K82O
         * source : 堆糖网
         * title : 刘亦菲 美女 芭莎珠宝
         * upTimes : 141
         */

        public int adtype;
        public String boardid;
        public int clkNum;
        public int danmu;
        public String digest;
        public String docid;
        public int downTimes;
        public int hasAD;
        public String img;
        public int imgType;
        public String imgsrc;
        public int imgsum;
        public int picCount;
        public String pixel;
        public String program;
        public String prompt;
        public int rank;
        public int recNews;
        public int recType;
        public int refreshPrompt;
        public int replyCount;
        public String replyid;
        public String source;
        public String title;
        public int upTimes;

        @Override
        public String toString() {
            return "美女Bean{" +
                    "adtype=" + adtype +
                    ", boardid='" + boardid + '\'' +
                    ", clkNum=" + clkNum +
                    ", danmu=" + danmu +
                    ", digest='" + digest + '\'' +
                    ", docid='" + docid + '\'' +
                    ", downTimes=" + downTimes +
                    ", hasAD=" + hasAD +
                    ", img='" + img + '\'' +
                    ", imgType=" + imgType +
                    ", imgsrc='" + imgsrc + '\'' +
                    ", imgsum=" + imgsum +
                    ", picCount=" + picCount +
                    ", pixel='" + pixel + '\'' +
                    ", program='" + program + '\'' +
                    ", prompt='" + prompt + '\'' +
                    ", rank=" + rank +
                    ", recNews=" + recNews +
                    ", recType=" + recType +
                    ", refreshPrompt=" + refreshPrompt +
                    ", replyCount=" + replyCount +
                    ", replyid='" + replyid + '\'' +
                    ", source='" + source + '\'' +
                    ", title='" + title + '\'' +
                    ", upTimes=" + upTimes +
                    '}';
        }
    }
}
