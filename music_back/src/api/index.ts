import { get, post, deletes, getBaseURL } from './request'

const HttpManager = {
  // 获取图片信息
  attachImageUrl: (url) => `${getBaseURL()}/${url}`,
  // =======================> 管理员 API
  // 是否登录成功
  getLoginStatus: (params) => post(`admin/login/status`, params),

  // =======================> 用户 API

}

export { HttpManager }
