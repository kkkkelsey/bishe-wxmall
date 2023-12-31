import {request} from "../../request/index.js";
import {config} from "../../request/config.js";
Page({
  data: {
    defaultImagUrl: '../../imgs/default.png',
    goodsInfoCarouselList: [],   //轮播图列表
    goodsInfoRecommendList: [],   //推荐商品列表
    goodsInfoHotList: [],   //热卖商品列表
    goodsInfoGoodsList: [],   //本站商品列表
  },
  onShow: function() {
    this.getGoodsInfoCarouselList();
    this.getGoodsInfoRecommendList();
    this.getGoodsInfoHotList();
    this.getGoodsInfoGoodsList();
  },

  //获取轮播图
  getGoodsInfoCarouselList(){
    request({url: '/goodsInfo/page/all?pageNum=1&pageSize=3'}).then(res => {
      if(res.code === '0'){
        let goodsInfoCarouselList = res.data.list;
       // console.log(goodsInfoCarouselList);
        if(!goodsInfoCarouselList || goodsInfoCarouselList.length === 0){
          goodsInfoCarouselList.push({"name": "名称1","url": this.data.defaultImagUrl});
          goodsInfoCarouselList.push({"name": "名称2","url": this.data.defaultImagUrl});
          goodsInfoCarouselList.push({"name": "名称3","url": this.data.defaultImagUrl});
        }else{
          if(goodsInfoCarouselList.length > 4){
            goodsInfoCarouselList = goodsInfoCarouselList.slice(0,4);
          }
          goodsInfoCarouselList.forEach(item => {
            if(!item.fields || item.fields === '[]'){
              item.url = this.data.defaultImagUrl;
            }else{
              let fileArr = JSON.parse(item.fields);
              item.url = config.baseFileUrl + fileArr[0];
            }
          });
        }
        this.setData({
          goodsInfoCarouselList
        })
      }else{
        wx.showToast({
          title: res.msg,
          icon: 'none'
        })
      }
    })
  },

    //获取推荐商品列表
    getGoodsInfoRecommendList(){
      request({url: '/goodsInfo/findRecommendGoods'}).then(res => {
        if(res.code === '0'){
          let goodsInfoRecommendList = res.data.list;
          if(!goodsInfoRecommendList || goodsInfoRecommendList.length === 0){
            goodsInfoRecommendList.push({"name": "名称1","url": this.data.defaultImagUrl});
            goodsInfoRecommendList.push({"name": "名称2","url": this.data.defaultImagUrl});
            goodsInfoRecommendList.push({"name": "名称3","url": this.data.defaultImagUrl});
          }else{
            if(goodsInfoRecommendList.length > 4){
              goodsInfoRecommendList = goodsInfoRecommendList.slice(0,4);
            }
            goodsInfoRecommendList.forEach(item => {
              if(!item.fields || item.fields === '[]'){
                item.url = this.data.defaultImagUrl;
              }else{
                let fileArr = JSON.parse(item.fields);
                item.url = config.baseFileUrl + fileArr[0];
              }
            });
          }
          this.setData({
            goodsInfoRecommendList
          })
        }else{
          wx.showToast({
            title: res.msg,
            icon: 'none'
          })
        }
      })
    },

    //获取热卖商品列表
    getGoodsInfoHotList(){
      request({url: '/goodsInfo/findHotSalesGoods'}).then(res => {
        if(res.code === '0'){
          let goodsInfoHotList = res.data.list;
          if(!goodsInfoHotList || goodsInfoHotList.length === 0){
            goodsInfoHotList.push({"name": "名称1","url": this.data.defaultImagUrl});
            goodsInfoHotList.push({"name": "名称2","url": this.data.defaultImagUrl});
            goodsInfoHotList.push({"name": "名称3","url": this.data.defaultImagUrl});
          }else{
            if(goodsInfoHotList.length > 4){
              goodsInfoHotList = goodsInfoHotList.slice(0,6);
            }
            goodsInfoHotList.forEach(item => {
              if(!item.fields || item.fields === '[]'){
                item.url = this.data.defaultImagUrl;
              }else{
                let fileArr = JSON.parse(item.fields);
                item.url = config.baseFileUrl + fileArr[0];
              }
            });
          }
          this.setData({
            goodsInfoHotList
          })
        }else{
          wx.showToast({
            title: res.msg,
            icon: 'none'
          })
        }
      })
    },

    //获取本站所有商品
  getGoodsInfoGoodsList(){
    request({url: '/goodsInfo/page/all?pageNum=1&pageSize=100'}).then(res => {
      if(res.code === '0'){
        let goodsInfoGoodsList = res.data.list;
        if(!goodsInfoGoodsList || goodsInfoGoodsList.length === 0){
          goodsInfoGoodsList.push({"name": "名称1","url": this.data.defaultImagUrl});
          goodsInfoGoodsList.push({"name": "名称2","url": this.data.defaultImagUrl});
          goodsInfoGoodsList.push({"name": "名称3","url": this.data.defaultImagUrl});
        }else{
          if(goodsInfoGoodsList.length > 4){
            goodsInfoGoodsList = goodsInfoGoodsList.slice(0,10);
          }
          goodsInfoGoodsList.forEach(item => {
            if(!item.fields || item.fields === '[]'){
              item.url = this.data.defaultImagUrl;
            }else{
              let fileArr = JSON.parse(item.fields);
              item.url = config.baseFileUrl + fileArr[0];
            }
          });
        }
        this.setData({
          goodsInfoGoodsList
        })
      }else{
        wx.showToast({
          title: res.msg,
          icon: 'none'
        })
      }
    })
  },

  bindfocus() {
    wx.navigateTo({
      url: '/pages/search/search',
    })
  }
})
