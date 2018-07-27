package com.jeancle.cheap.bean;

import java.util.List;

/**
 * Created by Administrator on 2017-10-24.
 */

public class TicketsBean {

    /**
     * tbk_dg_item_coupon_get_response : {"results":{"tbk_coupon":[{"category":16,"commission_rate":"20.00","coupon_click_url":"https://uland.taobao.com/coupon/edetail?e=UrDT7jvEnzgGQASttHIRqaWVEtLH1cqXTBmNv2z4kq3eQisExutkD54tU8UyS3uyO%2FgE7%2FzCDlkde5UWjmQdBi5xf6U1J1ca819cieM8MLZzppLDP9AMmXIvacBiK1M8j%2BNTD8KNk%2BMR3PhK39%2BawfvQFWeqWAJiTq8oPC0XKpfnbYfZPG6qkkBsXx8cnY%2FDiHg3NJBnXSUSFW2CiO511w%3D%3D&traceId=0bfa98eb15323586648412539e","coupon_end_time":"2018-07-27","coupon_info":"满49元减20元","coupon_remain_count":47500,"coupon_start_time":"2018-07-21","coupon_total_count":50000,"item_description":"收藏加购付款优先发货，赠送运费险退货无忧","item_url":"http://detail.tmall.com/item.htm?id=566797988779","nick":"春晴旗舰店","num_iid":566797988779,"pict_url":"http://img.alicdn.com/tfscom/i3/1766066783/TB29runrkSWBuNjSszdXXbeSpXa_!!1766066783-0-item_pic.jpg","seller_id":1766066783,"shop_title":"春晴旗舰店","small_images":{"string":["http://img.alicdn.com/tfscom/i4/1766066783/TB20ZEopDtYBeNjy1XdXXXXyVXa_!!1766066783.jpg","http://img.alicdn.com/tfscom/i4/1766066783/TB2s8T5A1GSBuNjSspbXXciipXa_!!1766066783.jpg","http://img.alicdn.com/tfscom/i4/1766066783/TB2J5p_pASWBuNjSszdXXbeSpXa_!!1766066783.jpg","http://img.alicdn.com/tfscom/i2/1766066783/TB2xxyVvHSYBuNjSspfXXcZCpXa_!!1766066783.jpg"]},"title":"2018新款中老年女装夏装洋气两件套装中年妈妈短袖t恤夏季50上衣","user_type":1,"volume":5953,"zk_final_price":"49.90"},{"category":16,"commission_rate":"5.50","coupon_click_url":"https://uland.taobao.com/coupon/edetail?e=fYeRaIbTdkkGQASttHIRqRoZshCYQru1Fz9VveEa9FnB76UlhXoJ92sUGo3Jfj6CiUGPkZlmCQ3%2BLLjeDQkWPrZfqLtZUbQt819cieM8MLZzppLDP9AMmXIvacBiK1M8j%2BNTD8KNk%2BMR3PhK39%2BawfvQFWeqWAJiTq8oPC0XKpfnbYfZPG6qkkBsXx8cnY%2FDiHg3NJBnXSUSFW2CiO511w%3D%3D&traceId=0bfa98eb15323586648412539e","coupon_end_time":"2018-07-26","coupon_info":"满39元减10元","coupon_remain_count":79279,"coupon_start_time":"2018-07-18","coupon_total_count":100000,"item_description":"升级版可露头发 大帽口罩护领 加长半指袖","item_url":"http://detail.tmall.com/item.htm?id=547985308669","nick":"爱莱蒙旗舰店","num_iid":547985308669,"pict_url":"http://img.alicdn.com/tfscom/i1/1051175817/TB25Q_0oYuWBuNjSszgXXb8jVXa_!!1051175817-0-item_pic.jpg","seller_id":1051175817,"shop_title":"爱莱蒙旗舰店","small_images":{"string":["http://img.alicdn.com/tfscom/i4/1051175817/TB2Xz_tuR4lpuFjy1zjXXcAKpXa_!!1051175817.jpg","http://img.alicdn.com/tfscom/i3/1051175817/TB2AkSQuNXlpuFjSsphXXbJOXXa_!!1051175817.jpg","http://img.alicdn.com/tfscom/i3/1051175817/TB26XibtyC9MuFjSZFoXXbUzFXa_!!1051175817.jpg","http://img.alicdn.com/tfscom/i3/1051175817/TB2.Mb9sbBkpuFjy1zkXXbSpFXa_!!1051175817.jpg"]},"title":"2018夏季新款防晒衣女装中长款薄外套开衫韩版潮长袖防晒服防晒衫","user_type":1,"volume":81746,"zk_final_price":"39.00"}]},"total_results":100,"request_id":"2m6jsgh4rqh6"}
     */

    private TbkDgItemCouponGetResponseBean tbk_dg_item_coupon_get_response;

    public TbkDgItemCouponGetResponseBean getTbk_dg_item_coupon_get_response() {
        return tbk_dg_item_coupon_get_response;
    }

    public void setTbk_dg_item_coupon_get_response(TbkDgItemCouponGetResponseBean tbk_dg_item_coupon_get_response) {
        this.tbk_dg_item_coupon_get_response = tbk_dg_item_coupon_get_response;
    }

    public static class TbkDgItemCouponGetResponseBean {
        /**
         * results : {"tbk_coupon":[{"category":16,"commission_rate":"20.00","coupon_click_url":"https://uland.taobao.com/coupon/edetail?e=UrDT7jvEnzgGQASttHIRqaWVEtLH1cqXTBmNv2z4kq3eQisExutkD54tU8UyS3uyO%2FgE7%2FzCDlkde5UWjmQdBi5xf6U1J1ca819cieM8MLZzppLDP9AMmXIvacBiK1M8j%2BNTD8KNk%2BMR3PhK39%2BawfvQFWeqWAJiTq8oPC0XKpfnbYfZPG6qkkBsXx8cnY%2FDiHg3NJBnXSUSFW2CiO511w%3D%3D&traceId=0bfa98eb15323586648412539e","coupon_end_time":"2018-07-27","coupon_info":"满49元减20元","coupon_remain_count":47500,"coupon_start_time":"2018-07-21","coupon_total_count":50000,"item_description":"收藏加购付款优先发货，赠送运费险退货无忧","item_url":"http://detail.tmall.com/item.htm?id=566797988779","nick":"春晴旗舰店","num_iid":566797988779,"pict_url":"http://img.alicdn.com/tfscom/i3/1766066783/TB29runrkSWBuNjSszdXXbeSpXa_!!1766066783-0-item_pic.jpg","seller_id":1766066783,"shop_title":"春晴旗舰店","small_images":{"string":["http://img.alicdn.com/tfscom/i4/1766066783/TB20ZEopDtYBeNjy1XdXXXXyVXa_!!1766066783.jpg","http://img.alicdn.com/tfscom/i4/1766066783/TB2s8T5A1GSBuNjSspbXXciipXa_!!1766066783.jpg","http://img.alicdn.com/tfscom/i4/1766066783/TB2J5p_pASWBuNjSszdXXbeSpXa_!!1766066783.jpg","http://img.alicdn.com/tfscom/i2/1766066783/TB2xxyVvHSYBuNjSspfXXcZCpXa_!!1766066783.jpg"]},"title":"2018新款中老年女装夏装洋气两件套装中年妈妈短袖t恤夏季50上衣","user_type":1,"volume":5953,"zk_final_price":"49.90"},{"category":16,"commission_rate":"5.50","coupon_click_url":"https://uland.taobao.com/coupon/edetail?e=fYeRaIbTdkkGQASttHIRqRoZshCYQru1Fz9VveEa9FnB76UlhXoJ92sUGo3Jfj6CiUGPkZlmCQ3%2BLLjeDQkWPrZfqLtZUbQt819cieM8MLZzppLDP9AMmXIvacBiK1M8j%2BNTD8KNk%2BMR3PhK39%2BawfvQFWeqWAJiTq8oPC0XKpfnbYfZPG6qkkBsXx8cnY%2FDiHg3NJBnXSUSFW2CiO511w%3D%3D&traceId=0bfa98eb15323586648412539e","coupon_end_time":"2018-07-26","coupon_info":"满39元减10元","coupon_remain_count":79279,"coupon_start_time":"2018-07-18","coupon_total_count":100000,"item_description":"升级版可露头发 大帽口罩护领 加长半指袖","item_url":"http://detail.tmall.com/item.htm?id=547985308669","nick":"爱莱蒙旗舰店","num_iid":547985308669,"pict_url":"http://img.alicdn.com/tfscom/i1/1051175817/TB25Q_0oYuWBuNjSszgXXb8jVXa_!!1051175817-0-item_pic.jpg","seller_id":1051175817,"shop_title":"爱莱蒙旗舰店","small_images":{"string":["http://img.alicdn.com/tfscom/i4/1051175817/TB2Xz_tuR4lpuFjy1zjXXcAKpXa_!!1051175817.jpg","http://img.alicdn.com/tfscom/i3/1051175817/TB2AkSQuNXlpuFjSsphXXbJOXXa_!!1051175817.jpg","http://img.alicdn.com/tfscom/i3/1051175817/TB26XibtyC9MuFjSZFoXXbUzFXa_!!1051175817.jpg","http://img.alicdn.com/tfscom/i3/1051175817/TB2.Mb9sbBkpuFjy1zkXXbSpFXa_!!1051175817.jpg"]},"title":"2018夏季新款防晒衣女装中长款薄外套开衫韩版潮长袖防晒服防晒衫","user_type":1,"volume":81746,"zk_final_price":"39.00"}]}
         * total_results : 100
         * request_id : 2m6jsgh4rqh6
         */

        private ResultsBean results;
        private String total_results;
        private String request_id;

        public ResultsBean getResults() {
            return results;
        }

        public void setResults(ResultsBean results) {
            this.results = results;
        }

        public String getTotal_results() {
            return total_results;
        }

        public void setTotal_results(String total_results) {
            this.total_results = total_results;
        }

        public String getRequest_id() {
            return request_id;
        }

        public void setRequest_id(String request_id) {
            this.request_id = request_id;
        }

        public static class ResultsBean {
            private List<TbkCouponBean> tbk_coupon;

            public List<TbkCouponBean> getTbk_coupon() {
                return tbk_coupon;
            }

            public void setTbk_coupon(List<TbkCouponBean> tbk_coupon) {
                this.tbk_coupon = tbk_coupon;
            }

            public static class TbkCouponBean {
                /**
                 * category : 16
                 * commission_rate : 20.00
                 * coupon_click_url : https://uland.taobao.com/coupon/edetail?e=UrDT7jvEnzgGQASttHIRqaWVEtLH1cqXTBmNv2z4kq3eQisExutkD54tU8UyS3uyO%2FgE7%2FzCDlkde5UWjmQdBi5xf6U1J1ca819cieM8MLZzppLDP9AMmXIvacBiK1M8j%2BNTD8KNk%2BMR3PhK39%2BawfvQFWeqWAJiTq8oPC0XKpfnbYfZPG6qkkBsXx8cnY%2FDiHg3NJBnXSUSFW2CiO511w%3D%3D&traceId=0bfa98eb15323586648412539e
                 * coupon_end_time : 2018-07-27
                 * coupon_info : 满49元减20元
                 * coupon_remain_count : 47500
                 * coupon_start_time : 2018-07-21
                 * coupon_total_count : 50000
                 * item_description : 收藏加购付款优先发货，赠送运费险退货无忧
                 * item_url : http://detail.tmall.com/item.htm?id=566797988779
                 * nick : 春晴旗舰店
                 * num_iid : 566797988779
                 * pict_url : http://img.alicdn.com/tfscom/i3/1766066783/TB29runrkSWBuNjSszdXXbeSpXa_!!1766066783-0-item_pic.jpg
                 * seller_id : 1766066783
                 * shop_title : 春晴旗舰店
                 * small_images : {"string":["http://img.alicdn.com/tfscom/i4/1766066783/TB20ZEopDtYBeNjy1XdXXXXyVXa_!!1766066783.jpg","http://img.alicdn.com/tfscom/i4/1766066783/TB2s8T5A1GSBuNjSspbXXciipXa_!!1766066783.jpg","http://img.alicdn.com/tfscom/i4/1766066783/TB2J5p_pASWBuNjSszdXXbeSpXa_!!1766066783.jpg","http://img.alicdn.com/tfscom/i2/1766066783/TB2xxyVvHSYBuNjSspfXXcZCpXa_!!1766066783.jpg"]}
                 * title : 2018新款中老年女装夏装洋气两件套装中年妈妈短袖t恤夏季50上衣
                 * user_type : 1
                 * volume : 5953
                 * zk_final_price : 49.90
                 */

                private String category;
                private String commission_rate;
                private String coupon_click_url;
                private String coupon_end_time;
                private String coupon_info;
                private String coupon_remain_count;
                private String coupon_start_time;
                private String coupon_total_count;
                private String item_description;
                private String item_url;
                private String nick;
                private long num_iid;
                private String pict_url;
                private String seller_id;
                private String shop_title;
                private SmallImagesBean small_images;
                private String title;
                private String user_type;
                private String volume;
                private String zk_final_price;

                public String getCategory() {
                    return category;
                }

                public void setCategory(String category) {
                    this.category = category;
                }

                public String getCommission_rate() {
                    return commission_rate;
                }

                public void setCommission_rate(String commission_rate) {
                    this.commission_rate = commission_rate;
                }

                public String getCoupon_click_url() {
                    return coupon_click_url;
                }

                public void setCoupon_click_url(String coupon_click_url) {
                    this.coupon_click_url = coupon_click_url;
                }

                public String getCoupon_end_time() {
                    return coupon_end_time;
                }

                public void setCoupon_end_time(String coupon_end_time) {
                    this.coupon_end_time = coupon_end_time;
                }

                public String getCoupon_info() {
                    return coupon_info;
                }

                public void setCoupon_info(String coupon_info) {
                    this.coupon_info = coupon_info;
                }

                public String getCoupon_remain_count() {
                    return coupon_remain_count;
                }

                public void setCoupon_remain_count(String coupon_remain_count) {
                    this.coupon_remain_count = coupon_remain_count;
                }

                public String getCoupon_start_time() {
                    return coupon_start_time;
                }

                public void setCoupon_start_time(String coupon_start_time) {
                    this.coupon_start_time = coupon_start_time;
                }

                public String getCoupon_total_count() {
                    return coupon_total_count;
                }

                public void setCoupon_total_count(String coupon_total_count) {
                    this.coupon_total_count = coupon_total_count;
                }

                public String getItem_description() {
                    return item_description;
                }

                public void setItem_description(String item_description) {
                    this.item_description = item_description;
                }

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

                public String getSeller_id() {
                    return seller_id;
                }

                public void setSeller_id(String seller_id) {
                    this.seller_id = seller_id;
                }

                public String getShop_title() {
                    return shop_title;
                }

                public void setShop_title(String shop_title) {
                    this.shop_title = shop_title;
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

                public String getUser_type() {
                    return user_type;
                }

                public void setUser_type(String user_type) {
                    this.user_type = user_type;
                }

                public String getVolume() {
                    return volume;
                }

                public void setVolume(String volume) {
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
