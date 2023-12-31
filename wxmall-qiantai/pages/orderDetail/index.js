import {request} from "../../request/index.js";
import {config} from "../../request/config.js";
Page({

  /**
   * 页面的初始数据
   */
  data: {
    defaultImageUrl: '../../imgs/default.png',
    list: [],
    status: ''
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onLoad(options) {
    let id = options.id;
    let status = options.status;
    request({url: '/orderInfo/order/' + id}).then(res => {
      if (res.code === '0') {
        let list = res.data.goodsList;
        list.forEach(item => {
          let imgSrc = this.data.defaultImageUrl;
          if (item.fields) {
            let fields = JSON.parse(item.fields)[0];
            imgSrc = config.baseFileUrl + fields;
          }
          item.url = imgSrc;
        })
        this.setData({
          list: list,
          status: status
        })
      }
    })
  },

  comment(e){
    let goodsId = e.currentTarget.dataset.id;
    wx.navigateTo({
      url: '/pages/comment/index?goodsId=' + goodsId,
    })
  }
})