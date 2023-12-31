import {request} from "../../request/index.js";
Page({

  /**
   * 页面的初始数据
   */
  data: {
    isLogin: 0,      //0是未登录，1是已登录
    userInfo: {},    //用户信息
    avatarUrl: '',   //头像
    price: 0,         //用户余额
    addr: ""         //用户地址
  },

  /**
   * 微信接口，获取用户信息
   */
  getUserInfo: function(e) {
    var userInfo = e.detail.userInfo;
    wx.setStorageSync('avatarUrl', userInfo.avatarUrl);
    var data = {
      name: userInfo.nickName,
      code: userInfo.avatarUrl,
      nicakName: userInfo.nickName,
      password: "123456",
      account: 80000
    }

    request({url:"/register",data: data,method:"POST"}).then(res =>{
      if(res.code === '0') {
        wx.showToast({
          title: '登录成功',
          mask: true
        })
        //获取后存储本地数据
        this.setData({
          isLogin: 1,
          userInfo: res.data
        });
        //存到localStorage里
        wx.setStorageSync('user', res.data)
      }else{
        wx.showToast({
          title: '登录失败',
          mask: true
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {
    let user = wx.getStorageSync('user');
    let avatarUrl = wx.getStorageSync('avatarUrl');
    if (user) {
      this.setData ({
        isLogin: 1,
        userInfo: user,
        avatarUrl: avatarUrl
      });
    }
    request({url:"/userInfo/" + user.id}).then(res => {
      if (res.code === '0') {
        this.setData({
          price: res.data.account,
          addr: res.data.address
        })
      }
    })
  },

  /**
   * 转向订单列表页面
   */
  navigateToOrder(e) {
    let user = wx.getStorageSync('user');
    if (!user) {
      wx.showToast({
        title: '请先登录',
        icon: 'none'
      })
    }else{
      let status = e.currentTarget.dataset.status;
      wx.navigateTo({
        url: '/pages/orderInfo/index?status=' + status,
      })
    }
  },

  /**
   * 充值
   */
  recharge(){
    let user = wx.getStorageSync('user');
    if (!user) {
      wx.showToast({
        title: '请先登录',
        icon: 'none'
      })
    }else{
      wx.navigateTo({
        url: '/pages/pay/index',
      })
    }
  },
 
  /**
   * 修改收货地址
   */
  reset(){
    let user = wx.getStorageSync('user');
    if (!user) {
      wx.showToast({
        title: '请先登录',
        icon: 'none'
      })
    }else{
      wx.navigateTo({
        url: '/pages/address/index',
      })
    }
  }
})