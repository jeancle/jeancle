package com.jeancle.cheap.bean;

import java.util.List;

/**
 * Created by Administrator on 2017-10-14.
 */

public class GoodsBean {

    /**
     * tbk_item_get_response : {"results":{"n_tbk_item":[{"item_url":"http://item.taobao.com/item.htm?id=556780704940","nick":"衣拉格旗舰店","num_iid":556780704940,"pict_url":"http://img1.tbcdn.cn/tfscom/i3/1824312815/TB10JttjwMPMeJjy1XbXXcwxVXa_!!0-item_pic.jpg","provcity":"广东 东莞","reserve_price":"566.00","seller_id":1824312815,"small_images":{"string":["http://img4.tbcdn.cn/tfscom/i3/1824312815/TB2hjLFfjuhSKJjSspdXXc11XXa_!!1824312815.jpg","http://img3.tbcdn.cn/tfscom/i4/1824312815/TB2KKs3evNNTKJjSspkXXaeWFXa_!!1824312815.jpg","http://img3.tbcdn.cn/tfscom/i1/1824312815/TB2mynBXBE_1uJjSZFOXXXNwXXa_!!1824312815.jpg","http://img2.tbcdn.cn/tfscom/i8/TB1jYkLSFXXXXcVXXXXYXGcGpXX_M2.SS2"]},"title":"秋装女2017新款长袖针织连衣裙秋冬女装羊绒衫毛衣打底裙中长款","user_type":1,"volume":1459,"zk_final_price":"399.00"},{"item_url":"http://item.taobao.com/item.htm?id=538586058526","nick":"尘埃之家旗舰店","num_iid":538586058526,"pict_url":"http://img4.tbcdn.cn/tfscom/i1/TB1P6mVPpXXXXbaXpXXXXXXXXXX_!!0-item_pic.jpg","provcity":"浙江 温州","reserve_price":"798.00","seller_id":1894729836,"small_images":{"string":["http://img1.tbcdn.cn/tfscom/i1/1894729836/TB2c0m_a8LzQeBjSZFoXXc5gFXa_!!1894729836.jpg","http://img2.tbcdn.cn/tfscom/i1/1894729836/TB2cuxpXCPA11Bjy0FaXXbucXXa_!!1894729836.jpg","http://img3.tbcdn.cn/tfscom/i4/1894729836/TB2AaAgfHBkpuFjy1zkXXbSpFXa_!!1894729836.jpg","http://img4.tbcdn.cn/tfscom/i2/1894729836/TB2tmQnfKJ8puFjy1XbXXagqVXa_!!1894729836.jpg"]},"title":"2017秋季新款女装气质修身纯色西装领风衣中长款休闲薄款外套G38","user_type":1,"volume":1259,"zk_final_price":"398.00"}]},"total_results":19834,"request_id":"qm3q8zzdyhmd"}
     */

    private TbkItemGetResponseBean tbk_item_get_response;

    public TbkItemGetResponseBean getTbk_item_get_response() {
        return tbk_item_get_response;
    }

    public void setTbk_item_get_response(TbkItemGetResponseBean tbk_item_get_response) {
        this.tbk_item_get_response = tbk_item_get_response;
    }

    public static class TbkItemGetResponseBean {
        /**
         * results : {"n_tbk_item":[{"item_url":"http://item.taobao.com/item.htm?id=556780704940","nick":"衣拉格旗舰店","num_iid":556780704940,"pict_url":"http://img1.tbcdn.cn/tfscom/i3/1824312815/TB10JttjwMPMeJjy1XbXXcwxVXa_!!0-item_pic.jpg","provcity":"广东 东莞","reserve_price":"566.00","seller_id":1824312815,"small_images":{"string":["http://img4.tbcdn.cn/tfscom/i3/1824312815/TB2hjLFfjuhSKJjSspdXXc11XXa_!!1824312815.jpg","http://img3.tbcdn.cn/tfscom/i4/1824312815/TB2KKs3evNNTKJjSspkXXaeWFXa_!!1824312815.jpg","http://img3.tbcdn.cn/tfscom/i1/1824312815/TB2mynBXBE_1uJjSZFOXXXNwXXa_!!1824312815.jpg","http://img2.tbcdn.cn/tfscom/i8/TB1jYkLSFXXXXcVXXXXYXGcGpXX_M2.SS2"]},"title":"秋装女2017新款长袖针织连衣裙秋冬女装羊绒衫毛衣打底裙中长款","user_type":1,"volume":1459,"zk_final_price":"399.00"},{"item_url":"http://item.taobao.com/item.htm?id=538586058526","nick":"尘埃之家旗舰店","num_iid":538586058526,"pict_url":"http://img4.tbcdn.cn/tfscom/i1/TB1P6mVPpXXXXbaXpXXXXXXXXXX_!!0-item_pic.jpg","provcity":"浙江 温州","reserve_price":"798.00","seller_id":1894729836,"small_images":{"string":["http://img1.tbcdn.cn/tfscom/i1/1894729836/TB2c0m_a8LzQeBjSZFoXXc5gFXa_!!1894729836.jpg","http://img2.tbcdn.cn/tfscom/i1/1894729836/TB2cuxpXCPA11Bjy0FaXXbucXXa_!!1894729836.jpg","http://img3.tbcdn.cn/tfscom/i4/1894729836/TB2AaAgfHBkpuFjy1zkXXbSpFXa_!!1894729836.jpg","http://img4.tbcdn.cn/tfscom/i2/1894729836/TB2tmQnfKJ8puFjy1XbXXagqVXa_!!1894729836.jpg"]},"title":"2017秋季新款女装气质修身纯色西装领风衣中长款休闲薄款外套G38","user_type":1,"volume":1259,"zk_final_price":"398.00"}]}
         * total_results : 19834
         * request_id : qm3q8zzdyhmd
         */

        private ResultsBean results;
        private int total_results;
        private String request_id;

        public ResultsBean getResults() {
            return results;
        }

        public void setResults(ResultsBean results) {
            this.results = results;
        }

        public int getTotal_results() {
            return total_results;
        }

        public void setTotal_results(int total_results) {
            this.total_results = total_results;
        }

        public String getRequest_id() {
            return request_id;
        }

        public void setRequest_id(String request_id) {
            this.request_id = request_id;
        }

        public static class ResultsBean {
            private List<NTbkItemBean> n_tbk_item;

            public List<NTbkItemBean> getN_tbk_item() {
                return n_tbk_item;
            }

            public void setN_tbk_item(List<NTbkItemBean> n_tbk_item) {
                this.n_tbk_item = n_tbk_item;
            }

            public static class NTbkItemBean {
                /**
                 * item_url : http://item.taobao.com/item.htm?id=556780704940
                 * nick : 衣拉格旗舰店
                 * num_iid : 556780704940
                 * pict_url : http://img1.tbcdn.cn/tfscom/i3/1824312815/TB10JttjwMPMeJjy1XbXXcwxVXa_!!0-item_pic.jpg
                 * provcity : 广东 东莞
                 * reserve_price : 566.00
                 * seller_id : 1824312815
                 * small_images : {"string":["http://img4.tbcdn.cn/tfscom/i3/1824312815/TB2hjLFfjuhSKJjSspdXXc11XXa_!!1824312815.jpg","http://img3.tbcdn.cn/tfscom/i4/1824312815/TB2KKs3evNNTKJjSspkXXaeWFXa_!!1824312815.jpg","http://img3.tbcdn.cn/tfscom/i1/1824312815/TB2mynBXBE_1uJjSZFOXXXNwXXa_!!1824312815.jpg","http://img2.tbcdn.cn/tfscom/i8/TB1jYkLSFXXXXcVXXXXYXGcGpXX_M2.SS2"]}
                 * title : 秋装女2017新款长袖针织连衣裙秋冬女装羊绒衫毛衣打底裙中长款
                 * user_type : 1
                 * volume : 1459
                 * zk_final_price : 399.00
                 */

                private String item_url;
                private String nick;
                private long num_iid;
                private String pict_url;
                private String provcity;
                private String reserve_price;
                private int seller_id;
                private SmallImagesBean small_images;
                private String title;
                private int user_type;
                private int volume;
                private String zk_final_price;

                public String getItem_url() {
                    return item_url;
                }

                public void setItem_url(String item_url) {
                    this.item_url = item_url;
                }

                public String getNick() {
                    return nick;
                }

                public void setNick(String nick) {
                    this.nick = nick;
                }

                public long getNum_iid() {
                    return num_iid;
                }

                public void setNum_iid(long num_iid) {
                    this.num_iid = num_iid;
                }

                public String getPict_url() {
                    return pict_url;
                }

                public void setPict_url(String pict_url) {
                    this.pict_url = pict_url;
                }

                public String getProvcity() {
                    return provcity;
                }

                public void setProvcity(String provcity) {
                    this.provcity = provcity;
                }

                public String getReserve_price() {
                    return reserve_price;
                }

                public void setReserve_price(String reserve_price) {
                    this.reserve_price = reserve_price;
                }

                public int getSeller_id() {
                    return seller_id;
                }

                public void setSeller_id(int seller_id) {
                    this.seller_id = seller_id;
                }

                public SmallImagesBean getSmall_images() {
                    return small_images;
                }

                public void setSmall_images(SmallImagesBean small_images) {
                    this.small_images = small_images;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getUser_type() {
                    return user_type;
                }

                public void setUser_type(int user_type) {
                    this.user_type = user_type;
                }

                public int getVolume() {
                    return volume;
                }

                public void setVolume(int volume) {
                    this.volume = volume;
                }

                public String getZk_final_price() {
                    return zk_final_price;
                }

                public void setZk_final_price(String zk_final_price) {
                    this.zk_final_price = zk_final_price;
                }

                public static class SmallImagesBean {
                    private List<String> string;

                    public List<String> getString() {
                        return string;
                    }

                    public void setString(List<String> string) {
                        this.string = string;
                    }
                }
            }
        }
    }
}
