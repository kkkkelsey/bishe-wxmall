import {request} from "../../request/index.js";
Page({

  /**
   * 页面的初始数据
   */
  data: {
    newaddr: "",
    addr: ""
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {
    let user = wx.getStorageSync('user');
    if (!user) {
      wx.showToast({
        title: '请先登录',
        icon: 'none'
      })
    }else{
      request({url:"/userInfo/" + user.id}).then(res => {
        if (res.code === '0') {
        //  console.log(res.data);
          this.setData({
            addr: res.data.address
          })
        }
      })
    }
  },

    /**
    * 绑定输入地址
    */
  onAddr(e){
    this.setData({
      newaddr: e.detail.value
    })
  },

    /**
    * 充值
    */
  reset(e) {
    let user = wx.getStorageSync('user');
    let data = {id: user.id,address: String(this.data.newaddr)};
    request({url: "/userInfo",data:data,method:"PUT"}).then(res => {
      if (res.code === "0") {
        wx.showToast({
          title: '修改成功',
        })
        wx.switchTab({
          url: '/pages/user/index',
        })
      }else{
        wx.showToast({
          title: res.msg,
          icon: 'none'
        })
      }
    })
  }

})
