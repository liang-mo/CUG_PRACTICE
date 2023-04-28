import { get, post, deletes, getBaseURL } from './request'

const HttpManager = {
  // 获取图片信息
  attachImageUrl: (url) => `${getBaseURL()}/${url}`,
  // =======================> 管理员 API
  // 是否登录成功
  getLoginStatus: (params) => post(`admin/login/status`, params),

  // =======================> 用户 API
  // 返回所有用户
  getAllUser: () => get(`user`),
  // 返回指定ID的用户
  getUserOfId: (id) => get(`user/detail?id=${id}`),
  // 添加用户
  setUser: (params) => post(`user/add`, params),
  // 更新用户信息
  updateUserMsg: (params) => post(`user/update`, params),
  // 删除用户
  deleteUser: (id) => get(`user/delete?id=${id}`),

  // =======================> 收藏列表 API
  // 返回的指定用户ID收藏列表
  getCollectionOfUser: (userId) => get(`collection/detail?userId=${userId}`),
  // 删除收藏的歌曲
  deleteCollection: (userId, songId) => deletes(`collection/delete?userId=${userId}&&songId=${songId}`),

}

export { HttpManager }
