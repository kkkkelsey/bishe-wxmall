import {request} from "../../request/index.js";
import {config} from "../../request/config.js";
Page({

  /**
   * 页面的初始数据
   */
  data: {
    defaultImageUrl: '../../imgs/default.png',
    cart: [],
    totalPrice: 0,
    totalNum: 0
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {
    this.getCartInfo();
  },

  /**
   * 获取购物车的商品列表
   */
  getCartInfo(){
    let user = wx.getStorageSync('user');
    if (!user) {
      wx.navigateTo({
        url: '/pages/login/index?isTabBar=1&url=/pages/cartInfo/index'
      })
      return;
    }
    request({url: '/cartInfo?userId=' + user.id}).then(res => {
      if (res.code === '0') {
        let cartList = res.data;
        let totalPrice = 0;
        let totalNum = 0;
        cartList.forEach(item => {
          totalNum += item.count;
          totalPrice += item.count * item.price * item.discount;
          let imgSrc = this.data.defaultImageUrl;
          if (item.fields) {
            let fields = JSON.parse(item.fields)[0];
            imgSrc = config.baseFileUrl + fields;
          }
          item.url = imgSrc;
        })
        this.setData({
          cart: cartList,
          totalNum: totalNum,
          totalPrice: totalPrice.toFixed(2)
        })
      }
    })
  },

  /**
   * 商品数量的编辑功能
   */
  handleItemNumEdit(e) {
    //获取传来的参数
    const {operation,id} = e.currentTarget.dataset;
    //获取购物车数组
    let cart = this.data.cart;
    //获取需要修改的商品的索引
    const index = cart.findIndex(v => v.id === id);
    //判断是否要删除
    if (cart[index].count === 1 && operation === -1) {
      //弹窗提示
      wx.showModal({
        content: '您是否要删除该商品',
        success: (res) => {
          if (res.confirm) {
            let user = wx.getStorageSync('user');
            request({url: '/cartInfo/goods/' + user.id + '/' + id, method:'DELETE'}).then(res => {
              if (res.code === '0') {
                let cart = this.data.cart;
                cart.splice(index,1);  //删除数组元素
                let totalPrice = 0;
                let totalNum = 0;
                cart.forEach(item => {
                  totalNum += item.count;
                  totalPrice += item.count * item.price * item.discount;
                })
                this.setData({
                  cart: cart,
                  totalNum: totalNum,
                  totalPrice: totalPrice.toFixed(2)
                })
              }else {
                wx.showToast({
                  title: res.msg,
                  icon: 'error'
                })
              }
            })
          }
        }
      })
    }else {
      //修改数量
      let cart = this.data.cart;
      cart[index].count += operation;
      //重新计算一下总价格和总数量
      let totalPrice = 0;
      let totalNum = 0;
      cart.forEach(item => {
        totalNum += item.count;
        totalPrice += item.count * item.price * item.discount;
      })
      this.setData({
        cart: cart,
        totalNum: totalNum,
        totalPrice: totalPrice.toFixed(2)
      })
    }
  },

  /**
   * 下单
   */
  handlePay(){
    if (this.data.cart.length === 0) {
      wx.showToast({
        title: '购物车空空如也~',
        icon: 'none'
      })
      return;
    }
    let user = wx.getStorageSync('user');
    let data = {userid: user.id,level: user.level,totalprice: this.data.totalPrice,goodsList: this.data.cart};
    request({url: '/orderInfo',method: 'POST',data: data}).then(res => {
      if (res.code === '0') {
        wx.showToast({
          title: '提交订单成功，请付款',
        })
        //跳转到支付页面
        wx.navigateTo({
          url: '/pages/orderInfo/index?status=待付款'
        })
      }else{
        wx.showToast({
          title: res.msg,
          icon:'error'
        })
      }

    }) 
  }
})