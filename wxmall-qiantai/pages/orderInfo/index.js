import {request} from "../../request/index.js";
import {config} from "../../request/config.js";

Page({

  /**
   * 页面的初始数据
   */
  data: {
    status: "",      //订单状态
    dataList: [],     //订单列表

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    const status = options.status;
    this.setData({
      status: status
    })
    this.getOrderData(status);
  },

  getOrderData(status){
    let c = 0;  //件数
    let user = wx.getStorageSync('user');
    let url = "/orderInfo/page/front?pageNum=1&pageSize=100&userId=" + user.id;
    if (status != "all") {
      url = url + "&status=" + status;
    }
    request({url: url}).then(res => {
      if (res.code === '0') {
        let list = res.data.list;
        list.forEach((item,index) => {
        //  console.log(item.goodsList);
        c = 0;
        let list1 = item.goodsList;
        list1.forEach(item => {
          c += item.count;
        })
        // console.log(c);
          let goodsInfo = item.goodsList[0];
          let imgSrc = "../../imgs/default.png";
          if (goodsInfo.fields) {
            let fields = JSON.parse(goodsInfo.fields);
            if (fields.length) {
              imgSrc = config.baseFileUrl + fields[0];
            }
          }
          item.url = imgSrc;
         // item.count = item.goodsList.length;
          item.count = c;
          item.description = goodsInfo.description;
        })
        this.setData({
          dataList: list
        })
      }
    })
  },

  /**
   * 付款或取消
   */
  payGoods(e) {
    let id = e.currentTarget.dataset.id;
    let status = e.currentTarget.dataset.status;
    request({url: "/orderInfo/status/" + id + "/" + status,method: "POST"}).then(res => {
      if (res.code === "0") {
        wx.showToast({
          title: '操作成功',
        })
        this.getOrderData(this.data.status);
      }else{
        wx.showToast({
          title: res.msg,
          icon: "none"
        })
      }
    })
  },

  /**
   * 删除订单
   */
  
})